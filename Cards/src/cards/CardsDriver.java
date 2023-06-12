/**
 * ---------------------------------------------------------------------------
 * File name: CardsDriver.java
 * Project name: Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Feb 10, 2021
 * ---------------------------------------------------------------------------
 */

package cards;

/**
 * The Scanner class of Java will allow us to create scanner objects and read user input for the program to display the correct card.
 * 
 * <hr>
 * Date Created: Feb 10, 2021
 * <hr>
 * @author Calen Cummings
 */
import java.util.Scanner;

/**
 * The main class of the program. This is what will be used to display cards and make sure that enumerated values 
 *
 * <hr>
 * Date created: Feb 10, 2021
 * <hr>
 * @author Calen Cummings
 */
public class CardsDriver
{
	
	/**
	 * 
	 * The main method of the class. Used to take user input, create objects, and display object states.         
	 *
	 * <hr>
	 * Date created: Feb 24, 2021
	 *
	 * <hr>
	 * @param args
	 */
	public static void main(String[] args)
	{
		Card defaultCard = new Card ();
		
		System.out.println("The default card is " + defaultCard.toString() + ".\n");
		
		Scanner kb = new Scanner (System.in);
		
		// Loop to ask for integers from the user. We initialize with a value to give a starting point for our loop
		// and use value checks to verify user is staying within the correct range of input.
		int userInt = 0;
		
		do
		{
			System.out.println("Please enter an integer between 1 and 52. Enter -1 to stop. ");
			userInt = kb.nextInt ( );
			
			if (userInt == 0 || userInt > 52)
			{
				System.out.println("Please enter an integer between 1 and 52. Enter -1 to stop. ");
				userInt = kb.nextInt();
				
			}
			
			if (1 <= userInt && userInt <= 52)
			{	
				Card userDraw = new Card (userInt - 1);
			
				System.out.println("The card for number " + userInt + " is " + userDraw.toString() + ".");
			}
			
			
		}while (0 <= userInt && userInt <= 52);
		
		// After demonstrating our ability to assign cards to integer values, we want to display all of the cards by calling the showDeck method
		
		showDeck();
		
	}
	
	/**
	 * 
	 * This method allows us to quickly display all the cards in our deck in a single list.        
	 *
	 * <hr>
	 * Date created: Feb 24, 2021
	 *
	 * <hr>
	 */
	private static void showDeck()
	{
		System.out.println("\nAll 52 Cards Follow: ");
		
		for (int totalCards = 0; totalCards <= 51; totalCards++)
		{
			Card nextCardUp = new Card(totalCards);
			
			System.out.println(nextCardUp.toString());
			
			
		}
		
	}
}
