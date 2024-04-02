public class PfxDouble implements PfxType {

    @Override
    public boolean assignable(PfxType pfxtype) {
        if (pfxtype.isDoubleType()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isDoubleType() {
        return true;
    }

    @Override
    public boolean isIntType() {
        return false;
    }
    
}
