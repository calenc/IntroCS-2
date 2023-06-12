/**
 * ---------------------------------------------------------------------------
 * File name: Test.java
 * Project name: Project 1 - Club Membership Roster
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: May 3, 2021
 * ---------------------------------------------------------------------------
 */

package clubRoster;


/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: May 3, 2021
 * <hr>
 * @author Calen Cummings
 */
public class Test
{
	public static void main(String[] args)
	{
		for (MemberType m : MemberType.values())
		{
			System.out.print (m);
		}
	}
}
