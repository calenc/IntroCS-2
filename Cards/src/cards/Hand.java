/**
 * ---------------------------------------------------------------------------
 * File name: Hand.java
 * Project name: Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Feb 25, 2021
 * ---------------------------------------------------------------------------
 */

package cards;

/**
 * The ArrayList class allows us to create array lists and access other related methods.
 * 
 * <hr>
 * Date created: Feb 25, 2021
 * <hr>
 * @author Calen Cummings
 */
import java.util.ArrayList;

/**
 * The class that allows us to organize hands of cards as objects.
 *
 * <hr>
 * Date created: Feb 25, 2021
 * <hr>
 * @author Calen Cummings
 */
public class Hand
{
	
	// Our private values
	private int handSize;	
	private int cardsInHand;
	private ArrayList<Card> hand;
	
	/**
	 * 
	 * Constructor for our default hand      
	 *
	 * <hr>
	 * Date created: Feb 25, 2021 
	 *
	 *
	 */
	public Hand()
	{
		this.handSize = 5;
		this.cardsInHand = 0;
		this.hand = new ArrayList<Card>();
		
	}
	
	
	/**
	 * 
	 * Constructor for a Hand of a specified size       
	 *
	 * <hr>
	 * Date created: Feb 25, 2021 
	 *
	 * 
	 * @param handSize
	 */
	public Hand(int handSize)
	{
		if (handSize > 52 || handSize < 1)
		{
			System.out.println("The handsize must be between 1 and 52. Please try again. ");
		}
		
		this.handSize = handSize;
		this.cardsInHand = 0;
		this.hand = new ArrayList<Card>();
		
		
	}
	
	
	/**
	 * 
	 * Constructor that creates a deep copy of another Hand object       
	 *
	 * <hr>
	 * Date created: Feb 25, 2021 
	 *
	 * 
	 * @param existingHand
	 */
	public Hand(Hand existingHand)
	{
		this.handSize = existingHand.handSize;
		
		this.cardsInHand = existingHand.cardsInHand;
		
		this.hand = new ArrayList<Card>();
		
		for (int count = 0; count < existingHand.handSize; count++)
		{
			this.hand.add (count, existingHand.hand.get(count));
		}
		
	}
	
	/**
	 * 
	 * This method adds a new card object to the Hand, filling our ArrayList with values         
	 *
	 * <hr>
	 * Date created: Feb 25, 2021
	 *
	 * <hr>
	 * @param card
	 */
	public void addCard(Card card)
	{
		if (cardsInHand < handSize)
		{
			this.hand.add (card);
			this.cardsInHand++;
		}
	}
	
	
	/**
	 * 
	 * Our toString method for this class, which in this case is not actually needed and has been given an "empty" value         
	 *
	 * <hr>
	 * Date created: Feb 25, 2021 
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	// The assigned document does not specify a format for the toString, and in my case the toString method for this class is un-needed, so it
	// is given an empty value.
	public String toString()
	{	
		return ""; 
	}
}
