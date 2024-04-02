grammar Expr;

prog: NEWLINE? (line NEWLINE)* line?;

// function names can be defined behind a #

line: declaration
    | assignment
    ;

declaration: 'var' ID type;

assignment: ID '=' rvalue;

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
      
factor: rvalue
//      | ID
      | '(' expression ')'
      | ('-' factor)
      ;

type: 'double'
    | 'int';

rvalue: DOUBLE # rValueDouble
      | INT # rValueInt;

ID: [A-Za-z_][A-Za-z_0-9]*;
NEWLINE: [\n\r]+;
DOUBLE: INT'.'[0-9]+;
INT: ([1-9][0-9]*|[0-9]);

SPACE: [ \t]+ -> skip;
COMMENT: '#'~[\n\r]* -> skip;
