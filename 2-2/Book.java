/*
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
* @Author:        Pascal Wallimann
* @Matriculation: 16-100-802
* @Date created:  2016-10-19 15:44:17
*/

/* ************************************************************************* *\
*                Programmierung 1 HS 2016 - Serie 2-2                         * 
\* ************************************************************************* */

import java.util.Date;
import java.util.Scanner;
import java.text.*;

public class Book
{
	private int id;
	private String title;
	private String author;
	private Date dateOfPublication;

	public static final String DATE_FORMAT = "dd.MM.yyyy";
	public static final long MSEC_PER_DAY = 86400000;

	//--- constructors ---

	public Book(int id, String title, String author, Date dateOfPublication) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.dateOfPublication = dateOfPublication;
	}

	/** Returns the age of the book in days since publication */
	public int age()
	{
		Date currentDate = new Date();
		long timeDifference = currentDate.getTime() - dateOfPublication.getTime();
		long daysSincePublication = timeDifference / MSEC_PER_DAY;

		// Question: Are we allowed to import and use TimeUnit?
		// Because then we could do it like this:
		// TimeUnit.MILLISECONDS.toDays(timeDifference);

		return (int)daysSincePublication;
	}

	/** Returns a String representation of the book */
	public String toString()
	{
		return id + ", " + title + ", " + author + ", " + dateToString(dateOfPublication);
	}

	/** Reads all book data from user input */
	public void input() 
	{
		Scanner intScn = new Scanner( System.in );
		Scanner scn = new Scanner( System.in );
        
		System.out.print( "\tPlease enter id: " );
		this.id = intScn.nextInt();

		System.out.print( "\tPlease enter title: " );
		this.title = scn.nextLine();

		System.out.print( "\tPlease enter author: " );
		this.author = scn.nextLine();

		System.out.print( "\tPlease enter date of publication (in form 'dd.MM.yyyy'): " );
		this.dateOfPublication = stringToDate(scn.nextLine());
	}

	//--- Get-/Set-methods ---
	
	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	//--- helper methods -- DO NOT CHANGE ------------------------------------
	/** Converts the Date object d into a String object */
	public static String dateToString( Date d )
	{
		SimpleDateFormat fmt = new SimpleDateFormat( DATE_FORMAT );
		return fmt.format( d );
	}

	/** Converts the String object s into a Date object */
	public static Date stringToDate( String s ) 
	{
		Date r = null;
		try {
			SimpleDateFormat fmt = new SimpleDateFormat( DATE_FORMAT );
			r = fmt.parse( s );
		} catch ( ParseException e ){
			System.err.println( e );
			System.exit(1);
		}
		return r;
	}
}
