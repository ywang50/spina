/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spina;

/**
 *
 * @author Yehong
 */
public class IndexerElement extends Element {

  String mText;

  public void Accept(Visitor visitor){
    visitor.VisitIndexerElement(this);
  }

  public String getText() { return mText; }
  public void setText(String text) { mText = text; }
}

