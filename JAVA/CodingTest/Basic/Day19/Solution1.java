// Day 19 문자열, 배열, 조건문 > 7의 개수
package Day19;

import java.util.*;

// 문제 설명
// 머쓱이는 행운의 숫자 7을 가장 좋아합니다.
// 정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.

// 제한사항
// 1 ≤ array의 길이 ≤ 100
// 0 ≤ array의 원소 ≤ 100,000

// 입출력 예
// array		result
// [7, 77, 17]	4
// [10, 29]		0

public class Solution1 {

	public int solution(int[] array) {
		int answer = 0;
		String str = Arrays.toString(array);

		for (char c : str.toCharArray()) {
			if (c == '7') {
				answer++;
			}
		}
		return answer;
	}
	
	public int solution2(int[] array) {
		int answer = 0;
		for(int a : array) {
			while(a != 0) {
				if(a % 10 == 7) {
					answer++;
				}
				a /= 10;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] array = { 7, 77, 17 };
		int result = new Solution1().solution(array);
		int result2 = new Solution1().solution2(array);
		System.out.println(result);
		System.out.println(result2);
	}

}
