import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Date;

public class Transaction {
	private static Transaction instance; //tracking the single instance of the transaction class
	
	//empty constructor
	private Transaction () {};
	
	//gets a instance of the transaction (if there is already one, returns the current one)
	public static Transaction getTransaction() {
		if(instance == null) 
			instance = new Transaction();
		return instance;
	}

    // Perform the borrowing of a book
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            
            saveTransaction(transactionDetails); //saving the transaction
            
            System.out.println(transactionDetails);
            return true;
            
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public boolean returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            
            saveTransaction(transactionDetails); //saving the transaction
            
            System.out.println(transactionDetails);
            
            return true;
            
        } else {
            System.out.println("This book was not borrowed by the member.");
            return false;
        }
    }

    // Get the current date and time in a readable format
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
    
    // method that records every transaction to a text file
    public void saveTransaction(String transactionDetails) {
    	try { 
    		//acssesing the file and making able to read the file
    		FileWriter allTransactions = new FileWriter("transactions.txt", true);
    		BufferedWriter writer = new BufferedWriter(allTransactions);
    		
    		//recording the transaction
    		writer.write(transactionDetails + "\n");
    		writer.close();
    	}
    	catch (IOException e) {
    	   e.printStackTrace(); //incase of error
    	}
    }
    
    //method that dispays all transactions
    public void displayTransactionHistory() {
    	try {
    	  //accsesing the file in a way we can read it
  	      BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"));
  	      String line;
  	      
  	      //loops through the entire file, outputing the contents
  	      while((line = reader.readLine()) != null) {
  	        System.out.println(line);
  	      }
  	      reader.close();
  	      
  	    } catch (IOException e) {
  	      e.printStackTrace(); //if a error occurs
  	    }
    }
}