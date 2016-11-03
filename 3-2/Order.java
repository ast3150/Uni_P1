/*
* @Author:        Pascal Wallimann
* @Matriculation: 16-100-802
* @Author:        Alain Stulz
* @Matriculation: 16-119-414
*/

import java.util.*;

public class Order {
	static int id;

	private String customerName;
	private String customerAddress;

	// Sure we could do it with 5 separate book variables but this is cleaner anyway
	private ArrayList<Book> books = new ArrayList(5);
	private Book book1;

	/** constructor */
	public Order() {
		id++;
	}

	/** Returns a String representation of the order */
	public String toString() {
		String str = "";

		str += "Order id: " + id + ", Customer: " + customerName + ", " + customerAddress;

		for(Book book: books) {
			str += "\n" + book.toString();
		}
		
		str += "\nTotal price: " + getTotalPrice() + " CHF";
		
		return str;
	}

	public void addBook(Book book) {
		
		// If you would want to do this with instance variables instead of ArrayList,
		// you could check each book whether it has a value 
		// and assign to the first one that is empty.
		// 
		// Example:
		// if (book1 == null) {
		// 		book1 = book;
		// }

		if (books.size() < 5) {
			this.books.add(book);
		}
	}

	public int getTotalPrice() {
		int totalPrice = 0;

		for(Book book: books) {
    		totalPrice += book.getPrice();
		}

		return totalPrice;
	}

	// --- Get-/Set-methods ---
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
}
