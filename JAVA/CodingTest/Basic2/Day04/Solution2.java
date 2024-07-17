// Day 4 연산, 조건문 > 공배수
package Day04;

import java.util.*;

// 제한사항
// 10 ≤ number ≤ 100
// 2 ≤ n, m < 10

// number	n	m	result
// 60		2	3	1
// 55		10	5	0

public class Solution2 {
	public int solution(int number, int n, int m) {
        int answer = number % n == 0 && number % m == 0 ? 1 : 0;
        return answer;
    }
	
	public static void main(String[] args) {
		int number = 60;
		int n = 2;
		int m = 3;
		int result = new Solution2().solution(number, n, m);
		System.out.println(result);
	}

}
