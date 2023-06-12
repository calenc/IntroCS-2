/**
 * ---------------------------------------------------------------------------
 * File name: AboutBox.java
 * Project name: Project 6 - Club Membership Manager GUI
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 26, 2021
 * ---------------------------------------------------------------------------
 */

package clubRoster;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * About box that gives the name, class, and "copyright" of the project.
 *
 * <hr>
 * Date created: Apr 26, 2021
 * <hr>
 * @author Calen Cummings
 */
public class AboutBox extends JDialog
{
	private static final long serialVersionUID = 1L;
	private JLabel title;
	private JLabel purpose;
	private JLabel copyright;
	private JLabel clubLogoPic;
	private JPanel logoPanel;
	private JPanel infoPanel;
	private final int WINDOW_WIDTH = 550;
	private final int WINDOW_HEIGHT = 300;
	
	/**
	 * 
	 * Constructor for the program's "About" box that displays author information.       
	 *
	 * <hr>
	 * Date created: Apr 30, 2021 
	 *
	 * 
	 * @param ManagerWindow
	 */
	public AboutBox(JFrame ClubManagerGUI)
	{
		super(ClubManagerGUI, "About Club Membership Manager...", true);
		
		setFrameIcon();
		
		title = new JLabel ("Club Membership Manager");
		purpose = new JLabel ("Created for CSCI 1260, Project 6");
		copyright = new JLabel ("Copyright: Calen Cummings, Monday, April 26, 2021");
		
		logoPanel.add(clubLogoPic);
		
		infoPanel.add (title);
		infoPanel.add (purpose);
		infoPanel.add(copyright);
		
		add(logoPanel);
		add(infoPanel);
		
		this.setResizable (false);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation (DISPOSE_ON_CLOSE);	
		setLocationRelativeTo(ClubManagerGUI);
		setVisible(true);
	
	}
	
	/**
	 * 
	 * Method to set the frame icon to a custom one, but also display that same custom icon as an image in a panel by itself.        
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 *
	 * <hr>
	 */
	public void setFrameIcon()
	{
		try
		{
			File file = new File ("Pictures/clubIcon.jpeg");
			BufferedImage icon = ImageIO.read (file);
			setIconImage(icon);
			
			clubLogoPic = new JLabel(new ImageIcon(icon));
			
		}
		catch (IOException e)
		{
			// ignore missing icon
		}
	}
}
