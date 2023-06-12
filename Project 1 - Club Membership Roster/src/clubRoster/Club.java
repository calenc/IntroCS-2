/**
 * ---------------------------------------------------------------------------
 * File name: Club.java
 * Project name: Project 1 - Club Membership Roster
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Mar 5, 2021
 * ---------------------------------------------------------------------------
 */

package clubRoster;

/**
 * The ArrayList class of Java must be imported so that we can create array lists.
 * 
 * <hr>
 * Date created: Mar 5, 2021
 * <hr>
 * @author Calen Cummings
 */
import java.util.ArrayList;

/**
 * The Scanner class allows us to create more in-depth methods within this class to make our driver more fluid
 * 
 * <hr>
 * Date created: Mar 16, 2021
 * <hr>
 * @author Calen Cummings
 */
import java.util.Scanner;


// All of these imports are necessary to use Files to fill input, allow the user to write to a File, and handle a FileNotFound exception
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * The Club class will allow us to maintain an array list of members.
 *
 * <hr>
 * Date created: Mar 5, 2021
 * <hr>
 * @author Calen Cummings
 */
public class Club
{
	private ArrayList<Member> roster;
	private String clubName;
	private String head;
	private int foundingYear;
	private boolean saveNeeded;
	
	
	/**
	 * @return saveNeeded
	 */
	public boolean isSaveNeeded ( )
	{
		return saveNeeded;
	}

	
	/**
	 * @param saveNeeded the saveNeeded to set
	 */
	public void setSaveNeeded (boolean saveNeeded)
	{
		this.saveNeeded = saveNeeded;
	}

	/**
	 * 
	 * Default Constructor        
	 *
	 * <hr>
	 * Date created: Mar 15, 2021 
	 *
	 *
	 */
	public Club()
	{
		this.roster = new ArrayList<Member>();
		this.clubName = null;
		this.head = null;
		this.foundingYear = 0;
		
	}
	
	/**
	 * 
	 * Copy Constructor        
	 *
	 * <hr>
	 * Date created: Mar 16, 2021 
	 *
	 * 
	 * @param existingClub
	 */
	public Club(Club existingClub)
	{
		this.roster = new ArrayList<Member>(existingClub.roster.size());
		
		for (int count = 0; count < existingClub.roster.size ( ); count++)
		{
			this.roster.add (existingClub.roster.get(count));
		}
		
		this.clubName = existingClub.getClubName ( );
		this.head = existingClub.getHead ( );
		this.foundingYear = existingClub.getFoundingYear();
		
	}
	
	/**
	 * 
	 * Parameterized Constructor        
	 *
	 * <hr>
	 * Date created: Mar 15, 2021 
	 *
	 * 
	 * @param roster
	 * @param clubName
	 * @param head
	 * @param foundingYear
	 */
	public Club(ArrayList<Member> roster, String clubName, String head, int foundingYear)
	{
		this.roster = roster;
		this.clubName = clubName;
		this.head = head;
		this.foundingYear = foundingYear;
		
		
	}
	
	
	/**
	 * @return clubName
	 */
	public String getClubName ( )
	{
		return clubName;
	}

	
	/**
	 * @param clubName the clubName to set
	 */
	public void setClubName (String clubName)
	{
		this.clubName = clubName;
		
		saveNeeded = true;
	}

	
	/**
	 * @return head
	 */
	public String getHead ( )
	{
		return head;
	}

	
	/**
	 * @param head the head to set
	 */
	public void setHead (String head)
	{
		this.head = head;
		
		saveNeeded = true;
	}

	
	/**
	 * @return year
	 */
	public int getFoundingYear ( )
	{
		return foundingYear;
	}

	
	/**
	 * @param year the year to set
	 */
	public void setFoundingYear (int year)
	{
		this.foundingYear = year;
		
		saveNeeded = true;
	}
	
	
	/**
	 * toString to represent a given Club at any point         
	 *
	 * <hr>
	 * Date created: Mar 17, 2021 
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		String str = "";
		
		str += "Club: " + this.clubName + "\nClub Leader: " + this.head + "\nFounded: " + this.foundingYear + "Current Roster: \n";
		
		for (int count = 0; count < this.roster.size ( ); count++)
		{
			str += this.roster.get(count).toString ( );
		}
		return str;
	}

	/**
	 * 
	 * The get method in this class allows our driver to reach the Member objects in our roster.         
	 *
	 * <hr>
	 * Date created: Mar 18, 2021
	 *
	 * <hr>
	 * @param index
	 * @return
	 */
	public Member get(int index)
	{
		return this.roster.get (index);
		
	}
	
	/**
	 * 
	 * set method in this class allows our driver to set members for our roster        
	 *
	 * <hr>
	 * Date created: Mar 18, 2021
	 *
	 * <hr>
	 * @param index
	 * @param member
	 */
	public void set(int index, Member member)
	{
		this.roster.set (index, member);
		
		saveNeeded = true;
	}
	
	/**
	 * 
	 * size in this class allows our driver to be able to reach the size of our roster       
	 *
	 * <hr>
	 * Date created: Mar 18, 2021
	 *
	 * <hr>
	 * @param arraySize
	 * @return
	 */
	public int size()
	{
		return this.roster.size ( );
		
	}
	
	/**
	 * 
	 * remove method in this class gives our driver access to directly remove a member from the roster. It saves the name of the member in the index
	 * and displays that name at the end to show they were removed.        
	 *
	 * <hr>
	 * Date created: Mar 18, 2021
	 *
	 * <hr>
	 * @param index
	 */
	public void remove(int index)
	{
		this.roster.remove (index);
		
		saveNeeded = true;
	}
	
	/**
	 * 
	 * addMember method allows our driver to be able to add Member objects to a specific club.         
	 *
	 * <hr>
	 * Date created: Mar 17, 2021
	 *
	 * <hr>
	 */
	public void addMember(Member m)
	{
		this.roster.add (m);
		
		saveNeeded = true;
	}
	
	/**
	 * 
	 * Sort method sorts a roster alphabetically by last, then first name.         
	 *
	 * <hr>
	 * Date created: Mar 18, 2021
	 *
	 * <hr>
	 */
	public void sortRoster()
	{
		// This method compares the Unicode values of the characters in each string to determine alphabetical order.
		// Making the entire string upper case for this sorting prevents a lower case letter causing an issue.
				
		for (int count = 0; count < this.roster.size ( ); count++)
		{
			String key = this.roster.get (count).getLastName ( ).toUpperCase();
					
			for (int alphabetCheck = 0; alphabetCheck < this.roster.size ( ); alphabetCheck++)
			{
				String decoder = this.roster.get (alphabetCheck).getLastName ( ).toUpperCase();
						
				int comparison = (key.compareTo(decoder));
						
				if (comparison < 0)
				{
					Member temp = this.roster.get (count);
					this.roster.set (count, this.roster.get (alphabetCheck));
					this.roster.set (alphabetCheck, temp);
				}
						
				else if (comparison > 0)
				{
					// Do nothing
				}
						
				else 
				{
					for (int countAgain = 0; countAgain < this.roster.size ( ); countAgain++)
					{
						String secondKey = this.roster.get (countAgain).getFirstName ( ).toUpperCase();
								
						for (int checkAgain = 0; checkAgain < this.roster.size ( ); checkAgain++)
						{
							String secondDecoder = this.roster.get (checkAgain).getFirstName ( ).toUpperCase();
									
							int comparisonAgain = (secondKey.compareTo (secondDecoder));
									
							if (comparisonAgain < 0)
							{
								Member temp = this.roster.get (count);
								this.roster.set (count, this.roster.get (alphabetCheck));
								this.roster.set (alphabetCheck, temp);
							}
									
							else if (comparisonAgain > 0)
							{
								// Do nothing
							}
						}
					}
				}
			}
		}
		
		saveNeeded = true;
	}
	
	/**
	 * 
	 * search method takes String parameter of a first name and searches the roster for a match.         
	 *
	 * <hr>
	 * Date created: Apr 5, 2021
	 *
	 * <hr>
	 */
	public int search(String name)
	{
		int index = 0;
		int	element = -1;
		boolean found = false;
				
		while (element == -1)
		{
			while ( !found && index < this.roster.size ( ))
			{
				if (this.roster.get (index).getFirstName ( ).equals (name))
				{
					found = true;
					element = index;
				}

				index++ ;
			} 
					
		}
		
		return element;
	}
	
	/**
	 * 
	 * searchLast method is identical to search method except it goes by last name, to provide another chance for user to identify correct
	 * search results from the roster.         
	 *
	 * <hr>
	 * Date created: Apr 5, 2021
	 *
	 * <hr>
	 * @param name
	 * @return
	 */
	public int searchLast(String name)
	{
		int index = 0;
		int	element = -1;
		boolean found = false;
				
		while (element == -1)
		{
			while ( !found && index < this.roster.size ( ))
			{
				if (this.roster.get (index).getLastName ( ).equals (name))
				{
					found = true;
					element = index;
				}

				index++ ;
			} 
					
		}
		
		return element;
	}
	
	/**
	 * 
	 * fillFromFile method takes a file path as a string parameter and uses the file to fill a club with member objects.         
	 *
	 * <hr>
	 * Date created: Apr 5, 2021
	 *
	 * <hr>
	 * @param filePath
	 */
	public void fillFromFile(String filePath)
	{
			
		File userFile = new File(filePath);
			
		try
		{
			Scanner inputFile = new Scanner(userFile);
		
			BufferedReader buff = new BufferedReader(new FileReader(userFile));
			String fileClubInfo = buff.readLine();
			
			String[] firstLine = fileClubInfo.split ("\\|");
			
			this.clubName = firstLine[0];
			this.head = firstLine[1];
			this.foundingYear = Integer.parseInt(firstLine[2]);
			
			
			// Reading each line of the file and creating a new Book object for each line
			while (inputFile.hasNext())
			{
				String str = inputFile.nextLine();
				String[] fields = str.split ("\\|");
						
				try
				{
					Member nextMember = new Member(fields [0], fields[1], fields[2], fields[3], MemberType.valueOf (fields[4]), fields[5], fields[6]);
					this.roster.add(nextMember);
				}
				catch (Exception e)
				{
					Member nextMember = new Member(fields [0], fields[1], fields[2], fields[3], MemberType.Junior, fields[5], fields[6]);
					this.roster.add(nextMember);
				}
						
			}
					
			inputFile.close ();
		}
		catch (FileNotFoundException e1)
		{
			return;
		}
		catch (IOException e1)
		{
			return;
		}
				
		saveNeeded = false;
	}
	
	/**
	 * 
	 * saveToFile method writes to a file and replaces anything currently in the file.         
	 *
	 * <hr>
	 * Date created: Apr 5, 2021
	 *
	 * <hr>
	 */
	public void saveToFile(String filePath)
	{
		try
		{
			PrintWriter pw = new PrintWriter (filePath);
			
			pw.println(this.clubName + "|" + this.head + "|" + this.foundingYear);
			
			for(int index = 0; index < this.roster.size ( ); index++)
			{
				
				try
				{
					pw.println(this.roster.get (index).getFirstName() + "|" + this.roster.get(index).getLastName() + "|" + this.roster.get (index).getCity() +
						"|" + this.roster.get (index).getState() + "|" + this.roster.get (index).getMemberType() + "|" + 
									this.roster.get (index).getJoinDate() + "|" + this.roster.get (index).getPhoto());
				}
				catch (Exception e)
				{
					return;
				}
				
			}
			pw.close ( );
		}
		catch (FileNotFoundException e)
		{
			return;
		}
		
		saveNeeded = false;
	}
}
