// Day 2 사칙연산, 조건문, 배열 > 배열 두 배 만들기
package Day02;

import java.util.*;

// 제한사항
// -10,000 ≤ numbers의 원소 ≤ 10,000
// 1 ≤ numbers의 길이 ≤ 1,000

// numbers						result
// [1, 2, 3, 4, 5]				[2, 4, 6, 8, 10]
// [1, 2, 100, -99, 1, 2, 3]	[2, 4, 200, -198, 2, 4, 6]

public class Solution4 {
	
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		for(int i = 0; i < numbers.length; i++) {
			answer[i] = numbers[i] * 2;
		}
        return answer;
    }
	
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 100, -99, 1, 2, 3 };
		int[] result = new Solution4().solution(numbers);
		System.out.println(Arrays.toString(result));
	}

}
