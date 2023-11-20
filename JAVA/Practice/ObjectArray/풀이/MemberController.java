package hw.member.controller;

import java.util.Arrays;

import hw.member.model.vo.Member;

public class MemberController {
	// Controller의 책임 범위(Responsibility Scope)
	// - View로 부터 사용자의 요청을 전달 받아 요청/답에 대한 흐름을 제어하는 역할
	// - 사용자의 입력 데이터를 전달받고, Model(DB)로 부터 데이터 확인을 거치고 성공/실패 페이징을 제어
	
	// Controller(Back-end)로서 책임져야하는 부분!
	// - 현재 코드 안에서 밖에서 발생할수 있는 다양한 에러나 문제를 미리 해결해야하고, (예외 처리)
	//   View가 단순화 될 수 있도록 일도 많이 해야한다!! ★★★★★ 매우 중요한 개념
	// - 이유 : View에서는 5개의 언어가 섞임으로 프로그래밍의 한계가 생김.
	
	// Controller 레벨에서 array가공하여 View에서 null 체크 안하게끔 짜는게 코드관점 유리하다.
	// --> null체크를 안하기 위해서는 중간에 null이 없도록 관리가 필요!!! ★★★★★
	
	public MemberController() { // test 용
		insertMember(new Member("test1", "홍길동", "1234", "test1@test.com", 'M', 31));
		insertMember(new Member("test2", "김길동", "4321", "test2@test.com", 'M', 32));
		insertMember(new Member("test3", "이길동", "1234", "test3@test.com", 'M', 24));
		insertMember(new Member("test4", "최길순", "4321", "test4@test.com", 'F', 27));
		insertMember(new Member("test5", "홍길동", "1234", "test1@test.com", 'M', 41));
	}
	
	public static int MAX_SIZE = 10; // 배열의 최대 크기
	private Member mArray[] = new Member[MAX_SIZE]; // 배열
	private int size = 0; // 현재 인원 수
	
	// 멤버의 수를 돌려주는 메소드
	public int existMemberNum() {
		return size;
	}
	
	/**
	 * @see id를 입력 받고, array에서 index를 탐색하여 돌려주는 메소드
	 * @param id : 사용자의 아이디
	 * @return index를 반환하고, 0 이상일 경우 탐색 성공, -1 일 경우 탐색 실패
	 */
	private int searchIdForIndex(String id) {
		for(int i = 0; i < size; i++) { // size까지만 돌고, null체크를 안하는 규칙으로 코딩
//			if(mArray[i] == null) { // null 체크 필수!!! -> 룰에 의해서 null 체크 안해도 됨
//				continue;
//			}
			
			if(mArray[i].getId().equals(id)) { // id를 찾았을 때!! equals 필수!!
				return i;
			}
		}
		return -1;
	}
	
	// 중복된 아이디를 찾아 여부를 돌려주는 메소드
	public boolean checkId(String inputId) {
		int index = searchIdForIndex(inputId);
		if(index >= 0) { // id가 존재하는 경우
			return true;
		} else {
		return false;
		}
	}
	
	// 아이디를 찾아 객체로 반환
	public Member searchId(String id) {
		int index = searchIdForIndex(id);
		
		if(index >= 0) {
			return mArray[index];
		} else {
			return null;
		}
	}
	
	// 이름이 일치하는 Member를 찾아 모두 돌려주는 메소드, 중요한건 이름은 중복될 수 있음!!
	public Member[] searchName(String name) {
		Member tempArray[] = new Member[MAX_SIZE];
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(mArray[i].getName().contains(name)) { // contains : 포함되는 것도 찾아주는 메소드
				tempArray[count++] = mArray[i];
			}
		}
		return Arrays.copyOf(tempArray, count); // 검색된 크기 만큼 짤라주는 코드
		// --> null 체크 안하도록 controller에서 가공해주는 코드, view 에서는 null 체크 안해도 된다!!
	}
	
	public Member[] searchEmail(String email) {
		Member tempArray[] = new Member[MAX_SIZE];
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(mArray[i].getName().contains(email)) { 
				tempArray[count++] = mArray[i];
			}
		}
		return Arrays.copyOf(tempArray, count); 
	}
	
//	public boolean insertMember(String id, String name, String password, String email, char gender, int age) {
//		return false;	
//	}
	
	// 인자 6개는 많다, 이것을 객체로 줄일 생각을 해야 한다.
	public boolean insertMember(Member member) {
		// 최대 인원인 경우 false 
		if(size == MAX_SIZE) {
			return false;
		}
		
		// 최대 인원인 경우 2배로 배열을 늘리는 코드 ★★★ ArrayList는 해당 방식으로 구현됨.
//		if(size == MAX_SIZE) {
//			MAX_SIZE = MAX_SIZE * 2; // 2배로 사이즈 조정
//			mArray = Arrays.copyOf(mArray, MAX_SIZE); // 사이즈를 늘려주고 복사하는 코드
//		}
//		
		// insert하는 코드 -> 전체 가운데 빈공간이 없을 때 끝을 채워준다.
		mArray[size++] = member;
		return true;
	}
	
	
	
	public boolean updatePassword(String id, String password) {
		int index = searchIdForIndex(id);
		
		if(index < 0) {
			return false;
		}
		mArray[index].setPassword(password);
		return true;
		}
	
	public boolean updateName(String id, String name) {
		int index = searchIdForIndex(id);
		
		if(index < 0) {
			return false;
		}
		mArray[index].setName(name);
		return true;
		}
	
	public boolean updateEmail(String id, String email) {
		int index = searchIdForIndex(id);
		
		if(index < 0) {
			return false;
		}
		mArray[index].setEmail(email);
		return true;
		}
		
	// insert 정책 : 배열에 들어온 순서대로 member를 채워주는 정책 = Queue 정책을 그대로
	// delete 정책 : 1개나, 마지막은 문제가 없다. 
	//              중간에 삭제되는 경우는 빈공간이 없도록 빈공간을 뒤에 객체로 채워줄 예정
	// 삭제 정책 예시
	// size = 5
	// [홍길동][최길동][박길동][김길동][이길동] // step 0, 초기상태 -> 최길동 삭제 요청!!
	// [홍길동][	  ][박길동][김길동][이길동] // step 1, 최길동을 삭제, 빈공간 발생!!
	// [홍길동][박길동][    ][김길동][이길동] // step 2, 박길동을 최길동 자리로 이동
	// [홍길동][박길동][김길동][    ][이길동] // step 3, 빈공간 메꾸는 일 반복
	// [홍길동][박길동][김길동][이길동][    ] // step 4, 모두 삭제하고 size = 4 로 바꿈
	// 전길동의 삽입 요청!!
	// [홍길동][박길동][김길동][이길동][전길동] size = 4 에 전길동을 삽입, size = 5로 변경
	
	public boolean delete(String id) {
		int index = searchIdForIndex(id);
		
		if(index == -1) { // 예외 처리
			return false;
		}
		
		// 당기는 로직 (빈공간 채우기) !
		for(int i = index; i < size - 1; i++) {
			mArray[i] = mArray[i + 1];
		}
		mArray[size - 1] = null; // 마지막 공간의 중복된 데이터를 삭제한다.
		size--;
		return true;
		}
	
	// allDelete - overloading 연습.
	public void delete() {
		MAX_SIZE = 10;
		size = 0;
		mArray = new Member[MAX_SIZE]; // 기존 member 공간은 사용하지 않는데, gc가 회수해준다.
	}
	
	public Member[] printAll() {
		return Arrays.copyOf(mArray, size);
		}
	
	// MemberController 검증하는 코드, TDD 코딩 스타일
//	public static void main(String[] args) { // test 용
//		MemberController mc = new MemberController();
//		System.out.println(Arrays.toString(mc.printAll()).replace("],", "],\n"));
//		System.out.println(mc.existMemberNum());
//		mc.insertMember(new Member("test1", "홍길동", "1234", "test1@test.com", 'M', 31));
//		mc.insertMember(new Member("test2", "김길동", "4321", "test2@test.com", 'M', 32));
//		mc.insertMember(new Member("test3", "이길동", "1234", "test3@test.com", 'M', 24));
//		mc.insertMember(new Member("test4", "최길순", "4321", "test4@test.com", 'F', 27));
//		mc.insertMember(new Member("test5", "홍길동", "1234", "test1@test.com", 'M', 41));
//		System.out.println(mc.existMemberNum());
//		boolean result = mc.insertMember(new Member("test11", "박길동", "4321", "test2@test.com", 'M', 25));
//		System.out.println(result); // false! = 결과 false
//		System.out.println(mc.existMemberNum());
//		
//		// checkId
//		System.out.println("check test6 : " + mc.checkId("test6")); // true = 중복됨
//		System.out.println("check test15 : " + mc.checkId("test15")); // false = 중복됨
//		
//		// searchId, test6, test15
//		System.out.println("test6 search : " + mc.searchIdForIndex("test6"));
//		System.out.println("test15 search : " + mc.searchIdForIndex("test15"));
//		
//		// searchName, '김길동', '홍길동', '홍길순', '길동', '길순'
//		System.out.println("김길동 : " + Arrays.toString(mc.searchName("김길동")));
//		System.out.println("최길순 : " + Arrays.toString(mc.searchName("최길순")));
//		System.out.println("홍길순 : " + Arrays.toString(mc.searchName("홍길순")));
//		System.out.println("길동 : " + Arrays.toString(mc.searchName("길동")));
//		System.out.println("길영 : " + Arrays.toString(mc.searchName("길영")));
//		
//		// searchEmail
//		System.out.println("test3 : " + Arrays.toString(mc.searchEmail("test3")));
//		
//		// updatePassword
//		System.out.println("pw, name, email 변경");
//		System.out.println("이전 : " + mc.searchId("test1"));
//		System.out.println(mc.updatePassword("test1", "1111"));
//		System.out.println(mc.updateName("test1", "김길순"));
//		System.out.println(mc.updateEmail("test1", "test222@home.com"));
//		System.out.println("이후 : " + mc.searchId("test1")); // 1111
//		
//		System.out.println("없는 케이스");
//		System.out.println(mc.updatePassword("test20", "1111"));
//		System.out.println(mc.updateName("test20", "1111"));
//		System.out.println(mc.updateEmail("test20", "1111"));
//		
//		// delete테스트 구간이 제일 중요!!!
//		System.out.println("삭제 테스트");
//		System.out.println(Arrays.toString(mc.printAll()).replace("],", "],\n"));
//		System.out.println(mc.existMemberNum());
//		System.out.println(mc.delete("test1"));
//		System.out.println(mc.existMemberNum());
//		System.out.println(Arrays.toString(mc.printAll()).replace("],", "],\n"));
//		System.out.println("------------------------------------------");
//		System.out.println(Arrays.toString(mc.printAll()).replace("],", "],\n"));
//		System.out.println(mc.existMemberNum());
//		System.out.println(mc.delete("test6"));
//		System.out.println(mc.existMemberNum());
//		System.out.println(Arrays.toString(mc.printAll()).replace("],", "],\n"));
//		System.out.println("-------------------------------------------");
//		System.out.println(Arrays.toString(mc.printAll()).replace("],", "],\n"));
//		System.out.println(mc.existMemberNum());
//		System.out.println(mc.delete("test10"));
//		System.out.println(mc.existMemberNum());
//		System.out.println(Arrays.toString(mc.printAll()).replace("],", "],\n"));
//	}
}
