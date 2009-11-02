// $ANTLR 3.1.3 Mar 18, 2009 10:09:25 spina.g 2009-11-01 04:05:42

package spina;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class spinaLexer extends Lexer {
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
    public static final int SQU_BRACKET_RIGHT=14;
    public static final int SQU_BRACKET_LEFT=10;
    public static final int ANG_BRACKET_RIGHT=21;
    public static final int END_OF_STATEMENT=5;

    // delegates
    // delegators

    public spinaLexer() {;} 
    public spinaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public spinaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "spina.g"; }

    // $ANTLR start "END_OF_STATEMENT"
    public final void mEND_OF_STATEMENT() throws RecognitionException {
        try {
            int _type = END_OF_STATEMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:142:17: ( ';' )
            // spina.g:142:19: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_OF_STATEMENT"

    // $ANTLR start "EQUAL"
    public final void mEQUAL() throws RecognitionException {
        try {
            int _type = EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:143:6: ( '=' )
            // spina.g:143:8: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUAL"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:144:5: ( '+' )
            // spina.g:144:7: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MULTIPLY"
    public final void mMULTIPLY() throws RecognitionException {
        try {
            int _type = MULTIPLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:145:9: ( '*' )
            // spina.g:145:11: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULTIPLY"

    // $ANTLR start "ANG_BRACKET_LEFT"
    public final void mANG_BRACKET_LEFT() throws RecognitionException {
        try {
            int _type = ANG_BRACKET_LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:146:17: ( '<' )
            // spina.g:146:19: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANG_BRACKET_LEFT"

    // $ANTLR start "ANG_BRACKET_RIGHT"
    public final void mANG_BRACKET_RIGHT() throws RecognitionException {
        try {
            int _type = ANG_BRACKET_RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:147:18: ( '>' )
            // spina.g:147:20: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANG_BRACKET_RIGHT"

    // $ANTLR start "SQU_BRACKET_LEFT"
    public final void mSQU_BRACKET_LEFT() throws RecognitionException {
        try {
            int _type = SQU_BRACKET_LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:148:17: ( '[' )
            // spina.g:148:19: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQU_BRACKET_LEFT"

    // $ANTLR start "SQU_BRACKET_RIGHT"
    public final void mSQU_BRACKET_RIGHT() throws RecognitionException {
        try {
            int _type = SQU_BRACKET_RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:149:18: ( ']' )
            // spina.g:149:20: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SQU_BRACKET_RIGHT"

    // $ANTLR start "ROU_BRACKET_LEFT"
    public final void mROU_BRACKET_LEFT() throws RecognitionException {
        try {
            int _type = ROU_BRACKET_LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:150:17: ( '(' )
            // spina.g:150:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ROU_BRACKET_LEFT"

    // $ANTLR start "ROU_BRACKET_RIGHT"
    public final void mROU_BRACKET_RIGHT() throws RecognitionException {
        try {
            int _type = ROU_BRACKET_RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:151:18: ( ')' )
            // spina.g:151:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ROU_BRACKET_RIGHT"

    // $ANTLR start "CUR_BRACKET_LEFT"
    public final void mCUR_BRACKET_LEFT() throws RecognitionException {
        try {
            int _type = CUR_BRACKET_LEFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:152:17: ( '{' )
            // spina.g:152:19: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CUR_BRACKET_LEFT"

    // $ANTLR start "CUR_BRACKET_RIGHT"
    public final void mCUR_BRACKET_RIGHT() throws RecognitionException {
        try {
            int _type = CUR_BRACKET_RIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:153:18: ( '}' )
            // spina.g:153:20: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CUR_BRACKET_RIGHT"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:154:6: ( ',' )
            // spina.g:154:8: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "TO"
    public final void mTO() throws RecognitionException {
        try {
            int _type = TO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:155:3: ( '..' )
            // spina.g:155:5: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TO"

    // $ANTLR start "PARALLEL_FOR"
    public final void mPARALLEL_FOR() throws RecognitionException {
        try {
            int _type = PARALLEL_FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:156:13: ( 'parallel-for' )
            // spina.g:156:15: 'parallel-for'
            {
            match("parallel-for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PARALLEL_FOR"

    // $ANTLR start "PRINT"
    public final void mPRINT() throws RecognitionException {
        try {
            int _type = PRINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:157:6: ( 'print' )
            // spina.g:157:8: 'print'
            {
            match("print"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRINT"

    // $ANTLR start "VARIABLE"
    public final void mVARIABLE() throws RecognitionException {
        try {
            int _type = VARIABLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:158:9: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // spina.g:158:11: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // spina.g:158:34: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // spina.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARIABLE"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:159:8: ( ( '0' | ( '1' .. '9' ) ( '0' .. '9' )* ) )
            // spina.g:159:10: ( '0' | ( '1' .. '9' ) ( '0' .. '9' )* )
            {
            // spina.g:159:10: ( '0' | ( '1' .. '9' ) ( '0' .. '9' )* )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='0') ) {
                alt3=1;
            }
            else if ( ((LA3_0>='1' && LA3_0<='9')) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // spina.g:159:11: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // spina.g:159:17: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // spina.g:159:17: ( '1' .. '9' )
                    // spina.g:159:18: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // spina.g:159:28: ( '0' .. '9' )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // spina.g:159:29: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // spina.g:160:12: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // spina.g:160:14: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // spina.g:160:14: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\t' && LA4_0<='\n')||LA4_0=='\r'||LA4_0==' ') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // spina.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHITESPACE"

    public void mTokens() throws RecognitionException {
        // spina.g:1:8: ( END_OF_STATEMENT | EQUAL | PLUS | MULTIPLY | ANG_BRACKET_LEFT | ANG_BRACKET_RIGHT | SQU_BRACKET_LEFT | SQU_BRACKET_RIGHT | ROU_BRACKET_LEFT | ROU_BRACKET_RIGHT | CUR_BRACKET_LEFT | CUR_BRACKET_RIGHT | COMMA | TO | PARALLEL_FOR | PRINT | VARIABLE | INTEGER | WHITESPACE )
        int alt5=19;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // spina.g:1:10: END_OF_STATEMENT
                {
                mEND_OF_STATEMENT(); 

                }
                break;
            case 2 :
                // spina.g:1:27: EQUAL
                {
                mEQUAL(); 

                }
                break;
            case 3 :
                // spina.g:1:33: PLUS
                {
                mPLUS(); 

                }
                break;
            case 4 :
                // spina.g:1:38: MULTIPLY
                {
                mMULTIPLY(); 

                }
                break;
            case 5 :
                // spina.g:1:47: ANG_BRACKET_LEFT
                {
                mANG_BRACKET_LEFT(); 

                }
                break;
            case 6 :
                // spina.g:1:64: ANG_BRACKET_RIGHT
                {
                mANG_BRACKET_RIGHT(); 

                }
                break;
            case 7 :
                // spina.g:1:82: SQU_BRACKET_LEFT
                {
                mSQU_BRACKET_LEFT(); 

                }
                break;
            case 8 :
                // spina.g:1:99: SQU_BRACKET_RIGHT
                {
                mSQU_BRACKET_RIGHT(); 

                }
                break;
            case 9 :
                // spina.g:1:117: ROU_BRACKET_LEFT
                {
                mROU_BRACKET_LEFT(); 

                }
                break;
            case 10 :
                // spina.g:1:134: ROU_BRACKET_RIGHT
                {
                mROU_BRACKET_RIGHT(); 

                }
                break;
            case 11 :
                // spina.g:1:152: CUR_BRACKET_LEFT
                {
                mCUR_BRACKET_LEFT(); 

                }
                break;
            case 12 :
                // spina.g:1:169: CUR_BRACKET_RIGHT
                {
                mCUR_BRACKET_RIGHT(); 

                }
                break;
            case 13 :
                // spina.g:1:187: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 14 :
                // spina.g:1:193: TO
                {
                mTO(); 

                }
                break;
            case 15 :
                // spina.g:1:196: PARALLEL_FOR
                {
                mPARALLEL_FOR(); 

                }
                break;
            case 16 :
                // spina.g:1:209: PRINT
                {
                mPRINT(); 

                }
                break;
            case 17 :
                // spina.g:1:215: VARIABLE
                {
                mVARIABLE(); 

                }
                break;
            case 18 :
                // spina.g:1:224: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 19 :
                // spina.g:1:232: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\17\uffff\1\20\3\uffff\7\20\1\34\1\20\1\uffff\2\20\1\uffff";
    static final String DFA5_eofS =
        "\40\uffff";
    static final String DFA5_minS =
        "\1\11\16\uffff\1\141\3\uffff\1\162\1\151\1\141\1\156\1\154\1\164"+
        "\1\154\1\60\1\145\1\uffff\1\154\1\55\1\uffff";
    static final String DFA5_maxS =
        "\1\175\16\uffff\1\162\3\uffff\1\162\1\151\1\141\1\156\1\154\1\164"+
        "\1\154\1\172\1\145\1\uffff\1\154\1\55\1\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\1\uffff\1\21\1\22\1\23\11\uffff\1\20\2\uffff\1\17";
    static final String DFA5_specialS =
        "\40\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\22\2\uffff\1\22\22\uffff\1\22\7\uffff\1\11\1\12\1\4\1\3\1"+
            "\15\1\uffff\1\16\1\uffff\12\21\1\uffff\1\1\1\5\1\2\1\6\2\uffff"+
            "\32\20\1\7\1\uffff\1\10\3\uffff\17\20\1\17\12\20\1\13\1\uffff"+
            "\1\14",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\23\20\uffff\1\24",
            "",
            "",
            "",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33",
            "\12\20\7\uffff\32\20\6\uffff\32\20",
            "\1\35",
            "",
            "\1\36",
            "\1\37",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( END_OF_STATEMENT | EQUAL | PLUS | MULTIPLY | ANG_BRACKET_LEFT | ANG_BRACKET_RIGHT | SQU_BRACKET_LEFT | SQU_BRACKET_RIGHT | ROU_BRACKET_LEFT | ROU_BRACKET_RIGHT | CUR_BRACKET_LEFT | CUR_BRACKET_RIGHT | COMMA | TO | PARALLEL_FOR | PRINT | VARIABLE | INTEGER | WHITESPACE );";
        }
    }
 

}