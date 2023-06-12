/**
 * ---------------------------------------------------------------------------
 * File name: Monster.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package game;


/**
 * Monster class serves as a superclass to derive multiple monster types for the dungeon
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Calen Cummings
 */
public class Monster extends Participant
{	
	// This String field will hold the two-letter representation of the monster, and alive makes sure we can set the monster to dead to not
	// trigger another fight sequence.
	private String screenCode;
	private boolean alive;
	
	/**
	 * 
	 * Default Constructor for the monster superclass. Necessary for functionality in derived classes.       
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 *
	 */
	public Monster()
	{
		super();
		
		this.screenCode = "  ";
		this.alive = true;
	}
	
	/**
	 * 
	 * Parameterized Constructor that will create allow us to create a fully specified monster.       
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * 
	 * @param health
	 * @param attack
	 * @param type
	 * @param code
	 * @param life
	 */
	public Monster(int health, int attack, String type, String code, boolean life)
	{
		super(health, attack, type);
		
		this.screenCode = code;
		this.alive = life;
	}
	
	/**
	 * 
	 * get health method so our derived monster classes can reach the field.        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * <hr>
	 * @return healthPoints
	 * @see game.Participant#setHealthPoints()
	 */
	public int getHealthPoints()
	{
		return super.getHealthPoints ( );
	}
	
	/**
	 * 
	 * Set health method so our derived monster classes can reach the field.         
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * <hr>
	 * @param health
	 * @see game.Participant#setHealthPoints(int)
	 */
	public void setHealthPoints(int health)
	{
		super.setHealthPoints (health);
	}
	
	/**
	 * 
	 * get attack method so derived classes can reach the field, and other classes can read the field for battle.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021 
	 *
	 * <hr>
	 * @return attackPoints
	 * @see game.Participant#getAttackPoints()
	 */
	public int getAttackPoints()
	{
		return super.getAttackPoints();
	}
	
	/**
	 * 
	 * Set attack method so our derived monster classes can reach the field.         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021 
	 *
	 * <hr>
	 * @param attack
	 * @see game.Participant#setAttackPoints(int)
	 */
	public void setAttackPoints(int attack)
	{
		super.setAttackPoints (attack);
	}
	
	/**
	 * 
	 * get method for the name of the monster.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021 
	 *
	 * <hr>
	 * @return name
	 * @see game.Participant#getName()
	 */
	public String getName()
	{
		return super.getName();
	}
	
	/**
	 * 
	 * set method for the monster name so derived classes can reach the field.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param type
	 */
	public void setName(String type)
	{
		super.setName (type);
	}
	
	/**
	 * 
	 * get method so derived classes can reach the field.         
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
	 * 
	 * Set method for screen code so derived classes can reach the field.         
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
	 * get method for the alive field so derived classes can access it.       
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @return alive
	 */
	public boolean getAlive()
	{
		return this.alive;
	}
	
	/**
	 * 
	 * set method for the alive field so derived classes can reach it.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param life
	 */
	public void setAlive(boolean life)
	{
		this.alive = life;
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
		return "Monster [screenCode=" + screenCode + ", alive=" + alive + "]";
	}
}
