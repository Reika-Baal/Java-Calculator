package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.function.Consumer;

// **Credits**
// https://docs.oracle.com/javafx/2/get_started/fxml_tutorial.htm
// https://www.youtube.com/watch?v=Dbb69NiQHso
// https://www.opensourceforu.com/2017/07/developing-basic-gui-application-using-javafx-eclipse/
// primary sources used alongside @author Dave Cohen to try encapsulate the GUI logic and provide
// methods for the controller.

/**
 * 
 * 
 * @author Pratik
 *
 */

public class CalcView extends Application implements ViewInterface {

  @FXML
  private Button calcButton;

  @FXML
  private ToggleButton infixCalculatorButton;

  @FXML
  private TextField inputField;

  @FXML
  private ToggleButton revPolishCalculatorButton;

  @FXML
  private TextField totalField;

  /**
   * Creates an observer to the calculate button so that it can perform a specified action when it
   * is pressed.
   *
   * @param f Action that will be performed when the calculate button is pressed.
   */

  @Override
  public void addCalculateObserver(Runnable f) {
    calcButton.setOnAction(event -> f.run());
  }

  /**
   * Creates an observer to the calculator type buttons being standard and Reverse Polish to perform
   * so an action can occur when pressed.
   *
   * @param c Action that will be performed when the calculate button is pressed.
   */

  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    infixCalculatorButton.setOnAction(event -> c.accept(OpType.STANDARD));
    revPolishCalculatorButton.setOnAction(event -> c.accept(OpType.REV_POLISH));
  }

  /**
   * Retrieves the mathematical expression entered by the user in the input field.
   *
   * @return The mathematical expression entered by the user.
   */

  @Override
  public String getExpression() {
    return inputField.getText();
  }

  /**
   * This will set the answer in the total field that will later be displayed to the user.
   *
   * @param answer is the result of a calculation else an error message will appear.
   */

  @Override
  public void setAnswer(String answer) {
    totalField.setText(answer);
  }

  /**
   * Initialises and starts the JavaFX application therefore displaying the calculator GUI.
   * 
   */

  @Override
  public void startView() {
    Stage stage = new Stage();
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
      loader.setController(this);
      Parent root = loader.load();
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Calculator");
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Method used for the JavaFX application to actually start.
   * 
   */

  @Override
  public void start(Stage primaryStage) {}

  /**
   * this is the main method to launch the JavaFX application.
   *
   * @param args is done via the command line to launch the application.
   */

  public static void main(String[] args) {
    launch(args);
  }

  // DO NOT CHANGE ANYTHING BELOW THIS COMMENT
  /////////////////////////////////////////////////////////////////////////////////
  // Block for creating an instance variable for others to use.
  //
  // Make it a JavaFX singleton. Instance is set by the javafx "initialize" method
  private static volatile CalcView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * This is a Singleton View constructed by the JavaaFX Thread and made available through this
   * method.
   * 
   * @return the single object representing this view
   */
  public static synchronized CalcView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(CalcView.class)).start();
      // Wait until the instance is ready since initialize has executed.
      while (instance == null) {// empty body
      }
    }

    return instance;
  }
  // End of special block
  /////////////////////////////////////////////////////////////////////////////////

}
