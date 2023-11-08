import java.util.Scanner;

public class ControlPractice {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ControlPractice cp = new ControlPractice();
		cp.practice1();
		cp.practice2();
		cp.practice3();
		cp.practice4();
		cp.practice5();
		cp.practice6();
		cp.practice7();
		cp.practice8();
	}
	
	public void practice1() {
		// 키보드로 입력 받은 하나의 정수가 양수이면 "양수다" 양수가 아니면 "양수가 아니다"를 출력하세요.
		// -9
		System.out.println("정수 : ");
		int value = Integer.parseInt(sc.nextLine());
		if(value > 0) {
			System.out.println("양수다");
		} else {
			System.out.println("양수가 아니다");
		}
	}
