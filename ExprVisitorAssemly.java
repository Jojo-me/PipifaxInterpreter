import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExprVisitorAssemly implements ExprVisitor<String> {
    @Override
    public String visitChildren(RuleNode arg0) {
        String result = "";
        for (int i = 0; i < arg0.getChildCount(); i++) {
            var child = arg0.getChild(i);
            result += child.accept(this) + "\n";
        }
        return result;
    }

    @Override
    public String visitTerminal(TerminalNode arg0) {
        System.out.println("Visit Terminal");
        String result = "." + arg0.getText();
        return result;
    }

    @Override
    public String visitProg(ExprParser.ProgContext ctx) {
        String result = ".data\n";

        for (var singleLine : ctx.line()) {
            if (singleLine.declaration() == null)
                continue;
            String fromLine = singleLine.accept(this);
            result += fromLine;
        }

        result += "\n.text\n.globl main\nmain:\n";

        for (var singleLine : ctx.line()) {
            if (singleLine.assignment() == null)
                continue;
            String fromLine = singleLine.accept(this);
            result += fromLine;
        }

        return result;
    }

    @Override
    public String visitLine(ExprParser.LineContext ctx) {
        return visitChildren(ctx);
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
    public String visitTerm(ExprParser.TermContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitType(ExprParser.TypeContext ctx) {
        System.out.println("Visit Type");

        String type = ctx.children.get(0).getText();
        switch (type) {
            case "int":
                return ".word";
            case "double":
                return ".word";
            default:
                return null;
        }
    }

    @Override
    public String visit(ParseTree arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public String visitErrorNode(ErrorNode arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitErrorNode'");
    }

    @Override
    public String visitAssignment(ExprParser.AssignmentContext ctx) {
        String result = "";

        result += ctx.ID();

        return result;
    }

    @Override
    public String visitExpression(ExprParser.ExpressionContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitExpression'");
    }

    @Override
    public String visitFactor(ExprParser.FactorContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitFactor'");
    }

    @Override
    public String visitRvalue(ExprParser.RvalueContext ctx) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visitRvalue'");
    }

}
