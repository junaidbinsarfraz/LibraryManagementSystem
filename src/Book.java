/**
 * This class Book is used to store a book data and borrower if any
 */
public class Book implements Comparable<Book> {

	private int catNumber; // A unique ID for each book
	private String author;
	private String title;
	private Borrower borrower; // The person who borrowed the book; when a book
								// is borrowed or returned this field must be
								// updated.

	public int getCatNumber() {
		return catNumber;
	}

	public void setCatNumber(int catNumber) {
		this.catNumber = catNumber;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	
	public void attachBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	
	public void detachBorrower(Borrower borrower) {
		this.borrower = null;
	}
	
	@Override
	public String toString() {
		return "CatNumber : " + catNumber + ", Title : " + title + ", Author : " + author + ", Borrower : " + borrower;
	}
	
	@Override
	public boolean equals(Object other) {
		if(other == null || this == null) {
			return false;
		}
		
		if(other instanceof Book) {
			if(((Book) other).catNumber == this.catNumber) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int compareTo(Book other) {
		return Integer.compare(this.catNumber, other.catNumber);
	}

}
