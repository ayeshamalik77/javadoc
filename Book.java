/**
*@author Ayesha Malik
*Software Development 1
*2/24/24
*class:Book
*It add(), delete() and display() books.
*Its a library management system that add, delete and display books
*/
public class Book {
	private int number;
	private String title;
	private String author;
	private int barcode;
	private String checkIn;
	
	public Book(int number, String title, String author, int barcode, String checkIn) {
		super();
		this.number = number;
		this.title = title;
		this.author = author;
		this.barcode = barcode;
		this.checkIn = checkIn;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	public int getBarcode() {
		return barcode;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	
}
