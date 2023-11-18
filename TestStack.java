package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {
  private Stack stack;

  @BeforeEach
  public void setup() {
    stack = new Stack();
  }

  @Test // Test 1 Creating a push should allow the value of the size too change.
  void testPushEntry() {
    stack.push(new Entry((float) 5.0));
    assertEquals(stack.size(), 1, "Test that pushes increasing the size of an empty stack by 1");
  }

  @Test // Test 2 Removing something from an empty stack is impossible hence should create an error
  void testEmptyPopEntry() {
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "You cannot pop from an empty stack causing an error.");
  }

  @Test // Test 3 multiple different test cases so I can build the correct limitations.
  void pushThenPopEntry() {
    stack.push(new Entry((float) 5.0));
    try {
      assertEquals(stack.pop().getNumber(), (float) 5.0,
          "Pushing a five then popping it should return 5.");
    } catch (BadType exception) {
      fail("BadTypes exception: " + exception.getMessage());
    }
    assertEquals(stack.size(), 0, "Pushing a five then popping it should give an empty stack.");
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "Push, pop, pop should throw an exception");
  }

  @Test // Pushing entries more than once
  void pushTwiceEntry() {
    stack.push(new Entry((float) 5.0));
    stack.push(new Entry((float) 17.0));
    assertEquals(stack.size(), 2, "Pushing twice should give size 2.");
    try {
      assertEquals(stack.pop().getNumber(), (float) 17.0,
          "Pushing twice then popping should return the second thing pushed");
    } catch (BadType exception) {
      fail("Unexpected BadTypes exception: " + exception.getMessage());
    }
    try {
      assertEquals(stack.pop().getNumber(), (float) 5.0,
          "Pushing twice then popping should return the first thing pushed.");
    } catch (BadType exception) {
      fail("Unexpected BadTypes exception: " + exception.getMessage());
    }
    assertEquals(stack.size(), 0, "Pushing a five then popping it should give an empty stack.");
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "Push, pop, pop should throw an exception");
  }

  @Test // Clients should be able to push a lot not just a limited array set hence create something
  // to increase the array size.
  void pushLotsEntry() {
    for (int index = 0; index < 1000; index++) {
      stack.push(new Entry((float) (index + 5)));
      try {
        assertEquals(stack.pop().getNumber(), (float) (index + 5),
            "Popped value should match the pushed value.");
      } catch (BadType exception) {
        exception.printStackTrace();
      }
    }

  }

  @Test // The entry should be able to recall what the top function is.
  void testTopEntry() {
    stack.push(new Entry((float) 5.0));
    stack.push(new Entry((float) 17.0));
    stack.push(new Entry((float) 2.0));
    try {
      assertEquals(stack.top().getNumber(), (float) 2.0, "Top element should be 2.");
    } catch (BadType exception) {
      fail("Unexpected BadTypes exception: " + exception.getMessage());
    }
    assertEquals(stack.size(), 3, "Stack size should remain unchanged.");
    stack.pop();
    stack.pop();
    try {
      assertEquals(stack.top().getNumber(), (float) 5.0, "Top element should now be 5.");
    } catch (BadType exception) {
      fail("Unexpected BadTypes exception: " + exception.getMessage());
    }

  }
}
