import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
*Library class
*<p>It add(), delete() and display() books.
*Its a library management system that add, delete and display books
*Software Development 1</p>
*@author Ayesha Malik
*@since 2/24/24
*/
public class Library {
	/**
	 *This method displays books for command line setups
	 */
	static void displayBooks() {
		System.out.println("Display books");
		System.out.println("id              title                       author         barcode      checkedOut");
		
		try {
		Connection conn = null;
	      Statement stmt = null;
	      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
	      PreparedStatement myStmt; 
	      myStmt = conn.prepareStatement("Select * from mybooks;");
	     ResultSet r = myStmt.executeQuery();
	     while(r.next()) {
	    	 int id = r.getInt(1);
	    	 String title = r.getString(2);
	    	 String author = r.getString(3);
	    	 int barcode = r.getInt(4);
	    	 int checkedIn = r.getInt(5);
	    	 String check = "";
	    	 if(checkedIn == 1) {
	    		 check = "checked out";
	    	 }
	    	 else {
	    		 check = "checked In";
	    	 }
	    	 
	    	System.out.printf("%3d %25s %25s %8d %20s\n", id, title, author, barcode, check);
	     }
	      conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * displays books for GUI applications
	 */
	static void displayBooks2() {
		
		DefaultTableModel dtm = (DefaultTableModel) gridLayoutDemo.table.getModel();
		dtm.setRowCount(0);
		try {
		Connection conn = null;
	      Statement stmt = null;
	      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
	      PreparedStatement myStmt; 
	      myStmt = conn.prepareStatement("Select * from mybooks;");
	     ResultSet r = myStmt.executeQuery();
	     while(r.next()) {
	    	 int id = r.getInt(1);
	    	 String title = r.getString(2);
	    	 String author = r.getString(3);
	    	 String genre = r.getString(4);
	    	 int barcode = r.getInt(5);
	    	 int checkedIn = r.getInt(6);
	    	 String date  = r.getString(7);
	    	 String check = "";
	    	 if(checkedIn == 1) {
	    		 check = "checked out";
	    	 }
	    	 else {
	    		 check = "checked In";
	    	 }
	    	 String data[]= {
	    			 "" + id,
	    			 title,
	    			 author,
	    			 genre,
	    			"" +  barcode,
	    			 check,
	    			 date
	    	 };
	    	
	    	(( DefaultTableModel) gridLayoutDemo.table.getModel()).addRow(data);
	    	 
	     }
	      conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * delete books for command line application.
	 * @return weather the book was deleted
	 */
	static int deleteBooks() {
		System.out.println("Delete books");
		try {
			Connection conn = null;
		      Statement stmt = null;
		      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
		      PreparedStatement myStmt; 
		      myStmt = conn.prepareStatement("delete from mybooks where id = ?;");
		      System.out.print("Enter the id of the book to delete: ");
		      Scanner input = new Scanner(System.in);
		      int id = input.nextInt();
		      myStmt.setInt(1,id); 
		     int result = myStmt.executeUpdate();
		      conn.close();
		      System.out.println("Book deleted");
		      displayBooks();
		      return result;
			}
			catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
			
		
	}
/**
 * This adds books to the database
 * @param file where book was list is found
 * @return Weather books were successfully loaded
 */
	static int  addBooks(String file) {
		
		BufferedReader reader;

		try {
			
			File f = new File(file);
			if(!f.exists()) {
			      JOptionPane.showMessageDialog(null, "File not found", 
	                      "", JOptionPane.PLAIN_MESSAGE);
			      return -1;
			}
			FileReader r = new FileReader(file);
			
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();

			while (line != null) {
				String []split = line.split(",");
				int id = Integer.parseInt(split[0]);
				String author = split[2];
				String genre = split[3];
				String title = split[1];
				int barcode = Integer.parseInt(split[4]);
				
				Connection conn = null;
			      Statement stmt = null;
			      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
			      PreparedStatement myStmt; 
			      myStmt = conn.prepareStatement("INSERT INTO mybooks VALUES ( ? , ? , ? , ? , ?, null,  null );");
			      myStmt.setInt(1,id);     
			      myStmt.setString(2,title);      
			      myStmt.setString(3,author);
			      myStmt.setString(4,genre);
			      myStmt.setInt(5, barcode);
			      myStmt.executeUpdate();
			      conn.close();
				
				line = reader.readLine();
			}
			JOptionPane.showMessageDialog(null, "Books are added", 
                    "", JOptionPane.PLAIN_MESSAGE);
			reader.close();
			r.close();
			displayBooks2();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
/**
 * This deletes books from database by using barcode
 * @param barcode barcode of the book to be deleted 
 * @return weather the book was successfully deleted
 */
	static int deleteBookByBarcode(String barcode) {
		
		try {
			Connection conn = null;
		      Statement stmt = null;
		      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
		      PreparedStatement myStmt; 
		      myStmt = conn.prepareStatement("delete from mybooks where barcode = ?;");
		      
		      int id = Integer.parseInt(barcode); 
		      myStmt.setInt(1,id); 
		     int result=  myStmt.executeUpdate();
		      conn.close();
		      
		      if(result > 0 ) {
			      JOptionPane.showMessageDialog(null, "Book deleted", 
	                      "", JOptionPane.PLAIN_MESSAGE);
			      }
			      else {
			    	  JOptionPane.showMessageDialog(null, "Thats not a book", 
		                      "", JOptionPane.PLAIN_MESSAGE); 
			      }
		      displayBooks2();
		      return 1;
			}
			catch (Exception e) {
				e.printStackTrace();
				return - 1;
			}
	}
	/**
	 * this deletes books from database using title number
	 * @param title title id of the book to be deleted
	 * @return number indicating weather the book was sucessfully deleted
	 */
	static int deleteBookByTitleNumber(String title) {
		
		try {
			Connection conn = null;
		      Statement stmt = null;
		      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
		      PreparedStatement myStmt; 
		      myStmt = conn.prepareStatement("delete from mybooks where id = ?;");
		      
		      int id = Integer.parseInt(title); 
		      myStmt.setInt(1,id); 
		      int result = myStmt.executeUpdate();
		      conn.close();
		      
		      if(result > 0 ) {
			      JOptionPane.showMessageDialog(null, "Book deleted", 
	                      "", JOptionPane.PLAIN_MESSAGE);
			      }
			      else {
			    	  JOptionPane.showMessageDialog(null, "Thats not a book", 
		                      "", JOptionPane.PLAIN_MESSAGE); 
			      }
		      displayBooks2();
		      return result;
			}
			catch (Exception e) {
				e.printStackTrace();
				return - 1;
			}
	}
	
/**
 * this check in books in the database 
 * @param checkIn title number of the book to be checked in
 * @return weather the book was successfully checked in
 */
	public static int checkInBookByTitleNumber(String checkIn) {
		
		try {
			Connection conn = null;
		      Statement stmt = null;
		      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
		      PreparedStatement myStmt; 
		      myStmt = conn.prepareStatement("update mybooks set checkIn = 0, dueDate = NULL where id = ?;");
		      
		      int id = Integer.parseInt(checkIn);
		      myStmt.setInt(1,id); 
		      int result = myStmt.executeUpdate();
		      conn.close();
		     
		      if(result > 0 ) {
		      JOptionPane.showMessageDialog(null, "Book checked in", 
                      "", JOptionPane.PLAIN_MESSAGE);
		      }
		      else {
		    	  JOptionPane.showMessageDialog(null, "Thats not a book", 
	                      "", JOptionPane.PLAIN_MESSAGE); 
		      }
		      displayBooks2();
		      return result;
			}
			catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
		
	}
/**
 * this check out books from database
 * @param checkOut out book using title id
 * @return checks weather the books were sucessfully checked out.
 */
	public static int checkOutBookByTitleNumber(String checkOut) {
		
		try {
			LocalDate L = LocalDate.now();
			L = L.plusDays(14);
			Connection conn = null;
		      Statement stmt = null;
		      conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/myLibrary", "root", "aalia786");
		      PreparedStatement myStmt; 
		      myStmt = conn.prepareStatement("update mybooks set checkIn = 1, dueDate = ?  where id = ?;");
		      
		      int id = Integer.parseInt(checkOut);
		      myStmt.setString(1, L.toString());
		      myStmt.setInt(2,id); 
		      int result =myStmt.executeUpdate();
		      conn.close();
		     
		      if(result <= 0) {
		    	  JOptionPane.showMessageDialog(null, "Thats not a book", 
	                      "", JOptionPane.PLAIN_MESSAGE);
		      }
		      else {
		    	   JOptionPane.showMessageDialog(null, "Book checked out", 
                      "", JOptionPane.PLAIN_MESSAGE);
		      }
		    
		      displayBooks2();
		      return result;
			}
			catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
		
	}
}


