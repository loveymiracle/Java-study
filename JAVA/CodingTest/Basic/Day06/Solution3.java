// Day 6 문자열, 반복문, 출력, 배열, 조건문 > 짝수 홀수 개수
package Day06;

import java.util.*;

// 제한사항
// 1 ≤ num_list의 길이 ≤ 100
// 0 ≤ num_list의 원소 ≤ 1,000

// num_list			result
// [1, 2, 3, 4, 5]	[2, 3]
// [1, 3, 5, 7]		[0, 4]

public class Solution3 {
	
	public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        for(int num : num_list) {
        	if(num % 2 == 0) {
        		answer[0] += 1;
        	} else {
        		answer[1] += 1;
        	}
        }
        return answer;
    }
	
	public int[] solution2(int[] num_list) {
		int[] answer = new int[2];
		for(int i = 0; i < num_list.length; i++) {
			answer[num_list[i] % 2]++;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[] num_list = { 1, 3, 5, 7 };
		int[] result = new Solution3().solution(num_list);
		System.out.println(Arrays.toString(result));
	}

}
