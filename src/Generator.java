import ast.Type;
import ast.Variable;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.Map;
import java.io.PrintStream;

class Generator<T> extends PfxBaseVisitor<T> {

    protected Map<ParserRuleContext, Variable> variables;
    protected Map<ParserRuleContext, Type> types;
    protected Map<ParserRuleContext, String> constants;
    protected PrintStream output;

    public Generator(Map<ParserRuleContext, Variable> variables, Map<ParserRuleContext, Type> types, Map<ParserRuleContext, String> constants, PrintStream output) {
        this.variables = variables;
        this.types = types;
        this.constants = constants;
        this.output = output;
    }

    protected void p(String s) {
        output.println(s);
    }
}
