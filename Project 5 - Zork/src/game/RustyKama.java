/**
 * ---------------------------------------------------------------------------
 * File name: RustyKama.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package game;


/**
 * This class defines the Rusty Kama weapon, an old abandoned weapon that barely does more damage than fists.
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Calen Cummings
 */
public class RustyKama extends Weapon
{
	/**
	 * 
	 * This creates a weapon object under the Rusty Kama type, and sets its attack value to 6.      
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 *
	 */
	public RustyKama()
	{
		super ("Rusty Kama", 6, "RK");
		
	}
	
	/**
	 * 
	 * This get damage method allows for the kama's damage value to be used in battle instead of the player value.       
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
	 * This method makes the get method for screen code accessible from the weapon directly.         
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
		return super.getScreenCode ( );
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
		return "RustyKama [weapName()=" + weapName ( ) + ", toString()=" + super.toString ( ) + ", getClass()=" +
						getClass ( ) + ", hashCode()=" + hashCode ( ) + "]";
	}
}
