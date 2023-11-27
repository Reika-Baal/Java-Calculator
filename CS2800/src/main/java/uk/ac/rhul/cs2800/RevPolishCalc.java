package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

// https://en.wikipedia.org/wiki/Reverse_Polish_notation
// https://www.dcode.fr/reverse-polish-notation
// https://codereview.stackexchange.com/questions/120451/reverse-polish-notation-calculator-in-java
// These are the main sites I used to aid me in this aspect of the code as I was unfamiliar with
// ReversePolish.

public class RevPolishCalc {

  public static float evaluate(String expr, CalcModel calculator)
      throws InvalidExpression, BadType {
    if (expr == null || expr.isEmpty()) {
      throw new InvalidExpression("Invalid expression");
    }

    uk.ac.rhul.cs2800.Stack stack = new uk.ac.rhul.cs2800.Stack();

    System.out.println("Input\tOperation\tStack after");

    for (String tokenStr : expr.split("\\s+")) {
      System.out.print(tokenStr + "\t");

      try {
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

    Entry resultEntry = stack.pop();
    if (stack.size() != 0 || resultEntry.getType() != Type.NUMBER) {
      throw new InvalidExpression("Invalid expression");
    }

    return resultEntry.getNumber();
  }

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
