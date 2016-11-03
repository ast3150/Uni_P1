/*
* @Author:        Pascal Wallimann
* @Matriculation: 16-100-802
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
*/

import java.util.Date;
import java.text.*;
import java.util.Scanner;

public class Book
{
	private int id;
	private String title;
	private String author;
	private Date dateOfPublication;
	private int price;

	public static final String DATE_FORMAT = "dd.MM.yyyy";

	/** constructor */
	public Book( int tmpId, String tmpTitle, String tmpAuthor, Date tmpDateOfPubl, int price)
	{
		id = tmpId;
		title = tmpTitle;
		author = tmpAuthor;
		dateOfPublication = ( Date ) tmpDateOfPubl.clone();
		this.price = price >= 0 ? price : 0;
	}

	/** constructor */
	public Book()
	{
		id = 0;
		title = null;
		author = null;
		dateOfPublication = new Date(); //required to be filled for age()
		price = 0;
	}


	/** Returns the age of the book in days since publication */
	public int age()
	{
		Date now = new Date();
		long age_ms = now.getTime() - dateOfPublication.getTime(); //age in milliseconds
		return ( int ) ( age_ms / ( ( long ) 1000 * 60 * 60 * 24 ) );	//convert to days
	}

	/** Returns a String representation of the book */
	public String toString()
	{
		//Notice: Setters or constructors might leave attributes "null"
		String temp = "";
		temp += id + ", ";
		if (null != title) temp += title ;
		temp += ", ";
		if (null != author) temp += author ;
		temp += ", " + dateToString( dateOfPublication );
		temp += ", " + price + " CHF";
		
		return temp;
	}

	/** Reads all book data from user input */
	public void input()
	{
		Scanner scn = new Scanner( System.in );
		System.out.print( "Please enter id: " );
		id = Integer.parseInt( scn.nextLine() );
		System.out.print( "Please enter the title: " );
		title = scn.nextLine();
		System.out.print( "Please enter the author's first and lastname: " );
		author = scn.nextLine();
		System.out.print( "Please enter date of publication (e.g. 01.12.2007): " );
		dateOfPublication = stringToDate( scn.nextLine() );
	}


	// --- Get-/Set-methods ---
	public int getId()
	{
		return id;
	}

	public void setId( int newId )
	{
		id = newId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int newPrice) {
		if (newPrice > 0) {
			price = newPrice;
		} else {
			price = 0;
		}
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor( String newAuthor )
	{
		author = newAuthor;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle( String newTitle )
	{
		title = newTitle;
	}

	public Date getDateOfPublication()
	{
		return ( Date ) dateOfPublication.clone();
		//Alternatives e.g.
		// return new Date( dateOfPublication.getTime() );
		// return stringToDate( dateToString( dateOfPublication ) ); //OK, but bad style
	}

	public void setDateOfPublication( Date newDate )
	{
		if ( null == newDate ) return; // Leave state consistent!

		dateOfPublication = ( Date ) newDate.clone();

		//Alternatives e.g.
		// dateOfPublication = new Date( newDate.getTime() );
		// dateOfPublication = stringToDate( dateToString( newDate ) ); //OK, but bad style
	}

	// --- helper methods ---

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
