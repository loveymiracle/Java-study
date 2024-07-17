// Day 4 연산, 조건문 > 조건 문자열
package Day04;

import java.util.*;

// 제한 사항
// 1 ≤ n, m ≤ 100

// ineq	eq	n	m	result
// "<"	"="	20	50	1
// ">"	"!"	41	78	0

public class Solution4 {
	public int solution(String ineq, String eq, int n, int m) {
		int answer = 0;
		if(eq.equals("=")) {
			if(ineq.equals("<")) {
				return n <= m ?  1 : 0;
			} else if(ineq.equals(">")) {
				return n >= m ? 1 : 0;
			}
		} else {
			if(ineq.equals("<")) {
				return n < m ? 1 : 0;
			} else if(ineq.equals(">")) {
				return n > m ? 1 : 0;
			}
		}
		return answer;
    }
	
	public static void main(String[] args) {
		String ineq = "<";
		String eq = "=";
		int n = 20;
		int m = 50;
		int result = new Solution4().solution(ineq, eq, n, m);
		System.out.println(result);
	}

}
