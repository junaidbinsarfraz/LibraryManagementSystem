import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * The class Library is use to manage books and borrowers
 */
public class Library {

	Set<Borrower> borrowers = new TreeSet<Borrower>();
	Set<Book> books = new TreeSet<Book>();

	/**
	 * The registerBorrower() method is use to register borrower
	 * 
	 * @param id
	 * @param name
	 */
	public void registerBorrower(int id, String name) {
		Borrower borrower = new Borrower();

		borrower.setBorrowerId(id);
		borrower.setBorrowerName(name);

		borrowers.add(borrower);
	}

	/**
	 * The addBook() method is use to add new book into the set
	 * 
	 * @param catNum
	 * @param title
	 * @param author
	 */
	public void addBook(int catNum, String title, String author) {
		Book book = new Book();

		book.setAuthor(author);
		book.setCatNumber(catNum);
		book.setTitle(title);
		book.setBorrower(null);

		books.add(book);
	}

	/**
	 * The displayAvailableBooks() method is use to display all available books
	 */
	public void displayAvailableBooks() {
		Iterator<Book> it = books.iterator();

		System.out.println("\nFollowing books are available for loan\n\n");

		while (it.hasNext()) {
			Book book = it.next();

			if (book.getBorrower() == null) {
				System.out.println(book + "\n");
			}
		}
	}

	/**
	 * The displayNonAvailableBooks() method is use to display all non-available
	 * books
	 */
	public void displayNonAvailableBooks() {
		Iterator<Book> it = books.iterator();

		System.out.println("\nFollowing books are not available for loan\n\n");

		while (it.hasNext()) {
			Book book = it.next();

			if (book.getBorrower() != null) {
				System.out.println(book + "\n");
			}
		}
	}

	/**
	 * The lendOneBook() method is use to lend one book
	 * 
	 * @param catNum
	 * @param brId
	 */
	public void lendOneBook(int catNum, int brId) {
		Book book = getBook(catNum);
		Borrower borrower = getBorrower(brId);

		if (book == null || borrower == null || book.getBorrower() != null) {
			System.out.println("Unable to lend this book");
			return;
		}

		book.attachBorrower(borrower);
		borrower.attachBook(book);
	}

	/**
	 * The getBook() method will return existing book from set
	 * 
	 * @param catNum
	 * @return
	 */
	public Book getBook(int catNum) {
		Iterator<Book> it = books.iterator();

		while (it.hasNext()) {
			Book book = it.next();

			if (book.getCatNumber() == catNum) {
				return book;
			}
		}

		return null;
	}

	/**
	 * The getBorrower() method will return existing borrower from set
	 * 
	 * @param brId
	 * @return
	 */
	public Borrower getBorrower(int brId) {
		Iterator<Borrower> it = borrowers.iterator();

		while (it.hasNext()) {
			Borrower borrower = it.next();

			if (borrower.getBorrowerId() == brId) {
				return borrower;
			}
		}

		return null;
	}

	/**
	 * The returnOneBook() method will return a lended book
	 * 
	 * @param catNum
	 */
	public void returnOneBook(int catNum) {
		Book book = getBook(catNum);
		Borrower borrower = book.getBorrower();

		if (borrower == null) {
			return;
		}

		borrower.detachBook(book);
	}

	public static void main(String[] args) {

		Library library = new Library();

		// Test-case 1
		System.out.println("Running test-case 1");
		library.registerBorrower(1, "John");
		System.out.println("Borrower Added");

		// Test-case 2
		System.out.println("Running test-case 2");
		library.addBook(123, "Physics", "Smith");
		System.out.println("Book Added");

		// Test-case 3
		System.out.println("Running test-case 3");
		library.displayAvailableBooks();

		// Test-case 4
		System.out.println("Running test-case 4");
		library.displayNonAvailableBooks();

		// Test-case 5
		System.out.println("Running test-case 5");
		library.lendOneBook(123, 1);

		library.displayAvailableBooks();

		library.displayNonAvailableBooks();

		// Test-case 6
		System.out.println("Running test-case 6");
		library.returnOneBook(123);

		library.displayAvailableBooks();

		library.displayNonAvailableBooks();
	}

}
