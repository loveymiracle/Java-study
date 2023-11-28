package ex01.array;

// 1000이하의 소수 구하면서 배열에 저장
public class PrimeNumber2 {
	public static void main(String[] args) {
		int counter = 0; // 나눗셈 횟수 // 소수랑은 관련 없는
		int[] prime = new int[1000];
		int counter2 = 0; // 소수의 갯수
		
		for(int n = 2; n <= 1000; n++) {
			int i;
			for(i = 2; i < n; i++) {
				counter++;
				if(n % i == 0) { // 나누어 떨어지면 소수가 아니다.
					break;
				}
			}
			if(n == i) { // 소수가 되는 기준
				prime[counter2++] = n;
			}
		}
		
		for(int i = 0; i < counter2; i++) {
			System.out.println(prime[i]);
		}
		
		System.out.println("나눗셈 횟수 : " + counter);
	}
}
