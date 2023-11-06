
public class TypeCasting {
	// TypeCasting이란? type간의 형을 변환하는 방법, ex) int -> long, int -> double
	
	// 종류 2가지
	// 1) 자동 형변환 : 작은 Type에서 큰 Type으로 갈 때, 아무 문제가 없고, cast를 명시하지 않아도 된다. (묵시적 형변환)
	// 2) 강제 형변환 : 큰 Type에서 작은 Type으로 갈 때, 데이터 손실이 발생할 수 있다. (명시적 형변환)
	//               반드시 cast 문법을 명시해야한다. -> 안하면 에러 발생 -> 프로그램이 죽는다!
	
	public static void main(String[] args) {
		byte value = 100; // java에서 정수는 int형으로 정의된다.
		value = 123; // 자동 형변환 
		value = (byte)123; // 강제 형변환, 굳이 할 필요는 없다.
//		value = 4000; // Type mismatch : cannot convert from int to byte, 자동 형변환 불가한 상황!
		value = (byte)4000; // 강제 형변환 -> overflow 발생!
		System.out.println(value); // -96 = overflow 된 숫자.
		
		// 의도한 강제 형변환 문법 1. 소수점 버리기 !!
		int intValue = 0;
		double doubleValue = 3.14;
//		intValue = doubleValue; // Type mismatch : cannot convert from double to int
		intValue = (int)doubleValue;
		System.out.println(doubleValue);
		System.out.println(intValue);
		
		
		// 의도한 강제 형변환 문법 2. 문자열 형변환
		char ch = 'A';
		int alpha = ch; // 65, 자동 형변환 발생!
		System.out.println(ch); // 'A'
		System.out.println(alpha); // 65
		System.out.println((char)alpha); // 강제 형변환
		System.out.println((char)++alpha); // 강제 형변환
		System.out.println((char)++alpha); // 강제 형변환
		System.out.println((char)++alpha); // 강제 형변환
		System.out.println((char)++alpha); // 강제 형변환
		// 대문자를 소문자로 바꾸는 방법 
		System.out.println('A' - 'a'); // gap 계산
		System.out.println((char)(alpha - 'A' + 'a'));
	}
}
