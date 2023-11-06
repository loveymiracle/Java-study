// 중괄호 : 블록 범위 
public class BaiscVariable {
	
//	int myValue; // 멤버 변수 

	public static void main(String[] args) {
		// 변수 선언 방법
		// 1) Type 변수명; // 선언만 하는 방법
		// 2) Type 변수명; = 리터럴(값); // 선언과 동시에 값을 초기화 하는 방법
		
		// 방법1 실습, ※ 주의 : 변수를 초기화 하지 않으면 에러가 발생한다!
		int myValue; // 0x100 번지에 할당된다.
//		System.out.println(myValue); // 변수를 초기화 하기 전에 사용하면 에러 발생!!
		myValue = 100;
		System.out.println(myValue); //100
		myValue = 123;
		// 선언 된 변수는 재사용이 가능하다. 범위는 자신의 블록(block)영역 까지
		// 블록 = 중괄호 {~~~}
		System.out.println(myValue); // 123
		
		// 방법2 : 보편적인 방법
		int myValue2 = 123; // 적절한 초기값으로 초기화하면 된다.
		System.out.println(myValue2);
		
		// 변수 선언 안되는 경우 (컴파일적으로) 3가지
		// 1. 예약어를 사용하면 안된다.
		// 2. 숫자로 시작하면 안된다.
		// 3. 특수문자는 '_' '$'만 사용할 수 있다.
		
//		int static = 0; // Syntax error
//		int 321Value = 0; //
//		int @!@#Value = 0;
//		int _$Value = 0; // 가급적 _$는 쓰지 말것
		
		// 변수 선언 요령 = 회사/프로젝트에서의 제약
		// 1. 대소문자 구별이 명확한 카멜 표기법을 사용한다. = myValueOfAge
		// 2. 변수명을 사람들이 쉽게 인지 할 수 있도록 선언한다.
		//    -> a,b,c x,y,z는 abc 일반적인 변수명으로 금지 -> 수학기호나 알고리즘 짤때는 인정
		//   a = 31; // 나이, b = "홍길동" ..
		// 3. 영문으로 표기한다. 한글사용금지. 인코딩 이슈 -> 프로그램 에러 발생...
		// 4. 멤버변수와 지역변수는 중복을 피한다. 단, 일시적인 코드는 가능
		// 5. 변수명 적절한 길이로 선언? myValueOfAddress = 허용 범위 마지노선
		// 전문가스럽게...
	}
}
