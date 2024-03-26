import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ExprVisitorAssembly implements ExprVisitor<String> {
    @Override
    public String visitChildren(RuleNode arg0) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < arg0.getChildCount(); i++) {
            var child = arg0.getChild(i);
            result.append(child.accept(this));
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public String visitTerminal(TerminalNode arg0) {
        System.out.println("Visit Terminal");
        return arg0.getText();
    }

    @Override
    public String visitProg(ExprParser.ProgContext ctx) {
        StringBuffer result = new StringBuffer();
        result.append("\t.data\n");

        // only declarations
        for (var singleLine : ctx.line()) {
            if (singleLine.declaration() == null)
                continue;
            result.append(singleLine.accept(this));
        }

        result.append("\n\t.text\n\t.globl main\nmain:\n");

        // only assignments
        for (var singleLine : ctx.line()) {
            if (singleLine.assignment() == null)
                continue;
                result.append(singleLine.accept(this));
        }

        return result.toString();
    }

    @Override
    public String visitLine(ExprParser.LineContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitDeclaration(ExprParser.DeclarationContext ctx) {
        System.out.println("Visit Declaration");

        StringBuffer result = new StringBuffer();

        result.append(ctx.ID().accept(this));
        result.append(":\t");
        result.append(ctx.type().accept(this));
        result.append(" 0");

        return result.toString();
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
        StringBuffer result = new StringBuffer();

        result.append("\tli t0, ");
        result.append(ctx.rint().accept(this));
        result.append("\n");
        result.append("\tsw t0, ");
        result.append(ctx.ID().accept(this));
        result.append(", t1");

        return result.toString();
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

    @Override
    public String visitRint(ExprParser.RintContext ctx) {
        return ctx.getText();
    }

}
