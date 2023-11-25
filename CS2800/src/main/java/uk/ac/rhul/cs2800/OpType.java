package uk.ac.rhul.cs2800;

/**
 * Enumeration class for the Types of calculation supported by the calculator.
 * 
 * @author Pratik
 *
 */
public enum OpType {
  /**
   * Standard infix notation.
   */

  STANDARD,

  /**
   * Reverse Polish Notation.
   */

  REV_POLISH;

  @Override
  public String toString() {
    return name();
  }
}
