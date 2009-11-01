// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 spina.g 2009-11-01 04:05:41

package spina;

import java.util.Vector;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class spinaParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "EQUAL", "END_OF_STATEMENT", "PLUS", "MULTIPLY", "VARIABLE", "INTEGER", "SQU_BRACKET_LEFT", "ROU_BRACKET_LEFT", "COMMA", "ROU_BRACKET_RIGHT", "SQU_BRACKET_RIGHT", "PARALLEL_FOR", "TO", "CUR_BRACKET_LEFT", "CUR_BRACKET_RIGHT", "PRINT", "ANG_BRACKET_LEFT", "ANG_BRACKET_RIGHT", "WHITESPACE"
    };
    public static final int INTEGER=9;
    public static final int PARALLEL_FOR=15;
    public static final int TO=16;
    public static final int WHITESPACE=22;
    public static final int ANG_BRACKET_LEFT=20;
    public static final int EOF=-1;
    public static final int PRINT=19;
    public static final int CUR_BRACKET_LEFT=17;
    public static final int ROU_BRACKET_LEFT=11;
    public static final int VARIABLE=8;
    public static final int MULTIPLY=7;
    public static final int COMMA=12;
    public static final int EQUAL=4;
    public static final int PLUS=6;
    public static final int ROU_BRACKET_RIGHT=13;
    public static final int CUR_BRACKET_RIGHT=18;
    public static final int ANG_BRACKET_RIGHT=21;
    public static final int SQU_BRACKET_LEFT=10;
    public static final int SQU_BRACKET_RIGHT=14;
    public static final int END_OF_STATEMENT=5;

    // delegates
    // delegators


        public spinaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public spinaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return spinaParser.tokenNames; }
    public String getGrammarFileName() { return "spina.g"; }


    public static class program_return extends ParserRuleReturnScope {
        public Vector<Element> ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "program"
    // spina.g:27:1: program returns [Vector<Element> ret] : ( expr )+ ;
    public final spinaParser.program_return program() throws RecognitionException {
        spinaParser.program_return retval = new spinaParser.program_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        spinaParser.expr_return expr1 = null;




          retval.ret = new Vector<Element>();

        try {
            // spina.g:31:3: ( ( expr )+ )
            // spina.g:31:5: ( expr )+
            {
            root_0 = (Object)adaptor.nil();

            // spina.g:31:5: ( expr )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==VARIABLE||LA1_0==PARALLEL_FOR||LA1_0==PRINT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // spina.g:31:6: expr
            	    {
            	    pushFollow(FOLLOW_expr_in_program61);
            	    expr1=expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, expr1.getTree());
            	    retval.ret.add((expr1!=null?expr1.ret:null)); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class expr_return extends ParserRuleReturnScope {
        public Element ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // spina.g:33:1: expr returns [Element ret] : ( assignment | print | parallel_for );
    public final spinaParser.expr_return expr() throws RecognitionException {
        spinaParser.expr_return retval = new spinaParser.expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        spinaParser.assignment_return assignment2 = null;

        spinaParser.print_return print3 = null;

        spinaParser.parallel_for_return parallel_for4 = null;



        try {
            // spina.g:34:3: ( assignment | print | parallel_for )
            int alt2=3;
            switch ( input.LA(1) ) {
            case VARIABLE:
                {
                alt2=1;
                }
                break;
            case PRINT:
                {
                alt2=2;
                }
                break;
            case PARALLEL_FOR:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // spina.g:34:5: assignment
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_assignment_in_expr80);
                    assignment2=assignment();

                    state._fsp--;

                    adaptor.addChild(root_0, assignment2.getTree());
                    retval.ret = (assignment2!=null?assignment2.ret:null);

                    }
                    break;
                case 2 :
                    // spina.g:35:5: print
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_print_in_expr88);
                    print3=print();

                    state._fsp--;

                    adaptor.addChild(root_0, print3.getTree());
                     retval.ret = (print3!=null?print3.ret:null); 

                    }
                    break;
                case 3 :
                    // spina.g:36:5: parallel_for
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_parallel_for_in_expr96);
                    parallel_for4=parallel_for();

                    state._fsp--;

                    adaptor.addChild(root_0, parallel_for4.getTree());
                     retval.ret = (parallel_for4!=null?parallel_for4.ret:null); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class assignment_return extends ParserRuleReturnScope {
        public AssignmentOperationElement ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignment"
    // spina.g:38:1: assignment returns [AssignmentOperationElement ret] : ( variable | indexer ) EQUAL ( literal | addition | multiplication ) END_OF_STATEMENT ;
    public final spinaParser.assignment_return assignment() throws RecognitionException {
        spinaParser.assignment_return retval = new spinaParser.assignment_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EQUAL7=null;
        Token END_OF_STATEMENT11=null;
        spinaParser.variable_return variable5 = null;

        spinaParser.indexer_return indexer6 = null;

        spinaParser.literal_return literal8 = null;

        spinaParser.addition_return addition9 = null;

        spinaParser.multiplication_return multiplication10 = null;


        Object EQUAL7_tree=null;
        Object END_OF_STATEMENT11_tree=null;


          retval.ret = new AssignmentOperationElement();

        try {
            // spina.g:42:3: ( ( variable | indexer ) EQUAL ( literal | addition | multiplication ) END_OF_STATEMENT )
            // spina.g:42:5: ( variable | indexer ) EQUAL ( literal | addition | multiplication ) END_OF_STATEMENT
            {
            root_0 = (Object)adaptor.nil();

            // spina.g:42:5: ( variable | indexer )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==VARIABLE) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==ANG_BRACKET_LEFT) ) {
                    alt3=2;
                }
                else if ( (LA3_1==EQUAL) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // spina.g:42:6: variable
                    {
                    pushFollow(FOLLOW_variable_in_assignment118);
                    variable5=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable5.getTree());
                    retval.ret.setLhs((variable5!=null?variable5.ret:null)); 

                    }
                    break;
                case 2 :
                    // spina.g:43:7: indexer
                    {
                    pushFollow(FOLLOW_indexer_in_assignment128);
                    indexer6=indexer();

                    state._fsp--;

                    adaptor.addChild(root_0, indexer6.getTree());
                    retval.ret.setLhs((indexer6!=null?indexer6.ret:null)); 

                    }
                    break;

            }

            EQUAL7=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_assignment137); 
            EQUAL7_tree = (Object)adaptor.create(EQUAL7);
            adaptor.addChild(root_0, EQUAL7_tree);

            // spina.g:45:5: ( literal | addition | multiplication )
            int alt4=3;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // spina.g:45:6: literal
                    {
                    pushFollow(FOLLOW_literal_in_assignment144);
                    literal8=literal();

                    state._fsp--;

                    adaptor.addChild(root_0, literal8.getTree());
                    retval.ret.setRhs((literal8!=null?literal8.ret:null)); 

                    }
                    break;
                case 2 :
                    // spina.g:46:7: addition
                    {
                    pushFollow(FOLLOW_addition_in_assignment154);
                    addition9=addition();

                    state._fsp--;

                    adaptor.addChild(root_0, addition9.getTree());
                    retval.ret.setRhs((addition9!=null?addition9.ret:null)); 

                    }
                    break;
                case 3 :
                    // spina.g:47:7: multiplication
                    {
                    pushFollow(FOLLOW_multiplication_in_assignment164);
                    multiplication10=multiplication();

                    state._fsp--;

                    adaptor.addChild(root_0, multiplication10.getTree());
                    retval.ret.setRhs((multiplication10!=null?multiplication10.ret:null)); 

                    }
                    break;

            }

            END_OF_STATEMENT11=(Token)match(input,END_OF_STATEMENT,FOLLOW_END_OF_STATEMENT_in_assignment178); 
            END_OF_STATEMENT11_tree = (Object)adaptor.create(END_OF_STATEMENT11);
            adaptor.addChild(root_0, END_OF_STATEMENT11_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assignment"

    public static class addition_return extends ParserRuleReturnScope {
        public AdditionOperationElement ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addition"
    // spina.g:51:1: addition returns [AdditionOperationElement ret] : (var1= variable | ind1= indexer | lit1= literal ) PLUS (var2= variable | ind2= indexer | lit2= literal ) ;
    public final spinaParser.addition_return addition() throws RecognitionException {
        spinaParser.addition_return retval = new spinaParser.addition_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PLUS12=null;
        spinaParser.variable_return var1 = null;

        spinaParser.indexer_return ind1 = null;

        spinaParser.literal_return lit1 = null;

        spinaParser.variable_return var2 = null;

        spinaParser.indexer_return ind2 = null;

        spinaParser.literal_return lit2 = null;


        Object PLUS12_tree=null;


          retval.ret = new AdditionOperationElement();

        try {
            // spina.g:55:3: ( (var1= variable | ind1= indexer | lit1= literal ) PLUS (var2= variable | ind2= indexer | lit2= literal ) )
            // spina.g:55:5: (var1= variable | ind1= indexer | lit1= literal ) PLUS (var2= variable | ind2= indexer | lit2= literal )
            {
            root_0 = (Object)adaptor.nil();

            // spina.g:55:5: (var1= variable | ind1= indexer | lit1= literal )
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==VARIABLE) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==ANG_BRACKET_LEFT) ) {
                    alt5=2;
                }
                else if ( (LA5_1==PLUS) ) {
                    alt5=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA5_0>=INTEGER && LA5_0<=SQU_BRACKET_LEFT)) ) {
                alt5=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // spina.g:55:6: var1= variable
                    {
                    pushFollow(FOLLOW_variable_in_addition200);
                    var1=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, var1.getTree());
                     retval.ret.setLhs((var1!=null?var1.ret:null)); 

                    }
                    break;
                case 2 :
                    // spina.g:56:7: ind1= indexer
                    {
                    pushFollow(FOLLOW_indexer_in_addition212);
                    ind1=indexer();

                    state._fsp--;

                    adaptor.addChild(root_0, ind1.getTree());
                     retval.ret.setLhs((ind1!=null?ind1.ret:null)); 

                    }
                    break;
                case 3 :
                    // spina.g:57:7: lit1= literal
                    {
                    pushFollow(FOLLOW_literal_in_addition224);
                    lit1=literal();

                    state._fsp--;

                    adaptor.addChild(root_0, lit1.getTree());
                     retval.ret.setLhs((lit1!=null?lit1.ret:null)); 

                    }
                    break;

            }

            PLUS12=(Token)match(input,PLUS,FOLLOW_PLUS_in_addition233); 
            PLUS12_tree = (Object)adaptor.create(PLUS12);
            adaptor.addChild(root_0, PLUS12_tree);

            // spina.g:59:5: (var2= variable | ind2= indexer | lit2= literal )
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==VARIABLE) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==ANG_BRACKET_LEFT) ) {
                    alt6=2;
                }
                else if ( (LA6_1==END_OF_STATEMENT) ) {
                    alt6=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA6_0>=INTEGER && LA6_0<=SQU_BRACKET_LEFT)) ) {
                alt6=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // spina.g:59:6: var2= variable
                    {
                    pushFollow(FOLLOW_variable_in_addition242);
                    var2=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, var2.getTree());
                     retval.ret.setRhs((var2!=null?var2.ret:null)); 

                    }
                    break;
                case 2 :
                    // spina.g:60:7: ind2= indexer
                    {
                    pushFollow(FOLLOW_indexer_in_addition254);
                    ind2=indexer();

                    state._fsp--;

                    adaptor.addChild(root_0, ind2.getTree());
                     retval.ret.setRhs((ind2!=null?ind2.ret:null)); 

                    }
                    break;
                case 3 :
                    // spina.g:61:7: lit2= literal
                    {
                    pushFollow(FOLLOW_literal_in_addition266);
                    lit2=literal();

                    state._fsp--;

                    adaptor.addChild(root_0, lit2.getTree());
                     retval.ret.setRhs((lit2!=null?lit2.ret:null)); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "addition"

    public static class multiplication_return extends ParserRuleReturnScope {
        public MultiplicationOperationElement ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiplication"
    // spina.g:63:1: multiplication returns [MultiplicationOperationElement ret] : (var1= variable | ind1= indexer | lit1= literal ) MULTIPLY (var2= variable | ind2= indexer | lit2= literal ) ;
    public final spinaParser.multiplication_return multiplication() throws RecognitionException {
        spinaParser.multiplication_return retval = new spinaParser.multiplication_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token MULTIPLY13=null;
        spinaParser.variable_return var1 = null;

        spinaParser.indexer_return ind1 = null;

        spinaParser.literal_return lit1 = null;

        spinaParser.variable_return var2 = null;

        spinaParser.indexer_return ind2 = null;

        spinaParser.literal_return lit2 = null;


        Object MULTIPLY13_tree=null;


          retval.ret = new MultiplicationOperationElement();

        try {
            // spina.g:67:3: ( (var1= variable | ind1= indexer | lit1= literal ) MULTIPLY (var2= variable | ind2= indexer | lit2= literal ) )
            // spina.g:67:5: (var1= variable | ind1= indexer | lit1= literal ) MULTIPLY (var2= variable | ind2= indexer | lit2= literal )
            {
            root_0 = (Object)adaptor.nil();

            // spina.g:67:5: (var1= variable | ind1= indexer | lit1= literal )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==VARIABLE) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==ANG_BRACKET_LEFT) ) {
                    alt7=2;
                }
                else if ( (LA7_1==MULTIPLY) ) {
                    alt7=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA7_0>=INTEGER && LA7_0<=SQU_BRACKET_LEFT)) ) {
                alt7=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // spina.g:67:6: var1= variable
                    {
                    pushFollow(FOLLOW_variable_in_multiplication291);
                    var1=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, var1.getTree());
                     retval.ret.setLhs((var1!=null?var1.ret:null)); 

                    }
                    break;
                case 2 :
                    // spina.g:68:7: ind1= indexer
                    {
                    pushFollow(FOLLOW_indexer_in_multiplication303);
                    ind1=indexer();

                    state._fsp--;

                    adaptor.addChild(root_0, ind1.getTree());
                     retval.ret.setLhs((ind1!=null?ind1.ret:null)); 

                    }
                    break;
                case 3 :
                    // spina.g:69:7: lit1= literal
                    {
                    pushFollow(FOLLOW_literal_in_multiplication315);
                    lit1=literal();

                    state._fsp--;

                    adaptor.addChild(root_0, lit1.getTree());
                     retval.ret.setLhs((lit1!=null?lit1.ret:null)); 

                    }
                    break;

            }

            MULTIPLY13=(Token)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_multiplication324); 
            MULTIPLY13_tree = (Object)adaptor.create(MULTIPLY13);
            adaptor.addChild(root_0, MULTIPLY13_tree);

            // spina.g:71:5: (var2= variable | ind2= indexer | lit2= literal )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==VARIABLE) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==END_OF_STATEMENT) ) {
                    alt8=1;
                }
                else if ( (LA8_1==ANG_BRACKET_LEFT) ) {
                    alt8=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA8_0>=INTEGER && LA8_0<=SQU_BRACKET_LEFT)) ) {
                alt8=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // spina.g:71:6: var2= variable
                    {
                    pushFollow(FOLLOW_variable_in_multiplication333);
                    var2=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, var2.getTree());
                     retval.ret.setRhs((var2!=null?var2.ret:null)); 

                    }
                    break;
                case 2 :
                    // spina.g:72:7: ind2= indexer
                    {
                    pushFollow(FOLLOW_indexer_in_multiplication345);
                    ind2=indexer();

                    state._fsp--;

                    adaptor.addChild(root_0, ind2.getTree());
                     retval.ret.setRhs((ind2!=null?ind2.ret:null)); 

                    }
                    break;
                case 3 :
                    // spina.g:73:7: lit2= literal
                    {
                    pushFollow(FOLLOW_literal_in_multiplication357);
                    lit2=literal();

                    state._fsp--;

                    adaptor.addChild(root_0, lit2.getTree());
                     retval.ret.setRhs((lit2!=null?lit2.ret:null)); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "multiplication"

    public static class variable_return extends ParserRuleReturnScope {
        public VariableElement ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "variable"
    // spina.g:75:1: variable returns [VariableElement ret] : VARIABLE ;
    public final spinaParser.variable_return variable() throws RecognitionException {
        spinaParser.variable_return retval = new spinaParser.variable_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VARIABLE14=null;

        Object VARIABLE14_tree=null;


          retval.ret = new VariableElement();

        try {
            // spina.g:79:3: ( VARIABLE )
            // spina.g:79:5: VARIABLE
            {
            root_0 = (Object)adaptor.nil();

            VARIABLE14=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_variable379); 
            VARIABLE14_tree = (Object)adaptor.create(VARIABLE14);
            adaptor.addChild(root_0, VARIABLE14_tree);

             retval.ret.setText((VARIABLE14!=null?VARIABLE14.getText():null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "variable"

    public static class indexer_return extends ParserRuleReturnScope {
        public IndexerElement ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "indexer"
    // spina.g:81:1: indexer returns [IndexerElement ret] : VAR1= VARIABLE '<' VAR2= VARIABLE '>' ;
    public final spinaParser.indexer_return indexer() throws RecognitionException {
        spinaParser.indexer_return retval = new spinaParser.indexer_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token VAR1=null;
        Token VAR2=null;
        Token char_literal15=null;
        Token char_literal16=null;

        Object VAR1_tree=null;
        Object VAR2_tree=null;
        Object char_literal15_tree=null;
        Object char_literal16_tree=null;


          retval.ret = new IndexerElement();

        try {
            // spina.g:85:3: (VAR1= VARIABLE '<' VAR2= VARIABLE '>' )
            // spina.g:85:5: VAR1= VARIABLE '<' VAR2= VARIABLE '>'
            {
            root_0 = (Object)adaptor.nil();

            VAR1=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_indexer402); 
            VAR1_tree = (Object)adaptor.create(VAR1);
            adaptor.addChild(root_0, VAR1_tree);

             retval.ret.setName((VAR1!=null?VAR1.getText():null)); 
            char_literal15=(Token)match(input,ANG_BRACKET_LEFT,FOLLOW_ANG_BRACKET_LEFT_in_indexer408); 
            char_literal15_tree = (Object)adaptor.create(char_literal15);
            adaptor.addChild(root_0, char_literal15_tree);

            VAR2=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_indexer414); 
            VAR2_tree = (Object)adaptor.create(VAR2);
            adaptor.addChild(root_0, VAR2_tree);

             retval.ret.setIter((VAR2!=null?VAR2.getText():null)); 
            char_literal16=(Token)match(input,ANG_BRACKET_RIGHT,FOLLOW_ANG_BRACKET_RIGHT_in_indexer420); 
            char_literal16_tree = (Object)adaptor.create(char_literal16);
            adaptor.addChild(root_0, char_literal16_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "indexer"

    public static class literal_return extends ParserRuleReturnScope {
        public Element ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "literal"
    // spina.g:90:1: literal returns [Element ret] : ( scalar_literal | matrix_literal ) ;
    public final spinaParser.literal_return literal() throws RecognitionException {
        spinaParser.literal_return retval = new spinaParser.literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        spinaParser.scalar_literal_return scalar_literal17 = null;

        spinaParser.matrix_literal_return matrix_literal18 = null;



        try {
            // spina.g:91:3: ( ( scalar_literal | matrix_literal ) )
            // spina.g:91:6: ( scalar_literal | matrix_literal )
            {
            root_0 = (Object)adaptor.nil();

            // spina.g:91:6: ( scalar_literal | matrix_literal )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==INTEGER) ) {
                alt9=1;
            }
            else if ( (LA9_0==SQU_BRACKET_LEFT) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // spina.g:91:7: scalar_literal
                    {
                    pushFollow(FOLLOW_scalar_literal_in_literal436);
                    scalar_literal17=scalar_literal();

                    state._fsp--;

                    adaptor.addChild(root_0, scalar_literal17.getTree());
                     retval.ret = (scalar_literal17!=null?scalar_literal17.ret:null); 

                    }
                    break;
                case 2 :
                    // spina.g:92:7: matrix_literal
                    {
                    pushFollow(FOLLOW_matrix_literal_in_literal446);
                    matrix_literal18=matrix_literal();

                    state._fsp--;

                    adaptor.addChild(root_0, matrix_literal18.getTree());
                     retval.ret = (matrix_literal18!=null?matrix_literal18.ret:null); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "literal"

    public static class scalar_literal_return extends ParserRuleReturnScope {
        public IntegerElement ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "scalar_literal"
    // spina.g:94:1: scalar_literal returns [IntegerElement ret] : INTEGER ;
    public final spinaParser.scalar_literal_return scalar_literal() throws RecognitionException {
        spinaParser.scalar_literal_return retval = new spinaParser.scalar_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INTEGER19=null;

        Object INTEGER19_tree=null;


          retval.ret = new IntegerElement();

        try {
            // spina.g:98:3: ( INTEGER )
            // spina.g:98:5: INTEGER
            {
            root_0 = (Object)adaptor.nil();

            INTEGER19=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_scalar_literal469); 
            INTEGER19_tree = (Object)adaptor.create(INTEGER19);
            adaptor.addChild(root_0, INTEGER19_tree);

             retval.ret.setText((INTEGER19!=null?INTEGER19.getText():null)); 

            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "scalar_literal"

    public static class matrix_literal_return extends ParserRuleReturnScope {
        public MatrixElement ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "matrix_literal"
    // spina.g:100:1: matrix_literal returns [MatrixElement ret] : SQU_BRACKET_LEFT ( ROU_BRACKET_LEFT INT1= INTEGER ( COMMA INT2= INTEGER )* ROU_BRACKET_RIGHT )+ SQU_BRACKET_RIGHT ;
    public final spinaParser.matrix_literal_return matrix_literal() throws RecognitionException {
        spinaParser.matrix_literal_return retval = new spinaParser.matrix_literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INT1=null;
        Token INT2=null;
        Token SQU_BRACKET_LEFT20=null;
        Token ROU_BRACKET_LEFT21=null;
        Token COMMA22=null;
        Token ROU_BRACKET_RIGHT23=null;
        Token SQU_BRACKET_RIGHT24=null;

        Object INT1_tree=null;
        Object INT2_tree=null;
        Object SQU_BRACKET_LEFT20_tree=null;
        Object ROU_BRACKET_LEFT21_tree=null;
        Object COMMA22_tree=null;
        Object ROU_BRACKET_RIGHT23_tree=null;
        Object SQU_BRACKET_RIGHT24_tree=null;


          retval.ret = new MatrixElement();

        try {
            // spina.g:104:3: ( SQU_BRACKET_LEFT ( ROU_BRACKET_LEFT INT1= INTEGER ( COMMA INT2= INTEGER )* ROU_BRACKET_RIGHT )+ SQU_BRACKET_RIGHT )
            // spina.g:104:5: SQU_BRACKET_LEFT ( ROU_BRACKET_LEFT INT1= INTEGER ( COMMA INT2= INTEGER )* ROU_BRACKET_RIGHT )+ SQU_BRACKET_RIGHT
            {
            root_0 = (Object)adaptor.nil();

            SQU_BRACKET_LEFT20=(Token)match(input,SQU_BRACKET_LEFT,FOLLOW_SQU_BRACKET_LEFT_in_matrix_literal490); 
            SQU_BRACKET_LEFT20_tree = (Object)adaptor.create(SQU_BRACKET_LEFT20);
            adaptor.addChild(root_0, SQU_BRACKET_LEFT20_tree);

            // spina.g:105:5: ( ROU_BRACKET_LEFT INT1= INTEGER ( COMMA INT2= INTEGER )* ROU_BRACKET_RIGHT )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==ROU_BRACKET_LEFT) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // spina.g:105:6: ROU_BRACKET_LEFT INT1= INTEGER ( COMMA INT2= INTEGER )* ROU_BRACKET_RIGHT
            	    {
            	    ROU_BRACKET_LEFT21=(Token)match(input,ROU_BRACKET_LEFT,FOLLOW_ROU_BRACKET_LEFT_in_matrix_literal498); 
            	    ROU_BRACKET_LEFT21_tree = (Object)adaptor.create(ROU_BRACKET_LEFT21);
            	    adaptor.addChild(root_0, ROU_BRACKET_LEFT21_tree);

            	    INT1=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_matrix_literal507); 
            	    INT1_tree = (Object)adaptor.create(INT1);
            	    adaptor.addChild(root_0, INT1_tree);

            	     retval.ret.addText((INT1!=null?INT1.getText():null)); 
            	    // spina.g:107:6: ( COMMA INT2= INTEGER )*
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==COMMA) ) {
            	            alt10=1;
            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // spina.g:107:7: COMMA INT2= INTEGER
            	    	    {
            	    	    COMMA22=(Token)match(input,COMMA,FOLLOW_COMMA_in_matrix_literal517); 
            	    	    COMMA22_tree = (Object)adaptor.create(COMMA22);
            	    	    adaptor.addChild(root_0, COMMA22_tree);

            	    	    INT2=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_matrix_literal526); 
            	    	    INT2_tree = (Object)adaptor.create(INT2);
            	    	    adaptor.addChild(root_0, INT2_tree);

            	    	     retval.ret.addText((INT2!=null?INT2.getText():null)); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop10;
            	        }
            	    } while (true);

            	    ROU_BRACKET_RIGHT23=(Token)match(input,ROU_BRACKET_RIGHT,FOLLOW_ROU_BRACKET_RIGHT_in_matrix_literal537); 
            	    ROU_BRACKET_RIGHT23_tree = (Object)adaptor.create(ROU_BRACKET_RIGHT23);
            	    adaptor.addChild(root_0, ROU_BRACKET_RIGHT23_tree);

            	     retval.ret.increRow(); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            SQU_BRACKET_RIGHT24=(Token)match(input,SQU_BRACKET_RIGHT,FOLLOW_SQU_BRACKET_RIGHT_in_matrix_literal547); 
            SQU_BRACKET_RIGHT24_tree = (Object)adaptor.create(SQU_BRACKET_RIGHT24);
            adaptor.addChild(root_0, SQU_BRACKET_RIGHT24_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "matrix_literal"

    public static class parallel_for_return extends ParserRuleReturnScope {
        public ParallelForElement ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parallel_for"
    // spina.g:112:1: parallel_for returns [ParallelForElement ret] : PARALLEL_FOR ROU_BRACKET_LEFT VARIABLE EQUAL INT1= INTEGER TO INT2= INTEGER ROU_BRACKET_RIGHT CUR_BRACKET_LEFT ( assignment )+ CUR_BRACKET_RIGHT ;
    public final spinaParser.parallel_for_return parallel_for() throws RecognitionException {
        spinaParser.parallel_for_return retval = new spinaParser.parallel_for_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token INT1=null;
        Token INT2=null;
        Token PARALLEL_FOR25=null;
        Token ROU_BRACKET_LEFT26=null;
        Token VARIABLE27=null;
        Token EQUAL28=null;
        Token TO29=null;
        Token ROU_BRACKET_RIGHT30=null;
        Token CUR_BRACKET_LEFT31=null;
        Token CUR_BRACKET_RIGHT33=null;
        spinaParser.assignment_return assignment32 = null;


        Object INT1_tree=null;
        Object INT2_tree=null;
        Object PARALLEL_FOR25_tree=null;
        Object ROU_BRACKET_LEFT26_tree=null;
        Object VARIABLE27_tree=null;
        Object EQUAL28_tree=null;
        Object TO29_tree=null;
        Object ROU_BRACKET_RIGHT30_tree=null;
        Object CUR_BRACKET_LEFT31_tree=null;
        Object CUR_BRACKET_RIGHT33_tree=null;


          retval.ret = new ParallelForElement();

        try {
            // spina.g:116:3: ( PARALLEL_FOR ROU_BRACKET_LEFT VARIABLE EQUAL INT1= INTEGER TO INT2= INTEGER ROU_BRACKET_RIGHT CUR_BRACKET_LEFT ( assignment )+ CUR_BRACKET_RIGHT )
            // spina.g:116:5: PARALLEL_FOR ROU_BRACKET_LEFT VARIABLE EQUAL INT1= INTEGER TO INT2= INTEGER ROU_BRACKET_RIGHT CUR_BRACKET_LEFT ( assignment )+ CUR_BRACKET_RIGHT
            {
            root_0 = (Object)adaptor.nil();

            PARALLEL_FOR25=(Token)match(input,PARALLEL_FOR,FOLLOW_PARALLEL_FOR_in_parallel_for566); 
            PARALLEL_FOR25_tree = (Object)adaptor.create(PARALLEL_FOR25);
            adaptor.addChild(root_0, PARALLEL_FOR25_tree);

            ROU_BRACKET_LEFT26=(Token)match(input,ROU_BRACKET_LEFT,FOLLOW_ROU_BRACKET_LEFT_in_parallel_for572); 
            ROU_BRACKET_LEFT26_tree = (Object)adaptor.create(ROU_BRACKET_LEFT26);
            adaptor.addChild(root_0, ROU_BRACKET_LEFT26_tree);

            VARIABLE27=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_parallel_for578); 
            VARIABLE27_tree = (Object)adaptor.create(VARIABLE27);
            adaptor.addChild(root_0, VARIABLE27_tree);

             retval.ret.setVar((VARIABLE27!=null?VARIABLE27.getText():null)); 
            EQUAL28=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_parallel_for586); 
            EQUAL28_tree = (Object)adaptor.create(EQUAL28);
            adaptor.addChild(root_0, EQUAL28_tree);

            INT1=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_for594); 
            INT1_tree = (Object)adaptor.create(INT1);
            adaptor.addChild(root_0, INT1_tree);

             retval.ret.setStart((INT1!=null?INT1.getText():null)); 
            TO29=(Token)match(input,TO,FOLLOW_TO_in_parallel_for602); 
            TO29_tree = (Object)adaptor.create(TO29);
            adaptor.addChild(root_0, TO29_tree);

            INT2=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_parallel_for610); 
            INT2_tree = (Object)adaptor.create(INT2);
            adaptor.addChild(root_0, INT2_tree);

             retval.ret.setEnd((INT2!=null?INT2.getText():null)); 
            ROU_BRACKET_RIGHT30=(Token)match(input,ROU_BRACKET_RIGHT,FOLLOW_ROU_BRACKET_RIGHT_in_parallel_for618); 
            ROU_BRACKET_RIGHT30_tree = (Object)adaptor.create(ROU_BRACKET_RIGHT30);
            adaptor.addChild(root_0, ROU_BRACKET_RIGHT30_tree);

            CUR_BRACKET_LEFT31=(Token)match(input,CUR_BRACKET_LEFT,FOLLOW_CUR_BRACKET_LEFT_in_parallel_for624); 
            CUR_BRACKET_LEFT31_tree = (Object)adaptor.create(CUR_BRACKET_LEFT31);
            adaptor.addChild(root_0, CUR_BRACKET_LEFT31_tree);

            // spina.g:125:5: ( assignment )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==VARIABLE) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // spina.g:125:6: assignment
            	    {
            	    pushFollow(FOLLOW_assignment_in_parallel_for631);
            	    assignment32=assignment();

            	    state._fsp--;

            	    adaptor.addChild(root_0, assignment32.getTree());
            	     retval.ret.addAssignment((assignment32!=null?assignment32.ret:null)); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            CUR_BRACKET_RIGHT33=(Token)match(input,CUR_BRACKET_RIGHT,FOLLOW_CUR_BRACKET_RIGHT_in_parallel_for641); 
            CUR_BRACKET_RIGHT33_tree = (Object)adaptor.create(CUR_BRACKET_RIGHT33);
            adaptor.addChild(root_0, CUR_BRACKET_RIGHT33_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "parallel_for"

    public static class print_return extends ParserRuleReturnScope {
        public PrintOperationElement ret;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "print"
    // spina.g:128:1: print returns [PrintOperationElement ret] : PRINT ( variable | indexer | literal ) END_OF_STATEMENT ;
    public final spinaParser.print_return print() throws RecognitionException {
        spinaParser.print_return retval = new spinaParser.print_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token PRINT34=null;
        Token END_OF_STATEMENT38=null;
        spinaParser.variable_return variable35 = null;

        spinaParser.indexer_return indexer36 = null;

        spinaParser.literal_return literal37 = null;


        Object PRINT34_tree=null;
        Object END_OF_STATEMENT38_tree=null;


          retval.ret = new PrintOperationElement();

        try {
            // spina.g:132:3: ( PRINT ( variable | indexer | literal ) END_OF_STATEMENT )
            // spina.g:132:5: PRINT ( variable | indexer | literal ) END_OF_STATEMENT
            {
            root_0 = (Object)adaptor.nil();

            PRINT34=(Token)match(input,PRINT,FOLLOW_PRINT_in_print660); 
            PRINT34_tree = (Object)adaptor.create(PRINT34);
            adaptor.addChild(root_0, PRINT34_tree);

            // spina.g:133:5: ( variable | indexer | literal )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==VARIABLE) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==END_OF_STATEMENT) ) {
                    alt13=1;
                }
                else if ( (LA13_1==ANG_BRACKET_LEFT) ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA13_0>=INTEGER && LA13_0<=SQU_BRACKET_LEFT)) ) {
                alt13=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // spina.g:133:6: variable
                    {
                    pushFollow(FOLLOW_variable_in_print667);
                    variable35=variable();

                    state._fsp--;

                    adaptor.addChild(root_0, variable35.getTree());
                     retval.ret.setChildElement((variable35!=null?variable35.ret:null)); 

                    }
                    break;
                case 2 :
                    // spina.g:134:7: indexer
                    {
                    pushFollow(FOLLOW_indexer_in_print677);
                    indexer36=indexer();

                    state._fsp--;

                    adaptor.addChild(root_0, indexer36.getTree());
                     retval.ret.setChildElement((indexer36!=null?indexer36.ret:null)); 

                    }
                    break;
                case 3 :
                    // spina.g:135:7: literal
                    {
                    pushFollow(FOLLOW_literal_in_print687);
                    literal37=literal();

                    state._fsp--;

                    adaptor.addChild(root_0, literal37.getTree());
                     retval.ret.setChildElement((literal37!=null?literal37.ret:null)); 

                    }
                    break;

            }

            END_OF_STATEMENT38=(Token)match(input,END_OF_STATEMENT,FOLLOW_END_OF_STATEMENT_in_print696); 
            END_OF_STATEMENT38_tree = (Object)adaptor.create(END_OF_STATEMENT38);
            adaptor.addChild(root_0, END_OF_STATEMENT38_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "print"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\20\uffff";
    static final String DFA4_eofS =
        "\20\uffff";
    static final String DFA4_minS =
        "\1\10\1\5\1\13\1\6\3\uffff\1\11\1\10\1\14\1\25\1\11\1\13\1\6\1\14"+
        "\1\5";
    static final String DFA4_maxS =
        "\1\12\1\7\1\13\1\24\3\uffff\1\11\1\10\1\15\1\25\1\11\1\16\1\7\1"+
        "\15\1\7";
    static final String DFA4_acceptS =
        "\4\uffff\1\3\1\2\1\1\11\uffff";
    static final String DFA4_specialS =
        "\20\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\3\1\1\1\2",
            "\1\6\1\5\1\4",
            "\1\7",
            "\1\5\1\4\14\uffff\1\10",
            "",
            "",
            "",
            "\1\11",
            "\1\12",
            "\1\13\1\14",
            "\1\15",
            "\1\16",
            "\1\7\2\uffff\1\17",
            "\1\5\1\4",
            "\1\13\1\14",
            "\1\6\1\5\1\4"
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "45:5: ( literal | addition | multiplication )";
        }
    }
 

    public static final BitSet FOLLOW_expr_in_program61 = new BitSet(new long[]{0x0000000000088102L});
    public static final BitSet FOLLOW_assignment_in_expr80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_in_expr88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parallel_for_in_expr96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_assignment118 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_indexer_in_assignment128 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_EQUAL_in_assignment137 = new BitSet(new long[]{0x0000000000000700L});
    public static final BitSet FOLLOW_literal_in_assignment144 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_addition_in_assignment154 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_multiplication_in_assignment164 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_END_OF_STATEMENT_in_assignment178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_addition200 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_indexer_in_addition212 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_literal_in_addition224 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_PLUS_in_addition233 = new BitSet(new long[]{0x0000000000000700L});
    public static final BitSet FOLLOW_variable_in_addition242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_indexer_in_addition254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_addition266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variable_in_multiplication291 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_indexer_in_multiplication303 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_literal_in_multiplication315 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_MULTIPLY_in_multiplication324 = new BitSet(new long[]{0x0000000000000700L});
    public static final BitSet FOLLOW_variable_in_multiplication333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_indexer_in_multiplication345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_multiplication357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_variable379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VARIABLE_in_indexer402 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ANG_BRACKET_LEFT_in_indexer408 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_VARIABLE_in_indexer414 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ANG_BRACKET_RIGHT_in_indexer420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_scalar_literal_in_literal436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_matrix_literal_in_literal446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_scalar_literal469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SQU_BRACKET_LEFT_in_matrix_literal490 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ROU_BRACKET_LEFT_in_matrix_literal498 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INTEGER_in_matrix_literal507 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_COMMA_in_matrix_literal517 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INTEGER_in_matrix_literal526 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_ROU_BRACKET_RIGHT_in_matrix_literal537 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_SQU_BRACKET_RIGHT_in_matrix_literal547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARALLEL_FOR_in_parallel_for566 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ROU_BRACKET_LEFT_in_parallel_for572 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_VARIABLE_in_parallel_for578 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_EQUAL_in_parallel_for586 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_for594 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_TO_in_parallel_for602 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_INTEGER_in_parallel_for610 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ROU_BRACKET_RIGHT_in_parallel_for618 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_CUR_BRACKET_LEFT_in_parallel_for624 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_assignment_in_parallel_for631 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_CUR_BRACKET_RIGHT_in_parallel_for641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_print660 = new BitSet(new long[]{0x0000000000000700L});
    public static final BitSet FOLLOW_variable_in_print667 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_indexer_in_print677 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_literal_in_print687 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_END_OF_STATEMENT_in_print696 = new BitSet(new long[]{0x0000000000000002L});

}