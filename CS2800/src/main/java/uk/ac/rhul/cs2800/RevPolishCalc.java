package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

// **Credits**
// https://en.wikipedia.org/wiki/Reverse_Polish_notation
// https://www.dcode.fr/reverse-polish-notation
// (3) https://codereview.stackexchange.com/questions/120451/reverse-polish-notation-calculator-in-java
// These are the main sites I used to aid me in this aspect of the code as I was unfamiliar with
// ReversePolish.

/**
 * The RevPolishCalc class provides functionality for evaluating mathematical expressions in Reverse
 * Polish notation. It handles the conversions the evaluations and everything to do with the Reverse
 * Polish notation.
 * 
 * @author Pratik
 *
 */

public class RevPolishCalc {

  /**
   * Evaluation of the mathematical expression in the Reverse Polish notation returning the result.
   * 
   * @param expression The Reverse Polish mathematical expression that will be evaluated.
   * @param calculator The calculator model used for arithmetic operations.
   * @return The result of the evaluation.
   * @throws InvalidExpression is thrown when the expression either could not be evaluated or is
   *         invalid.
   * @throws BadType is thrown if the expression contains unexpected data types.
   */

  public static float evaluate(String expression, CalcModel calculator)
      throws InvalidExpression, BadType {
    if (expression == null || expression.isEmpty()) {
      throw new InvalidExpression("Invalid expression");
    }

    uk.ac.rhul.cs2800.Stack stack = new uk.ac.rhul.cs2800.Stack();

    System.out.println("Input\tOperation\tStack after");

    for (String tokenStr : expression.split("\\s+")) {
      System.out.print(tokenStr + "\t");

      try { //3
        Symbol token = Symbol.valueOf(tokenStr);
        switch (token) {
          case PLUS:
          case MINUS:
          case TIME:
          case DIVIDE:
            System.out.print("Operate\t\t");
            try {
              float operand2 = stack.pop().getNumber();
              float operand1 = stack.pop().getNumber();
              float result = performOperation(operand1, operand2, token);
              stack.push(new Entry(result));
            } catch (EmptyStackException e) {
              throw new InvalidExpression("Invalid expression: not enough operands");
            }
            break;
          default:
            System.out.print("Push\t\t");
            try {
              stack.push(new Entry(Float.parseFloat(tokenStr)));
            } catch (NumberFormatException e) {
              throw new InvalidExpression("Invalid token: " + tokenStr);
            }
            break;
        }

        System.out.println(stack);
      } catch (IllegalArgumentException e) {
        throw new InvalidExpression("Invalid token: " + tokenStr);
      }
    }

    /**
     * Pops the result entry from the stack and validate the final state of the stack and the result
     * entry.
     *
     * @return The result of the Reverse Polish notation expression evaluation.
     * @throws InvalidExpression is thrown when the expression either could not be evaluated or is
     *         invalid
     */

    Entry resultEntry = stack.pop();
    if (stack.size() != 0 || resultEntry.getType() != Type.NUMBER) {
      throw new InvalidExpression("Invalid expression");
    }

    return resultEntry.getNumber();
  }

  /**
   * Used to apply mathematical operator to the two operands.
   * 
   * @param operand1 The first operand in which the operation is applied to. This can be understood
   *        as the first variable.
   * @param operand2 The second operand in which the operation is applied to. This can be understood
   *        as the second variable.
   * @param operator The value that is recalled in order to provide further clarification on the
   *        error.
   * @return is the result of applying the operator to the operands.
   */

  static float performOperation(float operand1, float operand2, Symbol operator) {
    switch (operator) {
      case PLUS:
        return operand1 + operand2;
      case MINUS:
        return operand1 - operand2;
      case TIME:
        return operand1 * operand2;
      case DIVIDE:
        if (operand2 == 0) {
          throw new ArithmeticException("Division by zero");
        }
        return operand1 / operand2;
      default:
        throw new IllegalArgumentException("Invalid operator: " + operator);
    }
  }
}
