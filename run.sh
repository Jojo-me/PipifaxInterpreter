#!/bin/sh

javac --source-path antlr_generated -d .compiled ./src/*.java ./src/ast/*.java ./src/util/*.java

java -cp ".compiled:$CLASSPATH" Main ./tst/t1.pfx