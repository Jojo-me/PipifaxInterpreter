import java.io.IOException;
import java.util.*;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

public class Main {

    public static List<PfxVariable> variables = new ArrayList<PfxVariable>();

    public static void main(String[] args) {
        System.out.println("Programm started");

        try {
            CharStream charStream = CharStreams.fromFileName(args[0]);
            ExprLexer exprLexer = new ExprLexer(charStream);
            CommonTokenStream tokenStream = new CommonTokenStream(exprLexer);
            ExprParser exprParser = new ExprParser(tokenStream);

            ParserRuleContext progContext = exprParser.prog();

            progContext.accept(new ExprVisitorNameChecker(variables));
            
            String assemblerCode = progContext.accept(new ExprVisitorAssembly(variables));
            System.out.println("Assembler Code:");
            System.out.println(assemblerCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
