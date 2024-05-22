// Day 4 수학, 배열 > 피자 나눠 먹기 (1)
package Day04;

import java.util.*;

// 제한사항
// 1 ≤ n ≤ 100

// n	result
// 7	1
// 1	1
// 15	3

public class Solution1 {
	
	public int solution(int n) {
		int answer = 0;
		System.out.println(n / 7);
		if(n % 7 == 0) {
			answer = n / 7;
		} else {
			answer = n / 7 + 1;
		}
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 21;
		int result = new Solution1().solution(n);
		System.out.println(result);
	}

}
