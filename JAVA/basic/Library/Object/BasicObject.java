package hw.ex01.object;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BasicObject {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object object1 = new Object();
		Object object2 = new String("test");
		Object object3 = "test";
		Member m1 = new Member("test1", "홍길동", 21); // 1 == 3
		Member m2 = new Member("test2", "박길동", 26); // 1 != 2
		Member m3 = new Member("test1", "홍길동", 21);
		
		// toString() : 일반적으로 객체의 정보를 문자열로 출력함, 메소드 없이 객체의 이름이 자동으로 toString을 호출
		System.out.println(object1.toString());
		// java.lang.Object@5eb5c224 toString을 선언하지 않은 경우 나오는 패턴
		// Full Class Name@해쉬코드
		System.out.println(object2.toString());
		System.out.println(object3);
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3);
		// com.multi.ex01.object.Member@ - toString을 오버라이드 하지 않으면 출력되는 패턴
		// 만일 hashCode를 오버라이드 하지 않은 경우 메모리 주소를 참조하여 hash코드가 발생된다.
		// -> equals를 제대로 활용할 수 없다.
		System.out.println("----------------------------------------------------");
		
		// hashCode : 객체의 고유 식별 번호
		// -> equals를 활용하기 위해선 개별적으로 hasCode를 객체에서 오버라이드가 필요!!
		System.out.println(object1.hashCode()); // 1588970020
		System.out.println(object2.hashCode()); // 3556498 -> 문자열 "test"
		System.out.println(object3.hashCode()); // 3556498 -> 문자열 "test"
		// 오버라이드 전!!
//		System.out.println(m1.hashCode()); // 183264084 // 1 == 3 
//		System.out.println(m2.hashCode()); // 476402209
//		System.out.println(m3.hashCode()); // 1490180672
		// 오버라이드 후!!
		System.out.println(m1.hashCode()); // -822971165 // 1 == 3 
		System.out.println(m2.hashCode()); // -829416561
		System.out.println(m3.hashCode()); // -822971165
		System.out.println("----------------------------------------------------");
		
		// identityHashCode : 실제 메모리 주소 기반으로 hasCode를 확인하는 방법
		// -> 메모리 기준으로 객체가 다른지 확인할 수 있다.
		System.out.println("identityHashCode");
		System.out.println(System.identityHashCode(m1));
		System.out.println(System.identityHashCode(m2));
		System.out.println(System.identityHashCode(m3));
		
		// equals : 객체의 고유 값을 비교하여 객체가 같은지 확인해주는 메소드
		// -> 실제 Class를 설계할 때 오버라이드가 필요
		// 객체간 비교하는 방법
		// -> 예전에는 사람 손으로 일일히 비교해야 했다.
//		boolean isEquals = m1.getName().equals(m2.getName()) && m1.getAge() == m2.getAge();
		
		System.out.println("객체 비교");
		System.out.println(m1 == m3); // false, 주소상으로는 객체가 같지 않다!!
		System.out.println(m1.equals(m3)); // true, 재정의된 equals  실제 값을 비교한다.
		
		// clone : 객체를 복사하는 메소드, 오버라이드 필요 !!
		// -> 만드는 방법 많이 귀찮다.
//		Member m4 = m1; // soft copy
		// Hard copy? -> clone을 활용, 방법 중 하나!
//		Member m4 = new Member(m1.getId(), m1.getName(), m1.getAge()); // 방법 중 하나...? -> 추천X
		Member m4 = m1.clone();
		System.out.println("clone 된 객체 비교");
		System.out.println(m1 == m4); // false, 주소상으로는 객체가 같지 않다.!!
		System.out.println(m1.equals(m4));
		System.out.println("----------------------------------------------");
		
		// getClass : Class의 정보를 가져올때 활용 (클래스 이름, 메소드, 멤버변수 선언 된 값, 실제값)
		// -> 해당 기능을 통해 Class의 모든 정보를 알수 있고 자동화 처리가 가능하다. (Spring의 핵심 원리)
		// 자세한건 리플랙션 개념글 참고 : https://steady-coding.tistory.com/609
		System.out.println(object3.getClass().getName()); // 패키지 포함한 이름
		System.out.println(object3.getClass().getSimpleName()); // 클래스 이름 
		System.out.println(object3.getClass().getSuperclass().getName()); // 부모
		for (Method method : object3.getClass().getMethods()) {
//			System.out.println(method.getName());
			if(method.getName().equals("length")) {
				System.out.println(method.invoke(object3, null));
				System.out.println(((String)object3).length());
			}
		}
	}
}
