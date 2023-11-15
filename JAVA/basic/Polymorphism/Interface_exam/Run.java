package hw.ex04.interface_exam;

public class _Run {
	public static void main(String[] args) { // main : 프로그램이 돌아가는 첫번째 메소드
		// 부모의 type
		Car[] carArray = new Car[5];
		
		carArray[0] = new Avante();
		carArray[1] = new Sonata();
		carArray[2] = new Grandeur();
		carArray[3] = new BMWM5();
		carArray[4] = new TeslaModel3();
		
		for(Car car : carArray) {
			printCar(car);
		}
	}
	
	public static void printCar(Car car) { 
		System.out.println(car.toString());
		
		car.move(); 
		
		// 전기차 내연차 구별하여 주유나 충전
		if(car instanceof ElectricType) { // 전기차 식별하는 방법
			((ElectricType)car).charge(); // interface도 casting이 가능하다.
		} else { // 내연차
			car.oilling();
		}
		
		if(car instanceof HyundaiCar) {
			((HyundaiCar)car).nickName(); 	
			((HyundaiCar)car).service();
			System.out.println(((HyundaiCar)car).serviceName);
		}
		
		if(car instanceof BMWM5) {
			((BMWM5)car).nickName();
		}
		
		if(car instanceof OverseasType) {
			((OverseasType)car).origin();
			System.out.println(((OverseasType)car).getOrigin() + "에서 수입 되었습니다.");
			
		}
		System.out.println();
	}
}
