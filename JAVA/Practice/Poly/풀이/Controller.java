package hw.poly.controller;

import java.util.Arrays;

import hw.poly.model.vo.AniBook;
import hw.poly.model.vo.Book;
import hw.poly.model.vo.CookBook;
import hw.poly.member.vo.Member;

public class LibraryController {
	private Member mem = null;
	private Book[] bList = new Book[5];

	{
		bList[0] = new CookBook("백종원의 집밥", "백종원", "tvN", true);
		bList[1] = new AniBook("탑의신", "소고기", "내이놈", 16);
		bList[2] = new AniBook("루피의 원피스", "루피", "japan", 12);
		bList[3] = new CookBook("이혜정의 얼마나 맛있게요", "이혜정", "문학", false);
		bList[4] = new CookBook("최현석 날 따라해봐", "최현석", "소금책", true);
	}

	public void insertMember(Member member) {
		this.mem = member;
	}

	public Member myInfo() {
		return mem;
	}

	public Book[] selectAll() {
		return bList;
	}

	public Book[] searchBook(String keyword) {
		Book[] tempArary = new Book[bList.length];
		int count = 0;
		for(int i = 0; i < bList.length; i++) {
			if(bList[i].getTitle().contains(keyword)) {
				tempArary[count++] = bList[i];
			}
		}
		return Arrays.copyOf(tempArary, count);
	}

//	switch (result) {
//	case 0: System.out.println("성공적으로 대여되었습니다."); break;
//	case 1: System.out.println("나이 제한으로 대여 불가능입니다.");  break;
//	case 2: System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요."); break;
//}
	public int rentBook(int index) {
		// 예외처리부
		if(index < 0 || index > bList.length || mem == null) {
			return -1;
		}
		
		Book book = bList[index];
		int result = 0;
		if(book instanceof AniBook) {
			int accessAge = ((AniBook)book).getAccessAge();
			if(accessAge > mem.getAge()) {
				result = 1;
			}
		} else if (book instanceof CookBook) {
			boolean isCoupon = ((CookBook)book).isCoupon();
			if(isCoupon == true) {
				mem.setCouponCount(mem.getCouponCount() + 1);
				result = 2;
			}
		}
		return result;
	}
}
