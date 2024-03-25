import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Programm started");

        try {
            CharStream charStream = CharStreams.fromFileName(args[0]);
            ExprLexer exprLexer = new ExprLexer(charStream);
            CommonTokenStream tokenStream = new CommonTokenStream(exprLexer);
            ExprParser exprParser = new ExprParser(tokenStream);

            ParserRuleContext progContext = exprParser.prog();

            String declarations = progContext.accept(new ExprVisitorAssemly());

            System.out.println("\nOutput Assembler Code:");
            System.out.println(declarations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}