grammar Pfx;

program
    : (function | declaration)*
    ;

function
    : 'func' ID '(' ')' block
    ;

block
    : '{' statement* '}'
    ;

statement
    : lvalue '=' expr # AssignmentStmt
    | ID '(' ')'       # CallStmt
	| 'if' expr block ('else' block)?
	| 'while' expr block
    ;

declaration
    : 'var' ID type
    ;

type
    : 'int'                     # IntType
    | 'double'                  # DoubleType
    | '[' IntLiteral ']' type   # ArrayType
    ;

lvalue
    : ID                    # NamedLValue
    | lvalue '[' expr ']'   # IndexedLValue
    ;

expr
    : left = expr '+' right = expr     # AddExpr
    | IntLiteral        # IntLiteralExpr
    | DoubleLiteral     # DoubleLiteralExpr
    | lvalue            # LValueExpr
    ;


/* ******************************************************************* */

fragment
INT : '0' | [1-9][0-9]* ;

fragment
EXP : [eE] [-+]? INT ;

fragment
LTR : [A-Za-z_] ;

fragment
LTR0 : [A-Za-z_0-9] ;

DoubleLiteral : INT '.' [0-9]+ (EXP)? | INT EXP ;

IntLiteral : INT ;

ID : LTR LTR0* ;

WS : [ \t\f\r\n]+ -> skip ;
COMMENT : '#' ~[\r\n]* -> skip ;
