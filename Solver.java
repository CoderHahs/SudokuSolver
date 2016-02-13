import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;

public class extends Applet implements ActionListener
{
    Panel p_card;  //to hold all of the screens
    Panel card1, card2, card3, card4, card5; //the two screens
    CardLayout cdLayout = new CardLayout ();

    public void init ()
    {
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	screen1 ();
	screen2 ();
	screen3 ();
	screen4 ();
	screen5 ();
	resize (150, 100);
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }


    public void screen1 ()
    { //screen 1 is set up.
	card1 = new Panel ();
	card1.setBackground (Color.white);
	JLabel title = new JLabel ("Knock, knock...");
	JButton next = new JButton ("Next");
	next.setActionCommand ("2");
	next.addActionListener (this);
	card1.add (title);
	card1.add (next);
	p_card.add ("1", card1);
    }


    public void screen2 ()
    { //screen 2 is set up.
	card2 = new Panel ();
	card2.setBackground (Color.orange);
	JLabel title = new JLabel ("Who's there?");
	JButton next = new JButton ("Next");
	next.setActionCommand ("3");
	next.addActionListener (this);
	card2.add (title);
	card2.add (next);
	p_card.add ("2", card2);
    }


    public void screen3 ()
    { //screen 3 is set up.
	card3 = new Panel ();
	card3.setBackground (Color.green);
	JLabel title = new JLabel ("Icon.");
	JButton next = new JButton ("Next");
	next.setActionCommand ("4");
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
	next.setActionCommand ("5");
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
	next.setActionCommand ("1");
	next.addActionListener (this);
	card5.add (title);
	card5.add (title2);
	card5.add (title3);
	card5.add (next);
	p_card.add ("5", card5);
    }


    public void actionPerformed (ActionEvent e)
    { //moves between the screens
	if (e.getActionCommand ().equals ("1"))
	    cdLayout.show (p_card, "1");
	else if (e.getActionCommand ().equals ("2"))
	    cdLayout.show (p_card, "2");
	else if (e.getActionCommand ().equals ("3"))
	    cdLayout.show (p_card, "3");
	else if (e.getActionCommand ().equals ("4"))
	    cdLayout.show (p_card, "4");
	else if (e.getActionCommand ().equals ("5"))
	    cdLayout.show (p_card, "5");
    }
    
    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = .class.getResource (path);
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
