import ast.Type;
import ast.Variable;
import ast.Function;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.Map;

class StorageAllocator extends PfxBaseVisitor<Void> {

    private Map<ParserRuleContext, Variable> variables;
    private Map<ParserRuleContext, Function> functions;
    private Map<ParserRuleContext, Type> types;
    private Map<ParserRuleContext, String> constants;

    private static int counter = 0;

    public StorageAllocator(Map<ParserRuleContext, Variable> variables, Map<ParserRuleContext, Function> functions, Map<ParserRuleContext, Type> types, Map<ParserRuleContext, String> constants) {
        this.variables = variables;
        this.functions = functions;
        this.types = types;
        this.constants = constants;
    }

    @Override
    public Void visitDoubleLiteralExpr(PfxParser.DoubleLiteralExprContext ctx) {
        String c = "const_" + counter;
        counter++;
        constants.put(ctx, c);
        return null;
    }
}
