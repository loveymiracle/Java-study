package hw.poly.controller;

import hw.poly.model.vo.AniBook;
import hw.poly.model.vo.Book;
import hw.poly.model.vo.CookBook;
import hw.poly.model.vo.Member;

public class LibraryController {
	
	private Member mem = null;
	private Book bList[] = new Book[5];
	
	{
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("탑의신", "소고기", "내이놈", 16);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	}
	
	public void insertMember(Member mem) {
		this.mem = mem;
	}
	
	public Member myInfo() {
		return this.mem;
	}
	
	public Book[] selectAll() {
		return bList;
	}
	
	public Book[] searchBook(String keyword) {
		Book newb[] = new Book[5];
		
		for(int i = 0; i < bList.length; i++) {
			if(bList[i].getTitle().contains(keyword)) {
				newb[i] = bList[i];
			}
		}
		return newb;
	}

	public int rentBook(int index) {
		int result = 0;
		
		if(bList[index] instanceof AniBook) {
			if(myInfo().getAge() < ((AniBook)bList[index]).getAccessAge()) {
				result = 1;
			}
		}
		if(bList[index] instanceof CookBook) {
			if(((CookBook)bList[index]).isCoupon() == true) {
				int couponCount = myInfo().getCouponCount() + 1;
				myInfo().setCouponCount(couponCount);
				result = 2;
			}
		}
		return result;
	}
}
