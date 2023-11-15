package hw.ex02.poly_exam;

// 초기에 생성자 관련 에러가 발생했다.
//Implicit super constructor car() is undefined for default constructor. Must define an explicit constructor
public class Avante extends Car {
	
	// 인자 있는 생ㅅ엉자를 자동 생성
//	public Avante(String name, int cc) {
//		super(name, cc);
//	}
	
	public Avante() {
		super("아반떼", 1600); // 아반뗴는 1600cc
	}
	
	@Override
	public void oilling() {
		System.out.println("휘발유를 주유합니다.");
	}
	
	// 자식의 고유 메소드
	public void avanteNickName() {
		System.out.println("아방이");
	}
}
