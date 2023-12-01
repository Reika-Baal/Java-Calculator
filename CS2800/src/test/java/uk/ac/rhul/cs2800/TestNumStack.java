package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

class TestNumStack {

  @Test
  void testPushPop() {
    NumStack numStack = new NumStack();
    numStack.push(8.0f);
    assertEquals(8.0f, numStack.pop());
  }

  @Test
  void testTop() {
    NumStack numStack = new NumStack();
    numStack.push(14.0f);
    assertEquals(14.0f, numStack.top());
  }

  @Test
  void testPopEmptyStack() {
    NumStack numStack = new NumStack();
    assertThrows(EmptyStackException.class, numStack::pop);
  }

  @Test
  void testTopEmptyStack() {
    NumStack numStack = new NumStack();
    assertThrows(EmptyStackException.class, numStack::top);
  }

  @Test
  void testSize() {
    NumStack numStack = new NumStack();
    numStack.push(6.0f);
    numStack.push(9.0f);
    assertEquals(2, numStack.size());
  }
}
