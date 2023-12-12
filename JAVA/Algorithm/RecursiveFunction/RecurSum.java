
// 재귀 함수 - 제어부(앞) + 호출부(뒤)
// 제어부란? 자기 자신을 호출하는 것을 언제 멈출지 판단하는 로직
// 호출부? 특정 연산을 수행하고 자기 자신을 다시 호출하는 로직
public class RecurSum {

	// 5 4 3 2 1
	static int sum(int n) {
		System.out.println(n);
		if(n == 1) {
			return n;
		}
		return sum(n - 1) + n;
	}
	
	public static void main(String[] args) {
		int n = 10; // 1 ~ 5 : 15, 1~10=55
//		int sum = 0;
//		for(int i = 1; i <= n; i++) {
//			sum += i;
//		}
		
		int sum = sum(n);
		System.out.println(sum);
	}
}
