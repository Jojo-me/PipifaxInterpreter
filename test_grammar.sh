#!/bin/bash

java -Xmx500M org.antlr.v4.Tool -o antlr_generated src/Pfx.g4
javac --source-path antlr_generated -d .compiled ./src/*.java ./src/ast/*.java ./src/util/*.java
cd .compiled
java -Xmx500M org.antlr.v4.gui.TestRig Pfx program -tree ../tst/t1.pfx
