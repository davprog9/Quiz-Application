// David Arzumanyan
package com.example.vivoquiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Backend {

    private final Scanner scanner;
    private ArrayList<Question> questions_list;


    /**
     * Constructor
     * @author David Arzumanyan
     */
    public Backend(String pathname) throws FileNotFoundException {
        File qa_file = new File(pathname);
        this.scanner = new Scanner(qa_file);
        this.questions_list = new ArrayList<Question>();

        }

    /**
     * Getter for questions list
     * @return Returns data type
     * @author David Arzumanyan
     */
    public ArrayList<Question> getQuestions_list() {
        return questions_list;
    }

    /**
     * Method parses questions from file into objects
     * and adds those objects into question list
     * @author David Arzumanyan
     */
    public void parse_questions(){

        while(this.scanner.hasNextLine()){
            String question = "";
            String option1 = "";
            String option2 = "";
            String option3 = "";
            String option4 = "";
            String correct_answer = "";

            question += this.scanner.nextLine();
            option1 += this.scanner.nextLine();
            option2 += this.scanner.nextLine();
            option3 += this.scanner.nextLine();
            option4 += this.scanner.nextLine();
            correct_answer += this.scanner.nextLine();

            Question new_question = new Question(question, option1, option2, option3, option4, correct_answer);
            this.questions_list.add(new_question);

        }

    }

    /**
     * Returns amount of question from questions list
     * @return Returns data type integer
     * @author David Arzumanyan
     */
    public int amount_of_questions(){
        return this.questions_list.size();
    }
}
