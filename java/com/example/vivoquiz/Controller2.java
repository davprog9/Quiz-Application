// David Arzumanyan
package com.example.vivoquiz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class Controller2 {

    private int counter;

    private final Backend backend;

    private String name;

    private int id;

    private int correctAnswers;

    private int wrongAnswers;

    private Stage stage;

    private Scene scene;

    private Parent root;

    @FXML
    private Label myQuestion;

    @FXML
    private RadioButton fx_option1, fx_option2, fx_option3, fx_option4;

    @FXML
    private Label promptMessage;



    /**
     * Default/Main constructor
     * @throws FileNotFoundException throws if file not found.
     * @author David Arzumanyan
     */
    public Controller2() throws FileNotFoundException {
        // Initializing the backend, providing path and parsing all questions.
        this.backend = new Backend("src/main/resources/com/example/vivoquiz/QuizFile");
        backend.parse_questions();

        this.counter = 0;
        this.correctAnswers = 0;
        this.wrongAnswers = 0;
    }

    /**
     * initialize() method comes from the interface,
     * and is used by the JavaFX runtime to initialize the controller when it is created in the call to FXMLLoader. load()
     * from the preceding Application class.
     * <p>
     * In current case, we set texts for all labels of JavaFX,
     * so when the window is opened we have all fields ready.
     * @author David Arzumanyan
     */
    @FXML
    private void initialize(){
        this.myQuestion.setText(this.backend.getQuestions_list().get(this.counter).getQuestion());
        this.fx_option1.setText(this.backend.getQuestions_list().get(this.counter).getOption1());
        this.fx_option2.setText(this.backend.getQuestions_list().get(this.counter).getOption2());
        this.fx_option3.setText(this.backend.getQuestions_list().get(this.counter).getOption3());
        this.fx_option4.setText(this.backend.getQuestions_list().get(this.counter).getOption4());
    }

    /**
     * Setter for name
     * @param name defines the new name for student
     * @author David Arzumanyan
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for id
     * @param id defines the new id for student
     * @author David Arzumanyan
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * onSubmit() method is set on Submit FXML button.
     * When submitting, method checks which radio button is checked.
     * After checking it, compares the radio button answer with the actual question answer.
     * @author David Arzumanyan
     */
    @FXML
    public void onSubmit() throws IOException {

        // If option 1 is selected then check the correct answer
        // if user selected option matches with the answer from backend file
        // then +1 to correct answers, otherwise +1 to wrong answers
        if (fx_option1.isSelected()) {
            String userChoice = fx_option1.getText();

            String answer = this.backend.getQuestions_list().get(this.counter).getCorrect_answer();

            if (userChoice.equals(answer)){
                this.correctAnswers += 1;
            }
            else{
                this.wrongAnswers += 1;
            }
        }

        else if (fx_option2.isSelected()) {
            String userChoice = fx_option2.getText();

            String answer = this.backend.getQuestions_list().get(this.counter).getCorrect_answer();

            if (userChoice.equals(answer)){
                this.correctAnswers += 1;
            }
            else{
                this.wrongAnswers += 1;
            }
        }

        else if (fx_option3.isSelected()) {
            String userChoice = fx_option3.getText();

            String answer = this.backend.getQuestions_list().get(this.counter).getCorrect_answer();

            if (userChoice.equals(answer)){
                this.correctAnswers += 1;
            }
            else{
                this.wrongAnswers += 1;
            }
        }

        else if (fx_option4.isSelected()) {
            String userChoice = fx_option4.getText();

            String answer = this.backend.getQuestions_list().get(this.counter).getCorrect_answer();

            if (userChoice.equals(answer)){
                this.correctAnswers += 1;
            }
            else{
                this.wrongAnswers += 1;
            }
        }

        int lastQuestionIndex = this.backend.getQuestions_list().size(); // Getting the last question's index from list of questions

        // Below statement is only for the last question
        // There are few conditions in the below if statement
        // First it checks if the last question is the last question in the list of questions.
        if (this.myQuestion.getText().equals(this.backend.getQuestions_list().get(lastQuestionIndex - 1).getQuestion())){

            // Second, it verifies that at least one of options is selected and only then clicked on submit button.
            // If not selected and clicked the Submit button, then show the prompt message.
            if (!this.fx_option1.isSelected() || !this.fx_option2.isSelected() || !this.fx_option3.isSelected() || !this.fx_option4.isSelected()) {
                this.promptMessage.setVisible(true);

                // In case if once submitted without choosing an option
                // Below statement allows the user to choose an option after the above statement.
                if (this.fx_option1.isSelected() || this.fx_option2.isSelected() || this.fx_option3.isSelected() || this.fx_option4.isSelected()){
                    this.promptMessage.setVisible(false);

                    // Moving to results page.
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("scene3.fxml"));
                    this.root = loader.load();

                    // Loading the controller for result page scene.
                    // And passing the name, id, correctAnswers and wrong answers into controller3
                    Controller3 controller3 = loader.getController();
                    controller3.labelInitializers(this.name, this.id, this.correctAnswers, this.wrongAnswers);

                    this.stage = (Stage) this.myQuestion.getScene().getWindow();
                    this.scene = new Scene(root);
                    String css = Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm();
                    this.scene.getStylesheets().add(css);
                    this.stage.setScene(this.scene);
                    this.stage.show();
                }
            }
        }
        // If not the last question, below statement checks that at least on option is chosen.
        else{
            if (!this.fx_option1.isSelected() || !this.fx_option2.isSelected() || !this.fx_option3.isSelected() || !this.fx_option4.isSelected()){
                this.promptMessage.setVisible(true);

                // If an option is selected, increment the counter.
                // Disable the selected radio button for the next questions.
                // Call changeQuestionObject() method
                if (this.fx_option1.isSelected() || this.fx_option2.isSelected() || this.fx_option3.isSelected() || this.fx_option4.isSelected()){
                    this.promptMessage.setVisible(false);
                    this.counter += 1;

                    this.fx_option1.setSelected(false);
                    this.fx_option2.setSelected(false);
                    this.fx_option3.setSelected(false);
                    this.fx_option4.setSelected(false);
                    changeQuestionObject();
                }
            }
        }
    }

    /**
     * Method changes all FXML fields texts with next
     * questions infos. Such as option1, option2, option3, option4 and answer.
     * @author David Arzumanyan
     */
    public void changeQuestionObject() throws IOException {

        String nextQuestion = this.backend.getQuestions_list().get(this.counter).getQuestion();
        this.myQuestion.setText(nextQuestion);

        String nextOption1 = this.backend.getQuestions_list().get(this.counter).getOption1();
        this.fx_option1.setText(nextOption1);

        String nextOption2 = this.backend.getQuestions_list().get(this.counter).getOption2();
        this.fx_option2.setText(nextOption2);

        String nextOption3 = this.backend.getQuestions_list().get(this.counter).getOption3();
        this.fx_option3.setText(nextOption3);

        String nextOption4 = this.backend.getQuestions_list().get(this.counter).getOption4();
        this.fx_option4.setText(nextOption4);

    }
}
