
import java.util.Scanner;

public class VariablePractice2 {
	public static void main(String[] args) {
		// 키보드로 정수 두 개를 입력 받아 두 수의 합, 차, 곱, 나누기한 몫을 출력하세요.
		
		int first = 0;
		int second = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫 번째 정수를 입력 하세요.");
		first = sc.nextInt();
		System.out.println("두 번째 정수를 입력 하세요.");
		second = sc.nextInt();
		
		System.out.println("더하기 결과 : " + (first + second));
		System.out.println("빼기 결과 : " + (first - second));
		System.out.println("곱하기 결과 : " + (first * second));
		System.out.println("나누기 몫 결과 : " + (first / second));
	}

}

