package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * CalcModel class being the implementation of the calculator. This is used to evaluate mathematical
 * expressions in the Infix and the Reverse Polish notations. The default in this cause being the
 * infix notation.
 * 
 * @author Pratik
 *
 */

public class CalcModel implements Calculator {
  @SuppressWarnings("unused")
  private boolean infixMode = true;

  /**
   * Used to set the notation of the Calculator from infix to Reverse Polish.
   * 
   * @param infix true if the user wants infix mode, and false if Reverse Polish is desired.
   */

  public void setInfixMode(boolean infix) {
    this.infixMode = infix;
  }

  /**
   * The method used to evaluate the mathematical expression when it is in 'string'.
   */

  @Override
  public float evaluate(String expression, Boolean infix) throws InvalidExpression {
    Stack<Entry> stack = new Stack<>();

    try {
      for (String token : expression.split(" ")) {
        Entry entry = new Entry(token);
        stack.push(entry);
        evaluateExpression(stack);
      }

      if (stack.size() != 1 || stack.peek().getType() != Type.NUMBER) {
        throw new InvalidExpression("Invalid expression");
      }

      return stack.pop().getNumber();
    } catch (BadType e) {
      throw new InvalidExpression("Invalid expression: " + e.getMessage());
    }
  }

  /**
   * This is another method used to aid the evaluation of expressions in the infix notation.
   * 
   * @param stack is the stack that is used for the expression evaluated.
   * @throws InvalidExpression is thrown when the expression either could not be evaluated or is
   *         invalid.
   */

  private void evaluateExpression(Stack<Entry> stack) throws InvalidExpression {
    try {
      while (stack.size() >= 3 && stack.peek().getType() == Type.NUMBER) {
        Entry operand2 = stack.pop();
        Entry operator = stack.pop();
        Entry operand1 = stack.pop();

        if (operator.getType() != Type.SYMBOL) {
          throw new InvalidExpression("Invalid expression");
        }

        float result =
            applyOperator(operand1.getNumber(), operand2.getNumber(), operator.getSymbol());
        stack.push(new Entry(result));
      }
    } catch (BadType e) {
      throw new InvalidExpression("Invalid expression: " + e.getMessage());
    }
  }

  /**
   * Evaluation of the mathematical expression in the infix notation i.e the Standard notation.
   * 
   * @param expression The infix mathematical expression that will be evaluated.
   * @return The result of the evaluation.
   * @throws InvalidExpression is thrown when the expression either could not be evaluated or is
   *         invalid.
   */

  float evaluateInfix(String expression) throws InvalidExpression {
    Stack<Entry> stack = new Stack<>();

    try {
      for (String token : expression.split(" ")) {
        Entry entry = new Entry(token);
        if (entry.getType() == Type.NUMBER) {
          stack.push(entry);
        } else if (entry.getType() == Type.SYMBOL) {
          while (!stack.isEmpty() && stack.peek().getType() == Type.NUMBER) {
            Entry operand2 = stack.pop();
            Entry operand1 = stack.pop();
            float result =
                applyOperator(operand1.getNumber(), operand2.getNumber(), entry.getSymbol());
            stack.push(new Entry(result));
          }
        } else {
          throw new InvalidExpression("Invalid expression");
        }
      }

      if (stack.size() != 1 || stack.peek().getType() != Type.NUMBER) {
        throw new InvalidExpression("Invalid expression");
      }

      return stack.pop().getNumber();
    } catch (BadType e) {
      throw new InvalidExpression("Invalid expression: " + e.getMessage());
    }
  }

  /**
   * Evaluation of the mathematical expression in the Reverse Polish notation.
   * 
   * @param expression Using the Reverse Polish notation it is the mathematical expression that we
   *        want to evaluate.
   * @return The result of the evaluation.
   * @throws InvalidExpression is thrown when the expression either could not be evaluated or is
   *         invalid.
   */

  float evaluateReversePolish(String expression) throws InvalidExpression {
    Stack<Entry> stack = new Stack<>();

    try {
      for (String tokenStr : expression.split("\\s+")) {
        Entry token = new Entry(tokenStr);
        switch (token.getType()) {
          case NUMBER:
            stack.push(token);
            break;
          case SYMBOL:
            try {
              float operand2 = stack.pop().getNumber();
              float operand1 = stack.pop().getNumber();
              float result = applyOperator(operand1, operand2, token.getSymbol());
              stack.push(new Entry(result));
            } catch (EmptyStackException e) {
              throw new InvalidExpression("Invalid expression: not enough operands");
            }
            break;
          default:
            throw new InvalidExpression("Invalid token: " + tokenStr);
        }
      }

      Entry resultEntry = stack.pop();
      if (stack.size() != 0 || resultEntry.getType() != Type.NUMBER) {
        throw new InvalidExpression("Invalid expression");
      }

      return resultEntry.getNumber();
    } catch (BadType e) {
      throw new InvalidExpression("Invalid expression: " + e.getMessage());
    }
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

  private float applyOperator(float operand1, float operand2, Symbol operator) {
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
