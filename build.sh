#!/bin/sh

java -Xmx500M org.antlr.v4.Tool -visitor -no-listener -o antlr_generated Expr.g4

