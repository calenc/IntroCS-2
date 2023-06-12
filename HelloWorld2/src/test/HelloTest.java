/**
 * ---------------------------------------------------------------------------
 * File name: HelloTest.java
 * Project name: HelloWorld2
 * ---------------------------------------------------------------------------
 * Creator's name and email: Calen Cummings, cummingscc@etsu.edu
 * Course:  CSCI 1260-940
 * Creation Date: Jan 20, 2021
 * ---------------------------------------------------------------------------
 */

package test;


/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Jan 20, 2021
 * <hr>
 * @author Calen Cummings
 */
public class HelloTest
{

	/**
	 * Enter method description here         
	 *
	 * <hr>
	 * Date created: Jan 20, 2021
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		Person John = new Person( );
		
		Person Sam = new Person("Sammy", "Longey", 29);
		
		System.out.println(John.getAge());
		
		System.out.print(Sam.toString ( ));
		
	
		

	}

}
