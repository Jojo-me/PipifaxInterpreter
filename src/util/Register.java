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
    }

    static class FP extends Register {
        FP(String name) {
            super(name);
        }
    }

    public String toString() {
        return name;
    }
}
