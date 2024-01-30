/*
 * Filename: CenterPanel.java
 * Short description: The Sports category Panel that contains each of the same elements of the other category panels
 *                  including the question, all possible options, submit & next buttons, and labels for text pop-ups.
 *                  This is all put into a group layout in order to make the GUI more pleasing.
 * IST 242 Assignment: Team_9_PP
 * @author  Matthew Nickolaus
 * @version 11/28/2023
 */

/**
 * @author mattn
 * @version 1.0 11/28/2023
 */

package View;

import javax.swing.*;
import java.awt.*;

public class SportsPanel extends JPanel {
    // Instance Variables -- define your private data
    private JLabel qs;
    private JLabel qNumber;
    private JLabel spacer;
    private JRadioButton op1;
    private JRadioButton op2;
    private JRadioButton op3;
    private JRadioButton op4;
    private JButton submit;
    private JButton next;
    private JLabel correct;
    private JLabel end;
    private JPanel buttonsPanel;
    private Container panel;

    // Constructors
    public SportsPanel() {
        // initialize default values

        // initialize panel to use for the group layout
        panel = new Container();

        // initializes JLabels for the question
        qNumber = new JLabel("Question #:");
        qs = new JLabel("Where on earth is Waldo?");
        spacer = new JLabel(" ");

        // initializes a panel for buttons (for organization in the group layout)
        buttonsPanel = new JPanel();

        // initialize option buttons
        op1 = new JRadioButton("Option 1");
        op2 = new JRadioButton("Option 2");
        op3 = new JRadioButton("Option 3");
        op4 = new JRadioButton("Option 4");

        // adds buttons to the buttonPanel
        buttonsPanel.add(op1);
        buttonsPanel.add(op2);
        buttonsPanel.add(op3);
        buttonsPanel.add(op4);

        // initializes submit button
        submit = new JButton("Submit");

        // initializes correct label and sets it to not visible
        correct = new JLabel("That's Correct!");
        correct.setVisible(false);

        // initialize next buttons and sets it not visible
        next = new JButton("Next");
        next.setVisible(false);

        // initializes ending label and sets it not visible
        end = new JLabel("Congratulations! Your score for the Sports category was " + "0" + "/5 --- To continue " +
                "please select a new tab to complete a new categroy of trivia!");
        end.setVisible(false);


        /**
         * Creates the group layout and adds all the elements to the group layout twice by setting the horizontal and
         * vertical groupings
         */
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(qNumber)
                                .addComponent(qs)
                                .addComponent(spacer)
                                .addComponent(buttonsPanel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(submit)
                                .addComponent(correct)
                                .addComponent(next))
                        .addComponent(end)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(qNumber)
                        .addComponent(qs)
                        .addComponent(spacer)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(buttonsPanel))
                        .addComponent(submit)
                        .addComponent(correct)
                        .addComponent(next)
                        .addComponent(end)
        );
        add(panel);


    }

    /**
     * getOptionBtns method allows easier access to all buttons via a for loop used in the controller
     *
     * @param n
     * @return
     */
    public JRadioButton getOptionBtns(int n) {
        switch (n) {
            case 0:
                return op1;
            case 1:
                return op2;
            case 2:
                return op3;
            case 3:
                return op4;
            default:
                return null;
        }
    }

    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public JLabel getEnd() {
        return end;
    }
    public JLabel getqNumber() {
        return qNumber;
    }
    public JLabel getQs() {
        return qs;
    }
    public JRadioButton getOp1() {
        return op1;
    }
    public JRadioButton getOp2() {
        return op2;
    }
    public JRadioButton getOp3() {
        return op3;
    }
    public JRadioButton getOp4() {
        return op4;
    }
    public JButton getSubmit() {
        return submit;
    }
    public JButton getNext() {
        return next;
    }
    public Container getPanel() {
        return panel;
    }
    public JLabel getCorrect() {
        return correct;
    }

    /**
     * Method used to set all the values to not visible used in the controller for the end score screen
     */
    public void setInvisible() {
        qs.setVisible(false);
        qNumber.setVisible(false);
        op1.setVisible(false);
        op2.setVisible(false);
        op3.setVisible(false);
        op4.setVisible(false);
        submit.setVisible(false);
        next.setVisible(false);
        correct.setVisible(false);
    }


}
