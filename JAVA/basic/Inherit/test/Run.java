
public class Run {
	
	public static void main(String[] args) {
		System.out.println("부모 클래스 생성!");
		new SuperClass(); 
		System.out.println("부모 클래스 끝!");
		
		System.out.println("자식 클래스 생성!");
		new ChildClass(); 
		System.out.println("자식 클래스 끝");
		
		// 부모의 publicMethod 접근하는 방법
		// -> 자신의 클래스에서 오버라이딩 하지 않으면 부모의 메소드가 호출된다.
		// -> 만일 오버라이딩 된 메소드가 자식에 존재하면 자식 메소드를 호출한다.
		new ChildClass().publicMethod();
		System.out.println("-------------------------------------------");
		// 한번 오버라이딩 된 메소드는 부모의 type으로도 메소드를 호출 될 수 없다.
		((SuperClass)new ChildClass()).publicMethod(); // 안된다!!!
	}
}

// 부모 클래스 생성!
// SuperClass의 default 생성자 입니다.
// 부모 클래스 끝!
// 자식 클래스 생성!
// SuperClass의 default 생성자 입니다.
// ChildClass의 생성자 입니다.
// 자식 클래스 끝
