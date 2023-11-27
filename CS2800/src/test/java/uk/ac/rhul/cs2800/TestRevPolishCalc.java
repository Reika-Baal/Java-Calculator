package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestRevPolishCalc {

  @Test
  void testEvaluateWithSymbolTokens() throws InvalidExpression, BadType {
    CalcModel calculator = new CalcModel();
    assertEquals(5, RevPolishCalc.evaluate("6 1 +", calculator));
    assertEquals(1, RevPolishCalc.evaluate("3 2 -", calculator));
    assertEquals(6, RevPolishCalc.evaluate("7 4 *", calculator));
    assertEquals(2, RevPolishCalc.evaluate("18 6 /", calculator));
  }

  @Test
  void testEvaluateMethodReturnsValue() throws InvalidExpression, BadType {
    CalcModel calculator = new CalcModel();
    assertEquals(0, RevPolishCalc.evaluate("0", calculator));
  }

  @Test
  void testPerformOperationMethodReturnsValue() {
    float result = RevPolishCalc.performOperation(2, 3, Symbol.PLUS);
    assertEquals(5, result);
  }

  @Test
  void testEvaluateAddition() throws InvalidExpression, BadType {
    CalcModel calculator = new CalcModel();
    assertEquals(5, RevPolishCalc.evaluate("2 3 +", calculator));
  }

  @Test
  void testEvaluateSubtraction() throws InvalidExpression, BadType {
    CalcModel calculator = new CalcModel();
    assertEquals(1, RevPolishCalc.evaluate("3 2 -", calculator));
  }

  @Test
  void testEvaluateMultiplication() throws InvalidExpression, BadType {
    CalcModel calculator = new CalcModel();
    assertEquals(6, RevPolishCalc.evaluate("2 3 *", calculator));
  }

  @Test
  void testEvaluateDivision() throws InvalidExpression, BadType {
    CalcModel calculator = new CalcModel();
    assertEquals(2, RevPolishCalc.evaluate("6 3 /", calculator));
  }

  @Test
  void testEvaluateComplexExpression() throws InvalidExpression, BadType {
    CalcModel calculator = new CalcModel();
    assertEquals(14, RevPolishCalc.evaluate("2 3 + 4 *", calculator));
  }

  @Test
  void testEvaluateInvalidToken() {
    CalcModel calculator = new CalcModel();
    assertThrows(InvalidExpression.class, () -> RevPolishCalc.evaluate("4 e +", calculator));
  }

  @Test
  void testEvaluateDivisionByZero() {
    CalcModel calculator = new CalcModel();
    assertThrows(ArithmeticException.class, () -> RevPolishCalc.evaluate("3 0 /", calculator));
  }

  @Test
  void testEvaluateEmptyExpression() {
    CalcModel calculator = new CalcModel();
    assertThrows(InvalidExpression.class, () -> RevPolishCalc.evaluate("", calculator));
  }

  @Test
  void testEvaluateWithMultipleExpressions() throws InvalidExpression, BadType {
    CalcModel calculator = new CalcModel();
    assertEquals(5, RevPolishCalc.evaluate("2 3 + 4 1 + *", calculator));
  }
}
