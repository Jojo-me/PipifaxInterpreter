import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class ExprVisitorNameChecker implements ExprVisitor<Void> {

    ArrayList varList  = new ArrayList<String>();

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
        //System.out.println("visitProg");
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
        if (isExisting(ctx.ID().getText())) {
            System.out.println("variable " + ctx.ID().getText() + " already exist");
        } else {
            varList.add(ctx.ID().getText());
        }
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitAssignment(ExprParser.AssignmentContext ctx) {
        if (!isExisting(ctx.ID().getText())) {
            System.out.println("variable " + ctx.ID().getText() + " doesn't exist");
        }
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitExpression(ExprParser.ExpressionContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitTerm(ExprParser.TermContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitFactor(ExprParser.FactorContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitType(ExprParser.TypeContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Void visitRvalue(ExprParser.RvalueContext ctx) {
        visitChildren(ctx);
        return null;
    }

    public boolean isExisting(String testingVar){
        boolean existing = false;
        if (varList.contains(testingVar)) {
            existing = true;
        }
        return existing;
    }
    
}

