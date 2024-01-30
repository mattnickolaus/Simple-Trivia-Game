/*
 * Filename: Controller.java
 * Short description: Handles all trivia game functionality through methods that implement actionListeners and draw
 *                  data from the model and view for displaying proper question data and responses to the user.
 * IST 242 Assignment: Team_9_PP
 * @author  Matthew Nickolaus
 * @version 11/14/2023
 */

/**
 * @author mattn
 * @version 1.0 11/14/2023
 */

package Controller;

import Model.Model;
import View.View;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller
{

    private Model model;
    private View view;
    private String answer;
    private int currentQuestion = 1;
    private int selectedTab = 0;
    private int score = 0;

    //Constructor
    public Controller(View v, Model m)
    {
        model = m;
        view = v;


        /*view.basicDisplay("Below is all our sample questions and answers loaded from a csv file and displayed in the console!!");
        for (int i = 0; i < model.getQuestionData().getQuestions().size(); i++){
            view.basicDisplay("------------------------------------------------------");
            view.basicDisplay(model.getQuestionData().getQuestions().get(i).getQuestionsText());
            view.basicDisplay(model.getQuestionData().getQuestions().get(i).getAllOptions());
        }*/

        // Method calls that add game functionality
        displayCurrentQuestion();
        getCategoryTab();
        getButtonsResponse();
        addSubmit();
        addNext();
    }

    /**
     * displayCurrentQuestion retrieves each component of the category panels and sets the text of each element based
     * upon data passed form the model. This data is based off the index of the question and a variable in which we will
     * use to track the current question throughout the game
     */
    private void displayCurrentQuestion() {
        // Sets question number and the actual question text
        view.getMf().getSpts().getqNumber().setText("Question " + currentQuestion + ":");
        view.getMf().getSpts().getQs().setText(model.getQuestionData().getQuestions().get(currentQuestion).getQuestionsText());
        // loops through and adds all text to the buttons
        for (int i = 0; i < 4; i++) {
            view.getMf().getSpts().getOptionBtns(i).setText(model.getQuestionData().getQuestions().get(currentQuestion).getOption(i));
        }

        // Does this for all the of the category panels
        view.getMf().getHst().getqNumber().setText("Question " + currentQuestion + ":");
        view.getMf().getHst().getQs().setText(model.getQuestionData().getQuestions().get(currentQuestion).getQuestionsText());
        for (int i = 0; i < 4; i++) {
            view.getMf().getHst().getOptionBtns(i).setText(model.getQuestionData().getQuestions().get(currentQuestion).getOption(i));
        }

        view.getMf().getMp().getqNumber().setText("Question " + currentQuestion + ":");
        view.getMf().getMp().getQs().setText(model.getQuestionData().getQuestions().get(currentQuestion).getQuestionsText());
        for (int i = 0; i < 4; i++) {
            view.getMf().getMp().getOptionBtns(i).setText(model.getQuestionData().getQuestions().get(currentQuestion).getOption(i));
        }

        view.getMf().getGp().getqNumber().setText("Question " + currentQuestion + ":");
        view.getMf().getGp().getQs().setText(model.getQuestionData().getQuestions().get(currentQuestion).getQuestionsText());
        for (int i = 0; i < 4; i++) {
            view.getMf().getGp().getOptionBtns(i).setText(model.getQuestionData().getQuestions().get(currentQuestion).getOption(i));
        }

    }

    /**
     *  The addNext method, gets the next buttons on each panel and adds an action listener. There is logic here based
     *  on which category the user is in and what question they are on in that category. If the user is not at the end
     *  of the category questions that it will increment the value of the current question by 1 and then used the
     *  displaycurrent question method. It will then use the three reset methods to reset the panel to a new question.
     *  If the user is at the end of the category and out of questions in it then it will run the endOfCategory method
     *  and display the scores to the user.
     */
    private void addNext() {
        ArrayList<JButton> nxts = new ArrayList<JButton>();
        nxts.add(view.getMf().getGp().getNext());
        nxts.add(view.getMf().getHst().getNext());
        nxts.add(view.getMf().getMp().getNext());
        nxts.add(view.getMf().getSpts().getNext());

        for (int i = 0; i < nxts.size(); i++) {
            JButton btn = nxts.get(i);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (selectedTab == 0 && currentQuestion < 5) {
                        currentQuestion++;
                        displayCurrentQuestion();
                        makeClickable();
                        resetButtons();
                        resetCorrect();
                        resetNext();
                    } else if (selectedTab == 1 && currentQuestion < 10) {
                        currentQuestion++;
                        displayCurrentQuestion();
                        makeClickable();
                        resetButtons();
                        resetCorrect();
                        resetNext();
                    } else if (selectedTab == 2 && currentQuestion < 15) {
                        currentQuestion++;
                        displayCurrentQuestion();
                        makeClickable();
                        resetButtons();
                        resetCorrect();
                        resetNext();
                    } else if (selectedTab == 3 && currentQuestion < 20) {
                        currentQuestion++;
                        displayCurrentQuestion();
                        makeClickable();
                        resetButtons();
                        resetCorrect();
                        resetNext();
                    } else {
                        endOfCategory();
                    }

                }
            });
        }
    }

    /**
     * The endOfCategory method allows us to display text after we have reached the end a categories question. This text
     * congratulates the user and shows their score for the category and encouraging them to select a new category to
     * continue the game. Afterwards it also resets the score to 0 so that it can be tracked moving to another category.
     */
    private void endOfCategory() {
        if (selectedTab == 0) {
            view.getMf().getSpts().getEnd().setText("Congratulations! Your score for the Sports category was " + score
                    + "/5 --- To continue please select a new tab to complete a new categroy of trivia!");
            view.getMf().getSpts().setInvisible();
            view.getMf().getSpts().getEnd().setVisible(true);
            score = 0;
        } else if (selectedTab == 1) {
            view.getMf().getHst().getEnd().setText("Congratulations! Your score for the History/Geography category was " + score
                    + "/5 --- To continue please select a new tab to complete a new categroy of trivia!");
            view.getMf().getHst().setInvisible();
            view.getMf().getHst().getEnd().setVisible(true);
            score = 0;
        } else if (selectedTab == 2){
            view.getMf().getMp().getEnd().setText("Congratulations! Your score for the TV/Movies category was " + score
                    + "/5 --- To continue please select a new tab to complete a new categroy of trivia!");
            view.getMf().getMp().setInvisible();
            view.getMf().getMp().getEnd().setVisible(true);
            score = 0;
        } else if (selectedTab == 3){
            view.getMf().getGp().getEnd().setText("Congratulations! Your score for the General Knowledge category was " + score
                    + "/5 --- To continue please select a new tab to complete a new categroy of trivia!");
            view.getMf().getGp().setInvisible();
            view.getMf().getGp().getEnd().setVisible(true);
            score = 0;
        }
    }

    /**
     * The addSubmit retrieves the submit buttons from each of the panels and creates an action listener on them so that
     * when clicked it runs the isCorrect method to check if the response.
     *
     * In addition, the radiobuttons are unenabled by a method makeNotClickable (to not get two responses) and then sets
     * the view so the next button appears.
     */
    private void addSubmit() {
        ArrayList<JButton> submits = new ArrayList<JButton>();
        submits.add(view.getMf().getGp().getSubmit());
        submits.add(view.getMf().getHst().getSubmit());
        submits.add(view.getMf().getMp().getSubmit());
        submits.add(view.getMf().getSpts().getSubmit());

        for (int i = 0; i < submits.size(); i++){
            JButton btn = submits.get(i);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    isCorrect();
                    makeNotClickable();
                    view.getMf().getGp().getNext().setVisible(true);
                    view.getMf().getHst().getNext().setVisible(true);
                    view.getMf().getMp().getNext().setVisible(true);
                    view.getMf().getSpts().getNext().setVisible(true);
                }
            });
        }
    }

    /**
     * makeNotClickable unenables each of the options buttons to prevent the user from reanswering the question
     */
    private void makeNotClickable() {
        for (int i = 0; i < 4; i++) {
            view.getMf().getSpts().getOptionBtns(i).setEnabled(false);
        }
        for (int i = 0; i < 4; i++) {
            view.getMf().getHst().getOptionBtns(i).setEnabled(false);
        }
        for (int i = 0; i < 4; i++) {
            view.getMf().getMp().getOptionBtns(i).setEnabled(false);
        }
        for (int i = 0; i < 4; i++) {
            view.getMf().getGp().getOptionBtns(i).setEnabled(false);
        }
    }

    /**
     * makeClickable reactivates the buttons and is used in the addNext method to do so when moving to the next question
     * in order to get a response from the user
     */
    private void makeClickable() {
        for (int i = 0; i < 4; i++) {
            view.getMf().getSpts().getOptionBtns(i).setEnabled(true);
        }
        for (int i = 0; i < 4; i++) {
            view.getMf().getHst().getOptionBtns(i).setEnabled(true);
        }
        for (int i = 0; i < 4; i++) {
            view.getMf().getMp().getOptionBtns(i).setEnabled(true);
        }
        for (int i = 0; i < 4; i++) {
            view.getMf().getGp().getOptionBtns(i).setEnabled(true);
        }
    }

    /**
     * These three reset methods are fairly self-explanatory. They reset the buttons so that they are don't have a
     * selected answer from the previous question, reset the "That's Correct" text so it does not still appear,
     * and resets the next button so it does not appear. These are all used in the addNext method for resetting the
     * new question.
     */
    private void resetCorrect() {
        view.getMf().getGp().getCorrect().setVisible(false);
        view.getMf().getHst().getCorrect().setVisible(false);
        view.getMf().getMp().getCorrect().setVisible(false);
        view.getMf().getSpts().getCorrect().setVisible(false);
        view.getMf().getGp().getCorrect().setText("That's Correct!");
        view.getMf().getHst().getCorrect().setText("That's Correct!");
        view.getMf().getMp().getCorrect().setText("That's Correct!");
        view.getMf().getSpts().getCorrect().setText("That's Correct!");
    }

    private void resetNext() {
        view.getMf().getGp().getNext().setVisible(false);
        view.getMf().getHst().getNext().setVisible(false);
        view.getMf().getMp().getNext().setVisible(false);
        view.getMf().getSpts().getNext().setVisible(false);
    }

    private void resetButtons() {
        ArrayList<JRadioButton> allButtons = new ArrayList<JRadioButton>();
        for (int i = 0; i < 4; i++) {
            allButtons.add(view.getMf().getSpts().getOptionBtns(i));
        }
        for (int i = 0; i < 4; i++) {
            allButtons.add(view.getMf().getHst().getOptionBtns(i));
        }
        for (int i = 0; i < 4; i++) {
            allButtons.add(view.getMf().getMp().getOptionBtns(i));
        }
        for (int i = 0; i < 4; i++) {
            allButtons.add(view.getMf().getGp().getOptionBtns(i));
        }
        // resets all buttons
        for (int h = 0; h < allButtons.size(); h++) {
            allButtons.get(h).setSelected(false);
        }
    }

    /**
     * This method uses an if statement to compare the value of the button string that we retrieved from ButtonResponse
     * earlier and compares it to the value from questionData that gets the correct answer of the current question.
     *
     * If the string values are equal the JLabel with the text "That Correct" appears or if it's not equal
     * "that's incorrect" appears. Also, it increments the score variable that stores the current score in a given
     * category.
     *
     * This method will then be used in the addSubmit method.
     */
    private void isCorrect() {
        resetCorrect();

        System.out.println("Answer: " + answer);
        System.out.println("Current Question: " + currentQuestion);
        // Gets the correct answer from the model using the index from current Question
        String correctAnswer = model.getQuestionData().getQuestions().get(currentQuestion).getCorrectAnswer();
        System.out.println("Correct Answer: " + correctAnswer);
        System.out.println("-----");

        // compares the strings from the selected answer and correct answer
        if (answer.equals(correctAnswer)) {
            view.getMf().getGp().getCorrect().setText("That's Correct!");
            view.getMf().getHst().getCorrect().setText("That's Correct!");
            view.getMf().getMp().getCorrect().setText("That's Correct!");
            view.getMf().getSpts().getCorrect().setText("That's Correct!");
            view.getMf().getGp().getCorrect().setVisible(true);
            view.getMf().getHst().getCorrect().setVisible(true);
            view.getMf().getMp().getCorrect().setVisible(true);
            view.getMf().getSpts().getCorrect().setVisible(true);

            // adds a point to score if correct
            score++;

        } else {
            view.getMf().getGp().getCorrect().setText("I'm sorry that's incorrect");
            view.getMf().getHst().getCorrect().setText("I'm sorry that's incorrect");
            view.getMf().getMp().getCorrect().setText("I'm sorry that's incorrect");
            view.getMf().getSpts().getCorrect().setText("I'm sorry that's incorrect");
            view.getMf().getGp().getCorrect().setVisible(true);
            view.getMf().getHst().getCorrect().setVisible(true);
            view.getMf().getMp().getCorrect().setVisible(true);
            view.getMf().getSpts().getCorrect().setVisible(true);
        }
    }

    /**
     * The resetCurrentQuestion method setups the logic that determines which question to display as the first
     * question of the category. The index of that will be passed to this method will come from the index of the tab
     * that is selected and will be created and used in the getCategoryTab method.
     *
     * @param i
     * @return
     */
    private int resetCurrentQuestion(int i) {
        switch (i) {
            case 0:
                return currentQuestion = 1;
            case 1:
                return currentQuestion = 6;
            case 2:
                return currentQuestion = 11;
            case 3:
                return currentQuestion = 16;
        }
        return 0;
    }

    /**
     * The getCategoryTab method accesses the tabbedpane from the view and adds a change listener which stores the
     * selectedTabIndex which we store in the variable, selectedTab, which allows us to update the currentQuestion
     * index to the first question in the indicated category.
     *
     * This last step is done is separate method called resetCurrentQuestion.
     *
     * In addition, the method also resets the question using the three reset methods above and the makeClickable to
     * reset the question elements for a new response. Also, to handle the score for the category we also just reset it
     * to 0.
     */
    private void getCategoryTab() {
        view.getMf().getTabbedPane().getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                selectedTab = view.getMf().getTabbedPane().getSelectedIndex();
                System.out.println("Current Tab Index: " + selectedTab);
                resetButtons();
                makeClickable();
                resetCorrect();
                resetNext();
                resetCurrentQuestion(selectedTab);
                displayCurrentQuestion();
                score = 0;
            }
        });
    }

    /**
     * This method retrieves all possible options from the view, puts them into an ArrayList and adds an actionListener
     * to each of them to find the user's selected answer to the question and pass it to the variable -  answer
     */
    private void getButtonsResponse() {
        ArrayList<JRadioButton> allOptions = new ArrayList<JRadioButton>();
        for (int i = 0; i < 4; i++) {
            allOptions.add(view.getMf().getSpts().getOptionBtns(i));
        }
        for (int i = 0; i < 4; i++) {
            allOptions.add(view.getMf().getHst().getOptionBtns(i));
        }
        for (int i = 0; i < 4; i++) {
            allOptions.add(view.getMf().getMp().getOptionBtns(i));
        }
        for (int i = 0; i < 4; i++) {
            allOptions.add(view.getMf().getGp().getOptionBtns(i));
        }

        for (int b = 0; b < allOptions.size(); b++){
            JRadioButton btn = allOptions.get(b);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JRadioButton button = (JRadioButton) e.getSource();
                    for (int h = 0; h < allOptions.size(); h++){
                        // makes sure all buttons are not selected
                        allOptions.get(h).setSelected(false);
                        if (allOptions.get(h) == button) {
                            answer = button.getText();
                            System.out.println("Selected Button: " + answer);
                        }
                    }
                    button.setSelected(true);
                }
            });
        }
    }


}
