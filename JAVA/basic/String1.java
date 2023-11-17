package hw.ex02.string;

public class String1 {
	// String 사용 Tip
		// 1. String의 저장소는 Heap과 String constant pool 두가지가 있다.
		// 2. String constant pool을 사용하는 것이 메모리 관리측면에서 유리하다.
		// 3. String은 new로 생성하지 않는다. -> Heap을 거쳐서 사용하지 않는다.
		//    -> 이유는 성능적으로 느려진다.
	
	public static void main(String[] args) {
		// String pool test
		String str1 = "Test String"; // String pool에 저장된 값, 이게 정석적인 표현법
		String str2 = new String("Test String"); // heap에서 생성된 문자
		String str3 = str2.toString(); 			 // heap에서 생성된 문자
		String str4 = str2.intern(); // 문자열을 복사할 때 쓰는 메소드!! pool of unique strings.
		
		// 문자열 hasCode(고유ID) 출력
		System.out.println(str1.hashCode()); // 432811871
		System.out.println(str2.hashCode()); // 432811871
		System.out.println(str3.hashCode()); // 423811871
		System.out.println(str4.hashCode()); // 423811871
		
		// equals로 비교
		System.out.println("-------equals-------");
		System.out.println(str1.equals(str2)); // true
		System.out.println(str1.equals(str3)); // true
		System.out.println(str1.equals(str4)); // true
		System.out.println("--------------------");
		
		// 비교 연산자 활용하는 경우 (==) -> 메모리주소 기반으로 비교함으로 heap, String pool 값이 다르게 출력
		System.out.println("------ '==' ------");
		System.out.println(str1 == str2); // false
		System.out.println(str1 == str3); // false
		System.out.println(str1 == str4); // true
		System.out.println("------------------");
		
		// 메모리 주소 (고유주소)
		System.out.println(System.identityHashCode(str1)); // 245565335
		System.out.println(System.identityHashCode(str2)); // 2121744517
		System.out.println(System.identityHashCode(str3)); // 2121744517
		System.out.println(System.identityHashCode(str4)); // 245565335
		
		// 문자열 초기화 하는 방법
		String temp = ""; // 공백으로 초기화 하는 방법, 임시변수 만들 때 활용
		temp += "1234" + "홍길동\n";
		temp += "1234" + "홍길동\n";
		temp += "1234" + "홍길동\n";
		System.out.println(temp);
	}
}
