/**
 * ---------------------------------------------------------------------------
 * File name: RockTitan.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package game;


/**
 * This derived class allows for a class to create a Rock Titan monster, a bulky opponent that deals low damage.
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Calen Cummings
 */
public class RockTitan extends Monster
{
	// We only need one type of Rock Titan to exist, so we create a no-arg constructor and have it create the monster with
	// the parameterized constructor from the superclass.
	
	/**
	 * 
	 * Calls the superclass constructor to make the Rock Titan monster type        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 *
	 */
	public RockTitan()
	{
		// Creates a monster called Rock Titan and gives it 45 health points, 4 attack points, and assigns it the screen tag RT.
		super(45, 4, "Rock Titan", "RT", true);
		
	}
	
	/**
	 * 
	 * returns the health value of a Rock Titan; overrides the superclass method.         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021 
	 *
	 * <hr>
	 * @return healthPoints
	 * @see game.Monster#getHealthPoints()
	 */
	public int getHealthPoints()
	{
		return super.getHealthPoints();
	}
	
	/**
	 * 
	 * overrides the superclass method to set health points.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021 
	 *
	 * <hr>
	 * @param health
	 * @see game.Monster#setHealthPoints(int)
	 */
	public void setHealthPoints(int health)
	{
		super.setHealthPoints (health);
	}
	
	/**
	 * 
	 * Returns the attack points of a Rock Titan; overrides the superclass method.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021 
	 *
	 * <hr>
	 * @return attackPoints
	 * @see game.Monster#getAttackPoints()
	 */
	public int getAttackPoints()
	{
		return super.getAttackPoints();
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
		return "RockTitan [getName()=" + getName ( ) + ", getScreenCode()=" + getScreenCode ( ) + ", getAlive()=" +
						getAlive ( ) + ", getClass()=" + getClass ( ) + ", hashCode()=" + hashCode ( ) +
						", toString()=" + super.toString ( ) + "]";
	}
	
	
}
