package uk.ac.rhul.cs2800;

/**
 * Emum class for the Symbols.
 * 
 * @author Pratik
 *
 */

public enum Symbol {
  /**
   * The left bracket symbol.
   * 
   */
  LEFT_BRACKET,
  /**
   * The right bracket symbol.
   * 
   */
  RIGHT_BRACKET,
  /**
   * The time symbol.
   * 
   */
  TIME,
  /**
   * The divide bracket symbol.
   * 
   */
  DIVIDE,
  /**
   * The plus symbol.
   * 
   */
  PLUS,
  /**
   * The minus symbol.
   * 
   */
  MINUS,
  /**
   * The invalid symbol.
   * 
   */
  INVALID;

  @Override
  public String toString() {
    return name();
  }
}
