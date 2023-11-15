package hw.ex03.abstract_exam;

public class _Run {
	public static void main(String[] args) { // main : 프로그램이 돌아가는 첫번째 메소드
		// 부모의 type
		Car[] carArray = new Car[4];
		
		carArray[0] = new Avante();
		carArray[1] = new Sonata();
		carArray[2] = new Grandeur();
		carArray[3] = new BMWM5();
		
		for(Car car : carArray) {
			printCar(car);
		}
	}
	
	public static void printCar(Car car) { 
		System.out.println(car.toString());
		
		car.move(); 
		car.oilling();
		
		if(car instanceof HyundaiCar) {
			((HyundaiCar)car).nickName(); 	
			((HyundaiCar)car).service();
			System.out.println(((HyundaiCar)car).serviceName);
		}
		
		if(car instanceof BMWM5) {
			((BMWM5)car).nickName();
		}
		System.out.println();
	}
}
