////////////////////////////////////////////////////////////////////////
// ParallelForElement.java: holds the data needed to represent
// a parallel for.
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
public class ParallelForElement extends Element {

  String mVar;
  int mStart, mEnd;
  Vector<AssignmentOperationElement> mBody;

  public ParallelForElement() {
      mBody = new Vector<AssignmentOperationElement>();
  }

  public void Accept(Visitor visitor){
    visitor.VisitParallelForElement(this);
  }

  public Vector<AssignmentOperationElement> getAssignmentElements() {
      return mBody;
  }

  public String getVar() { return mVar; }
  public void setVar(String value) { mVar = value; }
  public int getStart() { return mStart; }
  public void setStart(String value) { mStart = Integer.decode(value); }
  public void setStart(int value) { mStart = value; }
  public int getEnd() { return mEnd; }
  public void setEnd(String value) { mEnd = Integer.decode(value); }
  public void setEnd(int value) { mEnd = value; }
  public void addAssignment(AssignmentOperationElement elem) { mBody.add(elem); }
  public AssignmentOperationElement getAssignment(int index) { return mBody.elementAt(index); }
  public int numberOfElements() { return mBody.size(); }

}

