////////////////////////////////////////////////////////////////////////
// IndexerElement.java: holds the data needed to represent Indexers
// in the Spina language
//
// version: 1.0
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

/**
 *
 * @author Yehong
 */
public class IndexerElement extends Element {

  private String nameText;
  private String iterText;
  private String mText;

  public IndexerElement() {
      
  }

  public IndexerElement(String name, String iter) {
    nameText = new String(name);
    iterText = new String(iter);
    mText = new String (nameText + "<" + iterText + ">");
  }

  public IndexerElement(IndexerElement elem) {
    nameText = new String(elem.getName());
    iterText = new String(elem.getIter());
  }

  public void Accept(Visitor visitor){
    visitor.VisitIndexerElement(this);
  }

  public String getName() { return nameText; }
  public void setName(String text) { nameText = text; }
  public String getIter() { return iterText; }
  public void setIter(String text) { iterText = text; }
  public String getText() { return mText; }

  public void replaceIteratorText(String orig, String repl) {
      if (iterText.equals(orig)) {
          this.setIter(repl);
      }
  }
}

