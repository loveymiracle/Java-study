
import com.multi.ex02.object.MemberVO;

public class TestMethod {
	public static void main(String[] args) {
		// static 메소드 사용법
		// static 메소드의 올바른 접근 방법 -> Class이름.Static메소드();
		MyObject.staticMethod(); // static 메소드는 이텔릭체로 기울어짐
		MyObject test = new MyObject();
		test.staticMethod(); // 생성된 객체를 통해서도 접근 가능하지만 권장하지 않음!
	}
}

// default Class : 같은 패키지에서만 활용 가능한 Class -> 쓰면 안된다.
class MyObject{
	
	// static 메소드 : 외부에서 클래스의 생성(new) 없이 접근 가능한 메소드
	// public static 붙여서 사용 한다.
	public static void staticMethod() {
		System.out.println("Static 메소드 입니다!");
	}
	
	// 인자 1개 받는 메소드
	public void singleParameter(String str) {
		System.out.println(str);
	}
	
	// 인자는 무제한으로 선언할 수 있지만, 상식적으로  3 ~ 4개까지가 적당. 많아도 5개 까지만..
	// 5개 이상부터는 Class로 묶어서 인자를 받는 형태로 설계
	// 인자 2개 이상 받는 메소드
	protected void multipleParameter(int a, int b, String str) {
		System.out.println(a + b);
		System.out.println(str);
	}
	
	// 많은 인자를 한번에 받는 Class 인자 예시
	void printMember(MemberVO m) { // -> m에서는 인자 4개를 가지고 있음.
		System.out.println(m.getName());
		System.out.println(m.getAge());
		System.out.println(m.getPhoneNum());
		System.out.println(m.getAddress());
	}
	
	// 반환값이 있는 메소드
	int returnValue(int a, int b) {
		return a + b;
	}
	
	// toString꼴
	String returnValue2(String name, String address) {
		return "이름 : " + name + ", 주소 : " + address;
	}
}
