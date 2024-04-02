import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import java.util.*;

public class ExprVisitorNameChecker extends ExprBaseVisitor<Void> {

    List<PfxVariable> variables = new ArrayList<PfxVariable>();

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

    /*
     * Returns index in `variables`. If not exists returns -1
     */
    private int getIndexOfVariable(String name) {
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    private void defineVariable(String name, PfxType type) {
        PfxVariable variable = new PfxVariable(name, type);

        if (getIndexOfVariable(name) >= 0) {
            System.out.printf("Variable %s already exists\n", name);
        } else {
            variables.add(variable);
        }
    }

    private void foundVariable(String varName, PfxType typeToAssign) {
        int index = getIndexOfVariable(varName);

        if (index < 0) {
            System.out.printf("Variable %s is not defined\n", varName);
            return;
        }

        PfxVariable pfxVariable = variables.get(index);
        if (pfxVariable.getType().assignable(typeToAssign)) {
            System.out.printf("Correct Assignment to %s\n", varName);
        } else {
            System.out.printf("Cannot assign type to ");
        }
    }
}
