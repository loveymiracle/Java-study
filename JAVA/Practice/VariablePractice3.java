
import java.util.Scanner;

public class VariablePractice3 {
	public static void main(String[] args) {
		// 키보드로 가로, 세로 값을 실수형으로 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
    // 계산 공식 ) 면적 : 가로 * 세로 , 둘레 : (가로 + 세로) * 2
		
		double width = 0;
		double depth = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가로를 입력 하세요.");
		width = sc.nextDouble();
		System.out.println("세로를 입력 하세요.");
		depth = sc.nextDouble();
		
		System.out.println("면적 : " + (width * depth));
		System.out.println("둘레 : " + (width + depth) * 2);
	}
}
