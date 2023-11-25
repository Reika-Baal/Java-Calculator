package uk.ac.rhul.cs2800;

/**
 * The controller that sits between the calculator model that does actual evaluation and the view
 * that is the part the user interfaces with.
 */
public class CalcController {

  private CalcModel myModel;
  ViewInterface myView;

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

  private void handleTypeChange(OpType type) {
    if (type == OpType.STANDARD) {
      myModel.setInfixMode(true);
    } else if (type == OpType.REV_POLISH) {
      myModel.setInfixMode(false);
    }
    myView.setAnswer("Switched to " + type + " mode");
  }

  CalcController(CalcModel model, ViewInterface view) {
    this.myModel = model; // represents the view interface through which the controller interacts
                          // with the UI. Used for receiving inputs and displaying the outcome.
    this.myView = view;

    myView.addCalculateObserver(() -> handleCalculation());
    myView.addTypeObserver((type) -> handleTypeChange(type));

    myView.startView();
  }
}
