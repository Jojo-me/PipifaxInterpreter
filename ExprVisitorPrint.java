import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExprVisitorPrint implements ExprVisitor<Void> {

    @Override
    public Void visit(ParseTree arg0) {
        System.out.println("Visit");
        return null;
    }

    @Override
    public Void visitChildren(RuleNode arg0) {
        System.out.println("Visit Children");

        for (int i = 0; i < arg0.getChildCount(); i++){
            var child = arg0.getChild(i);
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visitErrorNode(ErrorNode arg0) {
        System.out.println("Visit ErrorNode");
        return null;
    }

    @Override
    public Void visitTerminal(TerminalNode arg0) {
        System.out.println("Visit Terminal");
        return null;
    }

    @Override
    public Void visitProg(ExprParser.ProgContext ctx) {
        System.out.println("Visit Prog");
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitLine(ExprParser.LineContext ctx) {
        System.out.println("Visit line");
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitDeclaration(ExprParser.DeclarationContext ctx) {
        System.out.println("Visit Declaration");
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitAssignment(ExprParser.AssignmentContext ctx) {
        System.out.println("Visit Assignment");
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitExpression(ExprParser.ExpressionContext ctx) {
        System.out.println("Visit Expression");
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitTerm(ExprParser.TermContext ctx) {
        System.out.println("Visit Term");
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitFactor(ExprParser.FactorContext ctx) {
        System.out.println("Visit Factor");
        visitChildren(ctx);
        return null;
    }
    
}
