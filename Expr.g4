grammar Expr;

prog: (line NEWLINE)*;

line: declaration
    | assignment
    ;

declaration: 'var' ID 'int';

assignment: ID '=' INT;

ID: [A-Za-z_][A-Za-z_0-9]*;
NEWLINE: [\n\r]+;
INT: [0-9]+;
SPACE: [ \t]+ -> skip;