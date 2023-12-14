package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * The StrStack class represents a stack of strings. It provides methods for manipulating and
 * accessing elements.
 * 
 * @author Pratik
 * 
 */
public class StrStack {

  /**
   * The list to store string elements.
   */
  
  private List<String> value = new ArrayList<>();

  /**
   * Returns the current size of the stack.
   * 
   * @return The current size of the stack.
   */
  
  public int size() {
    return value.size();
  }

  /**
   * Pushes a string onto the top of the stack.
   * 
   * @param str is the string to be pushed onto the stack.
   */
  public void push(String str) {
    value.add(str);
  }

  /**
   * Pops and returns the string at the top of the stack.
   * 
   * @return The string at the top of the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public String pop() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.remove(value.size() - 1);
  }

  /**
   * Returns the string at the top of the stack without removing it.
   * 
   * @return The string at the top of the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public String top() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.get(value.size() - 1);
  }
}
