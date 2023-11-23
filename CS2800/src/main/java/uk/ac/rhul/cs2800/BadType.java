package uk.ac.rhul.cs2800;

/**
 * Custom exception class as indicated in the UML diagram.
 * 
 * @author Pratik
 *
 */

@SuppressWarnings("serial")
public class BadType extends Exception {
  /**
   * The exception called BadType.
   * 
   * @param message will output a custom message alongside with the error if BadType is called.
   */
  public BadType(String message) {
    super(message);
  }
}
