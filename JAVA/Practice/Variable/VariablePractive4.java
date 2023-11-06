
import java.util.Scanner;

public class VariablePractice4 {
	public static void main(String[] args) {
		// 영어 문자열 값을 입력 받아 문자에서 앞에서 세 개를 출력하세요.
		String str = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열을 입력하세요");
		str = sc.nextLine();
		System.out.println("첫 번째 문자 : " + str.charAt(0));
		System.out.println("두 번째 문자 : " + str.charAt(1));
		System.out.println("세 번째 문자 : " + str.charAt(2));
	}
}
