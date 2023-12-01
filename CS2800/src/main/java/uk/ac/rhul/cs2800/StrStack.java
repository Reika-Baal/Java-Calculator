package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StrStack {
  private List<String> value = new ArrayList<>();

  public int size() {
    return value.size();
  }

  public void push(String str) {
    value.add(str);
  }

  public String pop() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.remove(value.size() - 1);
  }

  public String top() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.get(value.size() - 1);
  }
}
