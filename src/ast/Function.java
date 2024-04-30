package ast;

public class Function {
    private String name;

    public Function(String name) {
        this.name = name;
    }

    public String name() {
        return this.name;
    }

    public String label() {
        return "func_" + this.name;
    }
}
