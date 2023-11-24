package uk.ac.rhul.cs2800;

import java.util.Objects;

/**
 * Entry class that will be used for the Stack class taking in 4 value types.
 * 
 * @author Pratik
 *
 */
public class Entry {
  private Float number;
  private Symbol other;
  private String str;
  private Type type;

  /**
   * Creates a constructor that has an Entry object containing a Float number.
   *
   * @param number is the float number that will be stored in the Entry.
   */

  public Entry(Float number) {
    this.number = number;
    this.type = Type.NUMBER;
  }

  /**
   * Creates a constructor that has an Entry object containing a Symbol.
   *
   * @param other is the Symbol that will be stored in the Entry. It also sets the type in the Type
   *        class.
   */

  public Entry(Symbol other) {
    this.other = other;
    this.type = Type.SYMBOL;
  }

  /**
   * Creates a constructor that has an Entry object containing a String.
   *
   * @param str is the String that will be stored in the Entry.
   */

  public Entry(String str) {
    this.str = str;
    this.type = Type.STRING;
  }

  /**
   * Get the Float number stored in this Entry making sure that if it isn't the correct Type
   * throwing an error.
   *
   * @return The Float number stored in this Entry.
   * @throws BadType which is the custom class if this Entry does NOT contain a number.
   */

  public Float getNumber() throws BadType {
    if (type != Type.NUMBER) {
      throw new BadType("This entry is INVALID as it does not contain a number.");
    }
    return number;
  }

  /**
   * Get the Symbol stored in this Entry ensuring that is the correct Type else it will throw an
   * error.
   *
   * @return The Symbol stored in this Entry.
   * @throws BadType if this Entry does NOT contain a Symbol.
   */

  public Symbol getSymbol() throws BadType {
    if (type != Type.SYMBOL) {
      throw new BadType("This entry is INVALID as it does not contain a Symbol.");
    }
    return other;
  }

  /**
   * Get the String stored in this Entry.
   *
   * @return The String stored in this Entry.
   * @throws BadType if this Entry does NOT contain a String.
   */

  public String getString() throws BadType {
    if (type != Type.STRING) {
      throw new BadType("This entry is INVALID as it does not contain a String.");
    }
    return str;
  }

  /**
   * Gets the Type to work with CalcModel.
   * 
   * @return the Type which is stored in the desired data I'm trying to access.
   */

  public Type getType() {
    return type;
  }

  /**
   * Check if this Entry is equal to another object.
   *
   * @param o being The object that will compare with this Entry.
   * @return true if the objects are equal, else it will return False.
   */

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Entry entry = (Entry) o;
    return Objects.equals(number, entry.number) && other == entry.other
        && Objects.equals(str, entry.str) && type == entry.type;
  }


  /**
   * Calculate a hash code for this Entry.
   *
   * @return The has code for this entry containing all the values required being number, other, str
   *         and type.
   */

  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }

  // https://www.baeldung.com/java-objects-hash-vs-objects-hashcode (didn't know about this function
  // until I was researching since before I would multiply each value with a prime number)

  @Override
  public String toString() {
    switch (type) {
      case NUMBER:
        return number.toString();
      case SYMBOL:
        return other.toString();
      case STRING:
        return str;
      default:
        return "INVALID";
    }
  }
}
