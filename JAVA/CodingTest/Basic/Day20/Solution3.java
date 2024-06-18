// Day 20 수학, 시뮬레이션, 문자열, 사칙연산 > 최댓값 만들기 (2)
package Day20;

import java.util.*;

// 문제 설명
// 정수 배열 numbers가 매개변수로 주어집니다.
// numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// -10,000 ≤ numbers의 원소 ≤ 10,000
// 2 ≤ numbers 의 길이 ≤ 100

// 입출력 예
// numbers						result
// [1, 2, -3, 4, -5]			15
// [0, -31, 24, 10, 1, 9]		240
// [10, 20, 30, 5, 5, 20, 5]	600

public class Solution3 {

	public int solution(int[] numbers) {
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		int[] tmp = new int[numbers.length - 1];
		
		for(int i = 0; i < numbers.length - 1; i++) {
			tmp[i] = numbers[i] * numbers[i + 1];
		}
		
		System.out.println(Arrays.toString(tmp));
		int num = Integer.MIN_VALUE;
		
		for(int i = 0; i < tmp.length; i++) {
			if(tmp[i] > num) {
				num = tmp[i];
			}
		}
		
		int answer = num;
		return answer;
	}
	
	public int solution2(int[] numbers) {
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		int minValue = numbers[0] * numbers[1];
		int maxValue = numbers[numbers.length - 1] * numbers[numbers.length - 2];
		return minValue > maxValue ? minValue : maxValue; 
	}

	public static void main(String[] args) {
		int[] numbers = { 0, -31, 24, 10, 1, 9 };
		int result = new Solution3().solution(numbers);
		int result2 = new Solution3().solution2(numbers);
		System.out.println(result);
		System.out.println(result2);
	}

}
