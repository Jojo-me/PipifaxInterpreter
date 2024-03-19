#!/bin/sh

javac --source-path antlr_generated -d .compiled *.java

java -cp ".compiled:$CLASSPATH" Main PipifaxCode.pfx