package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Stack class taking in inputs from the Entry class.
 * 
 * @author Pratik
 *
 */

public class Stack {
  private int size = 0;
  private Entry[] value = new Entry[10];

  /**
   * Method to get the current size of the stack.
   *
   * @return The current size of the stack
   */

  public int size() {
    return size;
  }

  /**
   * Push an Entry object onto the stack.
   *
   * @param entry is The Entry object to push onto the stack.
   */

  // The size of the array is increased if there are more or equal size.
  public void push(Entry entry) {
    if (size >= value.length) {
      Entry[] newValue = new Entry[value.length * 2];
      System.arraycopy(value, 0, newValue, 0, value.length);
      value = newValue;
    }
    value[size] = entry;
    size++;
  }

  /**
   * Pops and returns the top Entry from the stack.
   *
   * @return The top Entry on the stack.
   * @throws EmptyStackException if the stack is empty.
   */

  public Entry pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    size--;
    return value[size];
  }

  /**
   * Get the top Entry from the stack without removing it.
   *
   * @return The top Entry on the stack.
   * @throws EmptyStackException if the stack is empty.
   */

  public Entry top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return value[size - 1];
  }
}
