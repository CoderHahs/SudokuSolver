// ////////////////////////////////////////////////////////
//
//                      SUDOKU SOLVER
//
// ////////////////////////////////////////////////////////

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

public class Sudoku_Solver extends Applet implements ActionListener
{
    Panel p_card;  //to hold all of the screens
    Panel card1, card2, card3, card4, card5; //the two screens
    CardLayout cdLayout = new CardLayout ();
    int row = 9;
    JButton grid[] = new JButton [row * row];

    //115
    // int board_115[] = {0, 0, 1, 3, 0, 0, 0, 5, 2,
    //     0, 8, 0, 0, 0, 0, 0, 7, 9,
    //     3, 0, 0, 0, 0, 2, 1, 0, 4,
    //     0, 0, 8, 4, 0, 0, 9, 6, 5,
    //     7, 4, 0, 0, 0, 0, 0, 1, 8,
    //     1, 6, 5, 0, 0, 8, 7, 0, 0,
    //     8, 0, 7, 2, 0, 0, 0, 0, 6,
    //     6, 2, 0, 0, 0, 0, 0, 3, 0,
    //     5, 9, 0, 0, 0, 1, 4, 0, 0};

    //184
    int board_184[] = {2, 0, 0, 0, 1, 8, 0, 5, 0,
	0, 0, 0, 7, 0, 9, 0, 1, 0,
	8, 0, 0, 0, 5, 0, 0, 0, 3,
	5, 2, 6, 0, 0, 7, 0, 3, 0,
	0, 0, 3, 0, 0, 0, 8, 0, 0,
	0, 8, 0, 9, 0, 0, 6, 4, 5,
	7, 0, 0, 0, 8, 0, 0, 0, 4,
	0, 4, 0, 5, 0, 3, 0, 0, 0,
	0, 5, 0, 4, 9, 0, 0, 0, 7};

    int original_board[] = new int [81];

    //copy_board
    int board[] = new int [81];

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
	JButton next = new JButton (createImageIcon ("Sudoku Solver Main Screen.jpg"));
	next.setPreferredSize (new Dimension (515, 620));
	next.setActionCommand ("s2");
	next.addActionListener (this);
	card1.add (next);
	p_card.add ("1", card1);
    }


    public void screen2 ()
    { //screen 2 is set up.
	card2 = new Panel ();

	JLabel title = new JLabel ("Click on the cells to enter the numbers");
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
	    grid [i] = new JButton (" ");
	    // board [i] = 0;
	    grid [i].setBackground (Color.white);
	    grid [i].setFont (new Font ("Arial", Font.PLAIN, 15));
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


    public void screen3 ()
    { //screen 3 is set up.
	card3 = new Panel ();
	card3.setBackground (Color.green);
	JLabel title = new JLabel ("Icon.");
	JButton next = new JButton ("Next");
	next.setActionCommand ("s4");
	next.addActionListener (this);
	card3.add (title);
	card3.add (next);
	p_card.add ("3", card3);
    }


    public void screen4 ()
    { //screen 4 is set up.
	card4 = new Panel ();
	card4.setBackground (Color.yellow);
	JLabel title = new JLabel ("Icon who?");
	JButton next = new JButton ("Next");
	next.setActionCommand ("s5");
	next.addActionListener (this);
	card4.add (title);
	card4.add (next);
	p_card.add ("4", card4);
    }


    public void screen5 ()
    { //screen 5 is set up.
	card5 = new Panel ();
	card5.setBackground (Color.cyan);
	JLabel title = new JLabel ("Icon tell you another");
	JLabel title2 = new JLabel ("knock knock joke.");
	JLabel title3 = new JLabel ("Do you want me to?");
	JButton next = new JButton ("Yes");
	next.setActionCommand ("s1");
	next.addActionListener (this);
	card5.add (title);
	card5.add (title2);
	card5.add (title3);
	card5.add (next);
	p_card.add ("5", card5);
    }


    int n = 0;
    int erase = 0;
    public void actionPerformed (ActionEvent e)
    { //moves between the screens

	if (n == 1)
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
			// made change board -> original_board
			original_board [cell] = 0;
			erase = 0;
		    }
		}
	    }
	}

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
	    int answer = JOptionPane.showConfirmDialog (null, "Ready to solve the puzzle?", "Ready", JOptionPane.YES_NO_OPTION);
	    if (answer == 1)
	    {
		cdLayout.show (p_card, "2");
	    }
	    else
	    {
		copy_array (original_board, board);
		// for (int i = 0 ; i < board.length ; i++)
		// {
		//     System.out.println (i + ": " + board [i]);
		// }
		puzzle_solver ();
	    }
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


    String numinput;
    boolean valid;
    public void input ()
    {
	numinput = JOptionPane.showInputDialog ("Please enter the number found at this location \nin your sudoku puzzle: ");
	if (numinput == null || numinput.equals (""))
	    cdLayout.show (p_card, "2");
	else
	{
	    valid = isValid (numinput);
	    while (valid == false)
	    {
		numinput = JOptionPane.showInputDialog ("You must enter a number between 1 and 9.\nPlease enter the number found at this location \nin your sudoku puzzle: ");
		if (numinput == null || numinput.equals (""))
		{
		    cdLayout.show (p_card, "2");
		    valid = true;
		}
		else
		    valid = isValid (numinput);
	    }
	    if (numinput == null || numinput.equals (""))
		cdLayout.show (p_card, "2");
	    else
	    {
		// made change board -> original_board
		original_board [cell] = Integer.parseInt (numinput);
		grid [cell].setText ("" + numinput);
		grid [cell].setFont (new Font ("Arial", Font.BOLD, 18));
	    }
	}

    }


    public boolean isValid (String input)
    {
	if (input.equals ("1") || input.equals ("2") || input.equals ("3") || input.equals ("4") || input.equals ("5") || input.equals ("6") || input.equals ("7") || input.equals ("8") || input.equals ("9"))
	    return true;
	else
	    return false;
    }


    // copies contents from one array to another
    public void copy_array (int[] orig, int[] copy)
    {
	if (orig.length == copy.length)
	{
	    for (int i = 0 ; i < orig.length ; i++)
	    {
		copy [i] = orig [i];
	    }
	}
    }


    // updates board with value at pos
    public void update_board (int pos, int value)
    {
	board [pos] = value;
	//System.out.println ("-----------------------------------");
	//System.out.println ("update " + pos + " with " + value);
	grid [pos].setText (" " + value);
	//System.out.println ("-----------------------------------");
    }


    // checks if number is in row
    public boolean check_row (int cell, int value)
    {
	int row_num = cell / 9;
	int start_pos = row_num * 9;
	int end_pos = start_pos + 8;
	boolean value_not_in_row = true;

	for (int pos = start_pos ; pos <= end_pos ; pos++)
	{
	    if (board [pos] == value)
		value_not_in_row = false;
	}


	return value_not_in_row;
    }


    // checks if number is in column
    public boolean check_col (int cell, int value)
    {
	int col_num = cell % 9;
	int start_pos = col_num;
	int end_pos = start_pos + 72;
	boolean value_not_in_col = true;

	for (int pos = start_pos ; pos <= end_pos ; pos = pos + 9)
	{
	    if (board [pos] == value)
		value_not_in_col = false;
	}


	return value_not_in_col;
    }


    // returns box number
    public int get_box (int cell)
    {
	int row_num = cell / 9;
	int col_num = cell % 9;
	int box_num = 0;

	if (row_num <= 2)
	{
	    if (col_num <= 2)
		box_num = 1;
	    else if (col_num <= 5)
		box_num = 2;
	    else
		box_num = 3;
	}


	else if (row_num <= 5)
	{
	    if (col_num <= 2)
		box_num = 4;
	    else if (col_num <= 5)
		box_num = 5;
	    else
		box_num = 6;
	}


	else
	{
	    if (col_num <= 2)
		box_num = 7;
	    else if (col_num <= 5)
		box_num = 8;
	    else
		box_num = 9;
	}

	return box_num;
    }


    // helper of check_box
    public boolean check_box_helper (int start_cell, int value)
    {
	boolean value_not_in_box = true;
	int row_count = 1;

	while (row_count <= 3)
	{

	    if (row_count == 1)
	    {
		for (int pos = start_cell ; pos < (start_cell + 3) ; pos++)
		{
		    if (board [pos] == value)
			value_not_in_box = false;
		}
	    }

	    else if (row_count == 2)
	    {
		for (int pos = start_cell + 9 ; pos < (start_cell + 12) ; pos++)
		{
		    if (board [pos] == value)
			value_not_in_box = false;
		}
	    }

	    else
	    {
		for (int pos = start_cell + 18 ; pos < (start_cell + 21) ; pos++)
		{
		    if (board [pos] == value)
			value_not_in_box = false;
		}
	    }

	    row_count++;
	}


	return value_not_in_box;
    }


    // checks if number is in box
    public boolean check_box (int cell, int value)
    {
	int box = get_box (cell);
	//System.out.println ("cell " + cell + " in box " + box);
	boolean value_not_in_box = true;

	if (box == 1)
	    value_not_in_box = check_box_helper (0, value);
	if (box == 2)
	    value_not_in_box = check_box_helper (3, value);
	if (box == 3)
	    value_not_in_box = check_box_helper (6, value);
	if (box == 4)
	    value_not_in_box = check_box_helper (27, value);
	if (box == 5)
	    value_not_in_box = check_box_helper (30, value);
	if (box == 6)
	    value_not_in_box = check_box_helper (33, value);
	if (box == 7)
	    value_not_in_box = check_box_helper (54, value);
	if (box == 8)
	    value_not_in_box = check_box_helper (57, value);
	if (box == 9)
	    value_not_in_box = check_box_helper (60, value);

	return value_not_in_box;
    }


    // Counts number of null values in board
    public int count_null ()
    {
	int count = 0;

	for (int pos = 0 ; pos < board.length ; pos++)
	{
	    if (board [pos] == 0)
		count++;
	}

	return count;
    }


    // Solves the sudoku puzzle
    public void puzzle_solver ()
    {
	for (int i = 0 ; i < grid.length ; i++)
	{
	    grid [i].setText (" " + board [i]);
	}

	boolean backward_pass = false;
	int curr_pos = 0;

	while (curr_pos < board.length)
	{
	    //System.out.println ("backward_pass = " + backward_pass);
	    //System.out.println ("current_cell: " + curr_pos);

	    if (backward_pass == false)
	    {
		if (board [curr_pos] > 0) //&& (board [curr_pos] == original_board [curr_pos])
		    curr_pos++;
		else
		{
		    boolean valid = false;
		    for (int i = 0 ; i < 10 ; i++)
		    {
			valid = check_row (curr_pos, i) && check_col (curr_pos, i) && check_box (curr_pos, i);
			if (valid == true)
			{
			    update_board (curr_pos, i);
			    curr_pos++;
			    break;
			}
		    }
		    if (valid == false)
		    {
			curr_pos--;
			backward_pass = true;
		    }
		}
	    }
	    else
	    {
		if ((board [curr_pos] > 0) && (board [curr_pos] == original_board [curr_pos]))
		    curr_pos--;
		else
		{
		    boolean valid = false;
		    for (int i = board [curr_pos] + 1 ; i < 10 ; i++)
		    {
			valid = check_row (curr_pos, i) && check_col (curr_pos, i) && check_box (curr_pos, i);
			if (valid == true)
			{
			    update_board (curr_pos, i);
			    backward_pass = false;
			    curr_pos++;
			    break;
			}
		    }
		    if (valid == false)
			update_board (curr_pos, 0);
		    curr_pos--;
		}
	    }

	}
    }


    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = Sudoku_Solver.class.getResource (path);
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
}


