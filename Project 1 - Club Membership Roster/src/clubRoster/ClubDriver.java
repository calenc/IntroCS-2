/**
 * ---------------------------------------------------------------------------
 * File name: ClubDriver.java
 * Project name: Project 1 - Club Membership Roster
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Mar 18, 2021
 * ---------------------------------------------------------------------------
 */

package clubRoster;

/**
 * The Menu class must be imported to make use of a menu in our driver.
 * 
 * <hr>
 * Date created: Mar 18, 2021
 * <hr>
 * @author Calen Cummings
 */
import util.Menu;

/**
 * These Date classes must be imported so we can compare the system year to our member join
 * dates and verify that they are within reason.
 */
import java.util.Date;

/**
 * The Scanner class is imported so we can use scanner objects.
 * 
 * <hr>
 * Date created: Mar 18, 2021
 * <hr>
 * @author Calen Cummings
 */
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;

/**
 * The driver class will use a menu to give users the ability to create a Club and interact with its members.
 *
 * <hr>
 * Date created: Mar 18, 2021
 * <hr>
 * @author Calen Cummings
 */
public class ClubDriver
{
	// Declaring userClub as an empty club allows us to create methods to use in conjunction with the main method
	private static Club userClub = new Club();
	private static Date today = new Date(); // Date object is created so we can later test Member join date's against the current year.
	
	/**
	 * 
	 * The main method. Uses local methods to go through a menu of choices.         
	 *
	 * <hr>
	 * Date created: Apr 5, 2021
	 *
	 * <hr>
	 * @param args
	 */
	public static void main(String[] args)
	{	
		Scanner keyboard = new Scanner(System.in);
		
		// Creating the menu that serves as the user interface for the program.
		Menu main = new Menu("Club Roster Manager Main Menu");
		
		main.addChoice("Create a new Club");
		main.addChoice("Create a new Member to add to the Club");
		main.addChoice("Edit a Member from the Club");
		main.addChoice("Drop a Member from the Club Roster");
		main.addChoice("Display all Members in the Club");
		main.addChoice("Find and Display a Member by Name");
		main.addChoice("Display all Club Members of a Given Type");
		main.addChoice("Sort Club Members by Name");
		main.addChoice("Sort Club Members by Membership Tenure");
		main.addChoice("Create a Club from a File");
		main.addChoice("Save a Club to a File");
		main.addChoice("Exit the program");
		
		int userChoice;
		
		
		while ((userChoice = main.getChoice()) != 12)
		{
			switch (userChoice)
			{
				case 1:
				{
					// Calls the local CreateClub method.
					
					createClub();
					
					break;
				}
				
				case 2:
				{
					// Try block is a part of all methods to prevent user from crashing the program by accessing a method on a null object
					// case 2 calls the addNewMember method and adds a member to the userClub
					
					try
					{
						addNewMember ( );
						
					}
					catch (Exception e)
					{
						System.out.println("No club exists yet. Please create a club. ");
					}
					break;
				}
				
				case 3:
				{
					// case 3 calls the editAMember method and allows the user to edit a member
					
					try
					{
						editAMember ( );
					}
					catch (Exception e)
					{
						System.out.println("No club exists yet. Please create a club. ");
					}
					break;
				}
				
				case 4:
				{
					// case 4 calls the dropAMember method to remove a member from the club
					
					try
					{
						dropAMember ( );
					}
					catch (Exception e)
					{
						System.out.println("No club exists yet. Please create a club. ");
					}
					break;
				}
				
				case 5:
				{
					// case 5 calls the displayTheRoster method to display all members currently in the club
					
					try
					{
						displayTheRoster ( );
					}
					catch (Exception e)
					{
						System.out.println("No club exists yet. Please create a club. ");
					}
					break;
				}
				
				case 6:
				{
					// case 6 calls the findAndShow method to search for and display a user requested member
					
					try
					{
						findAndShow();
					}
					catch (Exception e)
					{
						System.out.println("No club exists yet. Please create a club. ");
					}
					break;
				}
				
				case 7:
				{
					// case 7 uses the typeGroup method to display all members in a club of the same member type
					
					try
					{
						typeGroup ( );
					}
					catch (Exception e)
					{
						System.out.println("No club exists yet. Please create a club. ");
					}
					break;
				}
				
				case 8:
				{
					// case 8 calls the sort method to organize the club roster in alphabetical order
					
					try
					{
						sort();
						
					}
					catch (Exception e)
					{
						System.out.println("No club exists yet. Please create a club. ");
					}
					break;
				}
				
				case 9:
				{
					try
					{
						// case 9 calls on the local method dateSort to sort the roster by member join date (earliest year/longest members come first)
						dateSort();
						
						// After sorting the roster, display it.
						
						System.out.println("The club has been organized from longest to shortest tenure: ");
						
						for (int yearOrder = 0; yearOrder < userClub.size(); yearOrder++)
						{
							System.out.println(userClub.get (yearOrder).toString());
						}
					}
					catch (Exception e)
					{
						System.out.println("A club must exist for it to be sorted. Create a club then try again. ");
					}
					
					break;
				}
				
				case 10:
				{
					clubFromFile();
					
					break;
				}
				
				case 11:
				{
					saveClubToFile();
					
					break;
				}
			}
		}
		// Goodbye statement to signify the program has closed as intended.
		
		if (userClub.isSaveNeeded() == true)
		{
			userClub.saveToFile ("ClubData\\Roster.txt");
		}
		
		System.out.println("Thank you for using this program! ");
		return;
	}
	
	/**
	 * 
	 * createClub method fills the local userClub with a user-input club for the rest of the driver to work with.         
	 *
	 * <hr>
	 * Date created: Apr 5, 2021
	 *
	 * <hr>
	 */
	public static void createClub()
	{
		if (userClub.isSaveNeeded() == true)
		{
			userClub.saveToFile ("ClubData\\Roster.txt");
		}
		
		Scanner keyboard = new Scanner(System.in);
		
		// Fill the local userClub object with values so we have a club for the main method to interact with
		
		System.out.println("What is your Club called? ");
		userClub.setClubName (keyboard.nextLine());
		
		System.out.println("Who is the Leader/Head of the club? ");
		userClub.setHead (keyboard.nextLine());
		
		// The following try-catch block will only allow integers to be entered for the club founding year
		
		boolean yearCheck = false;
		while ( !yearCheck)
		{
			try
			{
				System.out.println ("What year was the club founded? ");
				userClub.setFoundingYear (keyboard.nextInt ( ));
				yearCheck = true;
			}
			catch (Exception e)
			{
				System.out.println ("Please enter only the year in which the club was founded. Try again. ");

			} 
		}
		
		System.out.println("Your club was created! ");
		
	}
	
	/**
	 * 
	 * editAMember method searches the Club roster for a member by name, and allows the user to change an attribute.         
	 *
	 * <hr>
	 * Date created: Mar 18, 2021
	 *
	 * <hr>
	 */
	public static void editAMember()
	{
		// This if statement is included in each method except for createClub, to prevent users from accessing any options or attempting to manipulate a club that does not exist.
		
		if (userClub.getHead() == null)
		{
			System.out.println("A club must exist. Please create a club from option 1. ");
			return;
		}
		
		// Scanner object needed for user input
		// This method attempts to search through the roster for a given name and verify with the user if the found value is the desired one.
		// Once the member is verified, the user can choose which field they want to change.
				
		Scanner kb = new Scanner(System.in);
				
		System.out.print ("Please give the First name of the member you would like to edit. ");
		String nameSearch = kb.nextLine ( );
				
		int element = userClub.search (nameSearch);
		
		if (element == -1)
		{
			System.out.println("The member name you entered does not exist in this club. Returning to menu. ");
			return;
						
		}
				
		System.out.println (userClub.get (element).toString());
				
		// If multiple members have the same first/last name, we want to make sure we are editing the right one. This gives a chance for a second search
		// by last name to hopefully differentiate between similar members.
		System.out.print ("Is this the member you are looking for (Y / N)? ");
		String confirmResults = kb.next ( ).toUpperCase();
		kb.nextLine ( );
				
		while (!confirmResults.equals ("Y") && !confirmResults.equals("N"))
		{
			System.out.println("Please enter either Y or N. Try again. ");
			System.out.print ("Is this the member you are looking for (Y / N)? ");
			confirmResults = kb.next().toUpperCase ( );
		}
				
		while (confirmResults.equals ("N"))
		{
			System.out.println("Enter the member's last name to refine the search. ");
			nameSearch = kb.nextLine ( );
				
			
			element = userClub.searchLast (nameSearch); 
				
			if (element != -1)
			{
				confirmResults = "Y";
			}
				
			if (element == -1)
			{
				System.out.println("The member name you entered does not exist in this club. Returning to the menu. ");
				return;
			}
						
						
		}
		// user is prompted to change one of 5 options, but a total of 7 member fields can be altered.
				
		System.out.print ("What would you like to edit? Please choose from the following: Name, Address, MemberType, Date Joined, Photo. ");
		String editChoice = kb.nextLine ( );
				
		// Switch statement executes the chosen field for the user and allows them to make a change, or exits the method if an invalid field is entered.
		// Using toUpperCase helps minimize bad data between the program and the user.
		switch (editChoice)
		{
			case "Name":
			{
				System.out.print ("Would you like to change the first or last name? Use F or L to choose. ");
				String namePick = kb.next ( ).toUpperCase();
				
				while (!namePick.equals("F") && !namePick.equals ("L"))
				{
					System.out.println("Please enter either F or L to choose. Try again. ");
					System.out.println ("Would you like to change the first or last name? Use F or L to choose. ");
					namePick = kb.next ( ).toUpperCase();
				}
						
				while (namePick.equals ("F"))
				{
					System.out.println ("What would you like to change the member's first name to? ");
					kb.nextLine ( );
					userClub.get(element).setFirstName (kb.nextLine());
							
					System.out.println ("The name was successfully changed to " + userClub.get (element).getFirstName() + ".");
					break;
				}
						
				while (namePick.equals ("L"))
				{
					System.out.println("What would you like to change the member's last name to? ");
					kb.nextLine ( );
					userClub.get (element).setLastName (kb.nextLine());
							
					System.out.println("The last name was successfully changed to " + userClub.get (element).getLastName() + ".");
					break;
				}
						
				break;
			}
					
			case "Address":
			{
				System.out.println("Do you want to change the member's city or state? Use C or S to choose. ");
				String addressPick = kb.next ( ).toUpperCase ( );
						
				while (!addressPick.equals ("C") && !addressPick.equals ("S"))
				{
					System.out.println("Please enter either C or S to choose. Try again. ");
					System.out.println("Do you want to change the member's city or state? Use C or S to choose. ");
					addressPick = kb.next().toUpperCase ( );
				}
						
				while (addressPick.equals ("C"))
				{
					System.out.println("What city does the member now live in? ");
					kb.nextLine ( );
					userClub.get (element).setCity (kb.nextLine());
							
					System.out.println("The member's city was changed to " + userClub.get (element).getCity() + ".");
					break;
				}
						
				while (addressPick.equals ("S"))
				{
					System.out.println("What state does the member now live in? ");
					kb.nextLine ( );
					userClub.get (element).setState (kb.nextLine());
							
					while (userClub.get (element).getState().length() != 2)
					{
						System.out.println("Please enter the state in XX format. ");
						System.out.print ("What state does the member now live in? Please answer in XX format. ");
						userClub.get (element).setState (kb.nextLine ( ).toUpperCase());
					}
							
					System.out.println("The member's state was changed to " + userClub.get (element).getState() + ".");
					break;
				}
						
				break;
			}
					
			case "MemberType":
			{
				boolean classify = false;
				while ( !classify)
				{
					try
					{
						System.out.print (
							"What classification is the member under now? Please enter one of the following values exactly: Provisional, Student, Officer, " +
											"Junior, Senior, Lifetime. ");
						String userChange = (kb.nextLine ( ));
						userClub.get (element).setMemberType ( (MemberType.valueOf (userChange)));
						classify = true;
					}
					catch (Exception e)
					{
						System.out.println ("Error! Please enter the member classification as one of the options shown. ");
								
					} 
				}
						
				System.out.println("The member's type was changed to " + userClub.get (element).getMemberType() + ".");
						
				break;
			}
					
			case "Date Joined":
			{
				System.out.println("What is the new member join date? Please enter in mm/dd/yyyy format. ");
				userClub.get (element).setJoinDate (kb.nextLine());
						
				while (userClub.get (element).getJoinDate ( ).length() != 10)
				{
					System.out.println ("Please enter the member's join date in the specified format. ");
					System.out.print ("What is the member's new join date? Please enter in mm/dd/yyyy format. ");
					kb.nextLine ( );
					userClub.get (element).setJoinDate (kb.nextLine());
									
				}
						
				System.out.println("The member's join date was changed to " + userClub.get (element).getJoinDate() + ".");
				break;
			}
					
			case "Photo":
			{
				System.out.println("Please enter the file path for the new photo. The file extension must be in the .jpg format. ");
				userClub.get (element).setPhoto(kb.nextLine());
						
				String extensionVerify;
				try
				{
					extensionVerify = userClub.get (element).getPhoto ( ).substring (userClub.get (element).getPhoto ( ).length() - 4);
				}
				catch (Exception e)
				{
					System.out.print ("Please enter a file path ending in .jpg. ");
					userClub.get (element).setPhoto (kb.nextLine());
					extensionVerify = userClub.get (element).getPhoto ( ).substring (userClub.get (element).getPhoto ( ).length() - 4);
				}
						
				while (!extensionVerify.equals (".jpg"))
				{
					System.out.println ("Error! Enter the file path with the correct extension at the end. Try again. ");
					System.out.print ("Please enter the file path for a recent photo of the member. This path should end in the .jpg format. ");
					userClub.get (element).setPhoto (kb.nextLine ( ));
					extensionVerify = userClub.get (element).getPhoto ( ).substring (userClub.get (element).getPhoto ( ).length() - 4);
				}
						
				System.out.println("The member photo file path was changed to " + userClub.get (element).getPhoto() + ".");
				break;
			}
					
			default:
			{
				System.out.println("You must enter one of the options exactly as shown. Returning to menu. ");
				return;
			}
		}
	}
	
	/**
	 * 
	 * dropAMember allows our driver class to list the members of a roster and choose which one to remove.         
	 *
	 * <hr>
	 * Date created: Mar 18, 2021
	 *
	 * <hr>
	 */
	public static void dropAMember()
	{
		if (userClub.getHead() == null)
		{
			System.out.println("A club must exist. Please create a club from option 1. ");
			return;
		}
		
		// User a menu-driven interface instead of searching for a club member to drop.
		
		Menu memberMenu = new Menu("Which Member Do You Want to Drop?");
				
		for (int count = 0; count < userClub.size ( ); count++)
		{
			memberMenu.addChoice (userClub.get (count).getFirstName() + " " + userClub.get (count).getLastName());
		}
				
		memberMenu.addChoice ("Exit");
				
		int menuChoice = memberMenu.getChoice ( );
				
		//getChoice starts at 1 while our index starts at 0, meaning we have to adjust some values to make sure our indices do not end up incorrect.
		if (menuChoice == userClub.size() + 1)
		{
			return;
		}
		// menuChoice minus 1 gets us back to the index for that menuChoice option/Member selected
		System.out.println("You have chosen " + userClub.get(menuChoice - 1).getFirstName() + " " + userClub.get (menuChoice - 1).getLastName() +
			" to be deleted. ");
		userClub.remove (menuChoice - 1);
				
		System.out.println("The member has been removed. ");
				
	}
	
	/**
	 * 
	 * Sort method calls the sortRoster method from the Club class and then gives output to display the newly sorted roster to the user.       
	 *
	 * <hr>
	 * Date created: Mar 18, 2021
	 *
	 * <hr>
	 */
	public static void sort()
	{
		if (userClub.getHead() == null)
		{
			System.out.println("A club must exist. Please create a club from option 1. ");
			return;
		}
		
		userClub.sortRoster ( );
		
		System.out.println("The aplhabetically sorted roster is shown below. \n");
		
		for (int newOrder = 0; newOrder < userClub.size ( ); newOrder++)
		{
			System.out.println(userClub.get (newOrder).toString());
		}
		
	}
	
	/**
	 * 
	 * addNewMember method creates a default member and writes over its fields with user input, then adds the member to the club         
	 *
	 * <hr>
	 * Date created: Apr 5, 2021
	 *
	 * <hr>
	 */
	public static void addNewMember()
	{
		if (userClub.getHead() == null)
		{
			System.out.println("A club must exist before a member can be added. Please create a club from option 1. ");
			return;
		}
		
		// Scanner object needed for user input
		Scanner kb = new Scanner(System.in);
				
		// we are adding a member so a blank member object is constructed and fields are filled by user input
		Member userCreated = new Member();
				
		// These question statements all lead to the creation of a user defined member
		// Exception handling and expectations are applied to everything except Strings in most cases (unnecessary to prevent 100% of bad data with
		// manual String entries).
		System.out.print ("What is the member's first name? ");
		userCreated.setFirstName (kb.nextLine ( ));
				
		System.out.print ("What is their last name? ");
		userCreated.setLastName (kb.nextLine ( ));
				
		System.out.print ("What city do they live in? ");
		userCreated.setCity (kb.nextLine ( ));
				
		System.out.print ("What state is " + userCreated.getCity ( ) + " in? Please answer in XX format. ");
		userCreated.setState (kb.nextLine ( ).toUpperCase());
						
		while (userCreated.getState().length() != 2)
		{
			System.out.println("Please enter the state in XX format. ");
			System.out.print ("What state is " + userCreated.getCity() + " in? Please answer in XX format. ");
			userCreated.setState (kb.nextLine ( ).toUpperCase());
		}
						
		// MemberType is guaranteed to throw an exception without a proper way to catch the exception or loop the user until they provide sufficient
		// input.
				
		boolean classify = false;
		while ( !classify)
		{
			try
			{
				System.out.print (
					"What classification is the member under? Please enter one of the following values exactly: Provisional, Student, Officer, " +
									"Junior, Senior, Lifetime. ");
				String userAttempt = (kb.nextLine ( ));
				userCreated.setMemberType ( (MemberType.valueOf (userAttempt)));
				classify = true;
			}
			catch (Exception e)
			{
				System.out.println ("Error! Please enter the member classification as one of the options shown. ");
						
			} 
		}
				
		// Join date is not verified in this method or class, but is in the driver (sort by member tenure).
		// Although we cannot easily restrict the string here, we can limit it to exactly 10 characters to have at least some defense against bad data.
		System.out.print ("What is the member's join date? Please enter in mm/dd/yyyy format. ");
		userCreated.setJoinDate (kb.nextLine ( ));
						
		while (Integer.parseInt(userCreated.getJoinDate().substring(userCreated.getJoinDate ( ).length() - 4)) < userClub.getFoundingYear() )
		{
			System.out.println("The member join year cannot occur before the club founding year. Try again. ");
			System.out.println("What is the member's join date? Please enter in mm/dd/yyyy format. ");
			userCreated.setJoinDate (kb.nextLine());
		}
		
		while (userCreated.getJoinDate ( ).length() != 10)
		{
			System.out.println ("Please enter the member's join date in the specified format. ");
			System.out.print ("What is the member's join date? Please enter in mm/dd/yyyy format. ");
			userCreated.setJoinDate (kb.nextLine());
							
		}
						
				
		System.out.print ("Please enter the file path for a recent photo of the member. This path should end in the .jpg format. ");
		userCreated.setPhoto (kb.nextLine ( ));
				
		// Here we see again the isolation of specifically the last 4 digits in a string.
		// This string check allows us to have all "photos" in the .jpg format.
				
		String extensionVerify = userCreated.getPhoto ( ).substring (userCreated.getPhoto ( ).length() - 4);
						
		while (!extensionVerify.equals (".jpg"))
		{
			System.out.println ("Error! Enter the file path with the correct extension at the end. Try again. ");
			System.out.print ("Please enter the file path for a recent photo of the member. This path should end in the .jpg format. ");
			userCreated.setPhoto (kb.nextLine ( ));
			extensionVerify = userCreated.getPhoto ( ).substring (userCreated.getPhoto ( ).length() - 4);
		}
					
		userClub.addMember (userCreated);
		
		System.out.println("The member was added to the club! ");		
	}
	
	/**
	 * 
	 * displayTheRoster prints each member of the club in its toString format.         
	 *
	 * <hr>
	 * Date created: Mar 18, 2021
	 *
	 * <hr>
	 */
	public static void displayTheRoster()
	{
		if (userClub.getHead() == null)
		{
			System.out.println("A club must exist. Please create a club from option 1. ");
			return;
		}
		
		System.out.println("Here are all the members of the club. \n");
		
		for (int count = 0; count < userClub.size(); count++)
		{
			System.out.println(userClub.get(count).toString());
		}
	}
	
	/**
	 * 
	 * findAndShow searches a roster for a specific member by name, and displays the member if found.         
	 *
	 * <hr>
	 * Date created: Mar 18, 2021
	 *
	 * <hr>
	 */
	public static void findAndShow()
	{
		if (userClub.getHead() == null)
		{
			System.out.println("A club must exist. Please create a club from option 1. ");
			return;
		}
		
		// algorithm searches through the roster, and if the member is found it is printed.
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("What is the member's name? Please enter the name exactly for the search to work best. ");
		String userSearch = kb.nextLine();
		
		int index = 0;
		int	element = -1;
		boolean found = false;
		
		while (element == -1)
		{
			while ( !found && index < userClub.size ( ))
			{
				// Instead of just searching by first or last name, we can expedite the method by combining them into a full name.
				
				String fullName = userClub.get (index).getFirstName() + " " + userClub.get (index).getLastName();
				
				if (fullName.equals (userSearch))
				{
					found = true;
					element = index;
					
				}

				index++ ;
			} 
			
			if (element == -1)
			{
				System.out.println("The member name you entered does not exist in this club. Returning to the menu. ");
				return;
			}
			
		}
		
		System.out.println(userClub.get (element).toString());
	}
	
	/**
	 * 
	 * typeGroup method asks what MemberType the user wants to search by, display all members of a given type, and it will automatically return to the main menu if a bad 
	 * MemberType is given.         
	 *
	 * <hr>
	 * Date created: Mar 18, 2021
	 *
	 * <hr>
	 */
	public static void typeGroup()
	{
		if (userClub.getHead() == null)
		{
			System.out.println("A club must exist. Please create a club from option 1. ");
			return;
		}
		
		Scanner kb = new Scanner(System.in);
		
		boolean classify = false;
		while ( !classify)
		{
			System.out.println("What Member Type do you want to show? Choose from the following: Provisional, Student, Officer, Junior, Senior, Lifetime.  ");
			String userType = kb.nextLine ( );
				
			int index = 0;
			int	element = -1;
			boolean found = false;
				
			while (element == -1)
			{
				while ( !found && index < userClub.size ( ))
				{	
					try
					{
						// MemberType will always throw an exception unless handled so we use the try-catch block
						if (userClub.get (index).getMemberType() == ((MemberType.valueOf (userType))))
						{
							System.out.println(userClub.get (index).toString());
								
						}
					}
					catch (Exception e)
					{
						System.out.println("Incorrect search value given. Returning to main menu. ");
						return;
					}

						index++ ;
				} 
					
				element = 0;	
			}
			classify = true;
		}
			
	}
	
	public static void dateSort()
	{
		if (userClub.getHead() == null)
		{
			System.out.println("A club must exist. Please create a club from option 1. ");
			return;
		}
		
		// Bringing DateFormat along with the date object from earlier in the code allows the program to know the current year.
		
		// To organize by join date, we are going to first compare years, then months, then days in a series of for loops to ensure the entire 
		// roster is searched.
		DateFormat fmtDate = DateFormat.getDateInstance(DateFormat.FULL);
		String systemYear = fmtDate.format (today);
		
		// .substring is used here to create new, specific strings from member join dates to easily compare them to the system (current) year
		// This substring exclusively takes the last 4 characters of the string.
		int yearVerify = Integer.parseInt(systemYear.substring (systemYear.length() - 4));
		
		
		for (int count = 0; count < userClub.size ( ); count++)
		{
			// substrings like those seen here are used to isolate the integers in our member dates to more easily verify their presence
			// in an acceptable range.
			// this substring isolates the year digits of the join date string
			String memberYear = userClub.get(count).getJoinDate().substring (6, 10);
			
			try
			{
				int keyMemberYear = Integer.parseInt(memberYear);
				
				// making sure the join year is within a valid range
				if (keyMemberYear > yearVerify || keyMemberYear < userClub.getFoundingYear())
				{
					// since we are making use of the main menu, most fails or exceptions result in the program returning to the main menu.
					// the tracker integer here is a little redundant but it clearly shows that we are using the current value in the for
					// loop to know exactly which member threw the exception or caused an issue.
					int tracker = count;
					System.out.println("The member join year for " + userClub.get(tracker).getFirstName() + " is invalid. Please edit it and try again. ");
					return;
				}
				
			}
			catch (NumberFormatException e)
			{
				// catcherFlag follows the same principles/purpose as the tracker variable.
				int catcherFlag = count;
				System.out.println("The member join date for " + userClub.get(catcherFlag).getFirstName ( ) + " is invalid. Please edit it and try agian. ");
				return;
			}
			
			
			for (int index = 0; index < userClub.size ( ); index++)
			{
				String decoderYear = userClub.get (index).getJoinDate().substring (6, 10);
				
				try
				{
					int decoderYearInt = Integer.parseInt(decoderYear);
					
					if (decoderYearInt > yearVerify || decoderYearInt < userClub.getFoundingYear())
					{
						int tracker = index;
						System.out.println("The member join year for " + userClub.get(tracker).getFirstName() + " is invalid. Please edit it and try again. ");
						return;
					}
					
				}
				catch (Exception e)
				{
					int catcherFlag = index;
					System.out.println("The member join date for " + userClub.get(catcherFlag).getFirstName() + " is invalid. Please edit it and try again. ");
					return;
				}
				
				int memberYearCompare = (Integer.parseInt(memberYear) - (Integer.parseInt(decoderYear)));
				
				// Our conditions for swapping places in the roster require us to consider the sum of the arguments and their respective "position"
				// Swap values under the met conditions to eventually have a roster sorted by join date.
				if (memberYearCompare < 0 && count > index)
				{
					Member temp = userClub.get (count);
					userClub.set (count, userClub.get (index));
					userClub.set (index, temp);
				}
				
				else if (memberYearCompare > 0 && count < index)
				{
					Member temp = userClub.get (count);
					userClub.set (count, userClub.get (index));
					userClub.set (index, temp);
				}
				
				else 
				{
					for (int countMonth = 0; countMonth < userClub.size ( ); countMonth++)
					{
						String memberMonth = userClub.get (countMonth).getJoinDate ( ).substring(0, 2);
						
						try
						{
							int keyMemberMonth = Integer.parseInt(memberMonth);
							
							// verifies the month is within expectations
							if (keyMemberMonth > 12 || keyMemberMonth < 1)
							{
								int tracker = countMonth;
								System.out.println("The member join month for " + userClub.get(tracker).getFirstName() + " is invalid. Please edit it and try again. ");
								return;
							}
						}
						catch (NumberFormatException e)
						{
							int catcherFlag = countMonth;
							System.out.println("The member join date for " + userClub.get(catcherFlag).getFirstName() + " is invalid. Please edit it and try again. ");
							return;
							
						}
						
						for (int checkDecoder = 0; checkDecoder < userClub.size ( ); checkDecoder++)
						{
							String decoderMonth = userClub.get (checkDecoder).getJoinDate().substring (0, 2);
							
							try
							{
								int decoderMonthInt = Integer.parseInt (decoderMonth);
								
								if (decoderMonthInt > 12 || decoderMonthInt < 1)
								{
									int tracker = checkDecoder;
									System.out.println("The member join month for " + userClub.get(tracker).getFirstName() + " is invalid. Please edit it and try again. ");
									return;
								}
							}
							catch (NumberFormatException e)
							{
								int catcherFlag = checkDecoder;
								System.out.println("The member join date for " + userClub.get(catcherFlag).getFirstName() + " is invalid. Please edit it and try again. ");
								return;
							}
							
							int comparisonAgain = (Integer.parseInt(memberMonth) - (Integer.parseInt(decoderMonth)));
							
							if (comparisonAgain < 0 && countMonth > checkDecoder)
							{
								Member temp = userClub.get (countMonth);
								userClub.set (countMonth, userClub.get (checkDecoder));
								userClub.set (checkDecoder, temp);
							}
							
							else if (comparisonAgain > 0 && countMonth < checkDecoder)
							{
								Member temp = userClub.get (countMonth);
								userClub.set (countMonth, userClub.get (checkDecoder));
								userClub.set (checkDecoder, temp);
							}
							
							else
							{
								for (int lastCheck = 0; lastCheck < userClub.size ( ); lastCheck++)
								{
									String memberDay = userClub.get(lastCheck).getJoinDate ( ).substring (3, 5);
									
									try
									{
										int keyMemberDay = Integer.parseInt (memberDay);
										
										// verifies the day is within expectations
										if (keyMemberDay > 31 || keyMemberDay < 1)
										{
											int tracker = lastCheck;
											System.out.println("The member join day for " + userClub.get(tracker).getFirstName() + " is invalid. Please edit it and try again. ");
											return;
										}
									}
									catch (NumberFormatException e)
									{
										int catcherFlag = lastCheck;
										System.out.println("The member join date for " + userClub.get(catcherFlag).getFirstName() + " is invalid. Please edit it and try again. ");
										return;
									}
									
									for (int lastDecoder = 0; lastDecoder < userClub.size ( ); lastDecoder++)
									{
										String decoderDay = userClub.get(lastDecoder).getJoinDate ( ).substring (3, 5);
										
										try
										{
											int decoderDayInt = Integer.parseInt (decoderDay);
											
											if (decoderDayInt > 31 || decoderDayInt < 1)
											{
												int tracker = lastDecoder;
												System.out.println("The member join day for " + userClub.get(tracker).getFirstName() + " is invalid. Please edit it and try again. ");
												return;
											}
										}
										catch (NumberFormatException e)
										{
											int catcherFlag = lastDecoder;
											System.out.println("The member join date is for " + userClub.get(catcherFlag).getFirstName() + " is invalid. Please edit it and try again. ");
											return;
										}
										
										int lastComparison = (Integer.parseInt(memberDay) - (Integer.parseInt (decoderDay)));
										
										if (lastComparison < 0 && lastCheck > lastDecoder)
										{
											Member temp = userClub.get (lastCheck);
											userClub.set (lastCheck, userClub.get (lastDecoder));
											userClub.set (lastDecoder, temp);
										}
										
										else if (lastComparison > 0 && lastCheck < lastDecoder)
										{
											Member temp = userClub.get (lastCheck);
											userClub.set (lastCheck, userClub.get (lastDecoder));
											userClub.set (lastDecoder, temp);
										}
										
										else
										{
											// Do nothing
										}
										
										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * clubFromFile method works with the fillFromFile method in the Club class to use a file to create a new club         
	 *
	 * <hr>
	 * Date created: Apr 5, 2021
	 *
	 * <hr>
	 */
	public static void clubFromFile()
	{
		JFileChooser fileChooser = new JFileChooser("ClubData");
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt", "text");
		fileChooser.setFileFilter (filter);
		fileChooser.setDialogTitle ("Select Text File to Import");
		int status = fileChooser.showOpenDialog(null);
		
		if (status == JFileChooser.APPROVE_OPTION)
		{
			
			File file = fileChooser.getSelectedFile();
			String userFileInput = file.getPath ( );
			
		
				userClub.fillFromFile(userFileInput);
				
				System.out.println("The Club was imported from the file! ");
				
				System.out.println("Any member with Type CORRUPT TYPE has an incorrect member type and must be corrected. +" +
								"Please edit these members for accurracy. ");
				return;
			
			/**
			catch (Exception e)
			{
				JOptionPane.showMessageDialog (null, "The file could not be read or contained incorrect data. ");
				return;
			}
			*/
			
		}
		
		else
		{
			JOptionPane.showMessageDialog (null, "No file selected! Unable to continue. ");
			return;
		}
	}
	
	/**
	 * 
	 * saveClubToFile allows the user to designate a specific folder to save a club to.         
	 *
	 * <hr>
	 * Date created: Apr 5, 2021
	 *
	 * <hr>
	 */
	public static void saveClubToFile()
	{
		JFileChooser fileChooser = new JFileChooser("ClubData");
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt", "text");
		fileChooser.setFileFilter (filter);
		fileChooser.setDialogTitle ("Select Club Save Destination");
		int status = fileChooser.showSaveDialog(null);
		
		if (status == JFileChooser.APPROVE_OPTION)
		{
			File file = fileChooser.getSelectedFile();
			String userSaveSpot = file.getPath();
			
			try
			{
				userClub.saveToFile (userSaveSpot);
				
				System.out.println("The Club was saved to the file! ");
				return;
			}
			catch (Exception e)
			{
				System.out.println("An error occurred and prevented the file from being saved. ");
				return;
			}
			
		}
		
		else
		{
			System.out.println("No file selected! Returning to menu. ");
			return;
		}
	}
}
