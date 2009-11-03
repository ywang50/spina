////////////////////////////////////////////////////////////////////////
// PrettyPrintVisitor.java: demonstrates printing the syntax tree in 
//  a difference source language than the input for the Spina language.
// 
// version: 1.0
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

public class PrettyPrintVisitor extends Visitor {

  public void VisitVariableElement(VariableElement element){
    System.out.print("var:" + element.getText() + " ");
  }
  public void VisitIndexerElement(IndexerElement element){
    System.out.print("indexer:" + element.getText() + " ");
  }
  public void VisitIntegerElement(IntegerElement element){
    System.out.print("int:" + element.getText() + " ");
  }
  public void VisitMatrixElement(MatrixElement element) {
    System.out.print("matrix: ");
  }
  public void VisitAssignmentOperationElement(AssignmentOperationElement element){
    VisitElement(element.getLhs());
    System.out.print(":= ");
    VisitElement(element.getRhs());
    System.out.println(";");
  }
  public void VisitAdditionOperationElement(AdditionOperationElement element){
    VisitElement(element.getLhs());
    System.out.print("+ ");
    VisitElement(element.getRhs());
    System.out.print(" ");
  }
  public void VisitMultiplicationOperationElement(MultiplicationOperationElement element){
    VisitElement(element.getLhs());
    System.out.print("* ");
    VisitElement(element.getRhs());
    System.out.print(" ");
  }
  public void VisitParallelForElement(ParallelForElement element){
    int count = element.numberOfElements();
    for (int i = 0; i < count; i++) {
        VisitAssignmentOperationElement(element.getAssignment(i));
    }
  }
  public void VisitPrintOperationElement(PrintOperationElement element){
    System.out.print("function:print ");
    VisitElement(element.getChildElement());
    System.out.println(";");
  }
}
