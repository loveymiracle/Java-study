package hw.practice2.model.vo;

public class Book {
	private String title;
	private String publisher;
	private String author;
	private int price;
	private double discountRate;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String publisher, String author, int price, double discountRate) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.discountRate = discountRate;
	}

	public Book(String title, String publisher, String author) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", publisher=" + publisher + ", author=" + author + ", price=" + price
				+ ", discountRate=" + discountRate + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	

}
