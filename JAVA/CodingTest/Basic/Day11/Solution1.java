// Day 11 수학, 반복문 > 주사위의 개수
package Day11;

import java.util.*;

// 제한사항
// box의 길이는 3입니다.
// box[0] = 상자의 가로 길이
// box[1] = 상자의 세로 길이
// box[2] = 상자의 높이 길이
// 1 ≤ box의 원소 ≤ 100
// 1 ≤ n ≤ 50
// n ≤ box의 원소
// 주사위는 상자와 평행하게 넣습니다.

// box			n	result
// [1, 1, 1]	1	1
// [10, 8, 6]	3	12

public class Solution1 {

	public int solution(int[] box, int n) {
//		int answer = ((2 * (box[0] + box[1])) / (2 * n)) * (box[2] / n);
		int a = box[0] / n;
		int b = box[1] / n;
		int c = box[2] / n;
		int answer = 0;
		if (a == b && a == 1 && b == 1) {
			answer = 1 * c;
		} else {
			answer = a * b * c;
		}
		return answer;
	}
	
	public int solution2(int[] box, int n) {
		int answer = (box[0] / n) * (box[1] / n) * (box[2] / n);
		return answer;
	}

	public static void main(String[] args) {
		int[] box = { 10, 8, 6 };
		int n = 3;
		int result = new Solution1().solution(box, n);
		int result2 = new Solution1().solution(box, n);
		System.out.println(result);
		System.out.println(result2);
	}

}
