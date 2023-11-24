package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Stack class taking in inputs from the Entry class.
 * 
 * @author Pratik
 *
 */

public class Stack {
  private List<Entry> value = new ArrayList<>();

  /**
   * Method to get the current size of the stack.
   *
   * @return The current size of the stack
   */

  public int size() {
    return value.size();
  }

  /**
   * Push an Entry object onto the stack.
   *
   * @param entry is The Entry object to push onto the stack.
   */

  // The size of the array is increased if there are more or equal size.
  public void push(Entry entry) {
    value.add(entry);
  }

  /**
   * Pops and returns the top Entry from the stack.
   *
   * @return The top Entry on the stack.
   * @throws EmptyStackException if the stack is empty.
   */

  public Entry pop() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.remove(value.size() - 1);// The size decrease should be after the entry is removed
                                          // not prior.
  }

  /**
   * Get the top Entry from the stack without removing it.
   *
   * @return The top Entry on the stack.
   * @throws EmptyStackException if the stack is empty.
   */

  public Entry top() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.get(value.size() - 1);
  }
}
