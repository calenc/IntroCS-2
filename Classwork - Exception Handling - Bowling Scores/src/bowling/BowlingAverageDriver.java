/**
 * ---------------------------------------------------------------------------
 * File name: BowlingAverageDriver.java
 * Project name: Classwork - Exception Handling - Bowling Scores
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Mar 11, 2021
 * ---------------------------------------------------------------------------
 */

package bowling;

/**
 * The Scanner class must be imported so we can make use of it.
 * 
 * <hr>
 * Date created: Mar 11, 2021
 * <hr>
 * @author Calen Cummings
 */
import java.util.Scanner;


/**
 * Driver class that will allow users to calculate an average from a sum of bowling games.
 *
 * <hr>
 * Date created: Mar 11, 2021
 * <hr>
 * @author Calen Cummings
 */
public class BowlingAverageDriver
{

	/**
	 * The main method.        
	 *
	 * <hr>
	 * Date created: Mar 11, 2021
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		// Create default bowling average score and display it
		BowlingAverage defaultBowl = new BowlingAverage();
		
		System.out.print("Default Bowling Average: " + defaultBowl.toString());
		System.out.println("------------------------------------------------------------------------------\n");
		
		
		// Creating a Scanner object to read user input
		Scanner kb = new Scanner(System.in);
		
		// Initializing a value that we will use to control when the loop will continue, and setting a games value to keep variables stable outside
		// of the try block.
		int userGames = 0;
		
		int gameCheck = -1;
		
		
		// For this program, a while loop will keep repeating until the user indicates they are done.
		while (gameCheck == -1)
		{
			
			// Initializing this boolean statement allows us to easily test and loop through the try-catch block
			boolean ok = false;
			
			while ( !ok)
			{
				try
				{
					System.out.println ("How many games were bowled? ");
					userGames = kb.nextInt ( );
					ok = true; // Getting to this point ends this loop and moves on to asking for scores.
				}
				
				// Several exception types that we do not have locally defined can result from user input, so 
				// for this catch block we can have a more flexible parameter that will trigger from any exception the try block throws.
				catch (Exception e1)
				{

					System.out.println ("Invalid integer input. ");
					kb.nextLine ( ); // Clears the input cache so the try block can be attempted without spill-over input
					
				} 
			}
			
			// Exception handling is not needed here but we still want to control the range.
			while (userGames < 0 || userGames > 10)
			{
				System.out.println("Please enter a number of games between 1 and 10.");
				System.out.println("How many games were bowled? ");
				userGames = kb.nextInt ( );
			}
			
			// Creating our array to be filled by user scores.
			int[] scores = new int[userGames];
			
			
			// To prevent non-integers from being entered, create exception handler for our array of scores
			// Rather than attempt to replace the input, the user is prompted to re-enter all scores.
			boolean scoreFiller = false;
			
			while ( !scoreFiller)
			{
				try
				{
					for (int count = 1; count <= userGames; count++ )
					{
						System.out.println ("What was the score for game " + count + "?");
						scores [count - 1] = kb.nextInt ( );
					}
					scoreFiller = true;
				}
				catch (Exception e)
				{
					System.out.println ("Invalid integer input. Start over. ");
					kb.nextLine();
				} 
			}
			
			// This try block creates our BowlingAverage object from user input.
			// The catch block does not attempt to fix the exception, rather it keeps the program running and lets the user decide to average more scores.
			// No matter what specifically throws the exception, the catch block will print the appropriate message to the console.
			try
			{
				BowlingAverage userBowl = new BowlingAverage(scores, userGames);
				System.out.println(userBowl.toString());
			}
			catch (BowlingException e)
			{
				System.out.println(e.getMessage());
			}
			
			
			System.out.println("\n\n-----------------------------------------------------");
			
			System.out.println("Do you want to average more scores (Y / N)? ");
			String str = kb.next ( ).toUpperCase();
			
			
			// This loop will make sure that only equivalent values of Y or N will be accepted.
			while (!str.equals ("Y") && !str.equals ("YES") && !str.equals ("N") && !str.equals ("NO"))
			{
				System.out.println("Please enter either yes or no. ");
				kb.nextLine ( );
				str = kb.next ( ).toUpperCase();
				
			}
			
			if (str.equals ("N") || str.equals ("NO"))
			{
				gameCheck = 0;
			}
			
			
			
		}
		
		// Goodbye message.
		System.out.println("Goodbye. Thank you for using this program!");
		
		
		

	}

}
