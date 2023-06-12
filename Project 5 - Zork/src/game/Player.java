/**
 * ---------------------------------------------------------------------------
 * File name: Player.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package game;


/**
 * This derived class represents the user character in the game.
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Calen Cummings
 */
public class Player extends Participant
{
	// These fields allow the player character to hold weapons, and the boolean field provides a way to quickly check for a weapon.
	private final char screenLetter = 'P';
	private String weaponSlot;
	private boolean weaponAvailable;
	
	/**
	 * 
	 * Default Constructor for the Player class. Health and attack will always be initialized as 100 and 5 respectively.       
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 *
	 */
	public Player()
	{
		super();
		
		super.setHealthPoints (100);
		super.setAttackPoints(5);
		super.setName("Player");
		this.weaponSlot = "Empty";
		this.weaponAvailable = false;
		
	}
	
	/**
	 * 
	 * Parameterized constructor to identify the player character by name. weaponSlot and weaponAvailable should
	 * always start as empty value so we do not need them as parameters. Health will always start at 100 and attack at 5 for any player character so 
	 * we can use the superclass constructor.      
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * 
	 * @param player
	 */
	public Player(String player)
	{	
		super(100, 5, player);
		
		this.weaponSlot = "Empty";
		this.weaponAvailable = false;
	}
	
	/**
	 * 
	 * Gets the player's health.         
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
		return super.getHealthPoints();
	}
	
	/**
	 * 
	 * Set method for the health points of the player         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021 
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
	 * get attack point method to give access to this field for the player character        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
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
	 * Set method for attack points for the player.        
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
	 * Allows access to change the held weapon value of the player; if the player holds a weapon, they will do damage based on the weapon's
	 * attack stat instead of the player's.         
	 *
	 * <hr>
	 * Date created: Apr 13, 2021
	 *
	 * <hr>
	 * @param weapon
	 */
	public void setHeldWeapon(String weapon)
	{
		this.weaponSlot = weapon;
	}
	
	/**
	 * 
	 * Allows access to see what weapon the player holds.          
	 *
	 * <hr>
	 * Date created: Apr 13, 2021
	 *
	 * <hr>
	 * @return weaponSlot
	 */
	public String getHeldWeapon()
	{
		return this.weaponSlot;
	}
	
	/**
	 * 
	 * Allows access to set the value of weaponAvailable.         
	 *
	 * <hr>
	 * Date created: Apr 13, 2021
	 *
	 * <hr>
	 * @param w
	 */
	public void setWeaponAvailable(boolean w)
	{
		this.weaponAvailable = w;
	}
	
	/**
	 * 
	 * Allows access to test if the player holds a weapon or not.         
	 *
	 * <hr>
	 * Date created: Apr 13, 2021
	 *
	 * <hr>
	 * @return weaponAvailable
	 */
	public boolean getWeaponAvailable()
	{
		return this.weaponAvailable;
	}
	
	/**
	 * 
	 * Set method to access the player name field.         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param name
	 */
	public void setName(String name)
	{
		super.setName (name);
	}
	
	/**
	 * 
	 * Get method for player name field.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @return name
	 */
	public String getName()
	{
		return super.getName ( );
	}
	
	/**
	 * 
	 * get method for the character that will represent the player character in the on-screen display.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @return screenLetter
	 */
	public char getScreenLetter()
	{
		return this.screenLetter;
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
		return "Player [screenLetter=" + screenLetter + ", weaponSlot=" + weaponSlot + ", weaponAvailable=" +
						weaponAvailable + "]";
	}
}
