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

    private void trace(String msg) {
        //~ System.out.println("TRACE: " + msg);
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
        trace("annotating Declaration with " + variable.name());
        return null;
    }

    @Override
    public Void visitAssignmentStmt(PfxParser.AssignmentStmtContext ctx) {
        String name = ctx.ID().getText();
        Variable variable = globalVariables.get(name);
        if (variable == null) {
            throw new SemanticError("Variable " + name + " is not declared.");
        }
        annotations.put(ctx, variable);
        trace("annotating AssignmentStmt with " + variable.name());
        ctx.expr().accept(this);
        return null;
    }

    @Override
    public Void visitNameExpr(PfxParser.NameExprContext ctx) {
        String name = ctx.ID().getText();
        Variable variable = globalVariables.get(name);
        if (variable == null) {
            throw new SemanticError("Variable " + name + " is not declared.");
        }
        annotations.put(ctx, variable);
        trace("annotating NameExpr with " + variable.name());
        return null;
    }
}
