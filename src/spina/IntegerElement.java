////////////////////////////////////////////////////////////////////////
// IntegerElement.java: holds the data needed to represent an Integer.
// 
// version: 1.0
// description: part of the interpreter example for the visitor design
//  pattern.
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

public class IntegerElement extends Element {

  String mText;  

  public void Accept(Visitor visitor){
    visitor.VisitIntegerElement(this);
  }

  public String getText() { return mText; }
  public void setText(String value) { mText = value; }
}
