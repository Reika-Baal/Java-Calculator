package uk.ac.rhul.cs2800;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Skeleton code for a terminal-based calculator that reads an expression from the user and
 * evaluates it and prints out the answer.
 * 
 * @author Dave Cohen (d.cohen@rhul.ac.uk)
 */

public class AsciiView implements ViewInterface {

  private String question;
  private Runnable doCalculation = null;
  private Consumer<OpType> setCalculatorType = null;

  /**
   * Displays the menu and handles user input for the terminal-based calculator.
   */
  private void menu() {
    Scanner scanner = new Scanner(System.in);
    boolean finished = false;
    help();

    while (!finished && scanner.hasNext()) {
      String userInput = scanner.next();
      switch (userInput.toUpperCase().charAt(0)) {
        case 'C':
          if (doCalculation != null) {
            doCalculation.run();
          }
          break;
        case '?':
          System.out.print("Enter expression: ");
          question = scanner.nextLine().trim();
          break;
        case 'S':
          if (setCalculatorType != null) {
            setCalculatorType.accept(OpType.STANDARD);
          }
          break;
        case 'R':
          if (setCalculatorType != null) {
            setCalculatorType.accept(OpType.REV_POLISH);
          }
          break;
        case 'Q':
          System.out.println("Bye");
          finished = true;
          break;
        default:
          help();
      }
    }
    scanner.close();
  }

  private void help() {
    System.out.println("Use one of the following:");
    System.out.println("  ?Expression - to set expression");
    System.out.println("  C - to calculate");
    System.out.println("  S - change to a standard calculator");
    System.out.println("  R - change to a reverse polish calculator");
    System.out.println("  Q - to exit");
  }

  @Override
  public String getExpression() {
    return question;
  }

  @Override
  public void setAnswer(String answer) {
    System.out.println("Answer: " + answer);
  }

  @Override
  public void addCalculateObserver(Runnable f) {
    doCalculation = f;
  }

  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    setCalculatorType = c;
  }

  @Override
  public void startView() {
    menu();
  }
}
