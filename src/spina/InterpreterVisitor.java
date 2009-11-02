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
import java.util.Vector;
import java.lang.Thread;

public class InterpreterVisitor extends Visitor implements Runnable {

  private Hashtable mVariableMap;
  private Stack<Integer> mIntStack;
  private Stack<Matrix> mMatStack;
  private Vector<String> mThreadedVars;
  private Vector<AssignmentOperationElement> mThreadedAssigs;
  private enum LiteralType { Literal_Integer, Literal_Matrix };
  private LiteralType mLiteralType;
  private enum VisitorType { Regular_Visitor, Thread_Visitor };
  private VisitorType mVisitorType;

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
    mThreadedVars = null;
    mThreadedAssigs = null;
    mVisitorType = VisitorType.Regular_Visitor;
  }

  public InterpreterVisitor(Hashtable table, Vector<AssignmentOperationElement> vec) {
    mVariableMap = new Hashtable(table);
    mIntStack = new Stack<Integer>();
    mMatStack = new Stack<Matrix>();
    mThreadedVars = new Vector<String>();
    mThreadedAssigs = new Vector<AssignmentOperationElement>(vec);
    mVisitorType = VisitorType.Thread_Visitor;
  }

  public Vector<String> GetThreadedVariables() {
    return mThreadedVars;
  }

  public Object GetValueOfThreadedVariable(String var) {
    if (mVariableMap.containsKey(var))
      return mVariableMap.get(var);
    else
      return null;
  }

  public void VisitVariableElement(VariableElement element){
    if(mVariableMap.containsKey(element.getText())){
      if (mVariableMap.get(element.getText()) instanceof Integer) {
        Integer element_value = (Integer) mVariableMap.get(element.getText());
        mIntStack.push(element_value);
        mLiteralType = LiteralType.Literal_Integer;
      }
      else if (mVariableMap.get(element.getText()) instanceof Matrix) {
        Matrix element_matrix = (Matrix) mVariableMap.get(element.getText());
        mMatStack.push(element_matrix);
        mLiteralType = LiteralType.Literal_Matrix;
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
          mLiteralType = LiteralType.Literal_Integer;
        }
        else if (mVariableMap.get(key) instanceof Matrix) {
          //Should we allow matrix to be indexed??
          Matrix element_matrix = (Matrix) mVariableMap.get(key);
          mMatStack.push(element_matrix);
          mLiteralType = LiteralType.Literal_Matrix;
        }
    }
    else {
        //error
    }
  }
  public void VisitIntegerElement(IntegerElement element){
    Integer element_value = Integer.decode(element.getText());
    mIntStack.push(element_value);
    mLiteralType = LiteralType.Literal_Integer;
  }
  public void VisitMatrixElement(MatrixElement element){
    Matrix element_matrix = element.GetMatrixLiteral();
    mMatStack.push(element_matrix);
    mLiteralType = LiteralType.Literal_Matrix;
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
        if (mVariableMap.containsKey(index)) {
            variable_name = GetIndexerHashKey(index_elem.getName(), index);
        }
        else
            return; ///////////error
    }
    else
        return; ///////////error

    Element rhs = element.getRhs();
    VisitElement(rhs);
    if (mLiteralType == LiteralType.Literal_Integer) {
      Integer int_result = mIntStack.pop();
      mVariableMap.put(variable_name, int_result);
      if (mVisitorType == VisitorType.Thread_Visitor)
        mThreadedVars.add(variable_name);
    }
    else {
      Matrix mat_result = mMatStack.pop();
      mVariableMap.put(variable_name, mat_result);
      if (mVisitorType == VisitorType.Thread_Visitor)
        mThreadedVars.add(variable_name);
    }
  }
  public void VisitAdditionOperationElement(AdditionOperationElement element){
    VisitElement(element.getLhs());
    VisitElement(element.getRhs());
    if (mLiteralType == LiteralType.Literal_Integer) {
      Integer rhs = mIntStack.pop();
      Integer lhs = mIntStack.pop();
      Integer int_result = new Integer(rhs.intValue() + lhs.intValue());
      mIntStack.push(int_result);
    }
    else if (mLiteralType == LiteralType.Literal_Matrix) {
      Matrix rhs = mMatStack.pop();
      Matrix lhs = mMatStack.pop();
      if (lhs.GetRow() != rhs.GetRow() || lhs.GetCol() != rhs.GetCol()) {
          //error
      }
      //////////////// Multithreading calculation here ///////////////
      Matrix new_mat = StartMatrixOperationWithMultithreading(lhs, rhs, MatrixOperationThread.MatrixOperationType.Matrix_Addition);
      // new matrix has been filled up
      mMatStack.push(new_mat);
    }
  }
  public void VisitMultiplicationOperationElement(MultiplicationOperationElement element) {
    VisitElement(element.getLhs());
    VisitElement(element.getRhs());
    if (mLiteralType == LiteralType.Literal_Integer) {
      Integer rhs = mIntStack.pop();
      Integer lhs = mIntStack.pop();
      Integer result = new Integer(rhs.intValue() * lhs.intValue());
      mIntStack.push(result);
    }
    else if (mLiteralType == LiteralType.Literal_Matrix) {
      Matrix rhs = mMatStack.pop();
      Matrix lhs = mMatStack.pop();
      if (lhs.GetCol() != rhs.GetRow()) {
          //error
      }
      //////////////// Multithreading calculation here ///////////////
      Matrix new_mat = StartMatrixOperationWithMultithreading(lhs, rhs, MatrixOperationThread.MatrixOperationType.Matrix_Multiplication);
      // new matrix has been filled up
      mMatStack.push(new_mat);
    }
  }
  public void VisitParallelForElement(ParallelForElement element) {
    int start = element.getStart();
    int end = element.getEnd();
    String orig = element.getVar();
    Vector<Thread> threads = new Vector<Thread>();
    Vector<InterpreterVisitor> visitors = new Vector<InterpreterVisitor>();
    for (int i = start; i <= end; i++) {
      String repl = orig.concat(":").concat(((Integer)i).toString());
      Vector<AssignmentOperationElement> vec = element.getAssignmentElements();
      Vector<AssignmentOperationElement> tmp_vec = new Vector<AssignmentOperationElement>();
      for (int count = 0; count < vec.size(); count++) {
          AssignmentOperationElement elem = vec.elementAt(count);
          AssignmentOperationElement tmp_elem = new AssignmentOperationElement(elem);
          tmp_vec.add(tmp_elem);
      }      
      for (int j = 0; j < tmp_vec.size(); j++) {
        tmp_vec.elementAt(j).replaceText(orig, repl);
      }
      mVariableMap.put(repl, i);
      InterpreterVisitor cur_visitor = new InterpreterVisitor(mVariableMap, tmp_vec);
      visitors.add(cur_visitor);
      Thread cur_thread = new Thread(cur_visitor);
      threads.add(cur_thread);
      cur_thread.start();
    }
    ///////////////////////////////
    // wait until all threads are done with their work
    boolean running = true;
    while (running) {
      running = false;
      for (int i = 0; i < threads.size(); i++) {
        if (threads.elementAt(i).isAlive())
          running = true;
        else {
          // Synchronize except for the last thread
          // which may overwrite privious threads' data
          if (i != threads.size() - 1)
            SynchronizeVariableMap(visitors.elementAt(i));
        }
      }
    }
    // Synchronize the last thread
    SynchronizeVariableMap(visitors.elementAt(threads.size() - 1));
    // Remove temporary elements in hashtable
    for (int i = start; i <= end; i++) {
      String new_var = orig.concat(":").concat(((Integer)i).toString());
      if (mVariableMap.containsKey(new_var)) {
          mVariableMap.remove(new_var);
      }
    }

  }
  public void VisitPrintOperationElement(PrintOperationElement element){
    VisitElement(element.getChildElement());
    if (mLiteralType == LiteralType.Literal_Integer) {
      ///////// print integer ////////////
      Integer int_result = mIntStack.pop();
      System.out.println(Integer.toString(int_result));
    }
    else if (mLiteralType == LiteralType.Literal_Matrix) {
      ///////// print matrix /////////////
      Matrix mat_result = mMatStack.pop();
      int row = mat_result.GetRow();
      int col = mat_result.GetCol();
      System.out.print("[");
      for (int i = 1; i <= row; i++) {
        System.out.print("(");
        for (int j = 1; j < col; j++) {
          Integer int_result = mat_result.GetValueAt(i, j);
          System.out.print(Integer.toString(int_result));
          System.out.print(",");
        }
        Integer int_result = mat_result.GetValueAt(i, col);
        System.out.print(Integer.toString(int_result));
        System.out.print(")");
      }
      System.out.println("]");
    }
  }

  public void run() {
    if (this.mVisitorType == VisitorType.Thread_Visitor) {
      for (int i = 0; i < mThreadedAssigs.size(); i++) {
        this.VisitAssignmentOperationElement(mThreadedAssigs.elementAt(i));
      }
    }
  }

  private void SynchronizeVariableMap(InterpreterVisitor visitor) {
    Vector<String> threaded_variables = visitor.GetThreadedVariables();
    for (int i = 0; i < threaded_variables.size(); i++) {
      String cur_var = threaded_variables.elementAt(i);
      Object cur_val = visitor.GetValueOfThreadedVariable(cur_var);
      mVariableMap.put(cur_var, cur_val);
    }
  }

  private Matrix StartMatrixOperationWithMultithreading(Matrix lhs, Matrix rhs, MatrixOperationThread.MatrixOperationType type) {
    Matrix res_mat;
    if (type == MatrixOperationThread.MatrixOperationType.Matrix_Addition)
      res_mat = new Matrix(lhs.GetRow(), lhs.GetCol());
    else // if (type == MatrixOperationThread.MatrixOperationType.Matrix_Multiplication)
      res_mat = new Matrix(lhs.GetRow(), rhs.GetCol());

    int dim = rhs.GetCol();
    Vector<Thread> threads = new Vector<Thread>();
    Vector<MatrixOperationThread> calculators = new Vector<MatrixOperationThread>();
    for (int dimNum = 1; dimNum <= dim; dimNum++) {
      MatrixOperationThread cur_calculator = new MatrixOperationThread(lhs, rhs, dimNum, type);
      calculators.add(cur_calculator);
      Thread cur_thread = new Thread(cur_calculator);
      threads.add(cur_thread);
      cur_thread.start();
    }
    ///////////////////////////////
    // wait until all threads are done with their work
    boolean running = true;
    while (running) {
      running = false;
      for (int i = 0; i < threads.size(); i++) {
        if (threads.elementAt(i).isAlive())
          running = true;
        else {
          // Synchronize this dimension
          Vector<Integer> vec = calculators.elementAt(i).GetThreadedDimension();
          for (int row = 0; row < vec.size(); row++) {
            int value = vec.elementAt(row).intValue();
            res_mat.SetValueAt(row+1, i+1, value);
          }
        }
      }
    }
    return res_mat;
  }
}

class MatrixOperationThread implements Runnable {
  private Matrix mThreadedMatL;
  private Matrix mThreadedMatR;
  private int mDimensionNum;
  private Vector<Integer> mThreadedDim;
  public enum MatrixOperationType { Matrix_Addition, Matrix_Multiplication };
  private MatrixOperationType mType;

  public MatrixOperationThread(Matrix matL, Matrix matR, int dim, MatrixOperationType type) {
    mThreadedMatL = matL;
    mThreadedMatR = matR;
    mDimensionNum = dim;
    mType = type;
    mThreadedDim = new Vector<Integer>();
  }

  public Vector<Integer> GetThreadedDimension() {
    return mThreadedDim;
  }

  public void run() {
    if (mType == MatrixOperationType.Matrix_Addition) {
      for (int i = 1; i <= mThreadedMatL.GetRow(); i++) {
        int left = mThreadedMatL.GetValueAt(i, mDimensionNum).intValue();
        int right = mThreadedMatR.GetValueAt(i, mDimensionNum).intValue();
        int res = left + right;
        mThreadedDim.add((Integer)res);
      }
    }
    else if (mType == MatrixOperationType.Matrix_Multiplication) {
      for (int i = 1; i <= mThreadedMatL.GetRow(); i++) {
        int[] tmp_arr = new int[mThreadedMatL.GetCol()];
        for (int j = 1; j <= mThreadedMatL.GetCol(); j++) {
          int left = mThreadedMatL.GetValueAt(i, j);
          int right = mThreadedMatR.GetValueAt(j, mDimensionNum);
          tmp_arr[j - 1] = left * right;
        }
        int res = 0;
        for (int count = 0; count < tmp_arr.length; count++)
          res += tmp_arr[count];
        mThreadedDim.add((Integer)res);
      }
    }
  }
}