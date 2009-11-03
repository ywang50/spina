////////////////////////////////////////////////////////////////////////
// PrintOperationElement.java: hold the data needed to implement the
//  'print' function in the Spina language.
// 
// version: 1.0
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

public class PrintOperationElement extends Element {

  Element mChildElement;

  public Element getChildElement() { return mChildElement; }
  public void setChildElement(Element value) { mChildElement = value; }

  public void Accept(Visitor visitor){
    visitor.VisitPrintOperationElement(this);
  }
}
