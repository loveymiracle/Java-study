package hw.ex02.poly_exam;

public class _Run {
	public static void main(String[] args) { // main : 프로그램이 돌아가는 첫번째 메소드
		// 부모의 type
		Car[] carArray = new Car[5];
		
		carArray[0] = new Car("", 1000); // 이름 없는 자동차
		carArray[1] = new Avante();
		carArray[2] = new Sonata();
		carArray[3] = new Grandeur();
		carArray[4] = new BMWM5();
		
		for(Car car : carArray) { // 열거형
			printCar(car);
			// 만약 아반떼의 닉네임을 출력하고 싶다면 ? -> cast 검사가 필요하다!.
//			((Avante)car).avanteNickName();
//			java.lang.ClassCastException:
//			class com.multi.ex02.poly_exam.Car cannot be cast to class com.multi.ex02.poly_exam.Avante
//			(com.multi.ex02.poly_exam.Car and com.multi.ex02.poly_exam.Avante are in unnamed module of loader 'app')
		}
	}
	
	// 자동차가 가지고 있는 모든 정보를 출력
	public static void printCar(Car car) { // 인자를 부모의 Type으로 받을 수 있다.
		System.out.println(car.toString());
		
		car.move(); // 동적 바인딩 발생하는 곳!!
		// 동적 바인딩이란?
		// - 컴파일 시점에 호출될 메소드를 특정하지 않고, 실행중(runtime) 도중 동적으로 호출될 메소드를 찾아 정해지는 메커니즘
		// - 이 시점에서는 부모의 move를 실행할 지 자식의 move를 실행할지를 실시간으로 찾아서 정해준다.
		// Avante -> 부모의 move 실행
		// Sonata -> Sonata Class의 move 실행
		
		car.oilling();
		
		// 각자의 닉네임을 출력하는 방법
		// instanceof 연산자 : 객체와 Class Type을 비교해서 동일한 type일 경우 true, 아닐 경우 false
		if(car instanceof Avante) {
//			((Avante)car).avanteNickName();
			Avante avante = (Avante)car; // step1
			avante.avanteNickName(); 	 // step2
		}
		if(car instanceof Sonata) {
			((Sonata)car).sonataNickName();
		}
		if(car instanceof Grandeur) {
			((Grandeur)car).grandeurNickName();
		}
		if(car instanceof BMWM5) {
			((BMWM5)car).nickName();
		}
		System.out.println();
	}
}
