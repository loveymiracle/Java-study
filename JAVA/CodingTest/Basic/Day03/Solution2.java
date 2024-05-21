// Day 3 사칙연산, 배열, 수학 > 중앙값 구하기
package Day03;

import java.util.*;

// 제한사항
// array의 길이는 홀수입니다.
// 0 < array의 길이 < 100
// -1,000 < array의 원소 < 1,000

// array				result
// [1, 2, 7, 10, 11]	7
// [9, -1, 0]			0

public class Solution2 {
	
	public int solution(int[] array) {
		Arrays.sort(array);
        int answer = array[array.length/2];
        return answer;
    }
	
	public static void main(String[] args) {
		int[] array = { 1 };
		int result = new Solution2().solution(array);
		System.out.println(result);
	}

}
