/**
 * ---------------------------------------------------------------------------
 * File name: Person.java
 * Project name: HelloWorld2
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Jan 20, 2021
 * ---------------------------------------------------------------------------
 */

package test;


/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Jan 20, 2021
 * <hr>
 * @author Calen Cummings
 */
public class Person
{
	private String firstName;
	private String lastName;
	private int age;
	
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
	 * @return age
	 */
	public int getAge ( )
	{
		return age;
	}
	
	/**
	 * @param age the age to set
	 */
	public void setAge (int age)
	{
		this.age = age;
	}

	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Jan 20, 2021 
	 *
	 * 
	 * @param firstName
	 * @param lastName
	 * @param age
	 */
	public Person (String firstName, String lastName, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	/**
	 * Enter method description here         
	 *
	 * <hr>
	 * Date created: Jan 20, 2021 
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Jan 20, 2021 
	 *
	 * 
	 */
	public Person ( )
	{
		super ( );
	}
	
	
}
