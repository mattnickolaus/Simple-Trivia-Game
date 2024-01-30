/*
 * Filename: QuestionData.java
 * Short description: QuestionData loads that data form CSV file and add it as an arrayList of question to be accessed
 *                  by the model (for the controller) and to be retrieved for display in the GUI
 * IST 242 Assignment: Team_9_PP
 * @author  Matthew Nickolaus
 * @version 11/14/2023
 */

/**
 * @author mattn
 * @version 1.0 11/14/2023
 */

package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionData implements QData {
    // Instance Variables -- define your private data
    private ArrayList<QuestionMember> questions;


    // Constructors
    public QuestionData() {
        // initialize default values
        questions = new ArrayList<>();

        // runs loadData method from QData
        loadData();
    }


    // runs readQuestionFromSCSV
    public void loadData(){
        readQuestionFromCSV();
    }

    /**
     * readQuestionFromCSV get the data from the CSV file by with a file reader that goes line by line and stores that
     * data into a new question by separating the line which a comma is read in the text file.
     *
     * The question is then added into the ArrayList of question members for access from the model
     */
    private void readQuestionFromCSV() {
        String file = "src/questions.csv";
        BufferedReader reader = null;
        String line = "";


        try{
            reader = new BufferedReader(new FileReader(file));



            while ((line = reader.readLine()) != null){
                String[] values = line.split(",");
                Question qs = new Question();
                qs.setQuestionText(values[0]);
                qs.setOption1(values[1]);
                qs.setOption2(values[2]);
                qs.setOption3(values[3]);
                qs.setOption4(values[4]);
                qs.setCorrectAnswer(values[5]);
                qs.setCategory(values[6]);
                questions.add(qs);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public ArrayList<QuestionMember> getQuestions() {
        return questions;
    }





}
