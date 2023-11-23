package uk.ac.rhul.cs2800;

/**
 * Emum class for the Types.
 * 
 * @author Pratik
 *
 */
public enum Type {
  /**
   * the String type face.
   * 
   */
  STRING,
  /**
   * the number type face.
   * 
   */
  NUMBER,
  /**
   * the symbol type face created with a custom enum.
   * 
   */
  SYMBOL,
  /**
   * the invalid type face.
   * 
   */
  INVALID;

  @Override
  public String toString() {
    return name();
  }
}
