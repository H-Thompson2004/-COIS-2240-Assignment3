import static org.junit.Assert.*;

import org.junit.Test;

public class LibraryManagementTest {

	@Test
	public void testBookId() throws Exception {
		Book validBook1 = new Book(100, "valid1");
		Book validBook2 = new Book(999, "valid2");
		Book nonValidBook1 = new Book(1000, "nonValid1");
		Book nonValidBook2 = new Book(99, "nonValid2");
		
		throw new Exception("The Id value added is not valid (is not between 100 and 999");
		
	}

}
