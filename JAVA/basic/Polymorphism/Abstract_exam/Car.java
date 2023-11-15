package hw.ex03.abstract_exam;

// 추상 클래스화
// -> 부모는 추상클래스로 생성하지 못하게 만드는 것이 좋다.
public abstract class Car {
	protected String name;
	protected int cc = 0;
	
	public Car(String name, int cc) {
		this.name = name;
		this.cc = cc;
	}
	
	public void oilling() {
		System.out.println("주유중 입니다.");
	}
	
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
