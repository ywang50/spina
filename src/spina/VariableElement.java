////////////////////////////////////////////////////////////////////////
// VariableElement.java: holds the data needed to represent variables 
//  in the Spina language.
// 
// version: 1.0
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

public class VariableElement extends Element {

  String mText;

  public VariableElement() {
      
  }

  public VariableElement(VariableElement elem) {
    mText = new String(elem.getText());
  }

  public void Accept(Visitor visitor){
    visitor.VisitVariableElement(this);
  }

  public String getText() { return mText; }
  public void setText(String text) { mText = text; }

  public void replaceVariableText(String orig, String repl) {
      if (mText.equals(orig)) {
          this.setText(repl);
      }
  }
}
