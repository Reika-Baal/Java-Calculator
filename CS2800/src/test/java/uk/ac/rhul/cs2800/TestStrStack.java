package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

class StrStackTest {

  @Test
  void testPushPop() {
    StrStack strStack = new StrStack();
    strStack.push("This is a test");
    assertEquals("This is a test", strStack.pop());
  }

  @Test
  void testTop() {
    StrStack strStack = new StrStack();
    strStack.push("Calc");
    assertEquals("Calc", strStack.top());
  }

  @Test
  void testPopEmptyStack() {
    StrStack strStack = new StrStack();
    assertThrows(EmptyStackException.class, strStack::pop);
  }

  @Test
  void testTopEmptyStack() {
    StrStack strStack = new StrStack();
    assertThrows(EmptyStackException.class, strStack::top);
  }

  @Test
  void testSize() {
    StrStack strStack = new StrStack();
    strStack.push("Test");
    strStack.push("Size");
    assertEquals(2, strStack.size());
  }
}
