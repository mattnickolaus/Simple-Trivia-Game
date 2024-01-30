/*
 * Filename: View.java
 * Short description: View class creates the updated basicDisplay method that are overloaded for use in controller, as
 *                  well as the new linesDisplay method that will display each line of data from an ArrayList of
 *                  an ArrayList. Now it also creates the Main Frame and creates its sets and get methods for call in
 *                  controller.
 * IST 242 Assignment: Team_9_PP
 * @author  Matthew Nickolaus
 * @version 11/14/2023
 */

/**
 * @author mattn
 * @version 1.0 11/14/2023
 */

package View;

import java.util.ArrayList;

public class View {
    // Instance Variables -- define private data
    private MainFrame mf;

    public View() {
        // initialize default values
        mf = new MainFrame();
    }

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public MainFrame getMf() {
        return mf;
    }



    //Displays the single strings (from previous iteration)
    public void basicDisplay (String s){
        System.out.println(s);

    }

    //Overloaded basicDisplay that receives the ArrayList and displays each String with a space (in the same line)
    // and finally going to a new line once we have gone through the whole arrayList
    public void basicDisplay(ArrayList<String> arr){
        for (String s: arr){
            System.out.print(s + " ");
        }
        System.out.println();
    }

    //This is the new method that will display each line of data from an ArrayList of an ArrayList
    // and in this case that is lines of the FootballPlayer objects data
    public void linesDisplay(ArrayList<ArrayList<String>> arrOfarr){
        for (ArrayList<String> a: arrOfarr) {
            basicDisplay(a);
        }
    }

}
