import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExprVisitorDeclaration implements ExprVisitor<Void> {

    @Override
    public Void visit(ParseTree arg0) {
        return null;
    }

    @Override
    public Void visitChildren(RuleNode arg0) {
        for (int i = 0; i < arg0.getChildCount(); i++){
            var child = arg0.getChild(i);
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visitErrorNode(ErrorNode arg0) {
        return null;
    }

    @Override
    public Void visitTerminal(TerminalNode arg0) {
        return null;
    }

    @Override
    public Void visitProg(ExprParser.ProgContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitLine(ExprParser.LineContext ctx) {
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
        return null;
    }

    @Override
    public Void visitExpression(ExprParser.ExpressionContext ctx) {
        return null;
    }

    @Override
    public Void visitTerm(ExprParser.TermContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitFactor(ExprParser.FactorContext ctx) {
        return null;
    }

    @Override
    public Void visitType(ExprParser.TypeContext ctx) {
        visitChildren(ctx);
        return null;
    }
    
}
