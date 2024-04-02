public class PfxVariable {
    private final String name;
    private final PfxType type;

    PfxVariable (String name, PfxType type){
        this.name = name;
        this.type = type;
    }

    String getName() {
        return name;
    };

    PfxType getType(){
        return type;
    }
}
