grammar Expr;

proc: (line NEWLINE)*;

line: definition
    | assignment
    ;

definition: 'var' ID 'int';

assignment: ID '=' INT;

ID: [A-Za-a_][A-Za-z_0-9]*;
NEWLINE: [\n\r]+;
INT: [0-9]+;