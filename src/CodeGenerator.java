import ast.Type;
import ast.Variable;
import util.Asm;
import util.Registers;
import util.Register;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.HashMap;
import java.util.Map;

class CodeGenerator extends Generator<Void> {

    private class ExprCodeGenerator extends PfxBaseVisitor<Register> {

        @Override
        public Register visitIndexedLValue(PfxParser.IndexedLValueContext ctx) {
            Type.ArrayType arr = (Type.ArrayType) types.get(ctx.lvalue());
            Register ri = ctx.expr().accept(this);
            Register rt = Registers.getGP();
            asm.li(rt, arr.elementType().storageSize());
            asm.mul(ri, ri, rt);
            rt.release();

            Register ra = ctx.lvalue().accept(this);
            asm.add(ra, ra, ri);
            ri.release();

            return ra;
        }

        @Override
        public Register visitNamedLValue(PfxParser.NamedLValueContext ctx) {
            Variable v = variables.get(ctx);
            Register r = Registers.getGP();
            asm.la(r, v.name());
            return r;
        }

        @Override
        public Register visitIntLiteralExpr(PfxParser.IntLiteralExprContext ctx) {
            Register r = Registers.getGP();
            asm.li(r, ctx.IntLiteral().getText());
            return r;
        }

        @Override
        public Register visitDoubleLiteralExpr(PfxParser.DoubleLiteralExprContext ctx) {
            Register r = Registers.getFP();
            Register rt = Registers.getGP();
            String label = constants.get(ctx);
            asm.fld(r, label,rt);
            rt.release();
            return r;
        }

        @Override
        public Register visitLValueExpr(PfxParser.LValueExprContext ctx) {
            Register ra = ctx.lvalue().accept(this);
            Type t = types.get(ctx);
            Register r = t.apply(new Type.Functor<Register>() {
                public Register apply(Type.IntType t) {
                    asm.lw(ra, ra);
                    return ra;
                }

                public Register apply(Type.DoubleType t) {
                    Register r = Registers.getFP();
                    asm.fld(r,ra);
                    ra.release();
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
                    asm.add(lhs, lhs, rhs);
                    return null;
                }

                public Void apply(Type.DoubleType t) {
                    asm.fadd(lhs, lhs, rhs);
                    return null;
                }
            });
            rhs.release();

            return lhs;
        }
    }

    private ExprCodeGenerator exprGen = new ExprCodeGenerator();

    public CodeGenerator(Map<ParserRuleContext, Variable> variables, Map<ParserRuleContext, Type> types, Map<ParserRuleContext, String> constants, Asm output) {
        super(variables, types, constants, output);
    }

    @Override
    public Void visitProgram(PfxParser.ProgramContext ctx) {
        asm.println("");
        asm.line(".text");
        asm.line(".global _main");
        asm.label("_main");
        asm.line("jal main");
        asm.line("li a7,10");
        asm.line("ecall");

        asm.label("main");
        for (ParserRuleContext c : ctx.statement()) {
            c.accept(this);
        }
        asm.line("ret");
        return null;
    }

    @Override
    public Void visitAssignmentStmt(PfxParser.AssignmentStmtContext ctx) {
        Type t = types.get(ctx.expr());
        Register r = ctx.expr().accept(exprGen);
        Register ra = ctx.lvalue().accept(exprGen);

        t.apply(new Type.Functor<Void>() {
            public Void apply(Type.IntType t) {
                asm.sw(r, ra);
                return null;
            }

            public Void apply(Type.DoubleType t) {
                asm.fsd(r, ra);
                return null;
            }
            // TODO Array assignments
        });
        r.release();
        ra.release();
        return null;
    }
}
