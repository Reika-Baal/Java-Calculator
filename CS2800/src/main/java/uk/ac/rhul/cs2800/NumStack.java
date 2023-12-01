package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class NumStack {
  private List<Float> value = new ArrayList<>();

  public int size() {
    return value.size();
  }

  public void push(float num) {
    value.add(num);
  }

  public float pop() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.remove(value.size() - 1);
  }

  public float top() {
    if (value.isEmpty()) {
      throw new EmptyStackException();
    }
    return value.get(value.size() - 1);
  }
}
