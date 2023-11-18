package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEntry {
  private Entry numberEntry;
  private Entry symbolEntry;
  private Entry stringEntry;

  @BeforeEach
  public void setup() {
    numberEntry = new Entry((float) 5.0);
    symbolEntry = new Entry(Symbol.DIVIDE);
    stringEntry = new Entry("Hello World");
  }

  @Test // First test to make make sure that the constructor is recognising the number value.
  void testNumberEntryCreation() {
    assertNotNull(numberEntry, "Tests if the Entry class is created with a number value.");
  }

  @Test // Test 2 to ensure the other constructor being symbols is working.
  void testSymbolEntryCreation() {
    assertNotNull(symbolEntry, "Tests if the Entry class is created with a symbol value.");
  }

  @Test // Test 3 to test the String entry.
  void testStringEntryCreation() {
    assertNotNull(stringEntry, "Tests if the Entry class is created with a string value.");
  }

  @Test // Test 4 allows me to create a getter value for the number and recalls the initialised
  // value previously set.
  void testNumberEntryandGetter() {
    try {
      assertEquals((float) 5.0, numberEntry.getNumber(),
          "Tests if the number getter works correctly");
    } catch (BadType exception) {
      //fail("The number value isn't correct, a BadType exception: " + exception.getMessage());
    }
  }

  @Test // Test 5 lets me create a getter for Symbols recalling the initialised throwing an error if
  // not recalled.
  void testSymbolEntryandGetter() {
    try {
      assertEquals(Symbol.DIVIDE, symbolEntry.getSymbol(), "Tests if the symbol value is DIVIDE.");
    } catch (BadType exception) {
      //fail("The symbol value isn't correct, a BadType exception: " + exception.getMessage());
    }
  }

  @Test // Test 6 Similar test to the previous, checking initialised if it's recalled correctly.
  void testStringEntryandGetter() {
    try {
      assertEquals("Hello World", stringEntry.getString(),
          "Tests if the string value is 'Hello World'.");
    } catch (BadType exception) {
      //fail("The string value isn't correct, a BadType exception:" + exception.getMessage());
    }
  }

  @Test // Test 7 I deliberately recall a string from Number Entry too correctly implement BadType
  // exception.
  void testInvalidNumberEntry() {
    assertThrows(BadType.class, () -> {
      Entry invalidNumberEntry = new Entry((float) 5.0);
      //invalidNumberEntry.getString(); // This should throw a BadType exception
    }, "Tests if trying to get a String from a Number Entry throws a BadType exception.");
  }

  @Test // Test 8 is recalling Number from Symbol so I create a method for this test case.
  void testInvalidSymbolEntry() {
    assertThrows(BadType.class, () -> {
      Entry invalidSymbolEntry = new Entry(Symbol.PLUS);
      //invalidSymbolEntry.getNumber(); // This should throw a BadType exception
    }, "Tests if trying to get a Number from a Symbol Entry throws a BadType exception.");
  //}

  @Test // Test 9 In the same vein I recall a Symbol from String Entry causing BadType exception.
  void testInvalidStringEntry() {
    assertThrows(BadType.class, () -> {
      Entry invalidStringEntry = new Entry("Test String");
      //invalidStringEntry.getSymbol(); // This should throw a BadType exception
    }, "Tests if trying to get a Symbol from a String Entry throws a BadType exception.");
  //}

  @Test // Test 10 A further test to see if I can equal itself useful to the Equals method.
  void testMakeEntryEqual() {
    assertTrue(numberEntry.equals(numberEntry), "Tests making Entry equal to itself.");
  }

  @Test // Test 11 Need to make sure that the Entries are testing if things are Equal and other
  // Entries.
  void testEntryEquals() {
    Entry numberEntry2 = new Entry((float) 5.0);
    assertTrue(numberEntry.equals(numberEntry2), "Tests if Entry.equals works for equal Entries.");

    assertFalse(numberEntry.equals(symbolEntry),
        "Tests if Entry.equals works for different Entries.");
  }

  @Test // // Test 12 Need to have a HashCode method, learnt that I don't need a prime number to act
  // as a key.
  void testMakeHashCode() {
    int hashCode = numberEntry.hashCode();
    assertNotNull(hashCode, "Tests making the hashCode method.");
  }

  @Test // Test 13 Need to ensure that the HashCode being a further check works with equal method.
  void testEntryHashCode() {
    Entry numberEntry2 = new Entry((float) 5.0);
    assertEquals(numberEntry.hashCode(), numberEntry2.hashCode(),
        "Tests if Entry.hashCode works for equal Entries.");
  }

  @Test // Test 14 Creating a method allowing me to print the constructors that have passed
  // previously created test.
  void testMakeToString() {
    String stringRep = numberEntry.toString();
    assertNotNull(stringRep, "Tests making the toString method.");
  }

  @Test // Test 15 trying to print all of the constructor.
  void testEntryToString() {
    assertEquals("5.0", numberEntry.toString(), "Tests if Entry.toString works for numbers.");
    assertEquals("DIVIDE", symbolEntry.toString(), "Tests if Entry.toString works for symbols.");
    assertEquals("Hello World", stringEntry.toString(),
        "Tests if Entry.toString works for strings.");
  }
}
