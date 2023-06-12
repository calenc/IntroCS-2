/**
 * ---------------------------------------------------------------------------
 * File name: BlisteringMace.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package game;


/**
 * This class defines the Blistering Mace weapon, a weapon shimmering in heat that deals moderate damage.
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Calen Cummings
 */
public class BlisteringMace extends Weapon
{
	/**
	 * 
	 * This constructor creates a weapon object of the Blistering Mace type, and sets its attack value to 14.        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 *
	 */
	public BlisteringMace()
	{
		super ("Blistering Mace", 14, "BM");
		
	}
	
	/**
	 * 
	 * This method allows the driver to access the Mace's attack value and use it instead of player damage.        
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 * <hr>
	 * @return attackDmg
	 * @see game.Weapon#getAttackDmg()
	 */
	public int getAttackDmg()
	{
		return super.getAttackDmg();
	}
	
	/**
	 * 
	 * This method makes the get method for the screen code accessible directly from the weapon itself.         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021 
	 *
	 * <hr>
	 * @return
	 * @see game.Weapon#getScreenCode()
	 */
	public String getScreenCode()
	{
		return super.getScreenCode();
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
		return "BlisteringMace [weapName()=" + weapName ( ) + ", toString()=" + super.toString ( ) + ", getClass()=" +
						getClass ( ) + ", hashCode()=" + hashCode ( ) + "]";
	}
}
