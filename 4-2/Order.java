/* ************************************************************************** *\
 *                       Programmierung 1 HS 2016                             * 
\* ************************************************************************** */

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

	private ArrayList<IArticle> articles;

	/** constructor */
	public Order() {
		id++;
		articles = new ArrayList<IArticle>();
	}

	/** Returns a String representation of the order */
	public String toString() {
		String str = "";

		str += "Order id: " + id + ", Customer: " + customerName + ", " + customerAddress;

		for ( IArticle a : this.articles ) {
			str += "\n" + a.toString();
		}

		str += "\nTotal price: " + getTotalPrice() + " CHF";
		
		return str;
	}

	public void add(IArticle article) {
		this.articles.add(article);
	}

	public int getTotalPrice() {
		int totalPrice = 0;

		for ( IArticle a : this.articles ) {
			totalPrice += a.getPrice();
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

	public String getCustomerName() {
		return this.customerName;
	}
	
	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setOrderedArticles(Iterable<IArticle> orderedArticles) {
		this.articles = (ArrayList<IArticle>) orderedArticles;
	}
	
	public int getId() {
		return this.id;
	}

	public Iterable<IArticle> getOrderedArticles() {
		return this.articles;
	}
	
	
}