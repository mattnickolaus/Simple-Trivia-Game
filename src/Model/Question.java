/*
 * Filename: Question.java
 * Short description: The Question class sets of the foundation of the question object and its attributes that will be
 *                  be used in questionData.
 * IST 242 Assignment: Team_9_PP
 * @author  Matthew Nickolaus
 * @version 11/14/2023
 */

/**
 * @author mattn
 * @version 1.0 11/14/2023
 */

package Model;

import java.util.ArrayList;

public class Question implements QuestionMember {
    // Instance Variables -- define your private data
    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;
    private String category;

    // Constructors
    public Question() {
        // initialize default values
        this.questionText = "Default Question";
        this.option1 = "1";
        this.option2 = "2";
        this.option3 = "3";
        this.option4 = "4";
        this.correctAnswer = option1;
        this.category = "Default";
    }

    public Question(String questionText, String option1, String option2, String option3, String option4,
                    String correctAnswer, String category) {
        // pass in data to initialize variables{
        this.questionText = questionText;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
        this.category = category;
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable

    public String getQuestionText() {
        return questionText;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }


    public String getCategory() {
        return category;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    // Additional methods -- such as for calculation, display

    //getOption returns the value of the selected option based off of its index
    @Override
    public String getOption(int n) {
        switch (n) {
            case 0:
                return option1;
            case 1:
                return option2;
            case 2:
                return option3;
            case 3:
                return option4;
            default:
                return "invalid input parameter";
        }
    }

    //getAllOptions return an arrayList of strings of all the question options
    @Override
    public ArrayList<String> getAllOptions() {
    ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
        data.add(getOption(i));
    }
        return data;
    }

    //getQuestionText returns the value of the text of each question
    @Override
    public String getQuestionsText(){
        return questionText;
    }


    @Override
    public String getAttribute(int n) {
        switch (n) {
            case 0:
                return questionText;
            case 1:
                return option1;
            case 2:
                return option2;
            case 3:
                return option3;
            case 4:
                return option4;
            case 5:
                return correctAnswer;
            case 6:
                return category;
            default:
                return "invalid input parameter";
        }
    }



    @Override
    public ArrayList<String> getAttributes() {
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            data.add(getAttribute(i));
        }
        return data;
    }


    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}