package ast;

public class Variable {
    private String name;
    private Type type;

    private Variable(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String name() {
        return this.name;
    }

    public Type type() {
        return this.type;
    }

    public static Variable globalVariable(String name, Type type) {
        return new Variable(name, type);
    }
}
