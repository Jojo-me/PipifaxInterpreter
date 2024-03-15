grammar Expr;

prog: NEWLINE? (line NEWLINE)* line?;

line: declaration
    | assignment
    ;

declaration: 'var' ID 'int';

assignment: ID '=' INT;

ID: [A-Za-z_][A-Za-z_0-9]*;
NEWLINE: [\n\r]+;
INT: [0-9]+;

SPACE: [ \t]+ -> skip;
COMMENT: '#'~[\n\r]+ -> skip;