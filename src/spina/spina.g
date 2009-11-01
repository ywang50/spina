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
  | parallel_for { retval.ret = $parallel_for.ret; };

assignment returns [AssignmentOperationElement ret]
@init {
  retval.ret = new AssignmentOperationElement();
}
  : (variable {retval.ret.setLhs($variable.ret); }
    | indexer {retval.ret.setLhs($indexer.ret); })
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
  : (var1=variable { retval.ret.setLhs($var1.ret); }
    | ind1=indexer { retval.ret.setLhs($ind1.ret); }
    | lit1=literal { retval.ret.setLhs($lit1.ret); })
    PLUS
    (var2=variable { retval.ret.setRhs($var2.ret); }
    | ind2=indexer { retval.ret.setRhs($ind2.ret); }
    | lit2=literal { retval.ret.setRhs($lit2.ret); });

multiplication returns [MultiplicationOperationElement ret]
@init {
  retval.ret = new MultiplicationOperationElement();
}
  : (var1=variable { retval.ret.setLhs($var1.ret); }
    | ind1=indexer { retval.ret.setLhs($ind1.ret); }
    | lit1=literal { retval.ret.setLhs($lit1.ret); })
    MULTIPLY
    (var2=variable { retval.ret.setRhs($var2.ret); }
    | ind2=indexer { retval.ret.setRhs($ind2.ret); }
    | lit2=literal { retval.ret.setRhs($lit2.ret); });

variable returns [VariableElement ret]
@init {
  retval.ret = new VariableElement();
}
  : VARIABLE { retval.ret.setText($VARIABLE.text); };

indexer returns [IndexerElement ret]
@init {
  retval.ret = new IndexerElement();
}
  : VAR1=VARIABLE { retval.ret.setName($VAR1.text); }
  '<'
  VAR2=VARIABLE { retval.ret.setIter($VAR2.text); }
  '>';

literal returns [Element ret]
  :  (scalar_literal { retval.ret = $scalar_literal.ret; }
  |   matrix_literal { retval.ret = $matrix_literal.ret; } );

scalar_literal returns [IntegerElement ret]
@init {
  retval.ret = new IntegerElement();
}
  : INTEGER { retval.ret.setText($INTEGER.text); };

matrix_literal returns [MatrixElement ret]
@init {
  retval.ret = new MatrixElement();
}
  : SQU_BRACKET_LEFT 
    (ROU_BRACKET_LEFT
     INT1=INTEGER { retval.ret.addText($INT1.text); }
     (COMMA
     INT2=INTEGER { retval.ret.addText($INT2.text); })*
     ROU_BRACKET_RIGHT { retval.ret.increRow(); })+
    SQU_BRACKET_RIGHT;

parallel_for returns [ParallelForElement ret]
@init {
  retval.ret = new ParallelForElement();
}
  : PARALLEL_FOR
    ROU_BRACKET_LEFT
    VARIABLE { retval.ret.setVar($VARIABLE.text); }
    EQUAL
    INT1=INTEGER { retval.ret.setStart($INT1.text); }
    TO
    INT2=INTEGER { retval.ret.setEnd($INT2.text); }
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
PARALLEL_FOR: 'parallel-for';
PRINT: 'print';
VARIABLE: ('a'..'z' | 'A'..'Z' ) ('a'..'z' | 'A'..'Z' | '0'..'9')*;
INTEGER: ('0' | ('1'..'9') ('0'..'9')*);
WHITESPACE : (' ' | '\t' | '\n' | '\r' )+ {$channel = HIDDEN; } ;
