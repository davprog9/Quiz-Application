// David Arzumanyan
package com.example.vivoquiz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller3 {

    private StudentRecord student;
    @FXML
    private Label fx_studentName;

    @FXML
    private Label fx_studentID;

    @FXML
    private Label fx_studentScore;

    @FXML
    private Label fx_correctAnswers;

    @FXML
    private Label fx_wrongAnswers;

    public Controller3(){
        this.student = new StudentRecord();
    }

    /**
     * Method declares and initializes new StudentRecord object which contains student info.
     * Method sets texts for labels which contain results of the quiz
     * @param name defines the name of the student
     * @param id defines the id of the student
     * @param correctAnswers defines the amount of correct answers of student
     * @param wrongAnswers defines the amount of correct wrong of student
     * @author David Arzumanyan
     */
    public void labelInitializers(String name, int id, int correctAnswers, int wrongAnswers){
        this.student.setName(name);
        this.student.setId(id);
        this.student.setCorrect_answers(correctAnswers);
        this.student.setWrong_answers(wrongAnswers);

        this.fx_studentName.setText("Student name :   " + this.student.getName());
        this.fx_studentID.setText("Student ID:   " + this.student.getId());
        this.fx_studentScore.setText("Total score:   " + ((student.getCorrect_answers() + student.getWrong_answers()) - student.getWrong_answers()));
        this.fx_correctAnswers.setText("Correct answers:   " + student.getCorrect_answers());
        this.fx_wrongAnswers.setText("Wrong answers:   " + student.getWrong_answers());

    }
}
