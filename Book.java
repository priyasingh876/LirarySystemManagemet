package pkg.book;

import java.io.Serializable;

public class Book  implements Serializable{
	private int isnb;
	private String title;
	private String author;
	private String puplisher;
	private int edition;
	private String subject;
	private int available_quantity;
	public int getIsnb() {
		return isnb;
	}
	public void setIsnb(int isnb) {
		this.isnb = isnb;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPuplisher() {
		return puplisher;
	}
	public void setPuplisher(String puplisher) {
		this.puplisher = puplisher;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getAvailable_quantity() {
		return available_quantity;
	}
	public void setAvailable_quantity(int available_quantity) {
		this.available_quantity = available_quantity;
	}
	public Book(int isnb, String title, String author, String puplisher, int edition, String subject,
			int available_quantity) {
		super();
		this.isnb = isnb;
		this.title = title;
		this.author = author;
		this.puplisher = puplisher;
		this.edition = edition;
		this.subject = subject;
		this.available_quantity = available_quantity;
	}
	public Book() {
		super();
		
	}
	@Override
	public String toString() {
		return "Book [isnb=" + isnb + ", title=" + title + ", author=" + author + ", puplisher=" + puplisher
				+ ", edition=" + edition + ", subject=" + subject + ", available_quantity=" + available_quantity + "]";
	 }
	
	}
	
	


