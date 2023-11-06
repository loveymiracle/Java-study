
import java.util.Scanner;

public class VariablePractice1 {
	public static void main(String[] args) {
		// 이름, 성별, 나이, 키를 사용자에게 입력 받아 각각의 값을 변수에 담고 출력하세요.
    // 이름을 입력하세요 : 아무개 
    // 성별을 입력하세요(남/여) : 남
    // 나이를 입력하세요 : 20
    // 키를 입력하세요(cm) : 180.5
    // 키 180.5cm인 20살 남자 아무개님 반갑습니다^^
		
		String name = null;
		String gender = null;
		int age = 0;
		double height = 0.0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		
		System.out.println("성별을(남/여) 입력하세요.");
		gender = sc.nextLine();
		
		System.out.println("나이를 입력하세요.");
		age = sc.nextInt();
		
		System.out.println("키를 입력하세요(cm).");
		height = sc.nextDouble();
		
		System.out.println("키 " + height + "cm인 " + age + "살 " + gender + "자 " + name + "님 반갑습니다 ^^");
	}
}
