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

  public void Accept(Visitor visitor){
    visitor.VisitMultiplicationOperationElement(this);
  }

  public Element getLhs() { return mLhs; }
  public void setLhs(Element lhs) { mLhs = lhs; }

  public Element getRhs() { return mRhs; }
  public void setRhs(Element rhs) { mRhs = rhs; }
}

