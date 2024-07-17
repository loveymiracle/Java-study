// Day 4 연산, 조건문 > flag에 따라 다른 값 반환하기
package Day04;

import java.util.*;

// 제한사항
// -1,000 ≤ a, b ≤ 1,000

// a	b	flag	result
// -4	7	true	3
// -4	7	false	-11

public class Solution5 {
	public int solution(int a, int b, boolean flag) {
        return flag == true ? a + b : a - b;
    }
	public static void main(String[] args) {
		int a = -4;
		int b = 7;
		boolean flag = false;
		int result = new Solution5().solution(a, b, flag);
		System.out.println(result);
	}

}
