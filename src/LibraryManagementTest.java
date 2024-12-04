import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryManagementTest {
	
	/*
	//unfinished 
	@Test
	public void testBookId() throws Exception {
		Book validBook1 = new Book(100, "valid1");
		Book validBook2 = new Book(999, "valid2");
		Book nonValidBook1 = new Book(1000, "nonValid1");
		Book nonValidBook2 = new Book(99, "nonValid2");
		
		throw new Exception("The Id value added is not valid (is not between 100 and 999");
	}
	*/
	@Test
	public void  testBorrowReturn() throws Exception {
		Transaction transactions = Transaction.getTransaction(); 
		Book testBook = new Book (100, "a book");
		Member testMember = new Member(2222, "name");
		
		//making the fisrt transaction, borrowing a book
		boolean firstTransaction = transactions.borrowBook(testBook, testMember);
		assertTrue(firstTransaction); //ensure the book was borrowed
		assertFalse(testBook.isAvailable()); //ensure the book is no londer available 
		
		//making the second transaction, borrowing with same member and book as last transaction
		boolean secondTransaction = transactions.borrowBook(testBook, testMember);
		assertFalse(secondTransaction); //ensure the book cant be borrowed again
		
		//making the third transaction, returning the book
		boolean thirdTransaction = transactions.returnBook(testBook, testMember);
		assertTrue(thirdTransaction); //checking to make sure the book was returned (aka is true)
		
		//making the thrid transaction, returning the same book again
		boolean fourthTransaction = transactions.returnBook(testBook, testMember);
		assertFalse(fourthTransaction); //checking to make sure we cant return the book again (aka is false)
	}
}
