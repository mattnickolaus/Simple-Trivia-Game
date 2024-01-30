/*
 * Filename: App.java
 * Short description: App class with the main method, creating the model, view, controller and passes the model and
 *                   view for the controller class to have access and output.
 * IST 242 Assignment: Team_9_PP
 * @author  Matthew Nickolaus
 * @version 11/14/2023
 */

import Controller.Controller;
import Model.Model;
import View.View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    //defines main application method

    public static void main(String[] args) {
        //declare variables

        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(view, model);

    }
}

