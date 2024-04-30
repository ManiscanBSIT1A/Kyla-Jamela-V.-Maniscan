import javafx.application.*;
import javafx.geometry.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import java.util.*;

public class GuessingGame extends Application {
    
    private int randomNumber;
    private int attempts;

    @Override
    public void start(Stage primaryStage) {
        // Generate a random number between 1 and 100
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
        attempts = 0;

        Label titleLabel = new Label("Guess the Number");
        Label instructionLabel = new Label("Guess a number between 1 and 100:");
        TextField guessTextField = new TextField();
        Button guessButton = new Button("Guess");
        Label resultLabel = new Label();

        // Event handler for the guess button
        guessButton.setOnAction(event -> {
            // Increment attempts count
            attempts++;

            // Get user's guess
            int guess = Integer.parseInt(guessTextField.getText());

            // Check if guess is correct
            if (guess == randomNumber) {
                resultLabel.setText("Congratulations! You guessed the number in " + attempts + " attempts.");
            } else {
                // Provide hint
                if (guess < randomNumber) {
                    resultLabel.setText("Try a higher number.");
                } else {
                    resultLabel.setText("Try a lower number.");
                }
            }
        });

        // Create layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titleLabel, instructionLabel, guessTextField, guessButton, resultLabel);

        // Set up the scene and show the stage
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Guess the Number");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
