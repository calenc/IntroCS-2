/**
 * ---------------------------------------------------------------------------
 * File name: Weapon.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package game;


/**
 * Weapon class serves as a superclass for multiple weapon types.
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Calen Cummings
 */
public class Weapon
{
	private String name;
	private int attackDmg;
	private String screenCode;
	
	
	/**
	 * 
	 * Default Constructor, creates a weapon with default fields.        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 *
	 */
	public Weapon()
	{
		this.name = "Unknown";
		this.attackDmg = 0;
		this.screenCode = "  ";
		
	}
	
	/**
	 * 
	 * Parameterized Constructor, allows for different types of weapons to be created.        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * 
	 * @param n
	 * @param dmg
	 * @param code
	 */
	public Weapon(String n, int dmg, String code)
	{
		this.name = n;
		this.attackDmg = dmg;
		this.screenCode = code;
	}
	
	/**
	 * 
	 * get method to make the attack damage value of any weapon accessible to outside classes.         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @return attackDmg
	 */
	public int getAttackDmg()
	{
		return this.attackDmg;
	}
	
	/**
	 * 
	 * set method for damage that will likely go unused, but is accessible to outside classes.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param dmg
	 */
	public void setAttackDmg(int dmg)
	{
		this.attackDmg = dmg;
	}
	
	/**
	 * 
	 * getter method that returns the name of the weapon, accessible by outside classes.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @return name
	 */
	public String weapName()
	{
		return this.name;
	}
	
	/**
	 * 
	 * This set method will go unused but is present for additional use.          
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param name
	 */
	public void setWeapName(String name)
	{
		this.name = name;
	}
	
	/**
	 * 
	 * set method for the screen code so derived and outside classes have access to change the screen code field.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param code
	 */
	public void setScreenCode(String code)
	{
		this.screenCode = code;
	}
	
	/**
	 * 
	 * get method for the screen code so the driver can display it for user readability.
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @return screenCode
	 */
	public String getScreenCode()
	{
		return this.screenCode; 
	}

	/**
	 * toString for the class.         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021 
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString ( )
	{
		return "Weapon [name=" + name + ", attackDmg=" + attackDmg + ", screenCode=" + screenCode + "]";
	}
}
