public class ExprVisitorTypeCommulator extends ExprBaseVisitor<PfxType> {

    @Override
    public PfxType visitRValueDouble(ExprParser.RValueDoubleContext ctx) {
        return new PfxDouble();
    }

    @Override
    public PfxType visitRValueInt(ExprParser.RValueIntContext ctx) {
        return new PfxInt();
    }
    
}
