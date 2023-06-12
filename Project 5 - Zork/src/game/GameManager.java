/**
 * ---------------------------------------------------------------------------
 * File name: GameManager.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 12, 2021
 * ---------------------------------------------------------------------------
 */

package game;

import java.util.ArrayList;
import java.util.Random;

/**
 * The GameManager class is a collection of methods and functionality for the game to play.
 *
 * <hr>
 * Date created: Apr 12, 2021
 * <hr>
 * @author Calen Cummings
 */
public class GameManager
{
	// All of these fields are given to allow methods within the class to reach them without needing to be declared in each method. 
	
	private Random ran = new Random();
	
	private ArrayList<DungeonRoom> dungeon;
	
	private Player user = new Player();
	
	private Weapon weaponDrop;
	
	private int playerPosition;
	
	private boolean playerMoved;
	
	private boolean lifeCheck = true;
	
	
	/**
	 * 
	 * Default Constructor. We are only going to use GameManager as a way to control the game flow so we do not need parameterized constructors.        
	 *
	 * <hr>
	 * Date created: Apr 18, 2021 
	 *
	 *
	 */
	public GameManager()
	{
		// As a default constructor, gives some default values to all fields.
		dungeon = new ArrayList<DungeonRoom>();
		weaponDrop = null;
		playerPosition = 0;
		playerMoved = false;
		lifeCheck = true;
		
	}
	
	/**
	 * 
	 * This gameStart method will be the used to initialize the game state; fills the Dungeon ArrayList with rooms after specifying a start room,
	 * performs the monsterRoll in each room before it is added to the list, and it spawns a random weapon in a random room (not the start room)        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 */
	public void gameStart()
	{	
		// The number of cells is determined by a random number between 5 and 10, and this value is stored so we can work with the
		// array capacity as a value.
		
		int dungeonMap = ran.nextInt(6) + 5;
		
		dungeon = new ArrayList<>(dungeonMap);
		
		// StartCell is declared and inserted first to make sure that there will never be a monster or weapon spawn in the starting room
		// of the game. The following for loop fills the ArrayList with dungeon cells.
		StartCell adventureStart = new StartCell();
		
		dungeon.add (adventureStart);
		
		for (int count = 1; count < dungeonMap; count++)
		{
			DungeonCell nextRoom = new DungeonCell();
			
			nextRoom.monsterRoll ( );
			
			dungeon.add (nextRoom);
		}
		
		// spawnWeapon is a random int between 1 and 4 that will determine what weapon will spawn for the game by running the result into a switch.
		int spawnWeapon = ran.nextInt(4) + 1;
		int spawnMath = dungeonMap - 1;
		int spawnRoom = ran.nextInt(spawnMath) + 1;
		
		switch (spawnWeapon)
		{
			// For each case, a specific weapon is created and added to the game, and stored within a specific dungeon room.
			
			case 1:
			{	
				RustyKama kama = new RustyKama();
				
				weaponDrop = kama;
				
				DungeonRoom lootRoom = dungeon.get (spawnRoom);
				
				((DungeonCell)lootRoom).setLootName (kama.weapName());
				
				((DungeonCell)lootRoom).setLootScreenCode (kama.getScreenCode());
				
				break;
			}
			
			case 2:
			{
				MagicGauntlet gauntlet = new MagicGauntlet();
				
				weaponDrop = gauntlet;
				
				DungeonRoom lootRoom = dungeon.get (spawnRoom);
				
				((DungeonCell)lootRoom).setLootName (gauntlet.weapName());
				
				((DungeonCell)lootRoom).setLootScreenCode (gauntlet.getScreenCode());
				
				break;
			}
			
			case 3:
			{
				BlisteringMace mace = new BlisteringMace();
				
				weaponDrop = mace;
				
				DungeonRoom lootRoom = dungeon.get (spawnRoom);
				
				((DungeonCell)lootRoom).setLootName(mace.weapName());
				
				((DungeonCell)lootRoom).setLootScreenCode (mace.getScreenCode());
				
				break;
			}
			
			case 4:
			{
				PossessedGreatsword greatSword = new PossessedGreatsword();
				
				weaponDrop = greatSword;
				
				DungeonRoom lootRoom = dungeon.get (spawnRoom);
				
				((DungeonCell)lootRoom).setLootName (greatSword.weapName());
				
				((DungeonCell)lootRoom).setLootScreenCode (greatSword.getScreenCode());
				
				break;
			}
		}
		
		// Player position represents and is used to help read what dungeon room the player is in. Must be set to zero at the start of the game so
		// the player is always moving initially from the start cell.
		playerPosition = 0;
	}
	
	/**
	 * 
	 * This method is used for fighting between the player and monsters. Attacking from the player perspective.         
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param atk
	 * @return
	 */
	public boolean playerHit(int atk)
	{
		boolean hit = true;
		int mobHealth = ((DungeonCell)dungeon.get (getPlayerPosition())).getMob().getHealthPoints ( );
		
		if ((ran.nextInt(10000)) < 1000)
		{
			atk = 0;
			hit = false;
			return hit;
		}
		
		((DungeonCell)dungeon.get (getPlayerPosition())).getMob().setHealthPoints (mobHealth -= atk);
		
		if (((DungeonCell)dungeon.get (getPlayerPosition())).getMob().getHealthPoints ( ) < 1)
		{
			((DungeonCell)dungeon.get (getPlayerPosition())).getMob().setAlive (false);
		}
		
		return hit;
	}
	
	
	/**
	 * 
	 * This method is used for fighting with the player.        
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @param atk
	 * @return
	 */
	public boolean monsterHit(int atk)
	{
		boolean hit = true;
		int userHealth = user.getHealthPoints ( );
		
		if ((ran.nextInt(10000)) < 2000)
		{
			atk = 0;
			hit = false;
		}
		
		user.setHealthPoints (userHealth -= atk);
		
		if (user.getHealthPoints() < 1)
		{
			lifeCheck = false;
		}
		
		return hit;
	}
	
	/**
	 * 
	 * Method to indicate that the player moved east between rooms.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 */
	public void travelEast()
	{
		if (dungeon.get (playerPosition).doorEast() == true)
		{
			playerPosition += 1;
			;
		}
		
		else
		{
			return;
		}
	}
	
	/**
	 * 
	 * Method to indicate the player moved west between rooms.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 */
	public void travelWest()
	{
		if (dungeon.get (playerPosition).doorWest() == true)
		{
			this.playerPosition = playerPosition - 1;
			
		}
		
		else
		{
			return;
		}
	}
	
	
	/**
	 * 
	 * method to give the player character the weapon spawn from a dungeon room.         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 */
	public boolean lootGet()
	{	
		DungeonRoom lootCheck = dungeon.get (playerPosition);
		
		// After getting the current dungeon room, it must be cast as a dungeon Cell so we can access the loot name field.
		DungeonCell lootCheckCell = ((DungeonCell)lootCheck);
		
		if (!lootCheckCell.getLootName().equals ("  "))
		{
			user.setHeldWeapon (weaponDrop.weapName());
			user.setWeaponAvailable (true);
			user.setAttackPoints (weaponDrop.getAttackDmg());
			
			lootCheckCell.setLootScreenCode ("  ");
			
			return true;
		}
		
		else
		{
			return false;
		}
	}

	
	/**
	 * 
	 * get method to allow the driver to access the dungeon ArrayList.         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param n
	 * @return dungeon.get()
	 */
	public DungeonRoom get(int n)
	{
		return dungeon.get (n);
	}
	
	/**
	 * 
	 * Gives the driver access to set rooms within the dungeon.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param n
	 * @param room
	 * @return dungeon.set()
	 */
	public DungeonRoom set(int n, DungeonRoom room)
	{
		return dungeon.set (n, room);
	}
	
	/**
	 * 
	 * allows the driver class to read the dungeon size.        
	 *
	 * <hr>
	 * Date created: Apr 18, 2021
	 *
	 * <hr>
	 * @return
	 */
	public int size()
	{
		return dungeon.size ( );
	}
	
	/**
	 * @return playerMoved
	 */
	public boolean isPlayerMoved ( )
	{
		return playerMoved;
	}


	
	/**
	 * @param playerMoved the playerMoved to set
	 */
	public void setPlayerMoved (boolean playerMove)
	{
		playerMoved = playerMove;
	}

	
	/**
	 * @return user
	 */
	public Player getUser ( )
	{
		return user;
	}

	
	/**
	 * @param user the user to set
	 */
	public void setUser (Player user)
	{
		this.user = user;
	}

	
	/**
	 * @return weaponDrop
	 */
	public Weapon getWeaponDrop ( )
	{
		return weaponDrop;
	}

	
	/**
	 * @param weaponDrop the weaponDrop to set
	 */
	public void setWeaponDrop (Weapon weaponDrop)
	{
		this.weaponDrop = weaponDrop;
	}

	
	/**
	 * @return playerPosition
	 */
	public int getPlayerPosition ( )
	{
		return playerPosition;
	}

	
	/**
	 * @param playerPosition the playerPosition to set
	 */
	public void setPlayerPosition (int playerPosition)
	{
		this.playerPosition = playerPosition;
	}

	
	/**
	 * @return lifeCheck
	 */
	public boolean isLifeCheck ( )
	{
		return lifeCheck;
	}

	
	/**
	 * @param lifeCheck the lifeCheck to set
	 */
	public void setLifeCheck (boolean lifeCheck)
	{
		this.lifeCheck = lifeCheck;
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
		return "GameManager [ran=" + ran + ", dungeon=" + dungeon + ", user=" + user + ", weaponDrop=" + weaponDrop +
						", playerPosition=" + playerPosition + ", playerMoved=" + playerMoved + ", lifeCheck=" +
						lifeCheck + "]";
	}
	
	
}
