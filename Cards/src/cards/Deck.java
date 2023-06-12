/**
 * ---------------------------------------------------------------------------
 * File name: Deck.java
 * Project name: Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Feb 23, 2021
 * ---------------------------------------------------------------------------
 */

package cards;

/**
 * Importing the Random class of Java so we can use random integers to shuffle our deck.
 * 
 * <hr>
 * Date created: Feb 24, 2021
 * <hr>
 * @author Calen Cummings
 */
import java.util.Random;

/**
 * This is our class to represent a deck of cards instead of a singular card.
 * 
 * <hr>
 * Date created: Feb 23, 2021
 * <hr>
 * @author Calen Cummings
 */
public class Deck
{
	// An array of card objects make up our deck attribute, and we have a value nextCard to keep track of how many cards have been dealt
	private Card[] deck;
	private int nextCard = 0;
	
	/**
	 * 
	 * Default constructor that creates a deck and fills it with Cards       
	 *
	 * <hr>
	 * Date created: Feb 25, 2021 
	 *
	 *
	 */
	public Deck()
	{
		this.deck = new Card[52];
		
		for (int totalCards = 0; totalCards <= 51; totalCards++)
		{
			this.deck[totalCards] = new Card(totalCards); 
		}
		
		this.nextCard = 0;
	}
	
	/**
	 * 
	 * Constructor that creates deep copies of other Deck objects        
	 *
	 * <hr>
	 * Date created: Feb 25, 2021 
	 *
	 * 
	 * @param existingDeck
	 */
	public Deck(Deck existingDeck)
	{
		this.deck = new Card[52];
		for (int index = 0; index <=51; index++)
		{
			this.deck[index] = existingDeck.deck[index];
		}
		this.nextCard = existingDeck.nextCard;
	}
	
	/**
	 * 
	 * The toString for the class prints each card in the deck in order         
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
		for (Card cardNumber : deck)
		{
		    System.out.println(cardNumber);
		}
		
		return " ";
	}
	
	/**
	 * 
	 * This method shuffles the deck, giving us different ways to represent our deck and draw cards in new orders        
	 *
	 * <hr>
	 * Date created: Feb 25, 2021
	 *
	 * <hr>
	 */
	public void shuffle()
	{
		Random shuffle = new Random();
		
		for (int index = 0; index <= 51; index++)
		{	
			int shuffleSpot = shuffle.nextInt(52) + 0;
			
			 Card temp = this.deck[index];
				
			this.deck[index] = this.deck[shuffleSpot];
			
			this.deck[shuffleSpot] = temp;
		}
		
		this.nextCard = 0;
	}
	
	/**
	 * 
	 * This method draws one card at a time from the deck        
	 *
	 * <hr>
	 * Date created: Feb 25, 2021
	 *
	 * <hr>
	 * @return
	 */
	public Card dealACard()
	{	
			
		return this.deck[(nextCard++)];
		
	}
	
	/**
	 * 
	 * This method fills our Hand objects with Cards, and keeps track of what position in the deck the next card will come from      
	 *
	 * <hr>
	 * Date created: Feb 25, 2021
	 *
	 * <hr>
	 * @param handSize
	 * @return
	 */
	public Hand dealAHand(int handSize)
	{
		// This is replaced by the creation of Hand objects:
		//	for (int count = 0; count < handSize; count++)
		//	{
		//	
		//		System.out.println(dealACard());
		//	}
		
		Hand dealer = new Hand(handSize);
		
		for (int count = 0; count < handSize; count++)
		{
			dealer.addCard (deck[nextCard]);
			
			System.out.println(deck[nextCard++]);
			
		}
		
		System.out.print ("\n");
		
		return dealer;
	}
}
