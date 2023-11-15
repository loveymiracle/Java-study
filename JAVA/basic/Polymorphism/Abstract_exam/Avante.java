package hw.ex03.abstract_exam;

// 현대카 상속!
public class Avante extends HyundaiCar {

	public Avante() {
		super("아반떼", 1600); // 아반뗴는 1600cc
	}
	
	@Override
	public void oilling() {
		System.out.println("휘발유를 주유합니다.");
	}
	
//	public void avanteNickName() {
//		System.out.println("아방이");
//	}
	
	@Override
	public void nickName() {
		System.out.println("아방이");
	}
}
