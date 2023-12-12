import java.util.Scanner;

public class Factorial3 {
	public static long factorial(long n) {
		return n > 0 ? factorial(n - 1) * n : 1;
	}
	
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
    }
}
