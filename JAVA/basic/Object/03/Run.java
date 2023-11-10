
import com.multi.ex02.object.Member;
import com.multi.ex02.object.MemberVO;

// 실행 클래스의 일종, 따로 멤버 변수나 메소드 없이 main만 가지는 Class
public class Run {
	public static void main(String[] args) {
		// Member 객체 실습 공간
		Member m = new Member(); // 객체를 변수로 선언시 최근에는 1 ~ 2 글자로 줄여서 활용하는 방법
		
		System.out.println("Member Default값 출력");
		System.out.println(m.name); // 생성자에서 초기화 된 값이 출력
		System.out.println(m.age);  // 생성자에서 초기화된 1이 출력됨
		System.out.println(m.phoneNum); // 참조형은 일반적으로 null로 초기화 된다.
		System.out.println(m.address);  //멤버변수 선언 시 초기화된 값
		System.out.println("----------------------------------");
		
		// 멤버변수로 접근하는 방법 = .(dot) 연산자 활용
		m.name = "홍길동";
		System.out.println(m.name);
		m.sayHello();
		System.out.println("----------------------------------");
		
		
		// getter, setter 활용법
		m.setName("홍길동");
		System.out.println(m.getName());
		System.out.println("----------------------------------");
		
		
		// 이름과 주소를 동시에 변경하는 메소드 호출
		m.setNameAndAddress("박길동", "서울시 강남구 역삼동");
		System.out.println(m.getName() + ", " + m.getAddress());
		System.out.println("----------------------------------");
		
		
		// set and get 활용
		String name = m.setAndGetName("최길동");
		System.out.println("변경된 이름 : " + name);
		System.out.println("----------------------------------");
		// member 실습 끝!
		
		// MemberVO 실습 시작
		MemberVO m2 = new MemberVO("홍길동", 31, "010-1234-5678", "서울시 강남구 역삼동");
		System.out.println(m2.getName());
		System.out.println(m2.getAge());
		System.out.println(m2.getPhoneNum());
		System.out.println(m2.getAddress());
//		m2.name = "박길동"; // 안된다! private 	접근제한자 때문에 외부에서 접근 불가능!
		m2.setName("박길동");
		String str = m2.toString(); // 일종의 getter다.
		System.out.println(str);
		System.out.println(m2.toString());
		System.out.println("----------------------------------");
		
		
		// 객체 배열 맛보기
		MemberVO mArray[] = new MemberVO[5];
		mArray[0] = new MemberVO("홍길동", 23, "010-1324-5768", "서울시 강남구 역삼동");
		mArray[1] = new MemberVO("박길동", 31, "010-1234-5678", "서울시 강남구 삼성동");
		mArray[2] = new MemberVO("최길동", 26, "010-1231-4678", "서울시 강남구 대치동");
		mArray[3] = new MemberVO("김길동", 24, "010-1334-5578", "서울시 강남구 도곡동");
		mArray[4] = new MemberVO("고길동", 27, "010-4321-5778", "서울시 강남구 논현동");
		
		for(int i = 0; i < mArray.length; i++) {
			System.out.println(mArray[i].toString());
		}
	}
}
