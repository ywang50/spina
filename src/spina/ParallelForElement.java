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
public class ParallelForElement extends Element {

  VariableElement mVar;
  IntegerElement mStart, mEnd;
  Vector<AssignmentOperationElement> mBody;

  public ParallelForElement() {
      mVar = new VariableElement();
      mStart = new IntegerElement();
      mEnd = new IntegerElement();
      mBody = new Vector<AssignmentOperationElement>();
  }

  public void Accept(Visitor visitor){
    visitor.VisitParallelForElement(this);
  }

  public String getVar() { return mVar.getText(); }
  public void setVar(String value) { mVar.setText(value); }
  public String getStart() { return mStart.getText(); }
  public void setStart(String value) { mStart.setText(value); }
  public String getEnd() { return mEnd.getText(); }
  public void setEnd(String value) { mEnd.setText(value); }
  public void addAssignment(AssignmentOperationElement elem) { mBody.add(elem); }
  public AssignmentOperationElement getAssignment(int index) { return mBody.elementAt(index); }
  public int numberOfElements() { return mBody.size(); }

}

