/**
 * ---------------------------------------------------------------------------
 * File name: StartCell.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 17, 2021
 * ---------------------------------------------------------------------------
 */

package game;


/**
 * This derived class makes sure the start cell is always separate from the other cells in the dungeon.
 *
 * <hr>
 * Date created: Apr 17, 2021
 * <hr>
 * @author Calen Cummings
 */
public class StartCell extends DungeonRoom
{
	// For the start cell, we just need to set west to false and make sure that the player can only continue east into the dungeon.
	
	public StartCell()
	{
		super(true, false);
		
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
		return "StartCell [doorEast()=" + doorEast ( ) + ", doorWest()=" + doorWest ( ) + ", toString()=" +
						super.toString ( ) + ", getClass()=" + getClass ( ) + ", hashCode()=" + hashCode ( ) + "]";
	}
	
	
}
