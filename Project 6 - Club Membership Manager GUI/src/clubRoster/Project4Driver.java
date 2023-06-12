/**
 * ---------------------------------------------------------------------------
 * File name: Project4Driver.java Project name: Project 4 - Club Roster
 * ---------------------------------------------------------------------------
 * Creator's name and email: Don Bailes, bailes@etsu.edu Course: CSCI 1260
 * Creation Date: Oct 19, 2015
 * Last Modified: Calen Cummings, cummingscc@etsu.edu
 * ---------------------------------------------------------------------------
 */

package clubRoster;

import javax.swing.SwingUtilities;

/**
 * Driver - manages user interaction with the program
 *
 * <hr>
 * Date created: Oct 19, 2015
 * Last Modified: Apr 26, 2021
 * <hr>
 * 
 * @author Don Bailes
 * Last Modified: Calen Cummings, cummingscc@etsu.edu
 */
public class Project4Driver
{
	/**
	 * Driver that will run our GUI application. The entire "Project 4 Driver" has been replaced, as per the project guidelines.
	 *
	 * <hr>
	 * Date created: Oct 19, 2015
	 * Last Modified: Apr 26, 2021
	 *
	 * <hr>
	 * 
	 * @param args
	 */
	public static void main (String[] args)
	{
		SwingUtilities.invokeLater (new Runnable ()
		{
			public void run ()
			{
				new ClubManagerGUI();
			}
		});
	}

}
