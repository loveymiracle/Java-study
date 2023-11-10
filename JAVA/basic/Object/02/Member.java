

// 객체란 ? 현실에서 존재하는 대상(Object)를 출상화하여 데이터 + 메소드로 표현한 방법
// Member : 한 사람의 개인 정보를 추상화 시켜 놓은 객체, 추상화 : 일부만 활용한다!
public class Member {
	// 멤버의 블록, 이곳을 필드라 부른다.
	// 시작은 보통 선언부로 시작, 선언부 : 객체 상단에서 멤버 변수 선언하는 곳
	// 멤버 변수란? 객체가 가질 수 있는 데이터(속성)
	// -> 멤버 변수는 사용자가 초기화 하지 않아도 0에 준하는 값으로 초기화 됨.
	// -> 숫자는 0;, 참조형(String, 다른 type)은 null로 초기화
	public String name; 	// 이름
	public int age; 		// 나이
	public String phoneNum; // 전화번호
	public String address = "서울시 강남구"; 	// 주소

	// 생성자란?
	// - 객체가 생성될 때 호출되는 특별한 메소드
	// - 용도 : 객체의 멤버변수를 초기화 하거나 다른 초기화 로직이 필요할 때 활용
	// - 특징 : return 값을 가질 수 없다. 멤버변수의 선언 불가. 만일 만들지 않으면 java가 자동으로 생성해준다.
	// - 객체이름() : default 생성자의 꼴, 만일 없으면 java 언어에서 생성시켜 주는 생성자 타입
	
	public Member() { // 생성자 : new Member(); //new 뒤에서 호출되는 메소드가 생성자
		name = "이름 없음"; // 의도적인 초기화
		age = 1;
	}
	
	// 메소드 : 객체에서 특별한 기능을 가지는 함수
	// void method() : 인자(입력값)와 리턴값(출력값)이 모두 없는 메소드, 가장 기본적인 꼴
	// void : 리턴값이 없을 때 메소드 앞에서 사용하는 키워드
	public void sayHello() {
		System.out.println("안녕하세요? 저는 " + name + "입니다.");
	}
	
	// 파라미터(인자)란? : 메소드(함수) 외부에서 함수를 호출 할 떄 입력 값으로 전달 되는 변수, 함수의 로컬변수로 취급된다.
	// this : 객체에서 자기 자신을 가리키는 키워드, 필드 영역으로 돌아와 멤버변수나 메소드를 찍을 수 있는 키워드
	// void method(인자1) : 리턴값은 없고, 인자(파라미터) 1개를 가지는 메소드
	// 로컬변수 : 메소드가 호출될 때 메모리에 같이 생성되고, 메소드가 종료되면 같이 사라지는 변수
	// setter의 표준 형태 - write only(쓰기 전용)
	public void setName(String name) {
//		String name = null; // Duplicate local variable name
//		name = "홍길동"; // 전달받은 인자를 다른 값으로 바꾸는 문장 -> 의미 없음!!!
		this.name = name; // 멤버변수의 name = 지역변수 파라미터의 name; 덮어 쓰기 하는 과정!!
	}
	
	// void method(인자1, 인자2) : 리턴값이 없고 인자가 2개를 가지는 메소드
	public void setNameAndAddress(String name, String address) {
		this.name = name; // 멤버변수 = 지역변수 파라미터의 name
		this.address = address;
	}
	
	// String method() : 리턴 type의 리턴 값만 있는 형태, 인자는 없음.
	// getter의 표준형태 - read only(읽기 전용)
	public String getName() {
//		return this.name;
		return name; // this.name 동치인 표현, 인자나 로컬변수에 name 변수가 없음으로 멤버변수 name을 매칭함
	}
	
	public String getAddress() {
		return address;
	}
	
	// 리턴 시킬 타입과 실제 리턴 하는 값의 타입은 일치해야 한다.
	public int getAge() {
		return age;
	}
	
	// 문자열 type으로 나이를 반환
	public String getAgeStr() {
		return "" + age;
	}
	
	// String method(인자) : 인자가 있고, 리턴값도 존재하는 메소드
	// 보통 인자는 많아도 3~4개 까지 권장. 그 이상 될 때는 다른 방법으로 전달할 필요성이 있음.
	public String setAndGetName(String name) {
		this.name = name;
		return this.name;
	}
}
