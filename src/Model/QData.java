/*
 * Filename: TableData.java
 * Short description: The QData interface enables the QData class to run the loadData function that loads the data from
 *                  the CSV file into an ArrayList
 * IST 242 Assignment: Team_9_PP
 * @author  Matthew Nickolaus
 * @version 11/14/2023
 */

/**
 * @author mattn
 * @version 1.0 11/14/2023
 */

package Model;

public interface QData {

    // loadData runs the readQuestionFromCSV method to load the question data into an arrayList of Questions
    public void loadData();


}
