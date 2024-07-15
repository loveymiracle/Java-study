// Day 3 연산 > 두 수의 연산값 비교하기
package Day03;

import java.util.*;

// 제한사항
// 1 ≤ a, b < 10,000

// a	b	result
// 2	91	364
// 91	2	912

public class Solution5 {
	
	public int solution(int a, int b) {
		String c = String.valueOf(a);
		String d = String.valueOf(b);
		String ba = c + d;
		
        return Math.max(Integer.parseInt(ba), 2*a*b);
    }
	
	public static void main(String[] args) {
		int a = 2;
		int b = 91;
		int result = new Solution5().solution(a, b);
		System.out.println(result);
	}

}
