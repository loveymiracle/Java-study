import java.util.Arrays;

// 객체배열
public class ObjectArray {
	public static void main(String[] args) {
		// 선언 및 초기화 문법
		MemberVO mArray[];
		MemberVO mArray1[] = null;
		MemberVO mArray2[] = new MemberVO[10]; // 표준적으로 배열을 초기화 시키는 문장
		MemberVO mArray3[] = /*new MemberVO[]*/ {
				new MemberVO("test1", "홍길동", 23),
				new MemberVO("test2", "최길동", 24),
				new MemberVO("test3", "박길동", 25),		
		};
		
//		mArray[0].setName("홍길동");  // 죽는 이유 : 배열 변수를 초기화 하지 않아서
//		mArray1[0].setName("홍길동"); // 죽는 이유 : Null발생!, 초기화 된 null로 객체를 접근해서 죽음 = PointerException
//		mArray2[0].setName("홍길동"); // 죽는 이유 : 배열은 생성했지만, Member 객체가 생성되지 않은 상태로 접근해서 죽음! 
//		System.out.println(Arrays.toString(mArray2));
		mArray2[0] = new MemberVO(); // null인 공간에 객체 생성
//		mArray2[0].getName().length(); // 죽는 이유 : 문자열을 초기화 하지 않아서 죽었다.
		System.out.println(Arrays.toString(mArray3));
		
		
		System.out.println(mArray3[0].getName().length()); // 초기화가 된 값을 가져옴으로 제대로된 값이 살아있다.
		System.out.println("-------------------------------------------");
		
		// 객체 배열을 올바르게 초기화 하고 사용하는 방법
		// 1. 배열을 선언하고 배열의 알맞은 크기로 초기화
		// 2. 실제 사용할 객체를 new로 생성하여 배열에 채워 놓는다.
		// 3. 배열 빈 공간이 생길 수 있으므로 항상 null 체크를 진행하고 해당 영역에 접근해야 한다.
		MemberVO mArray4[] = new MemberVO[10]; // 10개의 빈방
		mArray4[0] = new MemberVO("test1", "홍길동", 25);
		mArray4[1] = new MemberVO("test2", "이길동", 34);
		mArray4[2] = new MemberVO("test3", "고길동", 13);
		
		// null check하는 방법
		if(mArray4[0] != null) {
			System.out.println(mArray4[0].getName());
		}
	
		// null check하는 방법
		if(mArray4[3] != null) { // 사람 없는 곳
			System.out.println(mArray4[3].getName());
		}
		
		// 객체 배열을 초기화 하는 방법
		// 1. 인자 있는 생성자를 통해 초기화
		for(int i = 0; i < mArray4.length; i++) {
			mArray4[i] = new MemberVO("test" + (i + 1), "홍길동" + (i + 1), 25 + i);
		}
		System.out.println(Arrays.toString(mArray4));
		
		// 2. default 생성자를 활용하여 생성하고 setter로 초기화 하는 방법
		// -> 초기화문이 너무 길어질 때 밑으로 라인을 늘리는 방법 -> 가독성 확보!!
		for(int i = 0; i < mArray4.length; i++) {
			mArray4[i] = new MemberVO(); // default 생성자로 객체 생성
			mArray4[i].setId("test" + (i + 1));
			mArray4[i].setName("홍길동" + (i + 1));
			mArray4[i].setAge(25 + i);
		}
		System.out.println(Arrays.toString(mArray4));
		
		// 객체 배열 순회하는 방법
		
		// 1. 일반 반복문을 통해 순회하는 방법 - i(index)를 통해서 접근하는 고전적인(C언어) 방법
		System.out.println("---------------------------------------");
		for(int i = 0; i < mArray4.length; i++) {
			System.out.println(mArray4[i].toString());
			int age = mArray4[i].getAge() + 1;
			mArray4[i].setAge(age);
		}
		System.out.println("---------------------------------------");
	
		// 2. for each문 (Advance for문) : for문의 개선된 문법으로 객체로 배열 순회가 가능한 방법 ✭✭✭✭✭
		// 문법 : for(Type 변수명 : [배열이나 컬렉션]){ ... }
		// 단점 : index를 따로 알 수 없으므로 index는 필요한 경우는 고전 for문을 활용 할 것!
		// 강사가 추천하는 for each문 생성법 -> Type을 String으로 선언하고 자동완성으로 Type 바꾼다.
//		step1. for(String m : mArray4) {} -> type이 에러난 상태로 만든다.
//		step2. for(memberVO m : mArray4) {} -> 에러를 선택해서 올바른 타입으로 바꾼다.
		System.out.println("---------------------------------------");
		System.out.println("for each문");
		for(MemberVO m : mArray4) { // 배열에서 인덱스 차례대로 객체를 넘겨준다. 범위는 index 끝까지!!
			System.out.println(m);
			int age = m.getAge() + 1;
			m.setAge(age);
			System.out.println(m);
		}
		System.out.println("---------------------------------------");
		
		// 3. 꼼수 - 배열을 출력하는데 객체를 한 라인 마다 출력하는 쉬운 방법
		System.out.println("---------------------------------------");
		System.out.println(Arrays.toString(mArray4)); // -> 한라인에 옆으로 길어지는 출력문 나옴
		System.out.println(Arrays.toString(mArray4).replace("],", "] \n"));
		System.out.println("---------------------------------------");
		
		// 객체 배열에서 삭제 된 영역 skip하는 방법
		// -> 객체 배열에서는 빈공간이 발생 했을 때 이를 skip하는 방법이 필요
		mArray4[3] = null; // 데이터 삭제!
		for(MemberVO m : mArray4) {
			if(m == null) {
				continue;
			}
			System.out.println(m);
			m.setAge(m.getAge() + 1);
		}
	}
}
