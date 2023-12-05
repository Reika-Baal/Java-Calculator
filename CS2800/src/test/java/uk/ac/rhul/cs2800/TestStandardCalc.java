package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestStandardCalc {

  @Test // Addition and complex expressions tested
  public void testEvaluate() throws InvalidExpression {
    StandardCalc standardCalc = new StandardCalc();

    float result1 = standardCalc.evaluate("2 + 3");
    assertEquals(5, result1, 0.001);

    float result2 = standardCalc.evaluate("(5 * 2) - 3 / 2");
    assertEquals(9.5, result2, 0.001);

  }

  @Test // Test an invalid expression
  public void testInvalidExpression() {
    StandardCalc standardCalc = new StandardCalc();

    try {
      float result = standardCalc.evaluate("2 + ");
    } catch (InvalidExpression e) {
    }
  }
}
