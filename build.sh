#!/bin/sh

java -Xmx500M org.antlr.v4.Tool -visitor -no-listener -o antlr_generated src/Pfx.g4

