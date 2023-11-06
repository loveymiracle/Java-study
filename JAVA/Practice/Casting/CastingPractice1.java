
import java.util.Scanner;

public class CastingPractice1 {
	public static void main(String[] args) {
		// 문자 하나를 입력 받아 그 문자의 유니코드를 출력하세요.
    // ex. 문자 : A 
    // A unicode : 65
		
		String str = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자를 입력하세요.");
		str = sc.nextLine();
		int Value = str.charAt(0);
		System.out.println(str + " unicode :" + Value);
	}
}
