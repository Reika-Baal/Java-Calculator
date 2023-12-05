package uk.ac.rhul.cs2800;

/**
 * The StandardCalc class is used for evaluating mathematical expressions in standard (infix)
 * notation. It uses an OpStack.
 * 
 * @author Pratik
 */

public class StandardCalc {

  @SuppressWarnings("unused")
  private OpStack value;
  private RevPolishCalc rpCalc;

  /**
   * Constructs a StandardCalc with an OpStack and RevPolishCalc.
   */

  public StandardCalc() {
    this.value = new OpStack();
    this.rpCalc = new RevPolishCalc();
  }

  /**
   * Evaluates the mathematical expression in standard (infix) notation.
   * 
   * @param expression is the mathematical expression to be evaluated.
   * @return The result of the evaluation.
   * @throws InvalidExpression is called when the expression cannot be evaluated successfully.
   */

  @SuppressWarnings("static-access")
  public float evaluate(String expression) throws InvalidExpression {
    try {
      // Uses RevPolishCalc to evaluate the expression
      return rpCalc.evaluate(expression, null);
    } catch (BadType e) {
      throw new InvalidExpression("Invalid expression: " + e.getMessage());
    }
  }
}
