/**
 * ---------------------------------------------------------------------------
 * File name: SteelDraconid.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package game;


/**
 * This derived class allows for a class to create a Steel Draconid monster, a balanced threat that will require a weapon for triumph.
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Calen Cummings
 */
public class SteelDraconid extends Monster
{
	/**
	 * 
	 * Calls superclass constructor to create a new monster type, Steel Draconid. The Steel Draconid is a balanced threat that will be 
	 * difficult to defeat without a weapon.       
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 *
	 */
	public SteelDraconid()
	{
		super (50, 15, "Steel Draconid", "SD", true);
		
	}
	
	/**
	 * 
	 * get health method that overrides the superclass method. Makes the health of the Draconid reachable for other methods.         
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
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
	 * set method for the health points to be altered for battle in other classes         
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
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
	 * get attack method to read attack stat and use for battle in other classes.        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
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
		return "SteelDraconid [getName()=" + getName ( ) + ", getScreenCode()=" + getScreenCode ( ) + ", getAlive()=" +
						getAlive ( ) + ", getClass()=" + getClass ( ) + ", hashCode()=" + hashCode ( ) +
						", toString()=" + super.toString ( ) + "]";
	}
	
}
