import ast.Type;
import ast.Variable;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.Map;
import java.io.PrintStream;

class DataGenerator extends Generator<Void> {

    public DataGenerator(Map<ParserRuleContext, Variable> variables, Map<ParserRuleContext, Type> types, Map<ParserRuleContext, String> constants, PrintStream output) {
        super(variables, types, constants, output);
    }

    public Void visitProgram(PfxParser.ProgramContext ctx) {
        p("\t.data");
        for (ParserRuleContext c : ctx.declaration()) {
            c.accept(this);
        }
        for (ParserRuleContext c : ctx.statement()) {
            c.accept(this);
        }
        return null;
    }

    public Void visitDeclaration(PfxParser.DeclarationContext ctx) {
        Variable v = variables.get(ctx);
        Type.Functor<String> f = new Type.Functor<>() {
            public String apply(Type.IntType t) {
                return ".space " + t.storageSize();
            }

            public String apply(Type.DoubleType t) {
                return ".space " + t.storageSize();
            }
        };
        p(v.name() + ":\t" + v.type().apply(f));
        return null;
    }

    public Void visitDoubleLiteralExpr(PfxParser.DoubleLiteralExprContext ctx) {
        String label = constants.get(ctx);
        p(label + ":\t.double " + ctx.DoubleLiteral().getText());
        return null;
    }
}
