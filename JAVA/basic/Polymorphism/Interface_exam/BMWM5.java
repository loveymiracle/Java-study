package hw.ex04.interface_exam;

// 외제차
public class BMWM5 extends Car implements OverseasType {

	public BMWM5() {
		super("BMW M5", 4395); // 4395cc
	}
	
	@Override
	public void oilling() {
		System.out.println("고급 휘발유를 주유중입니다.");
	}
	
	@Override
	public void move() {
		System.out.println("부아아아아앙(시끄럽다.)");
	}
	
	public void nickName() {
		System.out.println("독삼사의 좋은차");
	}

	@Override
	public void origin() {
		System.out.println("Made in germany");
	}

	@Override
	public String getOrigin() {
		return "germany";
	}
}
