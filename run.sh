#!/bin/sh

javac --source-path antlr_generated -d .compiled Main.java

java -cp ".compiled:$CLASSPATH" Main PipifaxCode.pfx