// Day 3 사칙연산, 배열, 수학 > 나머지 구하기
package Day03;

import java.util.*;

// 제한사항
// 0 < num1 ≤ 100
// 0 < num2 ≤ 100

// num1	num2	result
// 3	2		1
// 10	5		0

public class Solution1 {
	
	public int solution(int num1, int num2) {
        int answer = num1 % num2;
        return answer;
    }
	
	public static void main(String[] args) {
		int num1 = 3;
		int num2 = 2;
		int result = new Solution1().solution(num1, num2);
		System.out.println(result);
	}

}
