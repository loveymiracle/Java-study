// Day 11 수학, 반복문 > 팩토리얼
package Day11;

import java.util.*;

// 제한사항
// 0 < n ≤ 3,628,800

// n		result
// 3628800	10
// 7		3

public class Solution4 {
	
	public int solution(int n) {
        int num = 1;
        int answer = 0;
        
        for(int i = 1; num <= n; i++) {
        	num *= i;
        	if(num > n) {
        		break;
        	}
        	answer = i;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 0;
		int result = new Solution4().solution(n);
		System.out.println(result);
	}

}
