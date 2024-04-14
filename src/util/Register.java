package util;

public abstract class Register {

    private String name;

    Register(String name) {
        this.name = name;
    }

    static class GP extends Register {
        GP(String name) {
            super(name);
        }

        public void release() {
            Registers.releaseGP(this);
        }
    }

    static class FP extends Register {
        FP(String name) {
            super(name);
        }

        public void release() {
            Registers.releaseFP(this);
        }
    }

    public String toString() {
        return name;
    }

    public abstract void release();
}
