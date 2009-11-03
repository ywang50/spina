////////////////////////////////////////////////////////////////////////
// IntegerElement.java: holds the data needed to represent an Integer.
// 
// version: 1.0
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

public class IntegerElement extends Element {

  String mText;

  public IntegerElement() {
      
  }

  public IntegerElement(IntegerElement elem) {
      mText = new String(elem.getText());
  }

  public void Accept(Visitor visitor){
    visitor.VisitIntegerElement(this);
  }

  public String getText() { return mText; }
  public void setText(String value) { mText = value; }
}
