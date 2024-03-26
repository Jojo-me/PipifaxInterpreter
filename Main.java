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

            progContext.accept(new ExprVisitorNameChecker());
            
            String assemblerCode = progContext.accept(new ExprVisitorAssembly());
            System.out.println("Assembler Code:");
            System.out.println(assemblerCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
