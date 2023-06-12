/**
 * ---------------------------------------------------------------------------
 * File name: ZorkDriver.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 17, 2021
 * ---------------------------------------------------------------------------
 */

package game;

import java.util.Scanner;

/**
 * Driver class that will execute the game code.
 *
 * <hr>
 * Date created: Apr 17, 2021
 * <hr>
 * @author Calen Cummings
 */
public class ZorkDriver
{
	// GameManager object is treated as a field for the driver to reduce visibility/exposure.
	private static GameManager zork = new GameManager();
	
	
	/**
	 * 
	 * the main method. Executes other local methods and utilizes a GameManager object to run a game.         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param args
	 */
	public static void main(String[] args)
	{
		// The main method makes use of local method adventure to carry out the simple interaction of the game.
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Welcome to Zork Dungeon Adventure! Fight to the exit or become a victim to the dungeon...");
		System.out.println("What is your name? ");
		zork.getUser ( ).setName (kb.nextLine());
		
		System.out.println("\nThe plunge begins now....\n");
		
		zork.gameStart();
		
		adventure();
		
		kb.close ( );
	}
	
	/**
	 * 
	 * this method prints the physical room that the player is currently in to give the game so sort of visual aid beyond pure text.        
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public static void showRoom()
	{
		System.out.println("\n-----------------------------------");
		System.out.println("|                                  |");
		System.out.println("|                                  |");
		System.out.println("|                                  |");
		System.out.println("|                                  |");
		
		// if statements are used to prevent formatting issues or exceptions from arising from conflicts between the StartCell and being cast as 
		// a DungeonCell.
		if (zork.getPlayerPosition() == 0)
		{
			System.out.println("|  " + zork.getUser().getScreenLetter() + "         " + "  " + 
				"               " + "  " + "   |\n");
		}
		else if (((DungeonCell)zork.get (zork.getPlayerPosition ( ))).getMob ( ).getAlive() == false)
		{
			System.out.println("|  " + zork.getUser().getScreenLetter() + "         " + 
							((DungeonCell)zork.get(zork.getPlayerPosition ( ))).getLootScreenCode() + 
			"               " + "  " + "   |\n");
		}
		else
		{	
			System.out.println("|  " + zork.getUser().getScreenLetter() + "         " + 
							((DungeonCell)zork.get(zork.getPlayerPosition ( ))).getLootScreenCode() + 
			"               " + ((DungeonCell)zork.get(zork.getPlayerPosition ( ))).getMob().getScreenCode() + "   |\n");
		}
	}
	
	/**
	 * 
	 * The adventure method pretty much runs the entire game. The bulk of gameplay occurs within this method, and it even uses other local methods
	 * to fulfill the game's needs.         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public static void adventure()
	{
		while (zork.isLifeCheck())
		{	
			// While the player is alive, we want to check the position, try and move, and fight monsters that appear. If the player moves out of
			// the bounds of the dungeon, they have found the exit and the game is over. 
			
			// This integer gives the current player position and allows us to bypass issues that arise from checking for a weapon in the start cell.
			int moveCheck = zork.getPlayerPosition ( );
			
			Scanner kb = new Scanner(System.in);
			
			// For each room in the dungeon, we want to actually display it before stating player location and other info.
			showRoom();
		
			System.out.println(zork.getUser ( ).getName() + " is in room " + (zork.getPlayerPosition() + 1) + ", and has " + 
			zork.getUser ( ).getHealthPoints() + " health points.");
			
			if (moveCheck > 0)
			{	
			
				if (zork.lootGet() && zork.getUser ( ).getWeaponAvailable())
				{
					System.out.println("There is a weapon here! A " + zork.getWeaponDrop ( ).weapName() + ", what a lucky find! ");
				}
		
				if (((DungeonCell)zork.get (zork.getPlayerPosition())).getMobName() != "  " && !((DungeonCell)zork.get (zork.getPlayerPosition ( ))).getMob ( ).getAlive() == false)
				{
					System.out.println("A wild and ferocious " + ((DungeonCell)zork.get (zork.getPlayerPosition())).getMob().getName() + " appeared!");
					System.out.println("The battle starts! ");
					fight();
				}
			}	
			
			
			// If user input throws an exception within the game, it will have to come from the prompt method. By 
			// running the method over and over in the event of an exception, it will never crash the game.
			try
			{
				prompt();
			}
			catch (Exception e)
			{
				prompt();
			}
			finally
			{
			
				if (zork.getPlayerPosition() == zork.size())
				{
					System.out.println("You found the exit! You have survived the dungeon! \n");
					System.out.println("Congratulations! The game will now close. ");
				
					kb.close ( );
					
					System.exit(0);
				}
			
			}
		}
	}
	
	/**
	 * 
	 * By isolating the user input to a method within the driver class, we can easily catch an exception thrown and clean up other methods.         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public static void prompt()
	{
		// The "gameplay" aspect of moving between rooms is limited to this method.
		
		Scanner kb = new Scanner(System.in);
		String direction;
		
		System.out.println("Go east or west? ");
		direction = kb.nextLine().toUpperCase();
		
		while (!direction.equals ("EAST") && !direction.equals("WEST"))
		{
			System.out.println("I do not know what you mean. Try again. Go east or west? ");
			direction = kb.nextLine ( ).toUpperCase();
		}
	
		while (direction.equals ("WEST") && zork.getPlayerPosition() == 0)
		{
			System.out.println("Sorry, but I cannot go that way. ");
			System.out.println("Go east or west? ");
			direction = kb.nextLine ( ).toUpperCase();
			
			while (!direction.equals ("EAST") && !direction.equals("WEST"))
			{
				System.out.println("I do not know what you mean. Try again. Go east or west? ");
				direction = kb.nextLine ( ).toUpperCase();
			}
		}
		
		if (direction.equals ("EAST") && zork.get(zork.getPlayerPosition()).doorEast())
		{
			zork.travelEast ( );
		}
		
		else if (direction.equals("WEST") && zork.get (zork.getPlayerPosition()).doorWest())
		{
			zork.travelWest ( );
		}
		
		
	}
	
	
	/**
	 * 
	 * To prevent cluttering other methods, we create the fight method since a fight will trigger anytime there is a monster in the room.         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 */
	public static void fight()
	{
		// the attack stats of both the monster and player are taken into account and used to deal damage to each other. Miss percentage
		// is calculated as part of 10000 and both the player and monster can miss on any given turn.
		
		int playerDmg = zork.getUser().getAttackPoints ( );
		int monsterDmg = ((DungeonCell)zork.get(zork.getPlayerPosition())).getMob().getAttackPoints ( );
		
		System.out.println("Player Health: " + zork.getUser().getHealthPoints());
		System.out.println(((DungeonCell)zork.get(zork.getPlayerPosition())).getMob().getName() + " Health: " + "" +
						((DungeonCell)zork.get(zork.getPlayerPosition())).getMob().getHealthPoints());
		
		// fight will trigger only when the player and monster are both alive. One being dead will end the loop of battle.
		while (zork.isLifeCheck() && ((DungeonCell)zork.get(zork.getPlayerPosition())).getMob().getAlive())
		{	
			boolean userTurn = zork.playerHit (playerDmg);
			if (userTurn == false)
			{
				System.out.println("Your attack missed! ");
			}
			else
			{
				System.out.print("A hit! ");
			}
			
			if (((DungeonCell)zork.get (zork.getPlayerPosition())).getMob ( ).getAlive() == false)
			{
				System.out.println("The beast has been defeated! ");
				return;
			}
		
			System.out.println("The monster's health is now " + ((DungeonCell)zork.get(zork.getPlayerPosition())).getMob().getHealthPoints()
				+ ".");
		
			boolean monsterTurn = zork.monsterHit (monsterDmg);
			if (monsterTurn == false)
			{
				System.out.println("The beast's attack missed! ");
			}
			else
			{
				System.out.print("You were hit! ");
			}
			
			if (zork.isLifeCheck() == false)
			{
				System.out.println("You could not overcome the dungeon beast. Your adventure is over. ");
				System.exit (0);
			}
			
			System.out.println(zork.getUser ( ).getName() + "'s health is now " + zork.getUser ( ).getHealthPoints() + ".");
		}	
	}
}
