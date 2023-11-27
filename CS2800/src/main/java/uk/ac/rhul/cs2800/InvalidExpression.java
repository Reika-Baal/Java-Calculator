package uk.ac.rhul.cs2800;

/**
 * An expression that was passed to a method but which could not be evaluated.
 */
public class InvalidExpression extends Exception {

  /**
   * Creates an InvalidExpression with the specified detail message to help resolve it.
   * 
   * @param message is the detailed message of what the error is and can be retrieved later.
   */
  public InvalidExpression(String message) {
    super("This is an InvalidExpression and error as occured" + message);
  }
}
