import java.util.Scanner;

public class OperatorPractice {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		OperatorPractice op = new OperatorPractice();
		op.practice1();
		op.practice2();
		op.practice3();
		op.practice4();
	}
	
	public void practice1() {
		// ex
    		// 인원 수 : 29
		// 사탕 개수 : 100

    		//answer
		//1인당 사탕 개수 : 3
		//남는 사탕 개수 : 13
		System.out.println("practice1!!");
		
		System.out.println("인원 수 : ");
		int men = Integer.parseInt(sc.nextLine());
		
		System.out.println("사탕 개수 : ");
		int amount = Integer.parseInt(sc.nextLine());
		
		int each = amount / men;
		int rest = amount % men;
		
		System.out.println("1인당 사탕 개수 : " 	+ each);
		System.out.println("남는 사탕 개수 : "	+ rest);
	}
