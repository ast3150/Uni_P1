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

	private Book book1;
	private Book book2;
	private Book book3;
	private Book book4;
	private Book book5;

	/** constructor */
	public Order() {
		id++;
	}

	/** Returns a String representation of the order */
	public String toString() {
		String str = "";

		str += "Order id: " + id + ", Customer: " + customerName + ", " + customerAddress;

		if (book1 != null) {
			str += "\n" + book1.toString();
		}

		if (book2 != null) {
			str += "\n" + book2.toString();
		}

		if (book3 != null) {
			str += "\n" + book3.toString();
		}

		if (book4 != null) {
			str += "\n" + book4.toString();
		}

		if (book5 != null) {
			str += "\n" + book5.toString();
		}

		str += "\nTotal price: " + getTotalPrice() + " CHF";
		
		return str;
	}

	public void addBook(final Book book) {
		if (book == null) {
			throw new NullPointerException("Argument 'book' is null");
		}

		if (book1 == null) {
			book1 = book;
		} else if (book2 == null) {
			book2 = book;
		} else if (book3 == null) {
			book3 = book;
		} else if (book4 == null) {
			book4 = book;
		} else if (book5 == null) {
			book5 = book;
		}
	}

	public int getTotalPrice() {
		int totalPrice = 0;

		if (book1 != null) {
	    	totalPrice += book1.getPrice();
		}

		if (book2 != null) {
    		totalPrice += book2.getPrice();
		}

		if (book3 != null) {
	    	totalPrice += book3.getPrice();
		}

		if (book4 != null) {
    		totalPrice += book4.getPrice();
		}

		if (book5 != null) {
    		totalPrice += book5.getPrice();
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
