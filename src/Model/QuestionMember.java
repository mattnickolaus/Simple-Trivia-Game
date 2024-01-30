/*
 * Filename: QuestionMember.java
 * Short description: The QuestionMember interface enables the use of the following methods that add functionality to
 *                  the question class for retrieval of data in the future from the aspects of the question object
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


public interface QuestionMember {

    //getAttribute returns the value of selected attribute of a class.
    //The attribute is returned as a String independently of its original type.
    public String getAttribute(int n);

    //getQuestionText returns the value of the text of each question
    public String getQuestionsText();

    //getOption returns the value of the selected option based off of its index
    public String getOption(int n);

    //getAllOptions return an arrayList of strings of all the question options
    public ArrayList<String> getAllOptions();

    //getAttributes returns the value of all attributes of a class.
    //The attributes are returned as a String ArrayList.
    public ArrayList<String> getAttributes();

    // getCorrectAnswer returns the string value of the correct quesiton
    public String getCorrectAnswer();
}
