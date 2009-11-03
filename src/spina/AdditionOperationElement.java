////////////////////////////////////////////////////////////////////////
// AdditionOperationElement.java: holds the data needed for an addition 
//  operation.
// 
// version: 1.0
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

public class AdditionOperationElement extends Element {

  Element mLhs;
  Element mRhs;

  public AdditionOperationElement() {
      
  }

  public AdditionOperationElement (AdditionOperationElement elem) {
    Element lhs = elem.getLhs();
    Element rhs = elem.getRhs();
    if (lhs instanceof VariableElement) {
      mLhs = new VariableElement((VariableElement)lhs);
    }
    else if (lhs instanceof IndexerElement) {
      mLhs = new IndexerElement((IndexerElement)lhs);
    }
    else if (lhs instanceof IntegerElement) {
      mLhs = new IntegerElement((IntegerElement)lhs);
    }
    else if (lhs instanceof MatrixElement) {
      mLhs = new MatrixElement((MatrixElement)lhs);
    }

    if (rhs instanceof VariableElement) {
      mRhs = new VariableElement((VariableElement)rhs);
    }
    else if (rhs instanceof IndexerElement) {
      mRhs = new IndexerElement((IndexerElement)rhs);
    }
    else if (rhs instanceof IntegerElement) {
      mRhs = new IntegerElement((IntegerElement)rhs);
    }
    else if (rhs instanceof MatrixElement) {
      mRhs = new MatrixElement((MatrixElement)rhs);
    }
  }

  public void Accept(Visitor visitor){
    visitor.VisitAdditionOperationElement(this);
  }

  public Element getLhs() { return mLhs; }
  public void setLhs(Element lhs) { mLhs = lhs; }

  public Element getRhs() { return mRhs; }
  public void setRhs(Element rhs) { mRhs = rhs; }
}
