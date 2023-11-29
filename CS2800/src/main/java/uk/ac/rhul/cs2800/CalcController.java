package uk.ac.rhul.cs2800;

/**
 * CalcController is a call that as implied is the controller between the CalcModel that does the
 * evaluation and the ViewInterface in which the user interacts with.
 * 
 * @author Pratik
 *
 */

public class CalcController {

  private CalcModel myModel;
  ViewInterface myView;

  /**
   * Does the mathematical calculation using the user's input and updates the view with the result
   * or outputs an error message.
   * 
   */

  private void handleCalculation() {
    try {
      String expression = myView.getExpression();
      boolean infix = true;
      float result = myModel.evaluate(expression, infix);
      myView.setAnswer(Float.toString(result));
    } catch (InvalidExpression | ArithmeticException e) {
      myView.setAnswer("Error: " + e.getMessage());
    }
  }

  /**
   * Handles the switch as mentioned Type Change between calculator operation types being standard
   * and Reverse Polish.
   * 
   * @param type being the operation to switch to standard or reverse polish.
   */

  private void handleTypeChange(OpType type) {
    if (type == OpType.STANDARD) {
      myModel.setInfixMode(true);
    } else if (type == OpType.REV_POLISH) {
      myModel.setInfixMode(false);
    }
    myView.setAnswer("Switched to " + type + " mode");
  }

  /**
   * This Constructs a new CalcController instance.
   * 
   * @param model The instance of the CalcModel, model.
   * @param view is the User Interface (UI) view.
   */

  CalcController(CalcModel model, ViewInterface view) {
    this.myModel = model; // represents the view interface through which the controller interacts
                          // with the UI. Used for receiving inputs and displaying the outcome.
    this.myView = view;

    myView.addCalculateObserver(() -> handleCalculation());
    myView.addTypeObserver((type) -> handleTypeChange(type));

    myView.startView();
  }
}
