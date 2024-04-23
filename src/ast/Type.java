package ast;

public abstract class Type {

    public static class IntType extends Type {
        public <T> T apply(Functor<T> f) {
            return f.apply(this);
        }

        public boolean assignable(Type t) {
            return t.isInt();
        }

        public boolean isInt() {
            return true;
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

    public static class ArrayType extends Type {
        private int dimension;
        Type elementType;

        ArrayType(Type elementType, int dimension) {
            this.elementType = elementType;
            this.dimension = dimension;
        }

        public <T> T apply(Functor<T> f) {
            return f.apply(this);
        }

        public boolean assignable(Type t) {
            if (t instanceof ArrayType) {
                ArrayType arr = (ArrayType) t;
                return elementType.assignable(arr.elementType) && dimension == arr.dimension;
            }
            return false;
        }

        public int storageSize() {
            return elementType.storageSize() * dimension;
        }

        public boolean isArray() {
            return true;
        }

        public Type elementType() {
            return this.elementType;
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

    public static Type arrayType(Type elementType, int dimension) {
        return new ArrayType(elementType, dimension);
    }

    public abstract int storageSize();

    /**
     * @returns true if t can be assigned to this
     */
    public abstract boolean assignable(Type t);

    public boolean isInt() {
        return false;
    }

    public boolean isNumeric() {
        return false;
    }

    public boolean isArray() {
        return false;
    }

    public interface Functor<T> {
        default T apply(IntType t) { throw new RuntimeException("Not implemented"); }
        default T apply(DoubleType t) { throw new RuntimeException("Not implemented"); }
        default T apply(ArrayType t) { throw new RuntimeException("Not implemented"); }
    }

    public abstract <T> T apply(Functor<T> f);
}
