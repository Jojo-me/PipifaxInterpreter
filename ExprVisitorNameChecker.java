import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

public class ExprVisitorNameChecker extends ExprBaseVisitor<Void> {

    VariablesList variables;

    ExprVisitorNameChecker(VariablesList variables){
        this.variables = variables;
    }

    @Override
    public Void visit(ParseTree arg0) {
        return null;
    }

    @Override
    public Void visitChildren(RuleNode arg0) {

        for (int i = 0; i < arg0.getChildCount(); i++) {
            var child = arg0.getChild(i);
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visitDeclaration(ExprParser.DeclarationContext ctx) {
        String literalID = ctx.ID().getText();
        String type = ctx.type().getText();

        switch (type) {
            case "int":
                defineVariable(literalID, new PfxInt());
                break;
            case "double":
                defineVariable(literalID, new PfxDouble());
                break;

            default:
                System.out.printf("Type not defined: %s\n", type);
                break;
        }
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitAssignment(ExprParser.AssignmentContext ctx) {
        String literalID = ctx.ID().getText();
        PfxType rType = ctx.rvalue().accept(new ExprVisitorTypeCommulator());

        foundVariable(literalID, rType);

        return null;
    }

    private void defineVariable(String name, PfxType type) {
variables.add(new PfxVariable(name, type));
    }

    private void foundVariable(String varName, PfxType typeToAssign) {
        PfxVariable pfxVariable = variables.get(varName);

        if (pfxVariable == null){
            return;
        }

        if (pfxVariable.getType().assignable(typeToAssign)) {
            System.out.printf("Correct Assignment to %s\n", varName);
        } else {
            System.out.printf("Cannot assign type to ");
        }
    }
}
