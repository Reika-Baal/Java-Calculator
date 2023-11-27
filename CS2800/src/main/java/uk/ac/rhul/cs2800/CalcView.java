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

// https://docs.oracle.com/javafx/2/get_started/fxml_tutorial.htm
// https://www.youtube.com/watch?v=Dbb69NiQHso
// https://www.opensourceforu.com/2017/07/developing-basic-gui-application-using-javafx-eclipse/
// primary sources used alongside @author Dave Cohen to try encapsulate the GUI logic and provide
// methods for the controller.

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

  @Override
  public void addCalculateObserver(Runnable f) {
    calcButton.setOnAction(event -> f.run());
  }

  @Override
  public void addTypeObserver(Consumer<OpType> c) {
    infixCalculatorButton.setOnAction(event -> c.accept(OpType.STANDARD));
    revPolishCalculatorButton.setOnAction(event -> c.accept(OpType.REV_POLISH));
  }

  @Override
  public String getExpression() {
    return inputField.getText();
  }

  @Override
  public void setAnswer(String answer) {
    totalField.setText(answer);
  }

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

  @Override
  public void start(Stage primaryStage) {}

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
