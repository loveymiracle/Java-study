import java.util.Scanner;

public class Factorial2 {

//	0! = 1;
//	1! = 1;
//	2! = 1*2 = 2;
//	3! = 3*2*1 = 6;
//	4! = 24;
	
	// 1 ~ 5 증감하는 방법
	public static long factorial(long n, int i) {
		System.out.println("n : " + n + ", i : " + i);
		// 제어부
		if(n == 0) 
			return 1;
		if(n == i)
			return i;
		// 호출부
		return factorial(n, i + 1) * i;
	}
	
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorial(x, 1) + "입니다.");
    }
}
