import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
  
/**
 *gridLayoutDemo class
*<p>this is the GUI code for LMS
*Software Development 1</p>
*@author Ayesha Malik
*@since 2/24/24
*/
public class gridLayoutDemo extends JFrame { 
	// Declaration of objects of JTextField class. 
    JTextField tname, tbarcode, tcode, ttitleNumber, checkIn, checkOut;
   static  JTable table ;
   /**
    * code to create GUI 
    */
gridLayoutDemo() { 
	
  
    // Creating Object P1 of JPanel class 
    JPanel p1 = new JPanel(); 
  
    // set the layout 
    p1.setLayout(new GridLayout(6, 2)); 
  
    // Creating Object of "FlowLayout" class 
    FlowLayout layout = new FlowLayout(); 
  
    // Creating Object P2 of JPanel class 
    JPanel p2 = new JPanel(); 
  
    // set the layout 
    p2.setLayout(layout); 
  
    // Declaration of objects of JLabel class. 
    JButton one, two, three, four, five, six; 
  
    // Declaration of objects of JButton class. 
    JButton buttonSave, buttonExit; 
  
    // Initialization of object  
    // "one" of JLabel class. 
    one = new JButton("Add books from file"); 
  
    one.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	Library.addBooks(tname.getText());
        }
    });
    
    // Initialization of object  
    // "tname" of JTextField class. 
    tname = new JTextField(20); 
  
    // Initialization of object 
    // "two" of JLabel class. 
    two = new JButton("Display books"); 
    
    two.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	Library.displayBooks2();
        }
    });
  
    // Initialization of object  
    // "tcode" of JTextField class. 
    tcode = new JTextField(20); 
  
    // Initialization of object 
    // "three" of JLabel class. 
    three = new JButton("Remove books by barcode"); 
    
    three.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	Library.deleteBookByBarcode(tbarcode.getText());
        }
    });
  
    // Initialization of object  
    // "tdesig" of JTextField class. 
    ttitleNumber = new JTextField(20); 
  
    // Initialization of object 
    // "four" of JLabel class. 
    four = new JButton("Remove books by title number"); 
    
    four.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	Library.deleteBookByTitleNumber(ttitleNumber.getText()); 
        }
    });
  
    // Initialization of object  
    // "tsalary" of JTextField class. 
    tbarcode = new JTextField(20);
    
    five = new JButton("Check out books by title number"); 
    
    five.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	Library.checkOutBookByTitleNumber(checkOut.getText());	
        }
    });
    
    six = new JButton("Check in books by title number"); 
    
    six.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	Library.checkInBookByTitleNumber(checkIn.getText());	
        }
    });
    
    checkIn = new JTextField(20);
    
    checkOut = new JTextField(20);
  
    ; 
  
    // Initialization of object 
     
    buttonExit = new JButton("EXIT"); 
    buttonExit.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
        	//Library.checkInBookByTitleNumber(checkIn.getText());'
        	System.exit(0);
        }
    });
  
    // Adding Jlabel "one" on JFrame. 
    p1.add(one); 
  
    // Adding JTextField "tname" on JFrame. 
    p1.add(tname); 
  
    // Adding Jlabel "two" on JFrame. 
    p1.add(two); 
  
    // Adding JTextField "tcode" on JFrame. 
    p1.add(new JLabel("")); 
  
    // Adding Jlabel "three" on JFrame. 
    p1.add(three); 
  
    // Adding JTextField "tdesig" on JFrame. 
     //p1.add(tdesig); 
    
    p1.add(tbarcode); 
  
    // Adding Jlabel "four" on JFrame. 
    p1.add(four); 
    
    // Adding JTextField "tsalary" on JFrame. 
    p1.add(ttitleNumber);
    
   // p1.add(tbarcode); 
    
    p1.add(five);
    
    p1.add(checkOut);
    
    p1.add(six);
    
    p1.add(checkIn);
  
  
    // Adding JButton "buttonexit" on JFrame. 
    p2.add(buttonExit); 
  
    // add the p1 object which  
    // refer to the Jpanel 
    add(p1, "North"); 
  
    // add the p2 object which 
    // refer to the Jpanel 
    add(p2, "South"); 
   
    String[] data = {
             "Kundan Kumar Jha", "4031", "CSE", "", ""
            
        };
 
        // Column Names
        String[] columnNames = { "Title no", "Title", "Author", "Barcode", "Check in" };
 
        // Initializing the JTable
        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Title no");
        model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Genre");
        model.addColumn("Barcode");
        model.addColumn("Check in");
        model.addColumn("Date");
        model.addRow(data);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(100);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(110);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        table.setBounds(0, 0, 600, 500);
        Library.displayBooks2();
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        p2.add(sp);
        
    
    setVisible(true); 
  
    
    this.setSize(800, 900); 
} 
  
    // Main Method 
    public static void main(String args[]) 
    { 
  
        // calling the constructor 
        new gridLayoutDemo(); 
    } 
} 
