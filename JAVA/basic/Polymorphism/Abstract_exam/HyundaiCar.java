package hw.ex03.abstract_exam;

// abstract 클래스 특징
// 1. new로 생성되지 않는다.
// 2. abstract 메소드를 가질 수 있다.
// 3. 일반 메소드나 멤버변수 선언도 자유롭다.

// 활용방법 : 주로 부모클래스 상속이 되거나 Type으로 활용된다.
// 추상클래스도 일반 멤버변수를 가질 수 있다.

public abstract class HyundaiCar extends Car {
	// 현대자동차의 공통적인 필드
	public String serviceName = "블루핸즈";

	public HyundaiCar(String name, int cc) {
		super(name, cc);
	}
	
	// 추상 메소드 : 몸통을 가지지 않고, 상속받은 자식이 강제로 해당 메소드를 오버라이드 해야 한다.
	abstract public void nickName(); // 몸통이 없다!!! { .. } !!! 
	
	// 일반 메소드 : 공통적인 기능을 구현할 때는 일반 메소드로 구현하고 자식 클래스에서는 그냥 재사용한다.
	public void service() { // 블루핸즈로 간다.
		System.out.println(serviceName + "로 출발합니다!");
	}
}
