import java.util.ArrayList;
import java.util.Iterator;

/**
 * The class Borrower is use to store borrower data and borrowed books if any
 */
public class Borrower implements Comparable<Borrower> {

	private int borrowerId;
	private String borrowerName;
	private ArrayList<Book> borrowedBooks = new ArrayList<Book>();

	public int getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}

	public String getBorrowerName() {
		return borrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	public ArrayList<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	@Override
	public String toString() {
		return borrowerName;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || this == null) {
			return false;
		}

		if (other instanceof Book) {
			if (((Borrower) other).borrowerId == this.borrowerId) {
				return true;
			}
		}

		return false;
	}

	public void attachBook(Book bk) {
		if(bk == null || bk.getBorrower() != null) {
			return;
		}
		
		borrowedBooks.add(bk);
	}
	
	public void detachBook(Book bk) {
		if(bk == null || bk.getBorrower() == null) {
			return;
		}
		
		bk.detachBorrower(this);
		
		Iterator<Book> it = borrowedBooks.iterator();
		
		while(it.hasNext()) {
			Book book = it.next();
			
			if(book == bk) {
				it.remove();
				return;
			}
		}
	}

	@Override
	public int compareTo(Borrower other) {
		return Integer.compare(this.borrowerId, other.borrowerId);
	}

}
