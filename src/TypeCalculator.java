import ast.Type;
import ast.Variable;
import ast.Function;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.Map;

class TypeCalculator extends PfxBaseVisitor<Type> {
    private Map<ParserRuleContext, Variable> variables;
    private Map<ParserRuleContext, Function> functions;
    private Map<ParserRuleContext, Type> types;

    public TypeCalculator(Map<ParserRuleContext, Variable> variables, Map<ParserRuleContext, Function> functions, Map<ParserRuleContext, Type> types) {
        this.variables = variables;
        this.functions = functions;
        this.types = types;
    }

    @Override
    public Type visitAssignmentStmt(PfxParser.AssignmentStmtContext ctx) {
        Type lhs = ctx.lvalue().accept(this);
        Type rhs = ctx.expr().accept(this);

        if (!lhs.assignable(rhs)) {
            throw new SemanticError("Incompatible types in assignment");
        }

        return null;
    }

    @Override
    public Type visitIndexedLValue(PfxParser.IndexedLValueContext ctx) {
        Type indexType = ctx.expr().accept(this);
        if (!indexType.isInt()) {
            throw new SemanticError("Index must be an integer value");
        }

        Type baseType = ctx.lvalue().accept(this);
        if (!baseType.isArray()) {
            throw new SemanticError("Indexed access is only possible for arrays.");
        }

        Type.ArrayType array = (Type.ArrayType) baseType;
        Type t = array.elementType();
        types.put(ctx, t);
        return t;
    }

    @Override
    public Type visitNamedLValue(PfxParser.NamedLValueContext ctx) {
        String name = ctx.ID().getText();
        Variable v = variables.get(ctx);
        Type t = v.type();
        types.put(ctx, t);
        return t;
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
    public Type visitLValueExpr(PfxParser.LValueExprContext ctx) {
        Type t = ctx.lvalue().accept(this);
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
