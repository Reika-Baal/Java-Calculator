package uk.ac.rhul.cs2800;

import java.util.Stack;

public class CalcModel implements Calculator {

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
