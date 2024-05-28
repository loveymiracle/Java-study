// Day 7 문자열, 조건문, 수학, 반복문 > 짝수의 합
package Day07;

import java.util.*;

// 제한사항
// 0 < n ≤ 1000

// 입출력 예
// n	result
// 10	30
// 4	6

public class Solution4 {
	
	public int solution(int n) {
		int answer = 0;
		for(int i = 0; i <= n; i++) {
			if(i % 2 == 0) {
				answer += i;
			}
		}
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 4;
		int result = new Solution4().solution(n);
		System.out.println(result);
	}

}
