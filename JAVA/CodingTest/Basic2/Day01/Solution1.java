// Day1 사칙 연산 > 두수의 합
package Day01;

import java.util.*;

// 제한사항
// -50,000 ≤ num1 ≤ 50,000
// -50,000 ≤ num2 ≤ 50,000

// num1	num2	result
// 2	3		5
// 100	2		102

public class Solution1 {
	
	public int solution(int num1, int num2) {
		
        int answer = num1 + num2;
        return answer;
    }
	
	public static void main(String[] args) {
		int num1 = 100;
		int num2 = 2;
		int result = new Solution1().solution(num1, num2);
		System.out.println(result);
	}

}
