////////////////////////////////////////////////////////////////////////
// AssignmentOperationElement.java: holds the data needed for an 
//  assignment operation.
// 
// version: 1.0
// description: part of the interpreter example for the visitor design
//  pattern.
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

public class AssignmentOperationElement extends Element {

  Element mLhs;
  Element mRhs;

  public AssignmentOperationElement() {
      
  }

  public AssignmentOperationElement(AssignmentOperationElement elem) {
    Element lhs = elem.getLhs();
    Element rhs = elem.getRhs();
    if (lhs instanceof VariableElement) {
      mLhs = new VariableElement((VariableElement)lhs);
    }
    else if (lhs instanceof IndexerElement) {
      mLhs = new IndexerElement((IndexerElement)lhs);
    }

    if (rhs instanceof IntegerElement) {
      mRhs = new IntegerElement((IntegerElement)rhs);
    }
    else if (rhs instanceof MatrixElement) {
      mRhs = new MatrixElement((MatrixElement)rhs);
    }
    else if (rhs instanceof AdditionOperationElement) {
      mRhs = new AdditionOperationElement((AdditionOperationElement)rhs);
    }
    else if (rhs instanceof MultiplicationOperationElement) {
      mRhs = new MultiplicationOperationElement((MultiplicationOperationElement)rhs);
    }
  }

  public void Accept(Visitor visitor){
    visitor.VisitAssignmentOperationElement(this);
  }

  public Element getLhs() { return mLhs; }
  public void setLhs(Element lhs) { mLhs = lhs; }

  public Element getRhs() { return mRhs; }
  public void setRhs(Element rhs) { mRhs = rhs; }

  public void replaceText(String orig, String repl) {
    if (mLhs instanceof VariableElement) {
        ((VariableElement)mLhs).replaceVariableText(orig, repl);
    }
    else if (mLhs instanceof IndexerElement) {
        ((IndexerElement)mLhs).replaceIteratorText(orig, repl);
    }

    if (mRhs instanceof AdditionOperationElement) {
        if (((AdditionOperationElement)mRhs).getLhs() instanceof VariableElement) {
            ((VariableElement)((AdditionOperationElement)mRhs).getLhs()).replaceVariableText(orig, repl);
        }
        else if (((AdditionOperationElement)mRhs).getLhs() instanceof IndexerElement) {
            ((IndexerElement)((AdditionOperationElement)mRhs).getLhs()).replaceIteratorText(orig, repl);
        }

        if (((AdditionOperationElement)mRhs).getRhs() instanceof VariableElement) {
            ((VariableElement)((AdditionOperationElement)mRhs).getRhs()).replaceVariableText(orig, repl);
        }
        else if (((AdditionOperationElement)mRhs).getRhs() instanceof IndexerElement) {
            ((IndexerElement)((AdditionOperationElement)mRhs).getRhs()).replaceIteratorText(orig, repl);
        }
    }
    else if (mRhs instanceof MultiplicationOperationElement) {
        if (((MultiplicationOperationElement)mRhs).getLhs() instanceof VariableElement) {
            ((VariableElement)((MultiplicationOperationElement)mRhs).getLhs()).replaceVariableText(orig, repl);
        }
        else if (((MultiplicationOperationElement)mRhs).getLhs() instanceof IndexerElement) {
            ((IndexerElement)((MultiplicationOperationElement)mRhs).getLhs()).replaceIteratorText(orig, repl);
        }

        if (((MultiplicationOperationElement)mRhs).getRhs() instanceof VariableElement) {
            ((VariableElement)((MultiplicationOperationElement)mRhs).getRhs()).replaceVariableText(orig, repl);
        }
        else if (((MultiplicationOperationElement)mRhs).getRhs() instanceof IndexerElement) {
            ((IndexerElement)((MultiplicationOperationElement)mRhs).getRhs()).replaceIteratorText(orig, repl);
        }
    }
  }
}
