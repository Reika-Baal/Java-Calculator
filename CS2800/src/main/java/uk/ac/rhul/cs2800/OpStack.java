package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class OpStack {
  private List<Symbol> value = new ArrayList<>();

  public int size() {
    return value.size();
  }

  public void push(Symbol symbol) {
    value.add(symbol);
  }

  public Symbol pop() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.remove(value.size() - 1);
  }

  public Symbol top() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.get(value.size() - 1);
  }
}
