/* ************************************************************************** *\
 *                       Programmierung 1 HS 2016                             * 
\* ************************************************************************** */

/*
 * @Author:			Alain Stulz
 * @Matriculation:	16-119-414
 * @Author:			Pascal Wallimann
 * @Matriculation:	16-100-802
 */


public class Book implements IArticle
{
	private int id;
	private String title;
	private String author;
	private int year;
	private int price; // CHF

	/** constructor */
	public Book( int id, String title, String author, int year, int price )
	{
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.price = price;
	}

	public String getDescription()
	{
		return id + " (Book) " + title + ", by " + author +
			", " + year + ", " + price + " CHF";
	}

	public int getPrice() {
		return price; 
	}

	public int getId() { 
		return id; 
	}
}
