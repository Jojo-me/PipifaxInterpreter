import ast.Type;
import ast.Variable;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.Map;

class TypeCalculator extends PfxBaseVisitor<Type> {
    private Map<ParserRuleContext, Variable> variables;
    private Map<ParserRuleContext, Type> types;

    public TypeCalculator(Map<ParserRuleContext, Variable> variables, Map<ParserRuleContext, Type> types) {
        this.variables = variables;
        this.types = types;
    }

    @Override
    public Type visitAssignmentStmt(PfxParser.AssignmentStmtContext ctx) {
        Type lhs = variables.get(ctx).type();
        Type rhs = ctx.expr().accept(this);

        if (!lhs.assignable(rhs)) {
            throw new SemanticError("Incompatible types in assignment");
        }
        Type t = lhs;

        return null;
    }

    @Override
    public Type visitIntLiteralExpr(PfxParser.IntLiteralExprContext ctx) {
        Type t = Type.intType();
        types.put(ctx, t);
        return t;
    }

    @Override
    public Type visitDoubleLiteralExpr(PfxParser.DoubleLiteralExprContext ctx) {
        Type t = Type.doubleType();
        types.put(ctx, t);
        return t;
    }

    @Override
    public Type visitNameExpr(PfxParser.NameExprContext ctx) {
        Variable v = variables.get(ctx);
        Type t = v.type();
        types.put(ctx, t);
        return t;
    }

    @Override
    public Type visitAddExpr(PfxParser.AddExprContext ctx) {
        Type lhs = ctx.left.accept(this);
        Type rhs = ctx.right.accept(this);
        if (!lhs.assignable(rhs) || !lhs.isNumeric() || !rhs.isNumeric() ) {
            throw new SemanticError("Addition is possible only with numeric types and operands of same type");
        }
        Type t = lhs;
        types.put(ctx, t);
        return t;
    }
}
