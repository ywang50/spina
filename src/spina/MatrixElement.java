////////////////////////////////////////////////////////////////////////
// MatrixElement.java: holds the data needed to represent a Matrix.
//
// version: 1.0
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

import java.util.Vector;

/**
 *
 * @author Yehong
 */
public class MatrixElement extends Element{

  private Vector<String> mElems;
  private int mRow;
  
  public MatrixElement() {
    mRow = 0;
    mElems = new Vector<String>();
  }

  public MatrixElement(MatrixElement elem) {
    mRow = elem.getRow();
    mElems = new Vector<String>();
    for (int i = 1; i <= elem.getRow(); i++) {
        for (int j = 1; j <= elem.getCol(); j++) {
            String txt = new String(elem.getText(i, j));
            mElems.add(txt);
        }
    }
  }

  public void Accept(Visitor visitor){
    visitor.VisitMatrixElement(this);
  }

  public int getRow() { return mRow; }
  public void setRow(int value) { mRow = value; }
  public void increRow() { mRow++; }
  public int getCol() { return mElems.size()/mRow; }

  public void addText(String value) {
      mElems.add(value);
  }

  public String getText(int row, int col) {
      int index = row * getCol() + col;
      return mElems.elementAt(index);
  }

  public Matrix GetMatrixLiteral() {
      Matrix mat = new Matrix(mElems, mRow);
      return mat;
  }

}
