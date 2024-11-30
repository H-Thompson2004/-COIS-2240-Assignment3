import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Member> members = new ArrayList<Member>();
    private List<Book> books = new ArrayList<Book>();

    // Add a new member to the library
    public boolean addMember(Member member) {
    	int memberId = member.getId();
    	
    	//if there is no current member that matches the added members Id
    	if(findBookById(memberId) == null) {
    		members.add(member);
    		return true;
    	}
    	else //if there is a match from the added members Id to one of the current members
    		return false;
    }
    
    // Add a new book to the library
    public boolean addBook(Book book) {
    	int bookId = book.getId();
    	
    	//if there is no book that matches the added book's Id
    	if(findBookById(bookId) == null) {
    		books.add(book);
    		return true;
    	}
    	else //if there is a match from the added book's Id to one of the books
    		return false;
    }

    // Find a member by ID
    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    // Find a book by ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Get the list of members
    public List<Member> getMembers() {
        return members;
    }
    
    // Get the list of books
    public List<Book> getBooks() {
        return books;
    }
}
