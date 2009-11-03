////////////////////////////////////////////////////////////////////////
// Element.java: declares the Accept function that takes a visitor 
// 
// version: 1.0
// author: Yehong Wang (ywang50@syr.edu)
// language: Java 1.6.0.0
////////////////////////////////////////////////////////////////////////

package spina;

public abstract class Element {

  public abstract void Accept(Visitor visitor);
}
