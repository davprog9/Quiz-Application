// David Arzumanyan
package com.example.vivoquiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class Controller {

    private Stage stage;
    private Scene scene;

    public Backend backend;

    @FXML
    private Label fx_label;

    @FXML
    private TextField fx_studentName;

    @FXML
    private TextField fx_studentId;

    @FXML
    private Label promptMessage;

    /**
     * Controller for scene1.fxml
     * @throws FileNotFoundException for file search
     * @author David Arzumanyan
     */
    public Controller() throws FileNotFoundException {
        this.backend = new Backend("src/main/resources/com/example/vivoquiz/QuizFile");
        this.backend.parse_questions();

    }

    /**
     * Method parses amount of questions from file
     * and sets the label for question amount to current amount of questions.
     * @author David Arzumanyan
     */
    @FXML
    private void initialize() {
        int amountOfQuestions = this.backend.amount_of_questions();
        fx_label.setText(amountOfQuestions + " questions");
    }


    /**
     * When the start button is being clicked`
     * Method first checks received inputs from user for name and id
     * if input meets expectations as for name (int,char) and for id (int) only,
     * the condition will be set true, and will be redirected to the next page.
     * @param event defines the event
     * @throws IOException for FXMLLoader
     * @author David Arzumanyan
     */
    @FXML
    public void onStartTestButton(ActionEvent event) throws IOException {
        // Declaring a condition for next page
        boolean condition = false;

        // Student name and ID check
        // Name can contain string + char + int
        // ID must contain digits only
        try{
            int nameCheck = Integer.parseInt(this.fx_studentName.getText());
            this.promptMessage.setVisible(true);
        }
        catch (NumberFormatException err){
            if (this.fx_studentName.getText().length() <= 2){
                this.promptMessage.setVisible(true);
            }
            else{
                //this.student.setName(fx_studentName.getText());
                this.promptMessage.setVisible(false);
                condition = true;
            }
        }

        try{
            int studentId = Integer.parseInt(this.fx_studentId.getText());
            //this.student.setId(studentId);
            if (condition){
                this.promptMessage.setVisible(false);
            }
        }
        catch (NumberFormatException err){
            this.promptMessage.setVisible(true);
            condition = false;
        }

        // If the condition is true, moving to next page
        if (condition){

            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("scene2.fxml")));
            this.stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            this.scene = new Scene(loader.load());
            String css = Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm();
            this.scene.getStylesheets().add(css);
            this.stage.setScene(this.scene);

            // Passing the name and id from text fields into Controller 2
            Controller2 controller2 = loader.getController();
            controller2.setName(this.fx_studentName.getText());
            controller2.setId(Integer.parseInt(this.fx_studentId.getText()));

            this.stage.show();
        }

    }

}