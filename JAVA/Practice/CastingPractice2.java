
import java.util.Scanner;

public class CastingPractice2 {
	public static void main(String[] args) {
		// 실수형으로 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
    // 이 때 총점과 평균은 정수형으로 처리하세요.
		
		double Korean = 0.0;
		double English = 0.0;
		double Mathmatics = 0.0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국어 점수를 입력하세요.");
		Korean = sc.nextDouble();
		
		System.out.println("영어 점수를 입력하세요.");
		English = sc.nextDouble();
		
		System.out.println("수학 점수를 입력하세요.");
		Mathmatics = sc.nextDouble();
		
		System.out.println("총점 : " + (int)(Korean + English + Mathmatics));
		System.out.println("평균 : " + (int)((Korean + English + Mathmatics)/3));		
	}
}
