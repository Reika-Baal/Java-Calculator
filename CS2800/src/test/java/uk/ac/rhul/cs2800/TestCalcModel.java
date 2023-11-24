package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {

  private CalcModel calcModel;

  @BeforeEach
  void setUp() {
    calcModel = new CalcModel();
  }

  @Test
  void testEvaluate() throws InvalidExpression {
    // Test valid infix expression
    assertEquals(6.0f, calcModel.evaluate("2 + 4", true));

    // Test valid reverse polish expression
    assertEquals(6.0f, calcModel.evaluate("2 4 +", false));

    // Test invalid expression
    assertThrows(InvalidExpression.class, () -> calcModel.evaluate("2 4 + +", false));
  }

  @Test
  void testEvaluateInfix() throws InvalidExpression {
    // Test valid infix expression
    assertEquals(6.0f, calcModel.evaluateInfix("2 + 4"));

    // Test invalid infix expression
    assertThrows(InvalidExpression.class, () -> calcModel.evaluateInfix("2 +"));
  }

  @Test
  void testInvalidExpression() {
    // Test if InvalidExpression is thrown for an invalid expression
    assertThrows(InvalidExpression.class, () -> calcModel.evaluateInfix("invalid expression"));
  }

  @Test
  void testInvalidExpressionException() {
    // Test if InvalidExpression is thrown for an invalid expression
    assertThrows(InvalidExpression.class, () -> calcModel.evaluateInfix("invalid expression"));
  }

  @Test
  void testEvaluateWithInvalidType() {
    // Test if BadType exception is thrown for invalid type in the expression
    assertThrows(InvalidExpression.class, () -> calcModel.evaluate("2 + A", true));
  }
}
