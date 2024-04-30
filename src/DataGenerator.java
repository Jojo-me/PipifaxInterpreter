import ast.Type;
import ast.Variable;
import ast.Function;
import util.Asm;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.Map;

class DataGenerator extends Generator<Void> {

    public DataGenerator(Map<ParserRuleContext, Variable> variables, Map<ParserRuleContext, Function> functions, Map<ParserRuleContext, Type> types, Map<ParserRuleContext, String> constants, Asm output) {
        super(variables, functions, types, constants, output);
    }

    public Void visitProgram(PfxParser.ProgramContext ctx) {
        asm.line(".data");
        for (ParserRuleContext c : ctx.declaration()) {
            c.accept(this);
        }
        for (ParserRuleContext c : ctx.function()) {
            c.accept(this);
        }
        return null;
    }

    public Void visitDeclaration(PfxParser.DeclarationContext ctx) {
        Variable v = variables.get(ctx);
        Type.Functor<Void> f = new Type.Functor<>() {
            public Void apply(Type.IntType t) {
                asm.line(".space " + t.storageSize());
                return null;
            }

            public Void apply(Type.DoubleType t) {
                asm.line(".space " + t.storageSize());
                return null;
            }

            public Void apply(Type.ArrayType t) {
                asm.line(".space " + t.storageSize());
                return null;
            }
        };
        asm.label(v.label());
        v.type().apply(f);
        return null;
    }

    public Void visitDoubleLiteralExpr(PfxParser.DoubleLiteralExprContext ctx) {
        String label = constants.get(ctx);
        asm.label(label);
        asm.line(".double " + ctx.DoubleLiteral().getText());
        return null;
    }
}
