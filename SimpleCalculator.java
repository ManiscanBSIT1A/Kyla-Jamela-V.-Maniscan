import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SimpleCalculator extends Application {

    private TextField num1Field;
    private TextField num2Field;
    private Label resultLabel;

    @Override
    public void start(Stage primaryStage) {
        
        Label titleLabel = new Label("Simple Calculator");
        Label num1Label = new Label("Input Number 1:");
        Label num2Label = new Label("Input Number 2:");
        num1Field = new TextField();
        num2Field = new TextField();
        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("x");
        Button divideButton = new Button("/");
        resultLabel = new Label();

        // Event handlers for arithmetic operations
        addButton.setOnAction(e -> calculate('+'));
        subtractButton.setOnAction(e -> calculate('-'));
        multiplyButton.setOnAction(e -> calculate('*'));
        divideButton.setOnAction(e -> calculate('/'));

        // Layout setup
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(titleLabel, 0, 0, 4, 1);
        gridPane.add(num1Label, 0, 1);
        gridPane.add(num1Field, 1, 1);
        gridPane.add(num2Label, 2, 1);
        gridPane.add(num2Field, 3, 1);
        gridPane.add(addButton, 0, 2);
        gridPane.add(subtractButton, 1, 2);
        gridPane.add(multiplyButton, 2, 2);
        gridPane.add(divideButton, 3, 2);
        gridPane.add(resultLabel, 0, 3, 4, 1);

        // Set up the scene and show the stage
        Scene scene = new Scene(gridPane, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Calculator");
        primaryStage.show();
    }

    private void calculate(char operation) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result;
            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        resultLabel.setText("Error: Division by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    result = 0; // Default to zero for unrecognized operation
            }
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Invalid input");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
