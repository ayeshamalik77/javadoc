import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
*@author Ayesha Malik
*Software Development 1
*@since 2/24/24
*class:Main
*It add(), delete() and display() books.
*Its a library management system that add, delete and display books
*/
public class Main {
	
	/**
	 * starts and run the program
	 * @param args
	 */
	public static void main(String[] args) {
		int choice=0;
		Scanner input = new Scanner(System.in);
		while(true) {	
			System.out.println("\n Enter your choice");
			System.out.println("1: add books");
			System.out.println("2: delete book by title number");
			System.out.println("3: delete book by barcode");
			System.out.println("4: check in book by title number");
			System.out.println("5: check out book by title number");
			System.out.println("6: display books");
			System.out.println("7: Exit");
			
			choice = input.nextInt();
			switch(choice) {
			case 1: Library.addBooks("books.txt");
				break;
			case 2: Library.deleteBooks();
				break;
			case 3: Library.deleteBookByBarcode("11111");
				break;
			case 4: Library.checkInBookByTitleNumber("");
				break;
			case 5: Library.checkOutBookByTitleNumber("1");
				break;
			case 6: Library.displayBooks();
				break;
			case 7: System.exit(0);
				break;
			
			}
		}
		
	}



}
