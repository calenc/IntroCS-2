/**
 * ---------------------------------------------------------------------------
 * File name: Club.java Project name: Project 3 - Club Roster
 * ---------------------------------------------------------------------------
 * Creator's name and email: Don Bailes, bailes@etsu.edu Course: CSCI 1260
 * Creation Date: Oct 2, 2015
 * ---------------------------------------------------------------------------
 */

package clubRoster;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Model a Club organization with a name, leader, date created, and a membership
 * roster
 *
 * <hr>
 * Date created: Oct 2, 2015
 * <hr>
 * 
 * @author Don Bailes
 */
public class Club
{
	private String				clubName	= null;
	private String				head		= null;
	private int					yearStarted;
	private ArrayList <Member>	roster		= null;
	private boolean				saveNeeded	= false;

	/**
	 * Default Constructor
	 *
	 * <hr>
	 * Date created: Oct 2, 2015
	 *
	 */
	public Club ( )
	{
		clubName = "Default Name";
		head = "I. M. Head";
		roster = new ArrayList <Member> ( );
		Calendar c = Calendar.getInstance ( );
		yearStarted = c.get (Calendar.YEAR) - 1900;
		saveNeeded = true;
	}

	/**
	 * Parameterized Constructor
	 *
	 * <hr>
	 * Date created: Oct 2, 2015
	 * 
	 * @param clubName
	 *            name of the club
	 * @param head
	 *            name of the current leader of the club
	 * @param year
	 *            year that the club was founded
	 */
	public Club (String clubName, String head, int year)
	{
		this.clubName = clubName;
		this.head = head;
		this.yearStarted = year;
		roster = new ArrayList <Member> ( );
		saveNeeded = true;
	}

	/**
	 * Copy Constructor
	 *
	 * <hr>
	 * Date created: Oct 2, 2015
	 *
	 * @param existingClub
	 *            name of the existing club
	 */
	public Club (Club existingClub)
	{
		clubName = existingClub.clubName;
		head = existingClub.head;
		yearStarted = existingClub.yearStarted;
		roster = new ArrayList <Member> (existingClub.roster);
		saveNeeded = true;
	}

	/**
	 * Open the specified text file and populate the Club object from it
	 *
	 * <hr>
	 * Date created: Oct 19, 2015
	 *
	 * <hr>
	 * 
	 * @param filePath
	 *            text file name and path to be opened
	 */
	public void fillFromFile (String filePath) throws Exception
	{
		Scanner file = null;
		String line;
		try
		{
			file = new Scanner (new File (filePath));
			line = file.nextLine ( );
			String [ ] clubData = line.split ("\\|");
			if (clubData.length != 3)
				throw new Exception (
								"\nInvalid club data in the input file.\nRest of file skipped");
			this.setClubName (clubData [0]);
			this.setHead (clubData [1]);
			this.setYear (Integer.parseInt (clubData [2]));

			while (file.hasNext ( ))
			{
				line = file.nextLine ( );
				String [ ] fields = line.split ("\\|");
				if (fields.length != 7)
					throw new Exception ("Invalid Member data in the input file on the line: '" +
									line + "'\nRest of input file was skipped.");
				Member m = new Member (fields [1], fields [0], fields [2], fields [3], fields [5],
								fields [6], MemberType.valueOf (fields [4]));
				roster.add (m);
			}
		}
		finally
		{
			if (file != null)
				file.close ( );
			saveNeeded = false;
		}
	}

	/**
	 * @return clubName
	 */
	public String getClubName ( )
	{
		return clubName;
	}

	/**
	 * @param clubName
	 *            the clubName to set
	 */
	public void setClubName (String clubName)
	{
		this.clubName = clubName;
		saveNeeded = true;
	}

	/**
	 * Getter for saveNeeded flag
	 *
	 * <hr>
	 * Date created: Oct 19, 2015
	 *
	 * <hr>
	 * 
	 * @return saveNeeded
	 */
	public boolean isSaveNeeded ( )
	{
		return saveNeeded;
	}

	/**
	 * @return head
	 */
	public String getHead ( )
	{
		return head;
	}

	/**
	 * @param head
	 *            the head to set
	 */
	public void setHead (String head)
	{
		this.head = head;
		saveNeeded = true;
	}

	/**
	 * @return year
	 */
	public int getYear ( )
	{
		return yearStarted;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear (int year)
	{
		this.yearStarted = year;
		saveNeeded = true;
	}

	/**
	 * Return the number of club members
	 *
	 * <hr>
	 * Date created: Oct 2, 2015
	 *
	 * <hr>
	 * 
	 * @return
	 */
	public int getClubSize ( )
	{
		return roster.size ( );
	}

	/**
	 * Format object of type Club as a String for possible display by another
	 * class
	 *
	 * Date created: Oct 2, 2015
	 * 
	 * @return the formatted string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		String resultOut = "";
		resultOut = "Club:\t\t" + clubName + "\n";
		resultOut += "Club leader:\t" + head + "\n";
		resultOut += "Founded in:\t" + yearStarted + "\n\n";
		resultOut += "Club Roster:\t" + "\n-----------\n\n";

		if (roster.size ( ) == 0)
			resultOut += "There are no members";
		else
			for (int n = 1; n <= roster.size ( ); n++ )
				resultOut += roster.get (n - 1) + "\n";

		return resultOut + "\n\n";
	} // end toString

	/**
	 * Add a member to the roster
	 *
	 * <hr>
	 * Date created: Oct 2, 2015
	 *
	 * <hr>
	 * 
	 * @param mem
	 *            new member to be added
	 */
	public void addMember (Member mem)
	{
		roster.add (mem);
		saveNeeded = true;
	}

	/**
	 * Remove a member with the specified name from the roster if there is such
	 * a member; otherwise do nothing
	 *
	 * <hr>
	 * Date created: Oct 2, 2015
	 *
	 * <hr>
	 * 
	 * @param name
	 *            the name of the member to be removed; must be in the form of
	 *            "last, first"
	 */
	public void removeMember (String name)
	{
		for (int n = 0; n < roster.size ( ); n++ )
		{
			if (name.equalsIgnoreCase (roster.get (n).getName ( )))
			{
				roster.remove (n);
				saveNeeded = true;
				return;
			}
		}
	}

	/**
	 * Return a member with the given name; return null if no such member
	 *
	 * <hr>
	 * Date created: Oct 2, 2015
	 *
	 * <hr>
	 * 
	 * @param name
	 *            name of the member to be returned; must be in the form of
	 *            "last, first"
	 * @return Member with the specified name
	 */
	public Member findByName (String name)
	{
		for (Member mem : roster)
		{
			if (mem.getName ( ).equalsIgnoreCase (name))
				return mem;
		}

		return null;
	}

	/**
	 * Return an ArrayList<Member> all of whom are of the specified MemberType
	 *
	 * <hr>
	 * Date created: Oct 2, 2015
	 *
	 * <hr>
	 * 
	 * @param type
	 *            the MemberType of the selected members
	 * @return an ArrayList containing all member of the specified type
	 */
	public ArrayList <Member> findByMemberType (MemberType type)
	{
		ArrayList <Member> list = new ArrayList <Member> ( );
		for (Member mem : roster)
			if (mem.getType ( ).equals (type))
				list.add (mem);

		return list;
	}

	/**
	 * Replace an existing member with a new member; can be used to edit a
	 * member by replacing the existing member with the edited member
	 *
	 * <hr>
	 * Date created: Oct 2, 2015
	 *
	 * <hr>
	 * 
	 * @param oldMember
	 *            member to be replaced
	 * @param newMember
	 *            member to replace existing member
	 */
	public void replaceMember (Member oldMember, Member newMember)
	{
		int n = roster.indexOf (oldMember);
		if (n >= 0)
		{
			roster.set (n, newMember);
			saveNeeded = true;
		}
	}

	/**
	 * Find the last name alphabetically in the first size positions in the
	 * roster and return its index
	 *
	 * <hr>
	 * Date created: Oct 2, 2015
	 *
	 * <hr>
	 * 
	 * @param size
	 *            the number of positions to search
	 * @return the index of the member with the last name alphabetically
	 */
	private int findMaxName (int size)
	{
		int max = 0;
		for (int n = 1; n < size; n++ )
		{
			if (roster.get (max).getName ( ).compareTo (roster.get (n).getName ( )) < 0)
				max = n;
		}
		return max;
	}

	/**
	 * Sort the roster alphabetically by member name
	 *
	 * <hr>
	 * Date created: Oct 2, 2015
	 *
	 * <hr>
	 */
	public void sortByName ( )
	{
		Member temp;
		int max;
		for (int n = roster.size ( ); n > 1; n-- )
		{
			max = findMaxName (n);
			if (max != n - 1)
			{
				temp = roster.get (max);
				roster.set (max, roster.get (n - 1));
				roster.set (n - 1, temp);
				saveNeeded = true;
			}
		}
	}

	/**
	 * Find the member from the first size members who has been a club member
	 * longest
	 *
	 * <hr>
	 * Date created: Oct 2, 2015
	 *
	 * <hr>
	 * 
	 * @param size
	 *            the number of members to consider
	 * @return the index of the member with the longest membership
	 */
	private int findMaxYears (int size)
	{
		int max = 0;
		for (int n = 1; n < size; n++ )
		{
			if (roster.get (max).getYearJoined ( ) > roster.get (n).getYearJoined ( ))
				max = n;
		}
		return max;
	}

	/**
	 * Sort by years of membership
	 *
	 * <hr>
	 * Date created: Oct 20, 2015
	 *
	 * <hr>
	 */
	public void sortByYears ( )
	{
		Member temp;
		int max;
		for (int n = roster.size ( ); n > 1; n-- )
		{
			max = findMaxYears (n);
			if (max != n - 1)
			{
				temp = roster.get (max);
				roster.set (max, roster.get (n - 1));
				roster.set (n - 1, temp);
				saveNeeded = true;
			}
		}
	}

	/**
	 * Save all Club data to the specified text file
	 *
	 * <hr>
	 * Date created: Oct 20, 2015
	 *
	 * <hr>
	 * 
	 * @param path
	 *            the name and path to the file to be saved
	 */
	public void saveFile (String path) throws Exception
	{
		PrintWriter pw = new PrintWriter (path);
		String line = clubName + "|" + head + "|" + yearStarted;
		pw.println (line);
		for (Member m : roster)
		{
			line = m.getFirstName ( ) + "|";
			line += m.getLastName ( ) + "|";
			line += m.getCity ( ) + "|";
			line += m.getState ( ) + "|";
			line += m.getType ( ) + "|";
			line += m.getYearJoined ( ) + "|";
			line += m.getPhoto ( );
			pw.println (line);
		}
		pw.close ( );
		this.saveNeeded = false;
	}
}
