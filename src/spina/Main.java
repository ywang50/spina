////////////////////////////////////////////////////////////////////////
// Main.java: demonstrates the interpreter for the Interp language.
// 
// version: 1.0
// description: part of the interpreter example for the visitor design
//  pattern.
// author: phil pratt-szeliga (pcpratts@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

/*

package spina;
import org.antlr.runtime.*;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    InterpreterVisitor interp_visitor = new InterpreterVisitor();
    PrettyPrintVisitor print_visitor = new PrettyPrintVisitor();
        
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
          curr.Accept(print_visitor);
          curr.Accept(interp_visitor);
        }
      } catch (RecognitionException e)  {
        System.out.println(e.getMessage());
      }

    }

    public void RunEvalLoop(){
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      
      while(true){
        System.out.print("Spina> ");
        String line = "";
        try{
          line = in.readLine();
        } catch(IOException ex) { System.out.println(ex.getMessage()); continue; }
        if(line.equals("reset"))
          interp_visitor = new InterpreterVisitor();
        else
          VisitLine(line);        
      }
    }

    public static void main(String[] args) {
      Main themain = new Main();

      //first demonstrate visiting premade line.
      themain.VisitLine("myvariable = 1 + 2; var = myvariable + 3; print var;");
      themain.RunEvalLoop();                  
    }

}
*/