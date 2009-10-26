////////////////////////////////////////////////////////////////////////
// Interp.g: creates a parser for the Spina language.
//
// version: 1.0
// description: Used for antlr3 to generate lexer and parser
// author: Yehong Wang (ywang50@syr.edu)
// language: antlr 3.0.1 parser generator - grammer input
////////////////////////////////////////////////////////////////////////


grammar spina;

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
  | print { retval.ret = $print.ret; }
  | parallel-for { retval.ret = $parallel-for.ret; };

assignment returns [AssignmentOperationElement ret]
@init {
  retval.ret = new AssignmentOperationElement();
}
  : (variable {retval.ret.setLhs($variable.ret); }
    | indexer {retval.ret.setLhs($indexer.ret); }
    EQUAL
    (literal {retval.ret.setRhs($literal.ret); }
    | addition {retval.ret.setRhs($addition.ret); }
    | multiplication {retval.ret.setRhs($multiplication.ret); }
    )
    END_OF_STATEMENT;

addition returns [AdditionOperationElement ret]
@init {
  retval.ret = new AdditionOperationElement();
}
  : (variable { retval.ret.setLhs($variable.ret); }
    | indexer { retval.ret.setLhs($indexer.ret); }
    | literal { retval.ret.setLhs($literal.ret); })
    '+'
    (variable { retval.ret.setRhs($variable.ret); }
    | indexer { retval.ret.setRhs($indexer.ret); }
    | literal { retval.ret.setRhs($literal.ret); });

multiplication returns [MultiplicationOperationElement ret]
@init {
  retval.ret = new MultiplicationOperationElement();
}
  : (variable { retval.ret.setLhs($variable.ret); }
    | indexer { retval.ret.setLhs($indexer.ret); }
    | literal { retval.ret.setLhs($literal.ret); })
    '*'
    (variable { retval.ret.setRhs($variable.ret); }
    | indexer { retval.ret.setRhs($indexer.ret); }
    | literal { retval.ret.setRhs($literal.ret); });

variable returns [VariableElement ret]
@init {
  retval.ret = new VariableElement();
}
  : VARIABLE { retval.ret.setText($VARIABLE.text); };

indexer returns [IndexerElement ret]
@init {
  retval.ret = new IndexerElement();
}
  : VARIABLE { retval.ret.setText($VARIABLE.text); }
  '<'
  VARIABLE { retval.ret.setIter($VARIABLE.text); }
  '>';

literal returns [Element ret]
  :  (scalar_literal { retval.ret = $scalar_literal.ret; }
  |   matrix_literal { retval.ret = $matrix_literal.ret; } );

scalar_literal returns [IntegerElement ret]
@init {
  retval.ret = new IntegerElement();
}
  : INTERGER { retval.ret.setText($INTERGER.text); };

matrix_literal returns [MatrixElement ret]
@init {
  retval.ret = new MatrixElement();
}
  : SQU_BRACKET_LEFT 
    (ROU_BRACKET_LEFT
     INTEGER { retval.ret.addText($INTEGER.text); }
     (COMMA
     INTEGER { retval.ret.addText($INTEGER.text); })*
     ROU_BRACKET_RIGHT { retval.ret.increRow(); })+
    SQU_BRACKET_RIGHT;

parallel-for returns [ParallelForElement ret]
@init {
  retval.ret = new ParallelForElement();
}
  : PARALLEL-FOR
    ROU_BRACKET_LEFT
    VARIABLE { retval.ret.setVar($VARIABLE.text); }
    EQUAL
    INTEGER { retval.ret.setStart($INTEGER.text); }
    TO
    INTEGER { retval.ret.setEnd($INTEGER.text); }
    ROU_BRACKET_RIGHT
    CUR_BRACKET_LEFT
    (assignment { retval.ret.addAssignment($assignment.ret); })+
    CUR_BRACKET_RIGHT;

print returns [PrintOperationElement ret]
@init {
  retval.ret = new PrintOperationElement();
}
  : PRINT
    (variable { retval.ret.setChildElement($variable.ret); }
    | indexer { retval.ret.setChildElement($indexer.ret); }
    | literal { retval.ret.setChildElement($literal.ret); })
    END_OF_STATEMENT;

/*
 * Lexer rules
 */

END_OF_STATEMENT: ';';
EQUAL: '=';
PLUS: '+';
MULTIPLY: '*';
ANG_BRACKET_LEFT: '<';
ANG_BRACKET_RIGHT: '>';
SQU_BRACKET_LEFT: '[';
SQU_BRACKET_RIGHT: ']';
ROU_BRACKET_LEFT: '(';
ROU_BRACKET_RIGHT: ')';
CUR_BRACKET_LEFT: '{';
CUR_BRACKET_RIGHT: '}';
COMMA: ',';
TO: '..';
PARALLEL-FOR: 'parallel-for';
PRINT: 'print';
VARIABLE: ('a'..'z' | 'A'..'Z' ) ('a'..'z' | 'A'..'Z' | '0'..'9')*;
INTEGER: ('0' | ('1'..'9) ('0'..'9')*);
WHITESPACE : (' ' | '\t' | '\n' | '\r' )+ {$channel = HIDDEN; } ;
