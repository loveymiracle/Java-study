// Day 4 수학, 배열 > 배열의 평균값
package Day04;

import java.util.*;

// 제한사항
// 0 ≤ numbers의 원소 ≤ 1,000
// 1 ≤ numbers의 길이 ≤ 100
// 정답의 소수 부분이 .0 또는 .5인 경우만 입력으로 주어집니다.

// numbers										result
// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]				5.5
// [89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99]	94.0

public class Solution4 {
	public double solution(int[] numbers) {
		int sum = 0;
		
		for(int num : numbers) {
			sum += num;
		}
        double answer = (double)sum / numbers.length;
        return answer;
    }
	
	public static void main(String[] args) {
		int[] numbers = { 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99 };
		double result = new Solution4().solution(numbers);
		System.out.println(result);
	}

}
