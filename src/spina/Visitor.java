////////////////////////////////////////////////////////////////////////
// Visitor.java: declares all the abstract Visit functions that each
//  visitor must implement.  Also includes the VisitElement function
//  which alows visiting of an Element when its type is not known.
// 
// version: 1.0
// description: part of the interpreter example for the visitor design
//  pattern.
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

public abstract class Visitor {

  public abstract void VisitVariableElement(VariableElement element);
  public abstract void VisitIndexerElement(IndexerElement element);
  public abstract void VisitIntegerElement(IntegerElement element);
  public abstract void VisitMatrixElement (MatrixElement element);
  public abstract void VisitAssignmentOperationElement(AssignmentOperationElement element);
  public abstract void VisitAdditionOperationElement(AdditionOperationElement element);
  public abstract void VisitMultiplicationOperationElement(MultiplicationOperationElement element);
  public abstract void VisitParallelForElement(ParallelForElement element);
  public abstract void VisitPrintOperationElement(PrintOperationElement element);

  public void VisitElement(Element element){
    if(element instanceof IntegerElement){
      IntegerElement int_elem = (IntegerElement) element;
      VisitIntegerElement(int_elem);       
    } else if(element instanceof MatrixElement){
      MatrixElement mat_elem = (MatrixElement) element;
      VisitMatrixElement(mat_elem);
    } else if(element instanceof VariableElement){
      VariableElement var_elem = (VariableElement) element;
      VisitVariableElement(var_elem);
    } else if (element instanceof IndexerElement) {
      IndexerElement ind_elem = (IndexerElement) element;
      VisitIndexerElement(ind_elem);
    } else if(element instanceof AdditionOperationElement){
      AdditionOperationElement add_elem = (AdditionOperationElement) element;
      VisitAdditionOperationElement(add_elem);
    } else if(element instanceof MultiplicationOperationElement){
      MultiplicationOperationElement mul_elem = (MultiplicationOperationElement) element;
      VisitMultiplicationOperationElement(mul_elem);
    } else if(element instanceof AssignmentOperationElement){
      AssignmentOperationElement assign_elem = (AssignmentOperationElement) element;
      VisitAssignmentOperationElement(assign_elem);
    } else if(element instanceof ParallelForElement){
      ParallelForElement paral_elem = (ParallelForElement) element;
      VisitParallelForElement(paral_elem);
    }
  }

  protected Visitor() { }
}
