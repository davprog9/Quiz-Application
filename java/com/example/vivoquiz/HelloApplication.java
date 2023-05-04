// David Arzumanyan
package com.example.vivoquiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("scene1.fxml")));
        Scene scene1 = new Scene(root);

        // Adding css file
        String css = getClass().getResource("style.css").toExternalForm();
        scene1.getStylesheets().add(css);

        stage.setTitle("VivoQuiz");
        stage.setScene(scene1);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}