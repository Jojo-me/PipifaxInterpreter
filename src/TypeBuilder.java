import ast.Type;

class TypeBuilder extends PfxBaseVisitor<Type> {

    @Override
    public Type visitIntType(PfxParser.IntTypeContext ctx) {
        return Type.intType();
    }

    @Override
    public Type visitDoubleType(PfxParser.DoubleTypeContext ctx) {
        return Type.doubleType();
    }

    @Override
    public Type visitArrayType(PfxParser.ArrayTypeContext ctx) {
        Type t = ctx.type().accept(this);
        int dim = Integer.parseInt(ctx.IntLiteral().getText());
        return Type.arrayType(t, dim);
    }
}
