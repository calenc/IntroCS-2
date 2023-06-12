/**
 * ---------------------------------------------------------------------------
 * File name: Card.java
 * Project name: Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Feb 10, 2021
 * ---------------------------------------------------------------------------
 */

package cards;


/**
 * The main class of the project. Stores the constructors and methods necessary for representing our deck of cards.
 *
 * <hr>
 * Date created: Feb 10, 2021
 * <hr>
 * @author Calen Cummings
 */
public class Card
{
	// Our attributes for our card objects.
	private Suit suit;
	private Face face;
	
	/**
	 * 
	 * Default constructor that creates our custom default card    
	 *
	 * <hr>
	 * Date created: Feb 25, 2021 
	 *
	 *
	 */
	public Card ( )
	{
		this.suit = Suit.SPADES;
		this.face = Face.ACE;
	}
	
	/**
	 * 
	 * Constructor that creates a deep copy of another card object       
	 *
	 * <hr>
	 * Date created: Feb 25, 2021 
	 *
	 * 
	 * @param existingCard
	 */
	public Card (Card existingCard)
	{
		this.suit = existingCard.suit;
		this.face = existingCard.face;
		
	}
	
	/**
	 * 
	 * Constructor that creates a card with an assigned integer value       
	 *
	 * <hr>
	 * Date created: Feb 25, 2021 
	 *
	 * 
	 * @param n
	 */
	public Card (int n)
	{
		this.face = Face.values()[n % 13];
		this.suit = Suit.values()[n % 4];
	}
	
	/**
	 * 
	 * The toString is used to print the value of the card         
	 *
	 * <hr>
	 * Date created: Feb 25, 2021 
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return ("the " + face + " of " + suit );
	}
	
	public static void main(String[] args)
	{
		double[] measurements = new double[4];
	}
}
