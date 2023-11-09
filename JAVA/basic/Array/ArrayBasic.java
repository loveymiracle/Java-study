
import java.util.Arrays;

// 배열
public class ArrayBasic {
	public static void main(String[] args) {
		System.out.println("1. 배열 기본 생성법");
		
		int[] array = null; // null로 초기화가 가능하다. = 참조형 변수
		array = new int[10]; // 10개의 공간을 heap에서 할당받는 문법, 내부는 0으로 초기화 된다.
		// 만일 배열을 생성하지 않고 사용하는 경우는 ?
		// java.lang.NullPointerException: Cannot load from int array because "array" is null
		
		System.out.println(array[0]); // 초기값은 0
		System.out.println(array[1]); // 두번째 초기값도 0
		System.out.println("----------------------------------------");
		
		// 배열값 변경하는 방법
		array[0] = 0;
		array[1] = 1;
		array[2] = 2;
		
		// 반복문을 통해 배열값을 초기화 하는 방법
		for(int i = 0; i < 10; i++) { // 배열순회 표준 문법 ✭, new int[10] 배열의 크기만큼 제어값을 설정하면 된다.
//		for(int i = 0; i <= 10; i++) { // -> IndexOutOfBoundsException 발생 문법!!
//		for(int i = 0; i <= 9; i++) { // 권장하지 않는 문법. 사용하지 말것!
//		for(int i = 0; i <= 10-1; i++) { // 권장하지 않는 문법. 사용하지 말것!
			array[i] = i;
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println("----------------------------------------");
		
		// 잘못된 인덱스로 순회하면 아래와 같은 에러가 발생한다.
		// java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
		
		System.out.println("2. 배열을 직접 선언하는 방법");
		int[] array2 = new int[10]; // ✭기본적인 배열 선언법
		int[] array3 = {1,2,3,4,5,6,7,8,9,10,11,12}; // 직접 선언하는 방법
		int[] array4 = new int[]{1,2,3,4,5,6,7,8,9,10}; 
//		int[] array5 = new int[10]{1,2,3,4,5,6,7,8,9,10}; // 크기를 지정하면 에러 발생!!
		
		
		// Hard 코딩 : 개발자가 직접 상수나 특정 데이터 값을 손으로 기입하는 방법
		//            -> 하드 코딩은 약간의 부정적인 용어로 이슈 발생 가능성이 존재!
		//               특히 동적인 상황에서는 에러가 발생한다.
		
		// 하드 코딩 예시
		// 아래 코드에 13이라는 부분이 하드코딩 되어 있다고 말한다.
//		for(int i = 0; i < 13; i++) { // 만일 오타가 발생한 경우라면 ?
			//
//			System.out.print(array3[i] + " ");
//		}
	
		// 배열순회 올바른 코딩 방법 ✭✭✭✭✭
		// - 배열 순회시 아래의 표현법으로 코딩해야한다.
		// array3.length : 배열의 크기를 저장한 변수, type은 int
		for(int i = 0; i < array3.length; i++) {
			System.out.print(array3[i] + " ");
		}
		System.out.println();
		
		System.out.println("3. 배열의 표준적인 사용법");
		int[] array5 = new int[12]; // 배열 선언 및 배열의 크기를 12로 초기화 하는 문장
		for(int i = 0; i < array5.length; i++) {
			array5[i] = i;
		}
		
		// 배열값을 간단하게 출력하는 방법
		String str = Arrays.toString(array5);
		System.out.println(str);
		System.out.println(Arrays.toString(array5)); // 한줄 처리
		
		// 문자 배열
		char[] charArray1 = new char[5];
		char[] charArray2 = { 'a', 'b', 'c', 'd', 'e' };
		System.out.println(Arrays.toString(charArray2));
		
		// 문자열 배열
		String[] strArray1 = new String[5];
		String[] strArray2 = { "사과", "바나나", "딸기", "수박", "멜론" };
		System.out.println(Arrays.toString(strArray2));
	}
}
