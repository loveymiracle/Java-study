// Day 11 수학, 반복문 > 합성수 찾기
package Day11;

import java.util.*;

// 제한사항
// 1 ≤ n ≤ 100

// n	result
// 10	5
// 15	8

public class Solution2 {
	
	public int solution(int n) {
		int answer = 0;
		for(int i = 1; i <= n; i++) {
			int a = 0;
			System.out.println("초기화 확인 : " + a);
			for(int j = 1; j <= n; j++) {
				if(i % j == 0) {
					a++;
					System.out.println("i = " + i + ", j = " + j + ", a = " + a);
				}
			}
			if(a >= 3) {
				answer++;
				System.out.println("anwer : " + answer);
			}
		}
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 15;
		int result = new Solution2().solution(n);
		System.out.println(result);
	}

}
