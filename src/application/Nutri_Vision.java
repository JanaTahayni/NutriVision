package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Nutri_Vision extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml")); // Ensure the file name is correct

            // Create a Scene with the loaded FXML
            Scene scene = new Scene(root);

            primaryStage.setTitle("Nutri Vision System");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}