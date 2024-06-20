// Day 21 문자열, 사칙연산, 시뮬레이션, 2차원배열, 수학, 배열 > 삼각형의 완성조건 2
package Day21;

import java.util.*;

// 문제 설명
// 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.

// 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
// 삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다.
// 나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// sides의 원소는 자연수입니다.
// sides의 길이는 2입니다.
// 1 ≤ sides의 원소 ≤ 1,000

// 입출력 예
// sides	result
// [1, 2]	1
// [3, 6]	5
// [11, 7]	13

public class Solution3 {

	public int solution(int[] sides) {
		Arrays.sort(sides);
		int answer = 0;
		int min = sides[0];
		int max = sides[1];
		
		// max 가장 긴 변
		// min + i > max -> i > max - min -> 3 < i <= 6 -> 4, 5, 6 : 3개
		for(int i = max - min + 1; i <= max; i++) {
			System.out.println("!" + i);
			answer++;
		}
		
		// i 가장 긴 변
		// min + max > i > max -> 9 > i > 6 -> 7, 8 : 2개
		for(int i = max + 1; i < min + max; i++) {
			System.out.println("@@" + i);
			answer++;
		}
		
		return answer;
	}
	
	public int solution2(int[] sides) {
		int answer = 0;
//		int max = Math.max(sides[0], sides[1]);
		int min = Math.min(sides[0], sides[1]);
		
		answer += min * 2 - 1;
		return answer;
	}

	public static void main(String[] args) {
		int[] sides = { 1, 2 };
		int result = new Solution3().solution(sides);
		int result2 = new Solution3().solution2(sides);
		System.out.println(result);
		System.out.println(result2);
	}

}
