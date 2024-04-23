import ast.Type;
import ast.Variable;
import util.Asm;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.Map;

class DataGenerator extends Generator<Void> {

    public DataGenerator(Map<ParserRuleContext, Variable> variables, Map<ParserRuleContext, Type> types, Map<ParserRuleContext, String> constants, Asm output) {
        super(variables, types, constants, output);
    }

    public Void visitProgram(PfxParser.ProgramContext ctx) {
        asm.line(".data");
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

            public String apply(Type.ArrayType t) {
                return ".space " + t.storageSize();
            }
        };
        asm.label(v.name());
        asm.line(v.type().apply(f));
        return null;
    }

    public Void visitDoubleLiteralExpr(PfxParser.DoubleLiteralExprContext ctx) {
        String label = constants.get(ctx);
        asm.label(label);
        asm.line(".double " + ctx.DoubleLiteral().getText());
        return null;
    }
}
