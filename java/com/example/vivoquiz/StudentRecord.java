// David Arzumanyan
package com.example.vivoquiz;

public class StudentRecord{

    private String name;
    private int id;
    private int correct_answers;
    private int wrong_answers;


    /**
     * Default constructor
     * @author David Arzumanyan
     */
    public StudentRecord(){
        this.name = "N/A";
        this.id = -1;
        this.correct_answers = 0;
        this.wrong_answers = 0;

    }

    /**
     * Setter for student name
     * @param name defines the name of the student
     * @author David Arzumanyan
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for student id
     * @param id defines the new id
     * @author David Arzumanyan
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter for correct answer
     * @param correct_answers defines the amount of correct answers
     * @author David Arzumanyan
     */
    public void setCorrect_answers(int correct_answers) {
        this.correct_answers = correct_answers;
    }

    /**
     * Setter for wrong answer
     * @param wrong_answers defines the amount of wrong answers
     * @author David Arzumanyan
     */
    public void setWrong_answers(int wrong_answers) {
        this.wrong_answers = wrong_answers;
    }

    /**
     * Getter for student name
     * @return Returns data type String
     * @author David Arzumanyan
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for id
     * @return Returns data type integer
     * @author David Arzumanyan
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for correct asnwers
     * @return Returns data type integer
     * @author David Arzumanyan
     */
    public int getCorrect_answers() {
        return correct_answers;
    }

    /**
     * Getter for wrong answers
     * @return Returns data type Integer
     * @author David Arzumanyan
     */
    public int getWrong_answers() {
        return wrong_answers;
    }

}
