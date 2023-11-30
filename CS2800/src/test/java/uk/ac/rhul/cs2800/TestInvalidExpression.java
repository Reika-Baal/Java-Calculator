package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestInvalidExpression {

  @Test // Test for throwing an InvalidExpression with a custom message.
  public void testInvalidExpressionWithMessage() {
    String errorMessage = "This needs to be printed";

    // Ensures that throwing InvalidExpression produces the expected message with the new error
    // message.
    InvalidExpression exception = assertThrows(InvalidExpression.class, () -> {
      throw new InvalidExpression(errorMessage);
    });

    // Used to confirm if they both match having the same format.
    assertEquals("This is an InvalidExpression and error has occurred" + errorMessage,
        exception.getMessage());
  }

  @Test // Testing with a null error message.
  void testInvalidExpressionWithNullMessage() {
    InvalidExpression invalidExpression = new InvalidExpression(null);
    assertNotNull(invalidExpression);
    assertEquals("This is an InvalidExpression and error as occurrednull",
        invalidExpression.getMessage());
  }


  @Test // Tests with an empty error message.
  public void testInvalidExpressionWithEmptyMessage() {
    InvalidExpression exception = assertThrows(InvalidExpression.class, () -> {
      throw new InvalidExpression("");
    });

    assertEquals("This is an InvalidExpression and error has occurred", exception.getMessage());
  }
}
