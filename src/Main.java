/*
 * Um den Parser (mit Visitors) zu erstellen:
 * java -jar ..\antlr-4.13.1-complete.jar -visitor -no-listener Expr.g4
 *
 * Um den Parser zu compilieren:
 * javac -cp antlr-4.13.1-complete.jar;. *.java
 *
 * Um das Programm laufen zu lassen:
 * java -cp antlr-4.13.1-complete.jar;. Main <INPUT_FILE>
 */

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import ast.Variable;
import ast.Function;
import ast.Type;
import util.Asm;

class Main {
    public static void main(String[] args) {
        String fileName = args[0];
        try {
            CharStream inputStream = CharStreams.fromFileName(fileName);
            PfxLexer lexer = new PfxLexer(inputStream);
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            PfxParser parser = new PfxParser(tokenStream);
            ParserRuleContext tree = parser.program();

            HashMap<ParserRuleContext, Variable> variablesAnnotation = new HashMap<>();
            HashMap<ParserRuleContext, Function> functionAnnotation = new HashMap<>();
            HashMap<ParserRuleContext, Type> typesAnnotation = new HashMap<>();
            HashMap<ParserRuleContext, String> constantsAnnotation = new HashMap<>();

            NameResolver resolver = new NameResolver(variablesAnnotation, functionAnnotation);
            tree.accept(resolver);

            if (resolver.function("main") == null) {
                throw new SemanticError("Main function is not defined");
            }

            TypeCalculator typeCalc = new TypeCalculator(variablesAnnotation, functionAnnotation, typesAnnotation);
            tree.accept(typeCalc);

            StorageAllocator allocator = new StorageAllocator(variablesAnnotation, functionAnnotation, typesAnnotation, constantsAnnotation);
            tree.accept(allocator);

            Asm output = new Asm(fileName);

            DataGenerator datagen = new DataGenerator(variablesAnnotation, functionAnnotation, typesAnnotation, constantsAnnotation, output);
            tree.accept(datagen);

            CodeGenerator codegen = new CodeGenerator(variablesAnnotation, functionAnnotation, typesAnnotation, constantsAnnotation, output);
            tree.accept(codegen);

            output.finish();
        }
        catch (FileNotFoundException e) {
            System.err.println("Cannot open file " + fileName + ".s for writing");
        }
        catch (IOException e) {
            System.err.println("Cannot open file " + fileName);
        }
        catch (SemanticError e) {
            System.err.println("Error: " + e.toString());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
