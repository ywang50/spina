/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spina;

/**
 *
 * @author Yehong
 */
public class MultiplicationOperationElement extends Element {

  Element mLhs;
  Element mRhs;

  public MultiplicationOperationElement() {
      
  }

  public MultiplicationOperationElement (MultiplicationOperationElement elem) {
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
    visitor.VisitMultiplicationOperationElement(this);
  }

  public Element getLhs() { return mLhs; }
  public void setLhs(Element lhs) { mLhs = lhs; }

  public Element getRhs() { return mRhs; }
  public void setRhs(Element rhs) { mRhs = rhs; }
}

