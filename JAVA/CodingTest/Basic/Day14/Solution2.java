// Day 14 조건문, 반복문, 시뮬레이션, 문자열 > 369게임
package Day14;

import java.util.*;

// 제한사항
// 1 ≤ order ≤ 1,000,000

// order	result
// 3		1
// 29423	2

public class Solution2 {
	
	public int solution(int order) {
		String orders = Integer.toString(order); // String.valueOf(order), order+""
        int answer = 0;
        for(int i = 0; i < orders.length(); i++) {
        	char c = orders.charAt(i);
        	if(c == '3' || c == '6' || c == '9') {
        		answer += 1;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int order = 29423;
		int result = new Solution2().solution(order);
		System.out.println(result);
	}

}
