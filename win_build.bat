java -jar .\antlr-4.13.1-complete.jar -visitor -no-listener Expr.g4
javac -cp .\antlr-4.13.1-complete.jar *.java
java -cp "%CD%\antlr-4.13.1-complete.jar;." Main .\PipifaxCode.pfx
java -cp "%CD%\antlr-4.13.1-complete.jar;." org.antlr.v4.gui.TestRig Expr prog -tree .\PipifaxCode.pfx
pause
