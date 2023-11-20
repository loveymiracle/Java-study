package hw.poly.model.vo;

public class CookBook extends Book {
	private boolean coupon;

	public CookBook() {
		super();
	}

	public CookBook(String title, String author, String publisher, boolean coupon) {
		super(title, author, publisher);
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return "CookBook [title=" + getTitle() + ", author="
				+ getAuthor() + ", publisher="
				+ getPublisher() + ", coupon=" + coupon + "]";
	}

	public boolean isCoupon() {
		return coupon;
	}

	public void setCoupon(boolean coupon) {
		this.coupon = coupon;
	}
}
