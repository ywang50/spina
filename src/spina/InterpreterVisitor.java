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

  private Hashtable mVariableMap;
  private Stack<Integer> mIntStack;
  private Stack<Matrix> mMatStack;
  private enum LiteralType { Literal_Integer, Literal_Matrix };
  private LiteralType type;

  private String GetIndexerHashKey(String name, String index) {
      // The hash key is "<var_name>:<index_value>"
      if (!mVariableMap.containsKey(index))
      {
          //////error
      }
      Integer index_value = (Integer) mVariableMap.get(index);
      return name.concat(":").concat(index_value.toString());
  }

  public InterpreterVisitor(){
    mVariableMap = new Hashtable();
    mIntStack = new Stack<Integer>();
    mMatStack = new Stack<Matrix>();
  }

  public void VisitVariableElement(VariableElement element){
    if(mVariableMap.containsKey(element.getText())){
      if (mVariableMap.get(element.getText()) instanceof Integer) {
        Integer element_value = (Integer) mVariableMap.get(element.getText());
        mIntStack.push(element_value);
        type = LiteralType.Literal_Integer;
      }
      else if (mVariableMap.get(element.getText()) instanceof Matrix) {
        Matrix element_matrix = (Matrix) mVariableMap.get(element.getText());
        mMatStack.push(element_matrix);
        type = LiteralType.Literal_Matrix;
      }
    } else {
      //lets assume that the syntax has been checked for this example because I don't like the exception
      //propegation that will happen if I throw here
      //throw new Exception("Variable " + element.getText() + " not defined.");
    }
  }
  public void VisitIndexerElement(IndexerElement element){
    String key = GetIndexerHashKey(element.getName(), element.getIter());
    if(mVariableMap.containsKey(key)) {
        if (mVariableMap.get(key) instanceof Integer) {
          Integer element_value = (Integer) mVariableMap.get(key);
          mIntStack.push(element_value);
          type = LiteralType.Literal_Integer;
        }
        else if (mVariableMap.get(key) instanceof Matrix) {
          //Should we allow matrix to be indexed??
          //Matrix element_matrix = (Matrix) mVariableMap.get(key);
          //mMatStack.push(element_matrix);
          //type = LiteralType.Literal_Matrix;
        }
    }
    else {
        //error
    }
  }
  public void VisitIntegerElement(IntegerElement element){
    Integer element_value = Integer.decode(element.getText());
    mIntStack.push(element_value);
    type = LiteralType.Literal_Integer;
  }
  public void VisitMatrixElement(MatrixElement element){
    Matrix element_matrix = element.GetMatrixLiteral();
    mMatStack.push(element_matrix);
    type = LiteralType.Literal_Matrix;
  }
  public void VisitAssignmentOperationElement(AssignmentOperationElement element){
    String variable_name;
    Element lelem = element.getLhs();
    if (lelem instanceof VariableElement)
        variable_name = ((VariableElement)lelem).getText();
    else if (lelem instanceof IndexerElement) {
        // Indexer ind[3] is store in the hashtable as variable "ind:3"
        IndexerElement index_elem = (IndexerElement)lelem;
        String index = index_elem.getIter();
        if (mVariableMap.contains(index)) {
            variable_name = GetIndexerHashKey(index_elem.getName(), index);
        }
        else
            return; ///////////error
    }
    else
        return; ///////////error

    Element rhs = element.getRhs();
    VisitElement(rhs);
    if (type == LiteralType.Literal_Integer) {
      Integer int_result = mIntStack.pop();
      mVariableMap.put(variable_name, int_result);
    }
    else {
      Matrix mat_result = mMatStack.pop();
      mVariableMap.put(variable_name, mat_result);
    }
  }
  public void VisitAdditionOperationElement(AdditionOperationElement element){
    VisitElement(element.getLhs());
    VisitElement(element.getRhs());
    if (type == LiteralType.Literal_Integer) {
      Integer rhs = mIntStack.pop();
      Integer lhs = mIntStack.pop();
      Integer int_result = new Integer(rhs.intValue() + lhs.intValue());
      mIntStack.push(int_result);
    }
    else if (type == LiteralType.Literal_Matrix) {
      Matrix rhs = mMatStack.pop();
      Matrix lhs = mMatStack.pop();
      if (lhs.GetRow() != rhs.GetRow() || lhs.GetCol() != rhs.GetCol()) {
          //error
      }
      Matrix new_mat = new Matrix(lhs.GetRow(), lhs.GetCol());
      //////////////// Multithreading calculation here ///////////////
      mMatStack.push(new_mat);
    }
  }
  public void VisitMultiplicationOperationElement(MultiplicationOperationElement element) {
    VisitElement(element.getLhs());
    VisitElement(element.getRhs());
    if (type == LiteralType.Literal_Integer) {
      Integer rhs = mIntStack.pop();
      Integer lhs = mIntStack.pop();
      Integer result = new Integer(rhs.intValue() * lhs.intValue());
      mIntStack.push(result);
    }
    else if (type == LiteralType.Literal_Matrix) {
      Matrix rhs = mMatStack.pop();
      Matrix lhs = mMatStack.pop();
      if (lhs.GetCol() != rhs.GetRow()) {
          //error
      }
      Matrix new_mat = new Matrix(lhs.GetRow(), rhs.GetCol());
      //////////////// Multithreading calculation here ///////////////
      mMatStack.push(new_mat);
    }
  }
  public void VisitParallelForElement(ParallelForElement element) {
      
  }
  public void VisitPrintOperationElement(PrintOperationElement element){
    VisitElement(element.getChildElement());
    if (type == LiteralType.Literal_Integer) {
      Integer int_result = mIntStack.pop();
      System.out.println(Integer.toString(int_result));
    }
    else if (type == LiteralType.Literal_Matrix) {
      Matrix mat_result = mMatStack.pop();
      ///////// print matrix /////////////
    }
  }
}
