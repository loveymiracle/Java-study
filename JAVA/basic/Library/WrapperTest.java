package hw.ex06.wrapper;

import java.util.ArrayList;
import java.util.List;

public class WrapperTest {
	// Wrapper Class의 역할
	//  : 기본형을 Wrapping해서 참조형으로 변환 시켜주는 기능
	//  - Integer, Double .. 
	// 1. 기본형의 도움을 줄수 있는 API를 제공함.
	// 2. ArrayList와 같은 객체기반의 자료구조에 기본형을 담을때 사용됨.
	
	public static void main(String[] args) {
		int age = 26;
//		Integer ageObj = new Integer(age); // Java 5버전 이전 문법
//		Integer ageObj = (Integer)(age); // Boxing, Java 5버전 이전 문법
		Integer ageObj = age; // AutoBoxing // 5버전 이후 문법, 기본형<->참조형 자동 형변환
		
		System.out.println(ageObj);
		System.out.println(ageObj.toString());
		
		// 기본형의 컬렉션 활용, 기본형의 List를 선언할 수 없다!
//		List<int> list = new ArrayList<>(); // 문법 에러 발생!!
		List<Integer> list = new ArrayList<>(); // Wrapper Class로 int 대체해서 선언 가능!!
		list.add((Integer)1);
		list.add((Integer)2);
		list.add((Integer)3);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list);
		
		// API적인 활용
		
		// 1. 문자 해석 가능 = parseXXXXX
		System.out.println(Integer.parseInt("123"));
		System.out.println(Double.parseDouble("3.14"));
		
		// 2. 숫자간의 대소 비교 ✭✭✭✭✭✭ 외워라!
		// -> 정렬 기능 구현 시 필수적으로 활용하는 문법
		// 문자열 비교 방법 : "abc".compareTo("adc");
		System.out.println(Integer.compare(30, 10)); // 1 : 앞이 크면 양수
		System.out.println(Integer.compare(10, 30)); // -1 : 뒤가 크면 음수
		System.out.println(Integer.compare(10, 10)); // 0 : 같으면 0
		
		// 3. min max 구할 때
		System.out.println(Integer.min(5, 2));  // 2
		System.out.println(Integer.max(10, 2)); // 10
		
		// 4. 기본형의 최대값, 최소값
		System.out.println(Integer.MAX_VALUE); 
		System.out.println(Integer.MIN_VALUE);
	}
}
