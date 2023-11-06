
public class BasicVariable2 {
	// 기본형 Type (8가지)
	// 1. 정수형 : byte(1), short(2), int(4)✭, long(8)✭
	// 2. 실수 : float(4), double(8)✭
	// 3. 문자 : char(2)
	// 4. 논리형 : boolean(1)✭
	
	public static void main(String[] args) {
		// 1. 정수형 
		byte byteValue = 127;
		short shortValue = 32000;
		int intValue = 2_100_000_000; // 정수를 _로 분류 표기 가능 
//		long longValue = 21000000000; // long은 리터럴 끝에 'l' , 'L' 필요!
		long longValue1 = 21000000000l;
		long longValue2 = 2100000000L;
		
		System.out.println(byteValue);
		System.out.println(shortValue);
		System.out.println(intValue);
		System.out.println(longValue1);
		System.out.println(longValue2);
		
		// 2. 실수 float(4), double(8)✭
		// 실수는 정확도에 대한 이슈가 발생하여 가능하면 큰수를 쓰는 것이 일반적이다.
		float floatValue   = 3.141592653589793238f; // float 리터럴 끝에 'f', 'F' 필요!
		double doubleValue = 3.141592653589793238;
		
				
		System.out.println(floatValue); // 3.1415927
		System.out.println(doubleValue); // 3.141592653589793
		// 부동소수점의 표현은 계산의 오류가 내포한다는 것을 인지해야함
		// 컴퓨터에서 부동소수점 연산은 항상 오차를 발생하나 double로 사용할 경우 오차가 극히 적음.
		// 부동소수점 표현 방법 지수부(10^-1), 가수부 (314159265...)로 구성되어 있음
		// 실제 변수 크기에 따라 표현이 제한적이다!
		
		// BigDecimal -> 가급적 프로그래밍적으로 쓰지 말것!!
//		BigDecimal bigDecimal = new BigDecimal("3.141592654689794348384950834059834905");
	
		// 부동소수점 오차 테스트
		float testFloat = 0.1f + 0.2f;
		double testDouble = 0.1 + 0.2;
		
		System.out.println(testFloat);  // 예측 : 0.3, 결과 : 0.3
		System.out.println(testDouble); // 예측 : 0.3, 결과 : 0.30000000000000004
		// 결론 : 부동소수점은 항상 오차 가능성이 존재함으로 자릿수 제한이 필요!
		
		// 자릿수 자르는 예시
		// 1. 문자열 포멧이용
		String str = String.format("%.2f", testDouble); // 소수점 2번째 자리까지 자르는 방법
		System.out.println(str);
		System.out.println(String.format("%.2f", testDouble));
		
		// 2. printf의 포멧팅 방법
		System.out.printf("%.2f", testDouble);
		System.out.println();
		
		// 3. 문자 char(2)
		// ' = 싱글코테이션
		// " = 더블코테이션 
		char charValue1 = 'A'; // 문자로 표현하는 것이 정석 
		char charValue2 = 65; // 아스키코드상 'A'가 되는 숫자
		char charValue3 = '가';
//		char charValue4 = '가나다'; // 1문자만 담을 수 있는 공간 
		String strValue = "가나다"; // 문자열 
		
		System.out.println(charValue1);
		System.out.println(charValue2);
		System.out.println(charValue3);
		System.out.println(strValue);
		System.out.println(charValue1 + charValue2);  // 문자열간 합연산이 가능하다. 숫자연산이 된다. 
		System.out.println("" + charValue1 + charValue2);  // "AA" 문자열로 바꿔서 합연산 하는 경우 문자가 합쳐진. 
		System.out.println((int)charValue3); // 44032 = '가'의 유니코드 
		System.out.println((char)charValue3 + 1); // 44033 '각'의 유니코드  
		System.out.println((char)(charValue1 + 1)); // B
		
		// 알파벳 순서대로 출력하는 방법
		for(int i = 0; i < 26; i++) {
			System.out.print((char)(i + 'A'));
		}
		System.out.println();
		
		// 4. 논리형 boolean(1)
		// 논리형 : 참과 거짓 값을 판별하는 값 
		boolean isTrue = true; // 참 = 1
		boolean isFalse = false; // 거짓 = 0
		System.out.println(isTrue);
		System.out.println(isFalse);
		System.out.println(!isTrue);
		
		// 상수란? 프로그래밍에서 변하지 않는 값
		// 상수 변수명 표기 방법 : 모두 대문자를 사용하고 띄어쓰기를 '_'로 표현하는 헝가리 표기법 사용
		final int USER_MAX_VALUE = 50; // 수강인원 최대 수 
		final int USER_MIN_VALUE = 10; // 수강인원 최소 수 
//		USER_MAX_VALUE = 10; // 상수는 한번 초기화 하면 변경할 수 없다!
		
		System.out.println(USER_MAX_VALUE);
		System.out.println(USER_MIN_VALUE);
	}
	
	// 프로그램에서 상수는 public final static로 표현하는 것이 정석
	public static final int USER_MAX_VALUE2 = 60;
}
