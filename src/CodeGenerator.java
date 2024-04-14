import ast.Type;
import ast.Variable;
import util.Registers;
import util.Register;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.HashMap;
import java.util.Map;
import java.io.PrintStream;

class CodeGenerator extends Generator<Void> {

    private class ExprCodeGenerator extends PfxBaseVisitor<Register> {
        @Override
        public Register visitIntLiteralExpr(PfxParser.IntLiteralExprContext ctx) {
            Register r = Registers.getGP();
            p("\tli " + r + "," + ctx.IntLiteral().getText());
            return r;
        }

        @Override
        public Register visitDoubleLiteralExpr(PfxParser.DoubleLiteralExprContext ctx) {
            Register r = Registers.getFP();
            Register rt = Registers.getGP();
            String label = constants.get(ctx);
            p("\tfld " + r + "," + label + "," + rt);
            rt.release();
            return r;
        }

        @Override
        public Register visitNameExpr(PfxParser.NameExprContext ctx) {
            Variable v = variables.get(ctx);
            Register r = v.type().apply(new Type.Functor<Register>() {
                public Register apply(Type.IntType t) {
                    Register r = Registers.getGP();
                    p("\tlw " + r + "," + v.name());
                    return r;
                }

                public Register apply(Type.DoubleType t) {
                    Register r = Registers.getFP();
                    Register rt = Registers.getGP();
                    p("\tfld " + r + "," + v.name() + "," + rt);
                    rt.release();
                    return r;
                }
            });
            return r;
        }

        @Override
        public Register visitAddExpr(PfxParser.AddExprContext ctx) {
            Register lhs = ctx.left.accept(this);
            Register rhs = ctx.right.accept(this);

            types.get(ctx).apply(new Type.Functor<Void>() {
                public Void apply(Type.IntType t) {
                    p("\tadd " + lhs + "," + lhs + "," + rhs);
                    return null;
                }

                public Void apply(Type.DoubleType t) {
                    p("\tfadd.d " + lhs + "," + lhs + "," + rhs);
                    return null;
                }
            });
            rhs.release();

            return lhs;
        }
    }

    private ExprCodeGenerator exprGen = new ExprCodeGenerator();

    public CodeGenerator(Map<ParserRuleContext, Variable> variables, Map<ParserRuleContext, Type> types, Map<ParserRuleContext, String> constants, PrintStream output) {
        super(variables, types, constants, output);
    }

    @Override
    public Void visitProgram(PfxParser.ProgramContext ctx) {
        p("\n\t.text");
        p("\t.global main");
        p("main:");
        for (ParserRuleContext c : ctx.statement()) {
            c.accept(this);
        }
        return null;
    }

    @Override
    public Void visitAssignmentStmt(PfxParser.AssignmentStmtContext ctx) {
        Type t = types.get(ctx.expr());
        Register r = ctx.expr().accept(exprGen);
        Variable v = variables.get(ctx);

        v.type().apply(new Type.Functor<Void>() {
            public Void apply(Type.IntType t) {
                Register rt = Registers.getGP();
                p("\tsw " + r + "," + v.name() + "," + rt);
                rt.release();
                return null;
            }

            public Void apply(Type.DoubleType t) {
                Register rt = Registers.getGP();
                p("\tfsd " + r + "," + v.name() + "," + rt);
                rt.release();
                return null;
            }
        });
        r.release();
        return null;
    }
}
