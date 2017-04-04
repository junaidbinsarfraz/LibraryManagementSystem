import java.util.ArrayList;

public class Borrower {

	private int borrowerId;
	private String borrowerName;
	private ArrayList<Book> borrowedBooks;

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
		return "";
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

	public void attachBook() {

	}
	
	public void detachBook() {
		
	}

}
