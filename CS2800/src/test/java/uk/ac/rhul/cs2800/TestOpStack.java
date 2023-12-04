package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

class TestOpStack {

  @Test
  void testPushPop() {
    OpStack opStack = new OpStack();
    opStack.push(Symbol.PLUS);
    assertEquals(Symbol.PLUS, opStack.pop());
  }

  @Test
  void testTop() {
    OpStack opStack = new OpStack();
    opStack.push(Symbol.MINUS);
    assertEquals(Symbol.MINUS, opStack.top());
  }

  @Test
  void testPopEmptyStack() {
    OpStack opStack = new OpStack();
    assertThrows(EmptyStackException.class, opStack::pop);
  }

  @Test
  void testTopEmptyStack() {
    OpStack opStack = new OpStack();
    assertThrows(EmptyStackException.class, opStack::top);
  }

  @Test
  void testSize() {
    OpStack opStack = new OpStack();
    opStack.push(Symbol.DIVIDE);
    opStack.push(Symbol.TIME);
    assertEquals(2, opStack.size());
  }
}
