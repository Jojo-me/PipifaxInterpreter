public class PfxInt implements PfxType {

    @Override
    public boolean assignable(PfxType pfxtype) {
        if (pfxtype.isIntType()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDoubleType() {
        return false;
    }

    @Override
    public boolean isIntType() {
        return true;
    }

}
