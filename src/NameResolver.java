import ast.Type;
import ast.Variable;
import ast.Function;
import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.ParserRuleContext;

class NameResolver extends PfxBaseVisitor<Void> {

    private Map<String, Variable> globalVariables = new HashMap<>();
    private Map<String, Function> functions = new HashMap<>();
    private Map<ParserRuleContext, Variable> varAnnotations;
    private Map<ParserRuleContext, Function> funcAnnotations;

    public NameResolver(Map<ParserRuleContext, Variable> varAnnotations, Map<ParserRuleContext, Function> funcAnnotations) {
        this.varAnnotations = varAnnotations;
        this.funcAnnotations = funcAnnotations;
    }

    @Override
    public Void visitProgram(PfxParser.ProgramContext ctx) {
        for (ParserRuleContext c : ctx.declaration()) {
            c.accept(this);
        }
        for (PfxParser.FunctionContext c : ctx.function()) {
            String name = c.ID().getText();
            Function f = new Function(name);
            if (functions.put(name, f) != null) {
                throw new SemanticError("Function " + name + " is defined more than once");
            }
            funcAnnotations.put(c, f);
        }
        for (ParserRuleContext c : ctx.function()) {
            c.accept(this);
        }
        return null;
    }

    @Override
    public Void visitDeclaration(PfxParser.DeclarationContext ctx) {
        String name = ctx.ID().getText();
        Type type = ctx.type().accept(new TypeBuilder());
        Variable variable = Variable.globalVariable(name, type);
        if (globalVariables.put(name, variable) != null) {
            throw new SemanticError("Global variable " + name + " is declared more than once.");
        }
        varAnnotations.put(ctx, variable);
        return null;
    }

    @Override
    public Void visitCallStmt(PfxParser.CallStmtContext ctx) {
        String name = ctx.ID().getText();
        Function f = functions.get(name);
        if (f == null) {
            throw new SemanticError("Function " + name + " is not defined");
        }
        funcAnnotations.put(ctx, f);
        return null;
    }

    @Override
    public Void visitNamedLValue(PfxParser.NamedLValueContext ctx) {
        String name = ctx.ID().getText();
        Variable variable = globalVariables.get(name);
        if (variable == null) {
            throw new SemanticError("Variable " + name + " is not declared.");
        }
        varAnnotations.put(ctx, variable);
        return null;
    }

    public Function function(String name) {
        return functions.get(name);
    }
}
