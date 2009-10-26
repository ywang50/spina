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

  String nameText;
  String iterText;

  public void Accept(Visitor visitor){
    visitor.VisitIndexerElement(this);
  }

  public String getName() { return nameText; }
  public void setName(String text) { nameText = text; }
  public String getIter() { return iterText; }
  public void setIter(String text) { iterText = text; }
}

