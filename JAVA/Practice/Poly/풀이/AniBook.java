package hw.poly.model.vo;

public class AniBook extends Book {
	
	private int accessAge;

	public AniBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AniBook(String title, String author, String publisher, int accessAge) {
		super(title, author, publisher);
		this.accessAge = accessAge;
	}

	@Override
	public String toString() {
		return "AniBook [title=" + getTitle() + ", author="
				+ getAuthor() + ", publisher="
				+ getPublisher() + ", accessAge=" + accessAge + "]";
	}

	public int getAccessAge() {
		return accessAge;
	}

	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}
}
