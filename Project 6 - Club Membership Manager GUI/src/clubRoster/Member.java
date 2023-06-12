/**
 * ---------------------------------------------------------------------------
 * File name: Member.java Project name: Project 1 - Club Membership Roster
 * ---------------------------------------------------------------------------
 * Creator's name and email: Don Bailes, bailes@etsu.edu Course: CSCI 1260
 * Creation Date: Sep 8, 2015
 * ---------------------------------------------------------------------------
 */

package clubRoster;

/**
 * Representation of a Club Member
 *
 * <hr>
 * Date created: Sep 8, 2015
 * <hr>
 * 
 * @author Don Bailes
 */
public class Member
{
	private String		lastName;
	private String		firstName;
	private String		city;
	private String		state;
	private String		dateJoined;
	private String		photo;
	private MemberType	type;

	/**
	 * Default Constructor
	 *
	 * <hr>
	 * Date created: Sep 8, 2015
	 *
	 */
	public Member ( )
	{
		lastName = "";
		firstName = "";
		city = "Johnson City";
		state = "TN";
		dateJoined = "12/31/1900";
		type = MemberType.Provisional;
		photo = "none.jpg";
	}

	/**
	 * Parameterized Constructor
	 *
	 * <hr>
	 * Date created: Sep 8, 2015
	 *
	 * @param lastName
	 *            member last name
	 * @param firstName
	 *            member first name
	 * @param city
	 *            member city address
	 * @param state
	 *            member state address
	 * @param dateJoined
	 *            date joined club
	 * @param photo
	 *            file name of recent photo
	 * @param type
	 *            membership type
	 */
	public Member (	String lastName, String firstName, String city, String state, String dateJoined,
					String photo, MemberType type)
	{
		this.lastName = lastName;
		this.firstName = firstName;
		this.city = city;
		this.state = state;
		this.dateJoined = dateJoined;
		this.photo = photo;
		this.type = type;
	}

	/**
	 * @return lastName
	 */
	public String getLastName ( )
	{
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName (String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName ( )
	{
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName (String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return city
	 */
	public String getCity ( )
	{
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity (String city)
	{
		this.city = city;
	}

	/**
	 * @return state
	 */
	public String getState ( )
	{
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState (String state)
	{
		this.state = state;
	}

	/**
	 * @return dateJoined
	 */
	public String getDateJoined ( )
	{
		return dateJoined;
	}

	/**
	 * @param dateJoined
	 *            the dateJoined to set
	 */
	public void setDateJoined (String dateJoined)
	{
		this.dateJoined = dateJoined;
	}

	/**
	 * @return photo
	 */
	public String getPhoto ( )
	{
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto (String photo)
	{
		this.photo = photo;
	}

	/**
	 * @return type
	 */
	public MemberType getType ( )
	{
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType (MemberType type)
	{
		this.type = type;
	}

	/**
	 * Return last name comma first name
	 *
	 * <hr>
	 * Date created: Sep 8, 2015
	 *
	 * <hr>
	 * 
	 * @return the whole name, last name first
	 */
	public String getName ( )
	{
		return lastName + ", " + firstName;
	}

	/**
	 * Format object of type Member as a String for possible display by another
	 * class
	 *
	 * Date created: Sep 8, 2015
	 * 
	 * @return the formatted string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		String resultOut = "";
		resultOut = "Member Name:\t" + getName ( ) + "\n";
		resultOut += "Address:\t" + city + ", " + state + "\n";
		resultOut += "Member Since:\t" + dateJoined;
		resultOut += "\tPhoto: " + photo + "\n";
		resultOut += "Member Type:\t" + type + "\n";
		return resultOut;
	}// end toString

	/**
	 * Return the year that the member joined the club
	 *
	 * <hr>
	 * Date created: Oct 2, 2015
	 *
	 * <hr>
	 * 
	 * @return the year the member joined the club
	 */
	public int getYearJoined ( )
	{
		int year;
		String [ ] fields = dateJoined.split ("/");
		year = Integer.parseInt (fields [2]);
		return year;
	}
}
