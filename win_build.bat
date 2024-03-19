java -jar .\antlr-4.13.1-complete.jar -visitor -no-listener Expr.g4
javac -cp .\antlr-4.13.1-complete.jar *.java
java -cp "C:\Users\sven.wolf\OneDrive - Advantest\Studienjahr 2\Semester 4\Compiler\CompilerbauProject\antlr-4.13.1-complete.jar;." Main .\PipifaxCode.pfx
java -cp "C:\Users\sven.wolf\OneDrive - Advantest\Studienjahr 2\Semester 4\Compiler\CompilerbauProject\antlr-4.13.1-complete.jar;." org.antlr.v4.gui.TestRig Expr prog -tree .\PipifaxCode.pfx
