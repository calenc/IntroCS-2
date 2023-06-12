/**
 * ---------------------------------------------------------------------------
 * File name: LibraryDriver.java Project name: Files-Books
 * ---------------------------------------------------------------------------
 * Creator's name and email: Don Bailes, bailes@etsu.edu
 * Course-Section: CSCI1260
 * Creation Date: March 21, 2018
 * ---------------------------------------------------------------------------
 */

package books;

import java.awt.Font;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FontUIResource;

/**
 * Demo the Book and Library classes<br>
 * 
 * <hr>
 * Date created: March 21, 2018<br>
 * <hr>
 * 
 * @author Don Bailes
 */
public class LibraryDriver
{
	private static Library	lib			= new Library ( );
	private static String	fileName	= "";								   // Save filename for later use

	/**
	 * Main method - fill library from input file; add books; save library<br>
	 * 
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 * 
	 * <hr>
	 * 
	 * @param args
	 *            - not used here
	 */
	public static void main (String [ ] args)
	{
		UIManager.put ("OptionPane.messageFont", new FontUIResource (new Font ("Arial", Font.PLAIN,
						12)));
		JOptionPane.showMessageDialog (null, "Welcome to the Library Manager.", "Library Manager",
			JOptionPane.INFORMATION_MESSAGE);
		inputFile ( );
		displayLibrary ( );
		addBooks ( );

		JOptionPane.showMessageDialog (null, "Thank you for using the Library Manager.",
			"Goodbye Now", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Save the file back to its original position <br>
	 * 
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 * 
	 * <hr>
	 */
	private static void saveFile ( )
	{
		// we create a PrintWriter object to write the library to the file.
		try
		{
			PrintWriter pw = new PrintWriter ("TextFiles\\BookFile.txt");
			
			for(int index = 0; index < lib.getNumBooks ( ); index++)
			{
				
				try
				{
					pw.println(lib.getBook (index).getTitle() + "," + lib.getBook (index).getAuthor() + "," + lib.getBook (index).getPrice());
				}
				catch (Exception e)
				{
					System.out.println("The library could not be written to the file. ");
				}
				
			}
			pw.close ( );
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Unable to write to the file. ");
			return;
		}
	}

	/**
	 * Allow the user to try to add any number of books to the library; this
	 * will result in an exception if one tries to add a book beyond the library
	 * size <br>
	 * 
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 * 
	 * <hr>
	 * returns - number of books added
	 */
	private static void addBooks ( )
	{
		int booksAdded = 0;
		
		// Adding confirm dialog to see if user wants to add more books
		int value = JOptionPane.showConfirmDialog(null, "Would you like to add one or more new books?");
		
		if (value == JOptionPane.YES_OPTION)
		{
			String bookAmt = JOptionPane.showInputDialog (null, "How many books do you want to add?");
			
			try
			{
				// Convert user input to integer so we can create a loop for our questions
				int bookCounter = Integer.parseInt (bookAmt);
				for (int index = 0; index < bookCounter; index++)
				{
					Book extras = new Book();
					try
					{
						// Each loop asks these questions and assigns the input to Book fields to create new completed books for the library.
						extras.setTitle (JOptionPane.showInputDialog(null, "What is the title of book " + (index + 1) + "? "));
						extras.setAuthor(JOptionPane.showInputDialog (null, "What is the author's name? "));
						extras.setPrice(Double.parseDouble(JOptionPane.showInputDialog(null, "What is the price of the book? ")));
						// After filling the fields, add to library
						lib.addBook (extras);
					}
					catch (HeadlessException e)
					{
						System.out.println("The book format was incorrect. Failed to add the book. ");
					}
					catch (Exception e)
					{
						System.out.println("The book format was incorrect. Failed to add the book. ");
					}
				}
				// Set equal to user input for the desired number of new books
				booksAdded = bookCounter;
				
			}
			catch (NumberFormatException e)
			{
				System.out.println("Unacceptable value entered. No more books will be added. ");
			}
			
			
			
		}
		
		if (booksAdded > 0)
		{
			JOptionPane.showMessageDialog (null, booksAdded + " books added", "Books Added",
				JOptionPane.INFORMATION_MESSAGE);

			displayLibrary ( );
			saveFile ( );
		}
	}

	/**
	 * Get the filename from the user and try to open it (JFileChooser); read contents and
	 * build library; handle any exceptions that occur. Save the filename and path for
	 * later use by the saveFile method<br>
	 * 
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 * 
	 * <hr>
	 */
	private static void inputFile ( )
	{
		// We create our fileChooser prompt to allow the user to select a file to input
		JFileChooser fileChooser = new JFileChooser("TextFiles");
		FileNameExtensionFilter filter = new FileNameExtensionFilter ("Text Files", "txt", "text");
		fileChooser.setFileFilter (filter);
		fileChooser.setDialogTitle ("Select Text File to Import");
		int status = fileChooser.showOpenDialog(null);
		
		if (status == JFileChooser.APPROVE_OPTION)
		{
			// Saving the file name for later
			fileName = fileChooser.getSelectedFile ( ).getPath();
			
			File file = fileChooser.getSelectedFile();
			
			try
			{
				// Scanner to read the file
				Scanner inputFile = new Scanner(file);
				
				// Reading each line of the file and creating a new Book object for each line
				while (inputFile.hasNext())
				{
					String str = inputFile.nextLine();
					String[] fields = str.split ("\\,");
					
					Book nextBook = new Book(fields [0], fields[1], Double.parseDouble(fields[2]));
					try
					{
						lib.addBook(nextBook);
					}
					catch (Exception e)
					{
						System.out.println("One or more books already exist in the library. ");
					}
					
					
				}
				
				inputFile.close ( );
			}
			catch (FileNotFoundException e)
			{
				JOptionPane.showMessageDialog (null, "The file could not be located. ");
				return;
			}
			
			
		}
		
		else
		{
			JOptionPane.showMessageDialog (null, "No file selected! Unable to continue. ");
			System.exit(-1);
		}
		
	}

	/**
	 * Display all books in the library <br>
	 * 
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 * 
	 * <hr>
	 */
	private static void displayLibrary ( )
	{
		JOptionPane.showMessageDialog (null, "There are " + lib.getNumBooks ( ) + " books in the library.",
			"Library Size", JOptionPane.INFORMATION_MESSAGE);
		System.out.println ("\n\n\nLibrary Contents\n----------------\n");
		System.out.println (lib);
		System.out.println ("\n\n");
	}
}
