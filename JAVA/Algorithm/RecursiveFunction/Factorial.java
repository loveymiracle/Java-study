import java.util.Scanner;

public class Factorial {

//	0! = 1;
//	1! = 1;
//	2! = 1*2 = 2;
//	3! = 3*2*1 = 6;
//	4! = 24;
	// 5 ~ 1로 내려가면서 계산하는 방법, 정석
	public static long factorial(long n) {
		System.out.println((n-1) + " * " +(n));
		// 제어부
		if(n <= 1)
			return 1;
		// 호출부
		return factorial(n - 1) * n;
	}

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
    }
}
