/**
 * ---------------------------------------------------------------------------
 * File name: DungeonRoom.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 12, 2021
 * ---------------------------------------------------------------------------
 */

package game;


/**
 * This class will make it possible to later create an array of dungeon rooms for the player to travel through, and individual rooms can be assigned 
 * random spawns like monsters and weapons.
 *
 * <hr>
 * Date created: Apr 12, 2021
 * <hr>
 * @author Calen Cummings
 */
public class DungeonRoom
{
	// These fields give each room a west or east exit, or both.
	private boolean goEast;
	private boolean goWest;
	
	/**
	 * 
	 * Constructor for dungeon rooms, by default travel is possible in both directions.        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 *
	 */
	public DungeonRoom()
	{
		this.goEast = true;
		this.goWest = true;
		
	}
	
	/**
	 * 
	 * Parameterized Constructor that takes boolean values for east and west to determine entrances.       
	 *
	 * <hr>
	 * Date created: Apr 17, 2021 
	 *
	 * 
	 * @param e
	 * @param w
	 */
	public DungeonRoom(boolean e, boolean w)
	{
		this.goEast = e;
		this.goWest = w;
	}
	
	/**
	 * 
	 * getter method that returns whether an east exit exists or not.         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @return goEast
	 */
	public boolean doorEast()
	{
		return this.goEast;
	}
	
	/**
	 * 
	 * setter method for the east entrance, allows other classes to access the field.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param door
	 */
	public void setEast(boolean door)
	{
		this.goEast = door;
	}
	
	/**
	 * 
	 * getter method for the west entrance that returns a boolean for its existence.         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @return goWest
	 */
	public boolean doorWest()
	{
		return this.goWest;
	}
	
	/**
	 * 
	 * setter method that allows other classes to access the field of the west entrances.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param door
	 */
	public void setWest(boolean door)
	{
		this.goWest = door;
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
		return "DungeonRoom [goEast=" + goEast + ", goWest=" + goWest + "]";
	}
}
