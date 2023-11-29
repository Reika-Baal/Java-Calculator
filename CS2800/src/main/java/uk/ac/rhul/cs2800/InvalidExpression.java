package uk.ac.rhul.cs2800;

/**
 * This extends the standard Exception which is thrown when an expression can't be evaluated
 * successfully. Therefore this provides additional information about the cause of the failure
 * through a detailed message.
 * 
 * @author Pratik
 * 
 */
public class InvalidExpression extends Exception {

  /**
   * Creates an InvalidExpression with the specified detail message to help resolve it.
   * 
   * @param message is the detailed message of what the error is and can be retrieved later if needed.
   */
  public InvalidExpression(String message) {
    super("This is an InvalidExpression and error as occured" + message);
  }
}
