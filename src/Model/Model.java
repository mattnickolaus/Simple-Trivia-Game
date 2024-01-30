/*
 * Filename: Model.java
 * Short description:  This is a more generic model class that has delegated more of its functions to questionData to
 *                  load and create questions.
 * IST 242 Assignment: Team_9_PP
 * @author  Matthew Nickolaus
 * @version 11/14/2023
 */

/**
 * @author mattn
 * @version 1.0 11/14/2023
 */

package Model;

public class Model {
    // Instance Variables
    private QuestionData questionData;

    public Model(){
        // Initialize variables
        questionData = new QuestionData();
    }

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable

    public QuestionData getQuestionData(){
        return questionData;
    }

    // Set methods - one set method for each instance variable defined above
    //             - purpose is to pass in a value stored in the private variable
    public void setQuestionData(QuestionData questionData){
        this.questionData = questionData;
    }

}
