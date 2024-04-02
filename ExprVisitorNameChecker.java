import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import java.util.*;

public class ExprVisitorNameChecker extends ExprBaseVisitor<Void> {

    List<String> intLiterals = new ArrayList<String>();
    List<String> doubleLiterals = new ArrayList<String>();

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
                defineInt(literalID);
                break;
            case "double":
                defineDouble(literalID);
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
        // TODO: is it int or double?
        findInt(literalID);

        visitChildren(ctx);
        return null;
    }

    private void defineInt(String literal) {
        if (intLiterals.contains(literal)) {
            System.out.printf("Variable %s already exists\n", literal);
        } else {
            intLiterals.add(literal);
        }
    }

    private void defineDouble(String literal) {
        if (doubleLiterals.contains(literal)) {
            System.out.printf("Variable %s already exists\n", literal);
        } else {
            doubleLiterals.add(literal);
            System.out.printf("Define %s\n", literal);
        }
    }

    private void findInt(String intLiteral) {
        if (!intLiterals.contains(intLiteral)) {
            System.out.printf("Variable %s is not defined\n", intLiteral);
        }
    }

    private void findDouble(String doubleLiteral) {
        if (!doubleLiterals.contains(doubleLiteral)) {
            System.out.printf("Variable %s is not defined\n", doubleLiteral);
        }
    }
}
