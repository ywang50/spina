////////////////////////////////////////////////////////////////////////
// SpinaExecutor.java - The acutal Spina executor
//
// version: 1.0
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

import org.antlr.runtime.*;
import java.util.Vector;

/**
 *
 * @author Yehong
 */
public class SpinaExecutor {

    InterpreterVisitor interp_visitor = new InterpreterVisitor();
//    PrettyPrintVisitor print_visitor = new PrettyPrintVisitor();

    
    public void VisitLine(String line){
      ANTLRStringStream string_stream = new ANTLRStringStream(line);
      spinaLexer lexer = new spinaLexer(string_stream);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      spinaParser parser = new spinaParser(tokens);
      try {
	spinaParser.program_return program = parser.program();
        Vector<Element> elements = program.ret;
        for(int i = 0; i < elements.size(); i++){
          Element curr = elements.get(i);
//          curr.Accept(print_visitor);
          curr.Accept(interp_visitor);
        }
      } catch (RecognitionException e)  {
        System.out.println(e.getMessage());
      }
    }

}
