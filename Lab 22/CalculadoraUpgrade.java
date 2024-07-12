import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class CalculadoraUpgrade extends Application {

  private TextField display;
  private double num1 = 0;
  private String operator = "";
  private boolean start = true;

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Calculadora 2");

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 10, 10, 10));
    grid.setVgap(5);
    grid.setHgap(5);

    display = new TextField();
    display.setEditable(false);
    display.setPrefHeight(50);
    display.setStyle("-fx-background-color: #fab4e6; -fx-font-size: 20px;");
    grid.add(display, 0, 0, 4, 1);

    String[] buttonLabels = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+",
        "√", "^", "C", "CE"
    };

    int row = 1;
    int col = 0;
    for (String label : buttonLabels) {
      Button button = new Button(label);
      button.setPrefWidth(50);
      button.setPrefHeight(50);
      button.setFont(Font.font(14));
      button.setStyle("-fx-background-color: #ed6dc9; -fx-text-fill: white;");
      button.setOnAction(e -> handleButtonClick(label));
      grid.add(button, col, row);
      col++;
      if (col > 3) {
        col = 0;
        row++;
      }
    }

    Scene scene = new Scene(grid, 230, 320);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void handleButtonClick(String value) {
    if (value.matches("[0-9.]")) {
      if (start) {
        display.setText(value);
        start = false;
      } else {
        display.setText(display.getText() + value);
      }
    } else if (value.matches("[+\\-*/^]")) {
      if (!operator.isEmpty())
        calculate();
      num1 = Double.parseDouble(display.getText());
      operator = value;
      start = true;
    } else if (value.equals("=")) {
      calculate();
    } else if (value.equals("√")) {
      double num = Double.parseDouble(display.getText());
      display.setText(String.valueOf(Math.sqrt(num)));
    } else if (value.equals("C")) {
      display.clear();
    } else if (value.equals("CE")) {
      display.clear();
      num1 = 0;
      operator = "";
      start = true;
    }
  }

  private void calculate() {
    double num2 = Double.parseDouble(display.getText());
    switch (operator) {
      case "+":
        display.setText(String.valueOf(num1 + num2));
        break;
      case "-":
        display.setText(String.valueOf(num1 - num2));
        break;
      case "*":
        display.setText(String.valueOf(num1 * num2));
        break;
      case "/":
        display.setText(String.valueOf(num1 / num2));
        break;
      case "^":
        display.setText(String.valueOf(Math.pow(num1, num2)));
        break;
    }
    start = true;
    operator = "";
  }

  public static void main(String[] args) {
    launch(args);
  }
}