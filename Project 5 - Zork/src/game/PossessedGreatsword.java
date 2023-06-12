/**
 * ---------------------------------------------------------------------------
 * File name: PossessedGreatsword.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 13, 2021
 * ---------------------------------------------------------------------------
 */

package game;


/**
 * This class defines the Possessed Greatsword weapon, a sinister weapon that quakes with power and seems to slash with a hatred of its own.
 *
 * <hr>
 * Date created: Apr 13, 2021
 * <hr>
 * @author Calen Cummings
 */
public class PossessedGreatsword extends Weapon
{
	/**
	 * 
	 * This constructor creates a weapon object of the type Possessed Greatsword, and sets its attack value to 20.       
	 *
	 * <hr>
	 * Date created: Apr 13, 2021 
	 *
	 *
	 */
	public PossessedGreatsword()
	{
		super ("Possessed Greatsword", 20, "PG");
		
	}
	
	/**
	 * 
	 * This allows the driver to read and use the Greatsword's damage value.         
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
	 * This makes the get method for screen code accessible from this weapon directly.         
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
		return "PossessedGreatsword [weapName()=" + weapName ( ) + ", toString()=" + super.toString ( ) +
						", getClass()=" + getClass ( ) + ", hashCode()=" + hashCode ( ) + "]";
	}
}
