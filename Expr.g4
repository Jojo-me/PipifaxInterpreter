grammar Expr;

prog: NEWLINE? (line NEWLINE)* line?;

// function names can be defined behind a #

line: declaration
    | assignment
    ;

declaration: 'var' ID type;

assignment: ID '=' (INT | expression);

expression: term 
            ( ('+' term)
            | ('-' term)
            )*
            ;

term: factor
      ( ('*' factor)
      | ('/' factor)
      )*
      ;
      
factor: INT
      | ID
      | '(' expression ')'
      | ('-' factor)
      ;

type: 'int';

ID: [A-Za-z_][A-Za-z_0-9]*;
NEWLINE: [\n\r]+;
INT: [0-9]+;

SPACE: [ \t]+ -> skip;
COMMENT: '#'~[\n\r]* -> skip;