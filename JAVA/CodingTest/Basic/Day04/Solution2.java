// Day 4 수학, 배열 > 피자 나눠 먹기 (2)
package Day04;

import java.util.*;

// 제한사항
// 1 ≤ n ≤ 100

// n	result
// 6	1
// 10	5
// 4	2

public class Solution2 {
	
	public static int GCD(int n, int n2) {
		if (n % n2 == 0) {
			System.out.println(10%6);
			return n2;
		}
		return GCD(n2, n%n2);
	}
	
	public static int LCM(int n, int n2) {
		return n * n2 / GCD(n, n2);
	}
	
	public int solution(int n) {
		int answer = 0;
		int pizza = 6;
		int gcd = GCD(n, pizza);
		System.out.println("Gcd : "+gcd);
		if(n % pizza == 0) {
			answer = n / pizza;
		} else {
			answer = n * pizza / gcd / pizza;
		}
        return answer;
    }
	
	public int solution2(int n) {
		int answer = 1;
		while(true) {
			if(6 * answer % n == 0) {
				return answer;
			}
			answer++;
		}
	}
	
	public static void main(String[] args) {
		int n = 10;
		int result = new Solution2().solution2(n);
		System.out.println(result);
	}

}
