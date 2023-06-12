/**
 * ---------------------------------------------------------------------------
 * File name: DeckDriver.java
 * Project name: Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Feb 24, 2021
 * ---------------------------------------------------------------------------
 */

package cards;

/**
 * The Scanner class of Java is used here for user input, to determine and test how many hands can be played from a deck of cards.
 * 
 * <hr>
 * Date created: Feb 25, 2021
 * <hr>
 * @author Calen Cummings
 */
import java.util.Scanner;

/**
 * The driver class for our Deck class of objects. Tests the methods and attributes in our Deck class to create objects, deal hands, and display them.
 *
 * <hr>
 * Date created: Feb 24, 2021
 * <hr>
 * @author Calen Cummings
 */
public class DeckDriver
{
	/**
	 * 
	 * The main method, where we will interact with the program and display decks and hands.         
	 *
	 * <hr>
	 * Date created: Feb 24, 2021
	 *
	 * <hr>
	 * @param args
	 */
	public static void main(String[] args)
	{
		Deck first = new Deck();
		
		System.out.println(first.toString());
		
		first.shuffle ( );
		
		System.out.println(first.toString());
		
		Deck second = new Deck(first);
		
		second.dealAHand(7);
		
		second.dealAHand(7);
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("How many cards are in each hand?\n");
		int cards = kb.nextInt ( );
		
		System.out.println("How many players are there?\n");
		int players = kb.nextInt();
		
		// Provides an exception if the user enters outside of our range.
		if (players * cards > 52)
		{
			System.out.println("There are not enough cards in the deck to deal " + players + " hands of " + cards + " cards. Please try again. ");
			
			System.out.println("How many cards are in each hand?\n");
			cards = kb.nextInt ( );
			
			System.out.println("How many players are there?\n");
			players = kb.nextInt();
			
		}
		
		first.shuffle ( );
		
		for (int dealer = 0; dealer < players; dealer++)
		{
			System.out.println("\nPlayer " + (dealer + 1) + ":\n");
			
			
			first.dealAHand (cards);
			
		}
		
		
	}
}
