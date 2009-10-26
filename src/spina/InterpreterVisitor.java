////////////////////////////////////////////////////////////////////////
// InterpreterVisitor.java: Implements a vistor that interprets the 
//  syntax tree.
// 
// version: 1.0
// description: part of the interpreter example for the visitor design
//  pattern.
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

import java.util.Hashtable;
import java.util.Stack;

public class InterpreterVisitor extends Visitor {

  Hashtable mVariableMap;
  Stack<Integer> mStack;

  public InterpreterVisitor(){
    mVariableMap = new Hashtable();
    mStack = new Stack<Integer>();
  }

  public void VisitVariableElement(VariableElement element){
    if(mVariableMap.containsKey(element.getText())){
      Integer element_value = (Integer) mVariableMap.get(element.getText());
      mStack.push(element_value);
    } else {
      //lets assume that the syntax has been checked for this example because I don't like the exception
      //propegation that will happen if I throw here
      //throw new Exception("Variable " + element.getText() + " not defined.");
    }
  }
  public void VisitIndexerElement(IndexerElement element){
    ///////////
  }
  public void VisitIntegerElement(IntegerElement element){
    Integer element_value = Integer.decode(element.getText());
    mStack.push(element_value);
  }
  public void VisitMatrixElement(MatrixElement element){
      ////////////
  }
  public void VisitAssignmentOperationElement(AssignmentOperationElement element){
    String variable_name = element.getLhs().getText();

    Element rhs = element.getRhs();
    VisitElement(rhs);
    Integer result = mStack.pop();    
    mVariableMap.put(variable_name, result);
  }
  public void VisitAdditionOperationElement(AdditionOperationElement element){
    VisitElement(element.getLhs());
    VisitElement(element.getRhs());
    Integer rhs = mStack.pop();
    Integer lhs = mStack.pop();
    Integer result = new Integer(rhs.intValue() + lhs.intValue());
    mStack.push(result);    
  }
  public void VisitMultiplicationOperationElement(MultiplicationOperationElement element) {
      ////////////////////
  }
  public void VisitParallelForElement(ParallelForElement element) {
      
  }
  public void VisitPrintOperationElement(PrintOperationElement element){
    VisitElement(element.getChildElement());
    Integer result = mStack.pop();
    System.out.println(Integer.toString(result));
  }
}
