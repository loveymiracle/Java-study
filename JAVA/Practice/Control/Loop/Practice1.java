import java.util.Scanner;

public class LoopPractice {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		LoopPractice lp = new LoopPractice();
		lp.practice1(); 
		lp.practice2(); 
		lp.practice3(); 
		lp.practice4(); 
		lp.practice5(); 
		lp.practice6(); 
		lp.practice7(); 
		lp.practice8(); 
		lp.practice9();
		}
		
	public static void practice1() {
		// 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력하세요.
		// 단, 입력한 수는 1보다 크거나 같아야 합니다.
		// 만일 1미만의 숫자가 입력됐다면 "1 이상의 숫자를 입력해주세요"를 출력하세요.
		// 4, 0
		System.out.println("1이상의 숫자를 입력하세요 : ");
		int value = Integer.parseInt(sc.nextLine());
		int i = 1;
		
		if(value == 0) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			while(i <= value) {
			System.out.print(i++ + " ");			
			}
		}
	}
  public static void practice1() {
		// 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력
		// 단, 입력한 수는 1보다 크거나 같아야 합니다.
		// 만일 1 미만의 숫자가 입력됐다면 "1 이상의 숫자를 입력해주세요"를 출력
		// 1이상의 숫자를 입력하세요 : 4
		// 1 2 3 4
		System.out.println("1이상의 숫자를 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		if(num > 1) {
			for (int i = 0; i <= num; i++) {
				System.out.print(i + " ");
			}	
		} else {
			System.out.println("1이상의 숫자를 입력해주세요");
		}
	}
