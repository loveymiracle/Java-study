
// 부모(조상) 클래스 
public class SuperClass {
	private		int privateValue = 5; // 본인만 활용 가능!
	protected 	int protectedValue = 10;
	public 		int publicValue = 20;
	
	// 부모의 생성자
	public SuperClass() {
		System.out.println("SuperClass의 default 생성자 입니다.");	
	}
	
	public void publicMethod() {
		System.out.println("SuperClass의 publicMethod입니다.");
	}

	public int getPrivateValue() {
		return privateValue;
	}

	public void setPrivateValue(int privateValue) {
		this.privateValue = privateValue;
	}
}
