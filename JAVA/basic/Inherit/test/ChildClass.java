
// 자식 클래스로 부모 SuperClass를 상속받을 Class	
public class ChildClass extends SuperClass {
	// 변수명이겹쳐도 선언은 가능하다.
	private		int privateValue 	= 105;
	protected 	int protectedValue	= 110;
	public 		int publicValue 	= 120;

	public ChildClass() {
		super(); // 부모의 생성자를 호출, 생략해도 자동으로 만들어진다.
		         // 자식 생성자 가장 첫 줄에 선언해야 하며, Constructor call must be the first statement in a constructor
				 // 부모의 생성자를 통해 부모의 메모리 공간이 생성되고 자식의 메모리공간이 이후에 할당된다.
		System.out.println("ChildClass의 생성자 입니다.");
		
		
		// Local 변수 = Stack에 메모리 공간이 잡히는 변수, 함수 호출 같이 없어
		int publicValue = 300;
		
		// Local변수 접근하는 방법 -> 그냥 접근하면 된다.
		// 원리 -> 선언된 가장 가까운 값이 변수의 값이 됩니다. -> 위치는 블록기준
		System.out.println(publicValue);
		
		// 본인의 멤버 변수 접근하는 방법
		// -> this 키워드 활용
		System.out.println("My private value : " + this.privateValue);
		System.out.println("My protected value : " + this.protectedValue);
		System.out.println("My public value : " + this.publicValue);
		
		// 부모의 멤버변수 접근하는 방법
		// -> super 키워드 활용
//		System.out.println("Super privateValue : " + super.privateValue); // 에러 발생!
		System.out.println("Super privateValue : " + super.getPrivateValue()); // 에러 발생!
		System.out.println("Super privateValue : " + super.protectedValue);
		System.out.println("Super privateValue : " + super.publicValue);
	}
	
	@Override // 오버라이드 됬다고 알려주는 어노테이션
	public void publicMethod() {
		System.out.println("ChildClass에서 오버라이드 된 publicMethod입니다.");
		super.publicMethod(); // 부모의 publicMethod를 호출하는 문법 -> 필요없으면 지우면 된다!!
	}
}
