package hw.ex04.interface_exam;


// 전기차 + 외제차 (중국차)
public class TeslaModel3 extends Car implements ElectricType, OverseasType{

	public TeslaModel3() {
		super("테슬라 모델3", 175); // kw/h
	}
	
	@Override
	public void oilling() {
		charge(); // 인터페이스에서 강제화한 charge 메소드
	}

	@Override
	public void origin() {
		System.out.println("Made in china");
	}

	@Override
	public String getOrigin() {
		return "china";
	}

	@Override
	public void charge() {
		System.out.println("테슬라 전용 충전기로 충전합니다.");
	}
}
