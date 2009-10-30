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

  private Vector<String> mElems;
  private int mRow;
  
  public MatrixElement() {
    mRow = 0;
    mElems = new Vector<String>();
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
