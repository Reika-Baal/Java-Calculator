package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * The OpStack class represents a stack of strings. It provides methods for manipulating and
 * accessing elements.
 * 
 * @author Pratik
 * 
 */
public class OpStack {

  /**
   * The list to store symbol elements.
   */
  
  private List<Symbol> value = new ArrayList<>();

  /**
   * Returns the current size of the stack.
   * 
   * @return The current size of the stack.
   */
  
  public int size() {
    return value.size();
  }

  /**
   * Pushes a symbol onto the top of the stack.
   * 
   * @param symbol is the symbol to be pushed onto the stack.
   */
  public void push(Symbol symbol) {
    value.add(symbol);
  }

  /**
   * Pops and returns the symbol at the top of the stack.
   * 
   * @return The symbol at the top of the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public Symbol pop() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.remove(value.size() - 1);
  }

  /**
   * Returns the symbol at the top of the stack without removing it.
   * 
   * @return The symbol at the top of the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public Symbol top() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.get(value.size() - 1);
  }
}
