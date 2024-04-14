// Generated from Pfx.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PfxParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PfxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PfxParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PfxParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link PfxParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(PfxParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PfxParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(PfxParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link PfxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(PfxParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleType}
	 * labeled alternative in {@link PfxParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleType(PfxParser.DoubleTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntLiteralExpr}
	 * labeled alternative in {@link PfxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteralExpr(PfxParser.IntLiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoubleLiteralExpr}
	 * labeled alternative in {@link PfxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleLiteralExpr(PfxParser.DoubleLiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NameExpr}
	 * labeled alternative in {@link PfxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameExpr(PfxParser.NameExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddExpr}
	 * labeled alternative in {@link PfxParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(PfxParser.AddExprContext ctx);
}