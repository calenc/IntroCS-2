/**
 * ---------------------------------------------------------------------------
 * File name: DungeonCell.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Apr 17, 2021
 * ---------------------------------------------------------------------------
 */

package game;

import java.util.Random;

/**
 * This derived class represents all cells in the dungeon that are not the start cell. By making the cells separate, we can give this cell fields
 * that hold names of present monsters and weapons.
 *
 * <hr>
 * Date created: Apr 17, 2021
 * <hr>
 * @author Calen Cummings
 */
public class DungeonCell extends DungeonRoom
{
	private Random ran = new Random();
	
	// Stores whatever monster or weapon drop may have spawned in the room.
	// lootScreenCode helps the driver easily print present loot.
	private String mobName = "  ";
	private Monster mob;
	private String lootName = "  ";
	private String lootScreenCode = "  ";
	
	/**
	 * 
	 * Default Constructor that will be the framework for every dungeon cell except the start cell.       
	 *
	 * <hr>
	 * Date created: Apr 17, 2021 
	 *
	 *
	 */
	public DungeonCell()
	{
		super(true, true);
		
		this.mobName = "  ";
		this.lootName = "  ";
		this.mob = new Monster();
		this.lootScreenCode = "  ";
	}
	


	/**
	 * @return mobName
	 */
	public String getMobName ( )
	{
		return mobName;
	}


	/**
	 * @param mobName the mobName to set
	 */
	public void setMobName (String mobName)
	{
		this.mobName = mobName;
	}

	
	/**
	 * @return lootName
	 */
	public String getLootName ( )
	{
		return lootName;
	}

	
	/**
	 * @param lootName the lootName to set
	 */
	public void setLootName (String lootName)
	{
		this.lootName = lootName;
	}

	/**
	 * 
	 * set method for the mob field so the room monster can be directly identified and reached.        
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @param mob
	 */
	public void setMob(Monster mob)
	{
		this.mob = mob;
	}
	
	/**
	 * 
	 * get method to allow other classes to read the mob field and know exactly which monster is present.         
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @return mob
	 */
	public Monster getMob()
	{
		return mob;
	}
	
	
	/**
	 * @return lootScreenCode
	 */
	public String getLootScreenCode ( )
	{
		return lootScreenCode;
	}



	
	/**
	 * @param lootScreenCode the lootScreenCode to set
	 */
	public void setLootScreenCode (String lootScreenCode)
	{
		this.lootScreenCode = lootScreenCode;
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
		return "DungeonCell [mobName=" + mobName + ", mob=" + mob + ", lootName=" + lootName + ", lootScreenCode=" +
						lootScreenCode + "]";
	}



	/**
	 * 
	 * This monsterRoll method generates a random number to determine if a monster is going to spawn in the room; if one is going to spawn,
	 * another random number determines which monster type will spawn, and relays the monster name to the cell object.       
	 *
	 * <hr>
	 * Date created: Apr 17, 2021
	 *
	 * <hr>
	 * @return monsterRoll
	 */
	public boolean monsterRoll()
	{
		int spawn = ran.nextInt(10000);
		
		if (spawn < 5000)
		{
			int mobSelect = ran.nextInt(3) + 1;
			
			switch (mobSelect)
			{
				case 1:
				{	
					RockTitan mobDrop = new RockTitan();
					
					this.mobName = mobDrop.getScreenCode ( );
					this.mob = mobDrop;
					
					break;
				}
				
				case 2:
				{
					FrigidPhantom mobDrop = new FrigidPhantom();
					
					this.mobName = mobDrop.getScreenCode ( );
					this.mob = mobDrop;
					
					break;
				}
				
				case 3:
				{
					SteelDraconid mobDrop = new SteelDraconid();
					
					this.mobName = mobDrop.getScreenCode ( );
					this.mob = mobDrop;
					
					break;
				}
			}
			
			return true;
		}
		
		else
		{
			return false;
		}
		
		
	}
}
