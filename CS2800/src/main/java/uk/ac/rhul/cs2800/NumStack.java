package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * The NumStack class represents a stack of strings. It provides methods for manipulating and
 * accessing elements.
 * 
 * @author Pratik
 * 
 */
public class NumStack {

  /**
   * The  list to store floating point number elements.
   */
  
  private List<Float> value = new ArrayList<>();

  /**
   * Returns the current size of the stack.
   * 
   * @return The current size of the stack.
   */
  
  public int size() {
    return value.size();
  }

  /**
   * Pushes a floating point number onto the top of the stack.
   * 
   * @param num is the floating point number to be pushed onto the stack.
   */
  public void push(float num) {
    value.add(num);
  }

  /**
   * Pops and returns the floating-point number at the top of the stack.
   * 
   * @return The floating-point number at the top of the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public float pop() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.remove(value.size() - 1);
  }

  /**
   * Returns the floating point number at the top of the stack without removing it.
   * 
   * @return The floating point number at the top of the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public float top() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.get(value.size() - 1);
  }
}
