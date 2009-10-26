////////////////////////////////////////////////////////////////////////
// AssignmentOperationElement.java: holds the data needed for an 
//  assignment operation.
// 
// version: 1.0
// description: part of the interpreter example for the visitor design
//  pattern.
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

public class AssignmentOperationElement extends Element {

  VariableElement mLhs;
  Element mRhs;  

  public void Accept(Visitor visitor){
    visitor.VisitAssignmentOperationElement(this);
  }

  public VariableElement getLhs() { return mLhs; }
  public void setLhs(VariableElement lhs) { mLhs = lhs; }

  public Element getRhs() { return mRhs; }
  public void setRhs(Element rhs) { mRhs = rhs; }
}
