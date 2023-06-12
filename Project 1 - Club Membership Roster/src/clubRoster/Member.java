/**
 * ---------------------------------------------------------------------------
 * File name: Member.java
 * Project name: Club Membership Roster
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Feb 11, 2021
 * ---------------------------------------------------------------------------
 */

package clubRoster;


/**
 * The main class of the project. This is what our program will use to create members and store their
 * information for identification and verification.
 *
 * <hr>
 * Date created: Feb 11, 2021
 * <hr>
 * @author Calen Cummings
 */
public class Member
{
	// We start by creating our attribute fields
	
	private String lastName;
	private String firstName;
	private String city;
	private String state;
	private MemberType memberType;
	private String joinDate;
	private String photo;
	
	//Getters and setters will be created for all attributes, even if unneeded to provide coverage. 
	/**
	 * The default constructor to create a Member object with blank fields.
	 * 
	 * <hr>
	 * Date created: Feb 11, 2021
	 * 
	 * 
	 * @param n/a
	 */
	public Member ( )
	{
		super();
		this.lastName = "John";
		this.firstName = "Deere";
		this.city = "Johnson City";
		this.state = "TN";
		this.memberType = MemberType.Junior;
		this.joinDate = "10/10/2000";
		this.photo = "defpic.jpg";
	}
	
	/**
	 * Constructor for a new club member.        
	 *
	 * <hr>
	 * Date created: Feb 11, 2021 
	 *
	 * 
	 * @param lastName
	 * @param firstName
	 * @param city
	 * @param state
	 * @param memberType
	 * @param joinDate
	 * @param photo
	 */
	public Member (	String lastName, String firstName, String city, String state, MemberType memberType, String joinDate,
					String photo)
	{
		this.lastName = lastName;
		this.firstName = firstName;
		this.city = city;
		this.state = state;
		this.memberType = memberType;
		this.joinDate = joinDate;
		this.photo = photo;
	}

	
	/**
	 * @return lastName
	 */
	public String getLastName ( )
	{
		return lastName;
	}

	
	/**
	 * @param lastName the lastName to set
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
	 * @param firstName the firstName to set
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
	 * @param city the city to set
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
	 * @param state the state to set
	 */
	public void setState (String state)
	{
		this.state = state;
	}

	
	/**
	 * @return memberType
	 */
	public MemberType getMemberType ( )
	{
		return memberType;
	}

	
	/**
	 * @param memberType the memberType to set
	 */
	public void setMemberType (MemberType memberType)
	{
		this.memberType = memberType;
	}

	
	/**
	 * @return joinDate
	 */
	public String getJoinDate ( )
	{
		return joinDate;
	}

	
	/**
	 * @param joinDate the joinDate to set
	 */
	public void setJoinDate (String joinDate)
	{
		this.joinDate = joinDate;
	}

	
	/**
	 * @return photo
	 */
	public String getPhoto ( )
	{
		return photo;
	}

	
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto (String photo)
	{
		this.photo = photo;
	}


	/**
	 * The toString to represent any given Member object's information/identification (current state).         
	 *
	 * <hr>
	 * Date created: Feb 12, 2021 
	 *
	 * <hr>
	 * @return A string meant to cleanly represent the current state of a given Member.
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		return ("\n\nMember Name:" + '\t' + lastName + ", " + firstName + '\n' + 
			"Address:" + '\t' + city + ", " + state + '\n' + "Member Since:" + 
			'\t' + joinDate + '\n' + "Member Type:" + '\t' + memberType + '\n' + 
			"Photo:" + "\t\t" + photo);
	}
	
	
	
}
