/**
 * ---------------------------------------------------------------------------
 * File name: FrigidPhantom.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package game;


/**
 * This derived class allows for a class to create a Frigid Phantom, a chilling spectre with a small health pool but devastating attack power.
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Calen Cummings
 */
public class FrigidPhantom extends Monster
{
	// As with the Rock Titan, we want our Phantom defined one way so only a no-arg constructor is created.
	
	/**
	 * 
	 * Calls the superclass constructor to create a monster of type Frigid Phantom. Sets health points to 20 and attack to 25.       
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 *
	 */
	public FrigidPhantom()
	{
		super (20, 25, "Frigid Phantom", "FP", true);
		
	}
	
	/**
	 * 
	 * get method to check the Phantom's health points.         
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
	 * set method for the Phantom's health to be altered by other classes         
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
		super.setHealthPoints(health);
	}
	
	/**
	 * 
	 * get method for the Phantom's attack point value.         
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
		return "FrigidPhantom [getName()=" + getName ( ) + ", getScreenCode()=" + getScreenCode ( ) + ", getAlive()=" +
						getAlive ( ) + ", toString()=" + super.toString ( ) + ", getClass()=" + getClass ( ) +
						", hashCode()=" + hashCode ( ) + "]";
	}
}
