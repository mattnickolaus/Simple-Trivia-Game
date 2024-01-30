/*
 * Filename: MainFrame.java
 * Short description: The Main Frame sets up the category panel, puts them into a tabbedpane, and sets the basic GUI
 *                   values and operations.
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
import java.util.ArrayList;

public class MainFrame extends JFrame {
    // Instance Variables -- define your private data

    private SportsPanel spts;
    private HistoryPanel hst;
    private MoviesPanel mp;
    private GeneralPanel gp;
    private JTabbedPane tabbedPane;


    // Constructors
    public MainFrame() {
        super("Team 9 Project- IST 242");
        // initialize default values

        // initializes all 4 panesl
        spts = new SportsPanel();
        add(spts);
        hst = new HistoryPanel();
        add(hst);
        mp = new MoviesPanel();
        add(mp);
        gp = new GeneralPanel();
        add(gp);

        // Initializes and adds the tabbedPane
        tabbedPane = new JTabbedPane();
        add(tabbedPane);

        // set up the JFrame for visibility
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 480);
        setVisible(true);


        // Uses temporary card panels to add to the tabbedPane
        JPanel card1 = new JPanel();
        card1.add(getSpts().getPanel());

        JPanel card2 = new JPanel();
        card2.add(getHst().getPanel());

        JPanel card3 = new JPanel();
        card3.add(getMp().getPanel());

        JPanel card4 = new JPanel();
        card4.add(getGp().getPanel());



        // Adds Panels to the tabbedPane
        tabbedPane.addTab("Sports", card1);
        tabbedPane.addTab("History/Geography", card2);
        tabbedPane.addTab("TV/Movies", card3);
        tabbedPane.addTab("General Knowledge", card4);


        validate();
        repaint();
    }


    // Get methods - one get method for each instance variable defined above
    //             - purpose is to return the value stored in the private variable
    public SportsPanel getSpts() {
        return spts;
    }

    public HistoryPanel getHst() {
        return hst;
    }

    public MoviesPanel getMp() {
        return mp;
    }

    public GeneralPanel getGp() {
        return gp;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }


}
