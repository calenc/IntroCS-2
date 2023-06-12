/**
 * ---------------------------------------------------------------------------
 * File name: ClubManagerGUI.java
 * Project name: Project 6 - Club Membership Manager GUI
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 26, 2021
 * ---------------------------------------------------------------------------
 */

package clubRoster;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * GUI class that will run all the components together to create a graphic interface for the program.
 *
 * <hr>
 * Date created: Apr 26, 2021
 * <hr>
 * @author Calen Cummings
 */
public class ClubManagerGUI extends JFrame
{	
	// These components are all declared here for visibility/accessibility, and they are initialized to avoid errors thrown by null fields.
	
	private static final long serialVersionUID = 1L;
	private static Club		club		= null;
	
	private JList<String> memberRoll = new JList<String>();
	private JPanel memberScrollWindow = new JPanel();
	private JPanel memberFields = new JPanel();
	private JPanel memberPicture = new JPanel();
	
	private JLabel showMemberPic = new JLabel();
	private JMenuBar frameMenu = new JMenuBar();
	private JMenu fileMenu = new JMenu();
	private JMenu editMenu = new JMenu();
	private JMenu aboutMenu = new JMenu();
	private JMenuItem openClub = new JMenuItem();
	private JMenuItem saveClub = new JMenuItem();
	private JMenuItem exitClub = new JMenuItem();
	
	private JLabel nameOfClub = new JLabel ("Club Name");
	private JLabel clubLeader = new JLabel ("Club Leader");
	private JLabel yearFound = new JLabel ("Year Founded");
	private JLabel nameFirst = new JLabel ("First Name");
	private JLabel nameLast = new JLabel ("Last Name");
	private JLabel city = new JLabel ("City");
	private JLabel state = new JLabel ("State");
	private JLabel memberClass = new JLabel ("Member Type");
	private JLabel joinDate = new JLabel ("Date Joined");
	
	private JTextField clubNameField = new JTextField (10);
	private JTextField clubLeadField = new JTextField (10);
	private JTextField yearFoundField = new JTextField (10);
	private JTextField firstNameField = new JTextField (10);
	private JTextField lastNameField = new JTextField (10);
	private JTextField cityField = new JTextField (10);
	private JTextField stateField = new JTextField (10);
	private JComboBox<MemberType> memberField = new JComboBox<> (MemberType.values());
	private JTextField joinDateField = new JTextField (10);
	
	/**
	 * 
	 * Window that we will use as the main window for the program.
	 *
	 * <hr>
	 * Date created: Apr 26, 2021
	 * <hr>
	 * @author Calen Cummings
	 */
	public ClubManagerGUI()
	{
		super("CSCI 1260 Club Membership Manager - Cummings");
			
		final int WINDOW_WIDTH = 550,
		WINDOW_HEIGHT = 625;
				
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI (this);
		}
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog (null, "Error setting the look and feel. ");
			System.exit(0);
		}
		catch (InstantiationException e)
		{
			JOptionPane.showMessageDialog (null, "Error setting the look and feel. ");
			System.exit(0);
		}
		catch (IllegalAccessException e)
		{
			JOptionPane.showMessageDialog (null, "Error setting the look and feel. ");
			System.exit(0);
		}
		catch (UnsupportedLookAndFeelException e)
		{
			JOptionPane.showMessageDialog (null, "Error setting the look and feel. ");
			System.exit(0);
		}
		
		setLayout(new FlowLayout());
		
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			
		setFrameIcon();
		
		buildMenuBar();
		this.setJMenuBar(frameMenu);
			
		buildMemberListPanel();
		add(memberScrollWindow);
		
		buildMemberFieldPanel();
		add(memberFields);
		
		buildPicturePanel();
		add(memberPicture);
		
		
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);					
		setVisible(true);
		
	}
	
	/**
	 * 
	 * Method that sets the frame icon to a new custom one.         
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 *
	 * <hr>
	 */
	private void setFrameIcon()
	{
		try
		{
			File file = new File ("Pictures/clubIcon.jpeg");
			BufferedImage clubLogo = ImageIO.read (file);
			setIconImage(clubLogo);
		}
		catch (IOException e)
		{
			// ignore missing icon
		}
		
	}
	
	/**
	 * 
	 * Method that will setup our panel containing the member text fields         
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 *
	 * <hr>
	 */
	public void buildMemberFieldPanel()
	{
		memberFields.setLayout (new GridLayout(9, 2));
		
		clubNameField.setEditable (false);
		clubLeadField.setEditable (false);
		yearFoundField.setEditable (false);
		firstNameField.setEditable (false);
		lastNameField.setEditable (false);
		cityField.setEditable (false);
		stateField.setEditable (false);
		joinDateField.setEditable (false);
		memberField.setEnabled (false);
						
		memberFields.add (nameOfClub);
		memberFields.add (clubNameField);
		
		memberFields.add (clubLeader);
		memberFields.add (clubLeadField);
		
		memberFields.add (yearFound);
		memberFields.add (yearFoundField);
		
		memberFields.add (nameFirst);
		memberFields.add (firstNameField);
		
		memberFields.add (nameLast);
		memberFields.add (lastNameField);
		
		memberFields.add (city);
		memberFields.add (cityField);
		
		memberFields.add (state);
		memberFields.add (stateField);
		
		memberFields.add (memberClass);
		memberFields.add (memberField);
		
		memberFields.add (joinDate);
		memberFields.add (joinDateField);
	}
	
	/**
	 * 
	 * Builds the panel for the member scroll list         
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 *
	 * <hr>
	 */
	public void buildMemberListPanel()
	{	
		memberRoll.setSelectionMode (ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		memberRoll.addListSelectionListener (new ListPanelListener());
		
		memberRoll.setVisibleRowCount (8);
		
		JScrollPane memberScroll = new JScrollPane (memberRoll);
		memberScrollWindow.add (memberScroll);
		
	}
	
	/**
	 * 
	 * Listener class for the scroll list of members
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 * <hr>
	 * @author Calen Cummings
	 */
	private class ListPanelListener implements ListSelectionListener
	{
		/**
		 * 
		 * Method that will display the currently selected Member's information in the text fields        
		 *
		 * <hr>
		 * Date created: May 1, 2021 
		 *
		 * <hr>
		 * @param event
		 * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
		 */
		public void valueChanged(ListSelectionEvent event)
		{
			String listChoice = memberRoll.getSelectedValue ( );
			
			Member selected = club.findByName(listChoice);
			
			clubNameField.setText (club.getClubName());
			clubLeadField.setText (club.getHead());
			yearFoundField.setText (String.valueOf (club.getYear()));
			firstNameField.setText (selected.getFirstName());
			lastNameField.setText (selected.getLastName());
			cityField.setText (selected.getCity());
			stateField.setText (selected.getState());
			memberField.setSelectedItem (selected.getType());
			joinDateField.setText(selected.getDateJoined());
			
			
			
		}
	}
	
	/**
	 * 
	 * Method to construct the panel for member pictures         
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 *
	 * <hr>
	 */
	public void buildPicturePanel()
	{
		if (club == null)
		{
			showMemberPic.setText ("No Member Selected");
			memberPicture.add (showMemberPic);
		}
		else
		{
			String selection = memberRoll.getSelectedValue ( );
			Member chosen = club.findByName(selection);
			String filePath = chosen.getPhoto ( );
			
			showMemberPic = new JLabel( getPhotoIcon(filePath, 250));
			
			memberPicture.add (showMemberPic);
		}
	}
	
	/**
	 * 
	 * Provided method that auto sizes the height of a member picture to fit in the screen       
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 *
	 * <hr>
	 * @param fileName
	 * @param desiredHeight
	 * @return
	 */
	public ImageIcon getPhotoIcon (String fileName, int desiredHeight)
	{
		ImageIcon icon = new ImageIcon ("Pictures/" + fileName);
		
		Image pic = icon.getImage();
		double ratio = (double) pic.getWidth(null) / pic.getHeight (null);
		
		BufferedImage b1 = new BufferedImage((int)(desiredHeight * ratio), desiredHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics g1 = b1.getGraphics ( );
		g1.drawImage(pic, 0, 0, (int)(desiredHeight * ratio), desiredHeight, null);
		return new ImageIcon(b1);
	}
	
	/**
	 * 
	 * Meant to serve as a method to be used in ClubManagerGUI() to create and be able to add the complete menu bar        
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 *
	 * <hr>
	 */
	public void buildMenuBar()
	{
		// will hold the methods to setup all the menus
	}
	
	/**
	 * 
	 * Holds all of the relevant components for the MenuBar for the window
	 *
	 * <hr>
	 * Date created: May 1, 2021
	 * <hr>
	 * @author Calen Cummings
	 */
	public class MenuBar extends JMenuBar
	{
		private static final long serialVersionUID = 1L;
		
		/**
		 * 
		 * Constructor to serve as the final way to unite all the menu components       
		 *
		 * <hr>
		 * Date created: May 1, 2021 
		 *
		 *
		 */
		public MenuBar()
		{
			
			JMenu editTab = new EditMenu();
			JMenu helpTab = new HelpMenu();
			
			
			frameMenu.add (editTab);
			frameMenu.add (helpTab);
		}
		
		/**
		 * 
		 * Builds the File menu from menu items         
		 *
		 * <hr>
		 * Date created: May 1, 2021
		 *
		 * <hr>
		 */
		public void setupFileMenu()
		{
			openClub = new JMenuItem("Open an existing Club from a File");
			openClub.addActionListener(new OpenListener());
				
			saveClub = new JMenuItem("Save the Current Club");
			saveClub.addActionListener(new SaveListener());
				
			exitClub = new JMenuItem("Exit the program");
			exitClub.addActionListener(new ExitListener());
				
			ImageIcon open = new ImageIcon("Pictures/openfolderIcon.png");
			ImageIcon save = new ImageIcon("Pictures/saveDisk.png");
			ImageIcon leave = new ImageIcon("Pictures/exitDoor.png");
		
			openClub.setIcon (open);
			saveClub.setIcon (save);
			exitClub.setIcon (leave);
				
			fileMenu.add (openClub);
			fileMenu.add (saveClub);
			fileMenu.add (exitClub);
		}
		
			/**
			 * 
			 * Listener class for the Open function of the file menu
			 *
			 * <hr>
			 * Date created: May 1, 2021
			 * <hr>
			 * @author Calen Cummings
			 */
			private class OpenListener implements ActionListener
			{
				/**
				 * 
				 * Uses the openClub method to populate the club with members from a file when the user selects the open feature         
				 *
				 * <hr>
				 * Date created: May 1, 2021 
				 *
				 * <hr>
				 * @param event
				 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
				 */
				public void actionPerformed(ActionEvent event)
				{
					openClub();
				}
			}
			
			/**
			 * 
			 * Listener class for the Save function in the File menu
			 *
			 * <hr>
			 * Date created: May 1, 2021
			 * <hr>
			 * @author Calen Cummings
			 */
			private class SaveListener implements ActionListener
			{
				/**
				 * 
				 * Uses the save file method to save the current club when the user tries to save        
				 *
				 * <hr>
				 * Date created: May 1, 2021 
				 *
				 * <hr>
				 * @param event
				 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
				 */
				public void actionPerformed(ActionEvent event)
				{
					saveFile();
				}
			}
			
			/**
			 * 
			 * Listener class for the Exit function of the File menu
			 *
			 * <hr>
			 * Date created: May 1, 2021
			 * <hr>
			 * @author Calen Cummings
			 */
			private class ExitListener implements ActionListener
			{
				/**
				 * 
				 * Listener event that tells the user goodbye and closes the program when exiting from the File menu         
				 *
				 * <hr>
				 * Date created: May 1, 2021 
				 *
				 * <hr>
				 * @param event
				 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
				 */
				public void actionPerformed(ActionEvent event)
				{
					goodbye();
					System.exit (-1);
				}
			}
		}
		
		/**
		 * 
		 * Class to house the components of the Edit menu
		 *
		 * <hr>
		 * Date created: May 1, 2021
		 * <hr>
		 * @author Calen Cummings
		 */
		public class EditMenu extends JMenu
		{
			private static final long serialVersionUID = 1L;
			
			
			/**
			 * 
			 * Constructor that executes the build method for the Edit menu       
			 *
			 * <hr>
			 * Date created: May 1, 2021 
			 *
			 *
			 */
			public EditMenu()
			{
				setupEditMenu();
			}
			
			/**
			 * 
			 * Builds the Edit menu        
			 *
			 * <hr>
			 * Date created: May 1, 2021
			 *
			 * <hr>
			 */
			public void setupEditMenu()
			{
				JMenuItem addPerson = new JMenuItem ("Add a Member");
				addPerson.addActionListener(new AddPersonListener());
				
				JMenuItem editPerson = new JMenuItem ("Edit a Member");
				JMenuItem deletePerson = new JMenuItem ("Delete a Member");
				
				ImageIcon addLogo = new ImageIcon("Pictures/addIcon.png");
				ImageIcon editLogo = new ImageIcon("Pictures/editIcon.png");
				ImageIcon deleteLogo = new ImageIcon("Pictures/deleteIcon.png");
				
				addPerson.setIcon(addLogo);
				editPerson.setIcon (editLogo);
				deletePerson.setIcon (deleteLogo);
			}
			
			/**
			 * 
			 * Listener class for the add feature
			 *
			 * <hr>
			 * Date created: May 1, 2021
			 * <hr>
			 * @author Calen Cummings
			 */
			private class AddPersonListener implements ActionListener
			{
				/**
				 * 
				 * This action listener sets all the text fields to defaults for the user to input data for a new member.        
				 *
				 * <hr>
				 * Date created: May 1, 2021 
				 *
				 * <hr>
				 * @param event
				 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
				 */
				public void actionPerformed(ActionEvent event)
				{
					clubNameField.setEditable (true);
					clubLeadField.setEditable (true); 
					yearFoundField.setEditable (true); 
					firstNameField.setEditable (true); 
					lastNameField.setEditable(true); 
					cityField.setEditable (true); 
					stateField.setEditable(true);  
					joinDateField.setEditable(true);
					memberField.setEnabled (true);
					
					clubNameField.setText ("");
					clubLeadField.setText ("");
					yearFoundField.setText ("");
					firstNameField.setText ("");
					lastNameField.setText ("");
					cityField.setText ("");
					stateField.setText ("");
					joinDateField.setText ("");
					memberField.setSelectedItem (MemberType.Provisional);
					
					JOptionPane.showMessageDialog (null, "Please fill out the fields for the new member. After all fields are complete the member will be added.");
					
					String newFirst = firstNameField.getText();
					String newLast = lastNameField.getText();
					String newCity = cityField.getText();
					String newState = stateField.getText();
					String newDate = joinDateField.getText();
					String newClassification = String.valueOf (memberField.getSelectedItem());
					MemberType newType = MemberType.valueOf (newClassification);
					
					Member added = new Member(newLast, newFirst, newCity, newState, newDate, "empty.jpg", newType);
					
					club.addMember (added);
				}
			}
		}
		
		/**
		 * 
		 * Class to hold components for Help menu
		 *
		 * <hr>
		 * Date created: May 1, 2021
		 * <hr>
		 * @author Calen Cummings
		 */
		public class HelpMenu extends JMenu
		{
			private static final long serialVersionUID = 1L;
			
			
			/**
			 * 
			 * Constructor that houses the method to create the structure of the help menu.       
			 *
			 * <hr>
			 * Date created: May 1, 2021 
			 *
			 *
			 */
			public HelpMenu()
			{
				setupHelpMenu();
			}
			
			/**
			 * 
			 * Builds the help menu         
			 *
			 * <hr>
			 * Date created: May 1, 2021
			 *
			 * <hr>
			 */
			public void setupHelpMenu()
			{
				JMenuItem aboutDialog = new JMenuItem("About...");
				
				aboutDialog.addActionListener (new HelpListener());
			}
			
			/**
			 * 
			 * Necessary listener class for the Help menu
			 *
			 * <hr>
			 * Date created: May 1, 2021
			 * <hr>
			 * @author Calen Cummings
			 */
			private class HelpListener implements ActionListener
			{
				/**
				 * 
				 * This action listener opens up the about box for the program.       
				 *
				 * <hr>
				 * Date created: May 1, 2021 
				 *
				 * <hr>
				 * @param event
				 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
				 */
				public void actionPerformed(ActionEvent event)
				{
					new AboutBox(ClubManagerGUI.this);
				}
			}
		}
		
	
	
	
	/**
	 * Save the Club Manager to a file
	 *
	 * <hr>
	 * Date created: Oct 19, 2015
	 * Last Modified: Apr 26, 2021
	 *
	 * <hr>
	 */
	private static void saveFile ( )
	{
		if (club == null)
		{
			JOptionPane.showMessageDialog (null, "There is no club to save", "Save Failed",
				JOptionPane.ERROR_MESSAGE);
			return;
		}
		JFileChooser dlg = new JFileChooser ("ClubData");
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt");
		dlg.setFileFilter (filter);
		dlg.setDialogTitle ("Select the Club Data File You Wish to Save");
		int button = dlg.showSaveDialog (null);
		if (button != JFileChooser.APPROVE_OPTION)
		{
			JOptionPane.showMessageDialog (null, "No file selected", "File Not Saved",
				JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		try
		{
			club.saveFile (dlg.getSelectedFile ( ).getPath ( ));
			JOptionPane.showMessageDialog (null, "File saved successfully", "File Saved",
				JOptionPane.INFORMATION_MESSAGE);
		}
		catch (FileNotFoundException e)
		{
			JOptionPane.showMessageDialog (null, "File not found - " + e.getMessage ( ),
				"File Not Found", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace ( );
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog (null, "File not saved - " + e.getMessage ( ),
				"Error During File Save", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace ( );
		}
	}
	
	/**
	 * Open a Club Manager file and populate the roster
	 *
	 * <hr>
	 * Date created: Jul 8, 2015
	 * Last Modified: Apr 26, 2021
	 *
	 * <hr>
	 */
	private static void openClub ( )
	{
		if (club != null && club.isSaveNeeded ( ))
		{
			saveFile ( );
		}
		club = new Club ( );
		JFileChooser dlg = new JFileChooser ("ClubData");
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt");
		dlg.setFileFilter (filter);
		dlg.setDialogTitle ("Select the Club Data File You Wish to Open");
		int button = dlg.showOpenDialog (null);
		if (button != JFileChooser.APPROVE_OPTION)
		{
			JOptionPane.showMessageDialog (null, "No file selected", "File Not Opened",
				JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		try
		{
			club.fillFromFile (dlg.getSelectedFile ( ).getPath ( ));
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog (null,
				"There was an error processing the file - operation terminated. \n" +
								e.getMessage ( ),
				"Error Reading from File", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * 
	 * Terminate the program with a goodbye message
	 *
	 * <hr>
	 * Date created: Oct 19, 2015
	 * Last Modified: Apr 26, 2021
	 *
	 * <hr>
	 */
	private static void goodbye ( )
	{
		JOptionPane.showMessageDialog (null, "Thank you for using the Club Roster Manager",
			"Thank You and Goodbye", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
