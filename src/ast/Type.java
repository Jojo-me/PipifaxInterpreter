package ast;

public abstract class Type {

    public static class IntType extends Type {
        public <T> T apply(Functor<T> f) {
            return f.apply(this);
        }

        public boolean assignable(Type t) {
            return t instanceof IntType;
        }

        public boolean isNumeric() {
            return true;
        }

        public int storageSize() {
            return 4;
        }
    }

    public static class DoubleType extends Type {
        public <T> T apply(Functor<T> f) {
            return f.apply(this);
        }

        public boolean assignable(Type t) {
            return t instanceof DoubleType;
        }

        public boolean isNumeric() {
            return true;
        }

        public int storageSize() {
            return 8;
        }
    }

    private static IntType theIntType = new IntType();
    private static DoubleType theDoubleType = new DoubleType();

    public static Type intType() {
        return theIntType;
    }

    public static Type doubleType() {
        return theDoubleType;
    }

    public abstract int storageSize();

    /**
     * @returns true if t can be assigned to this
     */
    public abstract boolean assignable(Type t);

    public boolean isNumeric() {
        return false;
    }

    public interface Functor<T> {
        T apply(IntType t);
        T apply(DoubleType t);
    }

    public abstract <T> T apply(Functor<T> f);
}
