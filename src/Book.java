
public class Book {

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
	
	public void attachBorrower() {
		
	}
	
	public void detachBorrower() {
		
	}
	
	@Override
	public String toString() {
		return "";
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

}
