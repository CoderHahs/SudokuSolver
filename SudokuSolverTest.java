// ////////////////////////////////////////////////////////
//
//                  SUDOKU SOLVER VIEW
//
// ////////////////////////////////////////////////////////

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

public class Solver1 extends Applet implements ActionListener
{
    Panel p_card;  //to hold all of the screens
    Panel card1, card2, card3, card4, card5; //the two screens
    CardLayout cdLayout = new CardLayout ();
    int row = 9;
    JButton grid[] = new JButton [row * row];
    //int board[] = new int [row * row];
    //115
    int board[] = {0, 0, 1, 3, 0, 0, 0, 5, 2,
	0, 8, 0, 0, 0, 0, 0, 7, 9,
	3, 0, 0, 0, 0, 2, 1, 0, 4,
	0, 0, 8, 4, 0, 0, 9, 6, 5,
	7, 4, 0, 0, 0, 0, 0, 1, 8,
	1, 6, 5, 0, 0, 8, 7, 0, 0,
	8, 0, 7, 2, 0, 0, 0, 0, 6,
	6, 2, 0, 0, 0, 0, 0, 3, 0,
	5, 9, 0, 0, 0, 1, 4, 0, 0};
    int cell;


    public void init ()
    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	screen1 ();
	screen2 ();
	//screen3 ();
	//screen4 ();
	//screen5 ();
	resize (515, 620);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    public void screen1 ()
    { //screen 1 is set up.
	card1 = new Panel ();
	card1.setBackground (Color.white);
	JLabel title = new JLabel ("Sudoku Solver");
	JButton next = new JButton ("Next");
	next.setActionCommand ("s2");
	next.addActionListener (this);
	card1.add (title);
	card1.add (next);
	p_card.add ("1", card1);
    }


    public void screen2 ()
    { //screen 2 is set up.
	card2 = new Panel ();

	JLabel title = new JLabel ("Select the cells that correspond to your sudoku puzzle");
	title.setFont (new Font ("Arial", Font.PLAIN, 20));

	Panel box1 = new Panel (new GridLayout (3, 3));
	Panel box2 = new Panel (new GridLayout (3, 3));
	Panel box3 = new Panel (new GridLayout (3, 3));
	Panel box4 = new Panel (new GridLayout (3, 3));
	Panel box5 = new Panel (new GridLayout (3, 3));
	Panel box6 = new Panel (new GridLayout (3, 3));
	Panel box7 = new Panel (new GridLayout (3, 3));
	Panel box8 = new Panel (new GridLayout (3, 3));
	Panel box9 = new Panel (new GridLayout (3, 3));

	for (int i = 0 ; i < grid.length ; i++)
	{
	    grid [i] = new JButton (" " + board [i]);
	    // board [i] = 0;
	    grid [i].setBackground (Color.white);
	    grid [i].setFont (new Font ("Arial", Font.PLAIN, 10));
	    grid [i].setPreferredSize (new Dimension (50, 50));
	    grid [i].addActionListener (this);
	    grid [i].setActionCommand ("" + i);
	    if (i <= 2 || i >= 9 && i <= 11 || i >= 18 && i <= 20)
		box1.add (grid [i]);
	    else if (i >= 3 && i <= 5 || i >= 12 && i <= 14 || i >= 21 && i <= 23)
		box2.add (grid [i]);
	    else if (i >= 6 && i <= 8 || i >= 15 && i <= 17 || i >= 24 && i <= 26)
		box3.add (grid [i]);
	    else if (i >= 27 && i <= 29 || i >= 36 && i <= 38 || i >= 45 && i <= 47)
		box4.add (grid [i]);
	    else if (i >= 30 && i <= 32 || i >= 39 && i <= 41 || i >= 48 && i <= 50)
		box5.add (grid [i]);
	    else if (i >= 33 && i <= 35 || i >= 42 && i <= 44 || i >= 51 && i <= 53)
		box6.add (grid [i]);
	    else if (i >= 54 && i <= 56 || i >= 63 && i <= 65 || i >= 72 && i <= 74)
		box7.add (grid [i]);
	    else if (i >= 57 && i <= 59 || i >= 66 && i <= 68 || i >= 75 && i <= 77)
		box8.add (grid [i]);
	    else
		box9.add (grid [i]);
	}

	JButton solve = new JButton ("Solution");
	solve.setActionCommand ("Solve");
	solve.addActionListener (this);
	JButton reset = new JButton ("Reset");
	reset.setActionCommand ("Reset");
	reset.addActionListener (this);
	JButton Erase = new JButton ("Erase");
	Erase.setActionCommand ("Erase");
	Erase.addActionListener (this);

	JLabel hl1 = new JLabel (createImageIcon ("Horizontal.jpg"));
	JLabel hl2 = new JLabel (createImageIcon ("Horizontal.jpg"));
	JLabel hl3 = new JLabel (createImageIcon ("Horizontal.jpg"));
	JLabel hl4 = new JLabel (createImageIcon ("Horizontal.jpg"));
	JLabel vl1 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl2 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl3 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl4 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl5 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl6 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl7 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl8 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl9 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl10 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl11 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl12 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl13 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl14 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl15 = new JLabel (createImageIcon ("Vertical.jpg"));
	JLabel vl16 = new JLabel (createImageIcon ("Vertical.jpg"));

	Panel row1 = new Panel ();
	Panel row2 = new Panel ();
	Panel row3 = new Panel ();
	card2.add (title);
	card2.add (hl1);
	row1.add (vl1);
	row1.add (box1);
	row1.add (vl2);
	row1.add (box2);
	row1.add (vl3);
	row1.add (box3);
	row1.add (vl4);
	card2.add (row1);
	card2.add (hl2);
	row2.add (vl5);
	row2.add (box4);
	row2.add (vl6);
	row2.add (box5);
	row2.add (vl7);
	row2.add (box6);
	row2.add (vl8);
	card2.add (row2);
	card2.add (hl3);
	row3.add (vl9);
	row3.add (box7);
	row3.add (vl10);
	row3.add (box8);
	row3.add (vl11);
	row3.add (box9);
	row3.add (vl12);
	card2.add (row3);
	card2.add (hl4);
	card2.add (Erase);
	card2.add (reset);
	card2.add (solve);
	p_card.add ("2", card2);
    }


    public void update ()
    {
	board [0] = 9;
	board [80] = 1;
	for (int i = 0 ; i < grid.length ; i++)
	{
	    grid [i].setText (" " + board [i]);
	}
    }


    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = Solver.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}
	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }


    int n = 0;
    int erase = 0;
    public void actionPerformed (ActionEvent e)
    { //moves between the screens

	/*if (n == 1)
	{
	    for (int i = 0 ; i < grid.length ; i++)
	    {
		if (e.getActionCommand ().equals ("" + i))
		{
		    if (erase == 0)
		    {
			cell = Integer.parseInt (e.getActionCommand ());
			input ();
		    }
		    else
		    {
			cell = Integer.parseInt (e.getActionCommand ());
			grid [cell].setText (null);
			board [cell] = 0;
			erase = 0;
		    }
		}
	    }
	}
	*/
	if (e.getActionCommand ().equals ("s1"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("s2"))
	{
	    n = 1;
	    cdLayout.show (p_card, "2");
	}
	else if (e.getActionCommand ().equals ("Reset"))
	{
	    for (int i = 0 ; i < grid.length ; i++)
	    {
		grid [i].setText (" ");
	    }
	}
	else if (e.getActionCommand ().equals ("Solve"))
	{
	    for (int i = 0 ; i < board.length ; i++)
	    {
		System.out.println (i + " " + board [i]);
	    }
	    //solve_puzzle ();
	    update ();
	}
	else if (e.getActionCommand ().equals ("Erase"))
	{
	    if (erase == 0)
	    {
		JOptionPane.showMessageDialog (null, "Click on the box to erase.", "Erase", JOptionPane.INFORMATION_MESSAGE);
		erase = 1;
	    }
	}
    }
}


