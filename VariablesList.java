import java.util.ArrayList;
import java.util.List;

public class VariablesList {
    private List<PfxVariable> variables = new ArrayList<PfxVariable>();
    
    /*
     * Returns index in `variables`. If not exists returns -1
     */
    public int getIndexOfVariable(String name) {
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public void add(PfxVariable variable){
        String name = variable.getName();

        if (getIndexOfVariable(name) >= 0) {
            System.out.printf("Variable %s already exists\n", name);
        } else {
            variables.add(variable);
        }
    }

    public PfxVariable get(String name){
        int index = getIndexOfVariable(name);

        if (index < 0) {
            System.out.printf("Variable %s is not defined\n", name);
            return null;
        }

        PfxVariable variable = variables.get(index);
        return variable;
    }
}
