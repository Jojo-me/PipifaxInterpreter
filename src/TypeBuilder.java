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
}
