package hw.poly.model.vo;

public class Book {
	
	private String title;
	private String author;
	private String publisher;
	
	public Book() {
		super();
	}
	
	public Book(String title, String author, String publisher) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void getAuthor() {
		return;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void getPublisher() {
		return;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + "]";
	}
}
