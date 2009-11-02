/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package spina;
import java.util.*;

/**
 *
 * @author Yehong
 */
public class Matrix {
    private Vector<Integer> mElems;
    private int mRow;
    private int mCol;

    public Matrix(int row, int col) {
        if (row > 0 && col > 0) {
            mElems = new Vector<Integer>();
            mRow = row;
            mCol = col;
            for (int i = 0; i < row * col; i++)
                mElems.add(new Integer(0));
        }
    }

    public Matrix(Vector<String> vec, int row) {
        int size = vec.size();
        if (row > 0 && size > 0) {
            mElems = new Vector<Integer>();
            for (int i = 0; i < size; i++) {
                String str_value = vec.elementAt(i);
                Integer int_value = Integer.decode(str_value);
                mElems.add(int_value);
            }
            mRow = row;
            mCol = size/row;
        }
    }

    public int GetRow() {
        return mRow;
    }

    public void setRow(int row) {
        if (row > 0)
          mRow = row;
    }

    public int GetCol() {
        return mCol;
    }

    public void setCol(int col) {
        if (col > 0)
          mCol = col;
    }

    public Integer GetValueAt(int row, int col) {
        int location = (row - 1) * mCol + (col - 1);
        if (location < 0 && location >= mElems.size()) {
            //error
        }
        return mElems.elementAt(location);
    }

    public void SetValueAt(int row, int col, Integer value) {
        int location = (row - 1) * mCol + (col - 1);
        if (location < 0 && location >= mElems.size()) {
            //error
        }
        mElems.set(location, value);
    }

}
