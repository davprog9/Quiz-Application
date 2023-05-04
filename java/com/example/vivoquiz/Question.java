// David Arzumanyan
package com.example.vivoquiz;

public class Question {

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correct_answer;

    /**
     * Default constructor
     * @author David Arzumanyan
     */
    public Question(){
        this.question = "N/A";
        this.option1 = "N/A";
        this.option2 = "N/A";
        this.option3 = "N/A";
        this.option4 = "N/A";
        this.correct_answer = "N/A";
    }

    /**
     * Main constructor with following parameters`
     * @param question defines the question
     * @param option1 defines first option for question's answer
     * @param option2 defines second option for question's answer
     * @param option3 defines third option for question's answer
     * @param option4 defines forth option for question's answer
     * @param correct_answer defines the correct answer for the question
     * @author David Arzumanyan
     */
    public Question(String question, String option1, String option2, String option3, String option4, String correct_answer){
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correct_answer = correct_answer;
    }

    /**
     * Getter for question
     * @return Returns data type String
     * @author David Arzumanyan
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Setter for question
     * @param question defines the question to be changed
     * @author David Arzumanyan
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Getter for option1
     * @return Returns data type String
     * @author David Arzumanyan
     */
    public String getOption1() {
        return option1;
    }

    /**
     * Setter for option1
     * @param option1 defines the option1 to be changed
     * @author David Arzumanyan
     */
    public void setOption1(String option1) {
        this.option1 = option1;
    }

    /**
     * Getter for option2
     * @return Returns data type String
     * @author David Arzumanyan
     */
    public String getOption2() {
        return option2;
    }

    /**
     * Setter for option2
     * @param option2 defines the option2 to be changed
     * @author David Arzumanyan
     */
    public void setOption2(String option2) {
        this.option2 = option2;
    }

    /**
     * Getter for option3
     * @return Returns data type String
     * @author David Arzumanyan
     */
    public String getOption3() {
        return option3;
    }

    /**
     * Setter for option3
     * @param option3 defines the option3 to be changed
     * @author David Arzumanyan
     */
    public void setOption3(String option3) {
        this.option3 = option3;
    }

    /**
     * Getter for option4
     * @return Returns data type String
     * @author David Arzumanyan
     */
    public String getOption4() {
        return option4;
    }

    /**
     * Setter for option4
     * @param option4 defines the option4 to be changed
     * @author David Arzumanyan
     */
    public void setOption4(String option4) {
        this.option4 = option4;
    }

    /**
     * Getter for correct answer
     * @return Returns data type String
     * @author David Arzumanyan
     */
    public String getCorrect_answer() {
        return correct_answer;
    }

    /**
     * Setter for correct answer
     * @param correct_answer defines the correct answer to be changed
     * @author David Arzumanyan
     */
    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    /**
     * Method checks whether the user chosen option was the correct answer
     * @param option defines the option chosen by user
     * @return Returns data type boolean
     * @author David Arzumanyan
     */
    public boolean check_for_correct_answer(String option){
        return this.correct_answer.equals(option);
    }
}
