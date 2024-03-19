import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExprVisitorPrint implements ExprVisitor<Integer> {

    @Override
    public Integer visit(ParseTree arg0) {
        System.out.println("Visit");
        return null;
    }

    @Override
    public Integer visitChildren(RuleNode arg0) {
        System.out.println("Visit Children");
        return null;
    }

    @Override
    public Integer visitErrorNode(ErrorNode arg0) {
        System.out.println("Visit ErrorNode");
        return null;
    }

    @Override
    public Integer visitTerminal(TerminalNode arg0) {
        System.out.println("Visit Terminal");
        return null;
    }

    @Override
    public Integer visitProg(ExprParser.ProgContext ctx) {
        System.out.println("Visit Prog");
        ParseTree test = ctx.children.get(0);
        test.accept(this);
        return null;
    }

    @Override
    public Integer visitLine(ExprParser.LineContext ctx) {
        System.out.println("Visit line");
        return null;
    }

    @Override
    public Integer visitDeclaration(ExprParser.DeclarationContext ctx) {
        System.out.println("Visit Declaration");
        return null;
    }

    @Override
    public Integer visitAssignment(ExprParser.AssignmentContext ctx) {
        System.out.println("Visit Assignment");
        return null;
    }

    @Override
    public Integer visitExpression(ExprParser.ExpressionContext ctx) {
        System.out.println("Visit Expression");
        return null;
    }

    @Override
    public Integer visitTerm(ExprParser.TermContext ctx) {
        System.out.println("Visit Term");
        return null;
    }

    @Override
    public Integer visitFactor(ExprParser.FactorContext ctx) {
        System.out.println("Visit Factor");
        return null;
    }
    
}
