package hw.ex02.poly_exam;

// 부모 CLASS
public class Car {
	// 공통으로 사용할 멤버변수
	protected String name; // 자동차 이름
	protected int cc = 0; // 배기량!
	
	// 인자 있는 생성자를 통해서 필수적인 정보를 담는다. -> 인자 없는 생성자는 만들지 않는다.
	public Car(String name, int cc) {
		this.name = name;
		this.cc = cc;
	}
	
	// 공통 기능 1. 주유 기능
	public void oilling() {
		System.out.println("주유중 입니다.");
	}
	
	// 공통 기능 2. 움직이는 기능
	public void move() {
		System.out.println("부릉부릉");
	}
	
	@Override
	public String toString() {
		String str = "";
		str += "name : " + name + ", ";
		str += "Classname : " + this.getClass().getSimpleName() + ", ";
		str += "cc : " + cc;
		return str;
	}
}
