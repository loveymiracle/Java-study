package hw.ex04.interface_exam;

// interface란?
// - 주로 코드간의 설계 규격을 맞추거나 또는 특별한 type임을 알리기 위해 활용되는 문법
public interface ElectricType {
	// 멤버변수는 public static을 생략 가능하다. -> 만일 생략하면 public static 자동으로 붙는다.
	// 상수만 선언할 수 있다.
	
	// 해당 차량의 연료 type
	String GAS_TYPE2 = "전기"; // 굵은 이탤릭체 : (public static final) 생략 된 상태..
	
	// 생략이 가능하더라도 원래 문법대로 선언하는 것을 추천한다.
	public static final String GAS_TYPE = "전기";
	
	// 멤버 메소드 -> 모두 추상 메소드가 된다.
	public abstract void charge(); // 충전 기능 
}
