// Day 4 연산, 조건문 > n의 배수
package Day04;

import java.util.*;

// 제한사항
// 2 ≤ num ≤ 100
// 2 ≤ n ≤ 9

// num	n	result
// 98	2	1
// 34	3	0

public class Solution1 {
	
	public int solution(int num, int n) {
		int answer = 0;
		if(num % n == 0) {
			return answer = 1; 
		} else {
			return answer;
		}
    }
	
	public static void main(String[] args) {
		int num = 98;
		int n = 3;
		int result = new Solution1().solution(num, n);
		System.out.println(result);
	}

}
