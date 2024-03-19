#!/bin/bash

java -Xmx500M org.antlr.v4.Tool -o antlr_generated Expr.g4
javac --source-path antlr_generated -d .compiled *.java
cd .compiled
java -Xmx500M org.antlr.v4.gui.TestRig Expr prog -tree ../PipifaxCode.pfx
