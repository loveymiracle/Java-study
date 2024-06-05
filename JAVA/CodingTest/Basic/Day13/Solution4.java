// Day 13 문자열, 배열, 사칙연산, 수학, 조건문 > 삼각형의 완성조건 (1)
package Day13;

import java.util.*;

// 제한사항
// sides의 원소는 자연수입니다.
// sides의 길이는 3입니다.
// 1 ≤ sides의 원소 ≤ 1,000

// sides			result
// [1, 2, 3]		2
// [3, 6, 2]		2
// [199, 72, 222]	1

public class Solution4 {

	public int solution(int[] sides) {
		Arrays.sort(sides);
		int answer = 0;
		
		if(sides[0] + sides[1] > sides[2]) {
			answer = 1;
		} else {
			answer = 2;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] sides = { 199, 72, 222 };
		int result = new Solution4().solution(sides);
		System.out.println(result);
	}

}
