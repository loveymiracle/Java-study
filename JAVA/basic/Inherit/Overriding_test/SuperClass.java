
public class SuperClass {
	// 접근 제한자 별로 Override 실습
	private void privateMethod() {
		System.out.println("privateMethod 호출!");
	}

	void defaultMethod() {
		System.out.println("defaultMethod 호출!");
	}
	
	protected void protectedMethod() {
		System.out.println("protectedMethod 호출!");
	}
	
	public void publicMethod() {
		System.out.println("publicMethod 호출!");
	}
	
	// final : 메소드에 붙으면 상속(오버라이드) 불가를 선언
	public final void finalMethod() {
		System.out.println("finalMethod 호출!");
	}
}
