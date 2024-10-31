package application;

import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class WelcomeController {
    @FXML
    private ImageView logo;

    @FXML
    private Label welcome_label;

    @FXML
    private HBox signing; // Change this to match the fx:id in FXML

    @FXML
    public void initialize() {
        // Hide the label and HBox initially
        welcome_label.setOpacity(0);
        signing.setOpacity(0);
        
        // Start the logo scaling animation
        startLogoAnimation();
    }

    private void startLogoAnimation() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(2), logo);
        scaleTransition.setFromX(0.5);
        scaleTransition.setFromY(0.5);
        scaleTransition.setToX(1.0);
        scaleTransition.setToY(1.0);
        scaleTransition.setCycleCount(1);
        scaleTransition.setAutoReverse(false);

        // Start the animation for the logo
        scaleTransition.play();

        // After the logo animation finishes, start the text animation
        scaleTransition.setOnFinished(event -> {
            animateText(welcome_label, "Welcome to Nutri Vision System!", 100);
        });
    }

    private void animateText(Label label, String text, int delay) {
        label.setText(""); // Ensure the label is empty before starting the animation
        label.setOpacity(1); // Make label visible before typing animation starts
        
        Timeline timeline = new Timeline();
        for (int i = 0; i < text.length(); i++) {
            final int index = i;
            KeyFrame keyFrame = new KeyFrame(Duration.millis(delay * (i + 1)), e -> {
                label.setText(label.getText() + text.charAt(index)); // Append the character
            });
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.setOnFinished(event -> startButtonAnimation()); // Start button animation after text
        timeline.play();
    }

    private void startButtonAnimation() {
        // Set initial position of the HBox off-screen
        signing.setTranslateY(50); // Adjust this value to move it off-screen
        signing.setOpacity(0); // Make it invisible

        // Create and play the fly-in animation for the buttons
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), signing);
        translateTransition.setFromY(50); // Start position (off-screen)
        translateTransition.setToY(0); // End position (original position)
        translateTransition.setOnFinished(e -> signing.setOpacity(1)); // Make it visible after animation

        // Play the animation
        translateTransition.play();
    }
}