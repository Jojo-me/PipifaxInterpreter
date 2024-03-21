import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExprVisitorDeclaration implements ExprVisitor<String> {

    @Override
    public String visit(ParseTree arg0) {
        return null;
    }

    @Override
    public String visitChildren(RuleNode arg0) {
        String result = "";
        for (int i = 0; i < arg0.getChildCount(); i++) {
            var child = arg0.getChild(i);
            result += child.accept(this) + "child\n";
        }
        return result;
    }

    @Override
    public String visitErrorNode(ErrorNode arg0) {
        return null;
    }

    @Override
    public String visitTerminal(TerminalNode arg0) {
        System.out.println("Visit Terminal");
        String result = "." + arg0.getText();
        return result;
    }

    @Override
    public String visitProg(ExprParser.ProgContext ctx) {
        String result = "";
        for (var singleLine : ctx.line()) {
            String fromLine = singleLine.accept(this);
            if (fromLine != null)
                result += fromLine + "\n";
        }
        return result;
    }

    @Override
    public String visitLine(ExprParser.LineContext ctx) {
        var declarationContext = ctx.declaration();
        if (declarationContext != null) {
            return declarationContext.accept(this);
        }
        return null;
    }

    @Override
    public String visitDeclaration(ExprParser.DeclarationContext ctx) {
        System.out.println("Visit Declaration");

        String result = "";

        result += ctx.ID().accept(this);
        result += ": ";
        result += ctx.type().accept(this);
        result += " 0";

        return result;
    }

    @Override
    public String visitAssignment(ExprParser.AssignmentContext ctx) {
        return null;
    }

    @Override
    public String visitExpression(ExprParser.ExpressionContext ctx) {
        return null;
    }

    @Override
    public String visitTerm(ExprParser.TermContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitFactor(ExprParser.FactorContext ctx) {
        return null;
    }

    @Override
    public String visitType(ExprParser.TypeContext ctx) {
        System.out.println("Visit Type");

        String type = ctx.children.get(0).getText();
        switch (type) {
            case "int":
                return ".word";
            default:
                return null;
        }
    }

}
