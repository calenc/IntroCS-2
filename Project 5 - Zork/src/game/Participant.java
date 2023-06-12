/**
 * ---------------------------------------------------------------------------
 * File name: Participant.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package game;


/**
 * This class separates the player from monsters and other objects by serving as a super class to people and monsters.
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Calen Cummings
 */
public class Participant
{
	// These fields will apply to all characters in the game (Player or monster)
	private String name;
	private int healthPoints;
	private int attackPoints;
	
	/**
	 * 
	 * Default Constructor, sets fields to chosen default values.        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 *
	 */
	public Participant()
	{
		this.name = "Unknown";
		this.healthPoints = 0;
		this.attackPoints = 0;
	}
	
	/**
	 * 
	 * Parameterized Constructor that takes health, attack, and name arguments.       
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * 
	 * @param health
	 * @param attack
	 */
	public Participant(int health, int attack, String name)
	{
		this.name = name;
		this.healthPoints = health;
		this.attackPoints = attack;
	}
	
	/**
	 * 
	 * get method for all derived classes and other classes to be able to read the field.         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @return healthPoints
	 */
	public int getHealthPoints()
	{
		return this.healthPoints;
	}
	
	/**
	 * 
	 * Set method for health for subclasses to access fields        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param health
	 */
	public void setHealthPoints(int health)
	{
		this.healthPoints = health;
	}
	
	/**
	 * 
	 * get method that makes the attack points field accessible by derived and outside classes.         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @return attackPoints
	 */
	public int getAttackPoints()
	{
		return this.attackPoints;
	}
	
	/**
	 * 
	 * Set method for subclasses to reach attack points field         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param attack
	 */
	public void setAttackPoints(int attack)
	{
		this.attackPoints = attack;
	}

	/**
	 * 
	 * allows derived classes to reach the name field and return its value.       
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @return name
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * 
	 * allows derived classes to reach and alter the name field.         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
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
		return "Participant [name=" + name + ", healthPoints=" + healthPoints + ", attackPoints=" + attackPoints + "]";
	}
}
