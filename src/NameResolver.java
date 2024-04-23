import ast.Type;
import ast.Variable;
import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.ParserRuleContext;

class NameResolver extends PfxBaseVisitor<Void> {

    private Map<String, Variable> globalVariables = new HashMap<>();
    private Map<ParserRuleContext, Variable> annotations;

    public NameResolver(Map<ParserRuleContext, Variable> annotations) {
        this.annotations = annotations;
    }

    @Override
    public Void visitDeclaration(PfxParser.DeclarationContext ctx) {
        String name = ctx.ID().getText();
        Type type = ctx.type().accept(new TypeBuilder());
        Variable variable = Variable.globalVariable(name, type);
        if (globalVariables.put(name, variable) != null) {
            throw new SemanticError("Global variable " + name + " is declared more than once.");
        }
        annotations.put(ctx, variable);
        return null;
    }

    @Override
    public Void visitNamedLValue(PfxParser.NamedLValueContext ctx) {
        String name = ctx.ID().getText();
        Variable variable = globalVariables.get(name);
        if (variable == null) {
            throw new SemanticError("Variable " + name + " is not declared.");
        }
        annotations.put(ctx, variable);
        return null;
    }
}
