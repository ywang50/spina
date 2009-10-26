/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spina;

import java.util.Vector;

/**
 *
 * @author Yehong
 */
public class MatrixElement extends Element{

  String mText;
  Vector<IntegerElement> mElems;
  int mRow;
  
  public MatrixElement() {
    mRow = 0;
    mElems = new Vector<IntegerElement>();
  }

  public void Accept(Visitor visitor){
    visitor.VisitMatrixElement(this);
  }

  public int getRow() { return mRow; }
  public void setRow(int value) { mRow = value; }
  public void increRow() { mRow++; }
  public int getCol() { return mElems.size()/(mRow + 1); }

  public void addText(String value) {
      IntegerElement ele = new IntegerElement();
      ele.setText(value);
      mElems.add(ele);
  }

  public void setText(int row, int col, String value) {
      int index = row * getCol() + col;
      mElems.elementAt(index).setText(value);
  }

  public String getText(int row, int col) {
      int index = row * getCol() + col;
      return mElems.elementAt(index).getText();
  }

}
