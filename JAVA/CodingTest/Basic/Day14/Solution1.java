// Day 14 조건문, 반복문, 시뮬레이션, 문자열 > 가까운 수
package Day14;

import java.util.*;

// 제한사항
// 1 ≤ array의 길이 ≤ 100
// 1 ≤ array의 원소 ≤ 100
// 1 ≤ n ≤ 100
// 가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.

// array		n	result
// [3, 10, 28]	20	28
// [10, 11, 12]	13	12

public class Solution1 {

	public int solution(int[] array, int n) {
		int temp = Integer.MAX_VALUE;
		int answer = 0;
		for(int i = 0; i < array.length; i++) {
			int g = Math.abs(n - array[i]);
			if(g < temp) {
				temp = g;
				answer = array[i];
			} else if(g == temp) {
				if(array[i] < answer) {
					answer = array[i];
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] array = { 10, 11, 12 };
		int n = 9;
		int result = new Solution1().solution(array, n);
		System.out.println(result);
	}

}
