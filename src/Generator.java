import ast.Type;
import ast.Variable;
import ast.Function;
import util.Asm;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.Map;

class Generator<T> extends PfxBaseVisitor<T> {

    protected Map<ParserRuleContext, Variable> variables;
    protected Map<ParserRuleContext, Function> functions;
    protected Map<ParserRuleContext, Type> types;
    protected Map<ParserRuleContext, String> constants;
    protected Asm asm;

    public Generator(Map<ParserRuleContext, Variable> variables, Map<ParserRuleContext, Function> functions, Map<ParserRuleContext, Type> types, Map<ParserRuleContext, String> constants, Asm output) {
        this.variables = variables;
        this.functions = functions;
        this.types = types;
        this.constants = constants;
        this.asm = output;
    }
}
