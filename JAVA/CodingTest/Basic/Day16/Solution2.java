// Day 16 문자열, 수학, 배열, 조건문 > 가장 큰 수 찾기
package Day16;

import java.util.Arrays;

// 제한사항
// 1 ≤ array의 길이 ≤ 100
// 0 ≤ array 원소 ≤ 1,000
// array에 중복된 숫자는 없습니다.

// array			result
// [1, 8, 3]		[8, 1]
// [9, 10, 11, 8]	[11, 2]

public class Solution2 {

	public int[] solution(int[] array) {
		int[] answer = new int[2];
		int tmp = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++) {
			if (tmp < array[i]) {
				tmp = array[i];
				answer[0] = tmp;
				answer[1] = i;
			}
		}
		return answer;
	}

	public int[] solution2(int[] array) {
		int max = 0;
		int maxIndex = -1;

		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
				maxIndex = i;
			}
		}
		int[] answer = { max, maxIndex };
		return answer;
	}

	public static void main(String[] args) {
		int[] array = { 9, 10, 11, 8 };
		int[] result = new Solution2().solution(array);
		int[] result2 = new Solution2().solution2(array);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(result2));
	}

}
