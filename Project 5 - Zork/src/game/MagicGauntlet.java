/**
 * ---------------------------------------------------------------------------
 * File name: MagicGauntlet.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package game;


/**
 * This class defines the Magic Gauntlet weapon, a mystical gauntlet that exudes magical power. It fires energy bolts for ok damage.
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Calen Cummings
 */
public class MagicGauntlet extends Weapon
{
	/**
	 * 
	 * This constructor creates a weapon object of the Magic Gauntlet type, and sets its attack value to 9.       
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 *
	 */
	public MagicGauntlet()
	{
		super ("Magic Gauntlet", 9, "MG");
		
	}
	
	/**
	 * 
	 * This method allows the driver to read and use the Gauntlet's attack value.        
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
	 * get method that allows the driver and other classes to access the gauntlet's screen code.         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021 
	 *
	 * <hr>
	 * @return screenCode
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
		return "MagicGauntlet [weapName()=" + weapName ( ) + ", toString()=" + super.toString ( ) + ", getClass()=" +
						getClass ( ) + ", hashCode()=" + hashCode ( ) + "]";
	}
}
