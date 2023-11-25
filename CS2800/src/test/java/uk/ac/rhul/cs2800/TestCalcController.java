package uk.ac.rhul.cs2800;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCalcController {

  private CalcModelStub modelStub; // Stub used for testing CalcModel
  private ViewInterfaceStub viewStub; // Stub used for testing ViewInterface
  private CalcController controller;

  // https://stackoverflow.com/questions/463278/what-is-a-stub
  // https://youtube.com/watch?v=vyjUIcr6iYY
  // used to see how I can get it to individually test one element in relation to this.

  @BeforeEach
  public void setUp() {
    modelStub = new CalcModelStub();
    viewStub = new ViewInterfaceStub();
    controller = new CalcController(modelStub, viewStub);
  }

  @Test
  public void testHandleCalculationWithValidExpression() {
    viewStub.setExpression("2 + 3"); //over here we are setting up variables and is the prior step to initialise the test.
    controller.handleCalculation(); //execution of the previous step
    assertEquals("5.0", viewStub.getAnswer()); //whilst this step allows me to have verification done to check the result is expected
  }

  @Test
  public void testHandleCalculationWithInvalidExpression() {
    viewStub.setExpression("2 + abc"); 
    controller.handleCalculation();
    assertTrue(viewStub.getAnswer().startsWith("Error"));
  }

  // Stub for testing CalcModel
  private static class CalcModelStub implements CalcModel {
    @Override
    public float evaluate(String expression, Boolean infix) throws InvalidExpression {
      return Float.parseFloat(expression);
    }
  }

  // Stub for testing ViewInterface
  private static class ViewInterfaceStub implements ViewInterface {
    private String expression;
    private String answer;

    @Override
    public String getExpression() {
      return expression;
    }

    @Override
    public void setAnswer(String a) {
      answer = a;
    }

    public void setExpression(String expression) {
      this.expression = expression;
    }

    public String getAnswer() {
      return answer;
    }
  }
}
