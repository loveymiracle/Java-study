package ex01.array;


// 1000이하의 Prime=소수를 나열
public class PrimeNumber1 {

	public static void main(String[] args) {
		int counter = 0; // 나눗셈 횟수 // 소수랑은 관련 없는
		
		for(int n = 2; n <= 1000; n++) {
			int i;
			for(i = 2; i < n; i++) {
				counter++;
				if(n % i == 0) { // 나누어 떨어지면 소수가 아니다.
					break;
				}
			}
			if(n == i) { // 소수가 되는 기준
				System.out.println(n);
			}
		}
		
		System.out.println("나눗셈 횟수 : " + counter);
		
	}
}
