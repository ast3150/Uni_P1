/*
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
* @Author:        Pascal Wallimann
* @Matriculation: 16-100-802
* @Date created:  2016-10-19 15:50:06
*/

/* ************************************************************************* *\
*                Programmierung 1 HS 2016 - Serie 2-2                         * 
\* ************************************************************************* */

/* *************** */
// NOTE: To test properly, you need to enable assertions, 
// for example by running `java -ea BookTest` (note the -ea parameter) from command line
/* *************** */

import java.util.Date;
import java.util.Scanner;
import java.text.*;

public class BookTest {
	public static void main(String[] args) {
		System.out.println("");
		System.out.println("Beginning tests...");
		
		if (!areAssertsEnabled()) {
			System.err.println( "WARNING: Assertions are not enabled. Try running with `-ea` argument, like: `java -ea BookTest`");
		}

		System.out.println("");

		// given
		int testID = 123;
		String testTitle = "Die Blechtrommel";
		String testAuthor = "Günter Grass";
		Date testPublicationDate = Book.stringToDate("12.02.1969");

		Book testBook = new Book(testID, testTitle, testAuthor, testPublicationDate);
		
		// when
		System.out.println("Testing methods...");

		int testedAge = testBook.age();
		
		String testedString = testBook.toString();
		
		testBook.setID(100);
		int testedID = testBook.getID();

		testBook.setTitle("Java For Dummies");
		String testedTitle = testBook.getTitle();

		testBook.setAuthor("Barry A. Burd");
		String testedAuthor = testBook.getAuthor();

		Date testSetterPublicationDate = testBook.stringToDate("31.03.2014");
		testBook.setDateOfPublication(testSetterPublicationDate);
		Date testedPublicationDate = testBook.getDateOfPublication();

		// then
		System.out.println("\tAge: " + testedAge + "  Date:  " + Book.dateToString(testPublicationDate));
		System.out.println("");

		assert testedString.equals("123, Die Blechtrommel, Günter Grass, 12.02.1969") : "Book.toString() failed";
		assert testedID == 100 : "Book.setID() or Book.getID() failed";
		assert testedTitle.equals("Java For Dummies") : "Book.setTitle() or Book.getTitle() failed";
		assert testedAuthor.equals("Barry A. Burd") : "Book.setAuthor() or Book.getAuthor() failed";
		assert testedPublicationDate.equals(testSetterPublicationDate) : "Book.setDateOfPublication() or Book.getDateOfPublication() failed";

		System.out.println("Testing input feature...");

		testBook.input();

		System.out.println("Book has values:\n\t" + testBook.toString());

		System.out.println("Ran all tests successfully.");
		System.out.println("");
	}

	public static boolean areAssertsEnabled() {
 		boolean assertsEnabled = false;
  		assert assertsEnabled = true;
  		return assertsEnabled;
	}
}
