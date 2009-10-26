////////////////////////////////////////////////////////////////////////
// Interp.g: creates a parser for the Spina language.
//
// version: 1.0
// description: Used for antlr3 to generate lexer and parser
// author: Yehong Wang (ywang50@syr.edu)
// language: antlr 3.0.1 parser generator - grammer input
////////////////////////////////////////////////////////////////////////


grammar Interp;

options {
  language = 'Java';
  output=AST;
}

@header {
package spina;

import java.util.Vector;
}

/*
 * Parser Rules
 */
program returns [Vector<Element> ret]
@init {
  retval.ret = new Vector<Element>();
}
  : (expr {retval.ret.add($expr.ret); } )+;

expr returns [Element ret]
  : assignment {retval.ret = $assignment.ret;}
  | print { retval.ret = $print.ret; };

assignment returns [AssignmentOperationElement ret]
@init {
  retval.ret = new AssignmentOperationElement();
}
  : variable {retval.ret.setLhs($variable.ret); }
    ASSIGNMENT
    (var_or_int_literal {retval.ret.setRhs($var_or_int_literal.ret); }
    | addition {retval.ret.setRhs($addition.ret); }
    ) END_OF_STATEMENT;

var_or_int_literal returns [Element ret]
  :  (variable { retval.ret = $variable.ret; }
  |   int_literal {retval.ret = $int_literal.ret; } );

variable returns [VariableElement ret]
@init {
  retval.ret = new VariableElement();
}
  : VARIABLE { retval.ret.setText($VARIABLE.text); };

int_literal returns [IntegerElement ret]
@init {
  retval.ret = new IntegerElement();
}
  : INT_LITERAL { retval.ret.setText($INT_LITERAL.text); };

addition returns [AdditionOperationElement ret]
@init {
  retval.ret = new AdditionOperationElement();
}
  : el1=var_or_int_literal { retval.ret.setLhs($el1.ret); }
    '+'
    el2=var_or_int_literal { retval.ret.setRhs($el2.ret); };

print returns [PrintOperationElement ret]
@init {
  retval.ret = new PrintOperationElement();
}
  : 'print' var_or_int_literal {retval.ret.setChildElement($var_or_int_literal.ret); }
    END_OF_STATEMENT;

/*
 * Spina syntax
 */

END_OF_STATEMENT: ';';
ASSIGNMENT: '=';
PLUS: '+';
VARIABLE: ('a'..'z' | 'A'..'Z' )+;
INT_LITERAL: ('0'..'9')+;
WHITESPACE : (' ' | '\t' | '\n' | '\r' )+ {$channel = HIDDEN; } ;

program: (top_level_expression)+;
top_level_expression: (assignment | parallel-for | print);
assignment: ((variable | indexer) '=' assignment_rhs ';');
assignment_rhs: (variable | indexer | literal) (+ | *) (variable | indexer | literal);
indexer: variable '<' variable '>';
literal: (scalar_literal | matrix_literal);
variable: ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9')*;
scalar_literal: number;
matrix_literal: '[' matrix_literal_row+ ']';
matrix_literal_row: '(' number (',' number)* ')';
number: ('0' | ('1'..'9) ('0'..'9')*);
parallel-for: 'parallel-for' '(' variable '=' '0' 'to' num_iters ')' parallel-for_body;
num_iters: ('1'..'9');
parallel-for_body: '{' assignment+ '}';
print: 'print' (variable | indexer | literal);
