// Day 8 배열, 구현, 수학 > 배열 자르기
package Day08;

import java.util.*;

// 제한사항
// 2 ≤ numbers의 길이 ≤ 30
// 0 ≤ numbers의 원소 ≤ 1,000
// 0 ≤num1 < num2 < numbers의 길이

// numbers			num1	num2	result
// [1, 2, 3, 4, 5]	1		3		[2, 3, 4]
// [1, 3, 5]		1		2		[3, 5]

public class Solution1 {
	
	public int[] solution(int[] numbers, int num1, int num2) {
		List<Integer> list = new ArrayList<>();
		
        for(int i = num1; i <= num2; i++) {
        	list.add(numbers[i]);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5 };
		int num1 = 1;
		int num2 = 3;
		int[] result = new Solution1().solution(numbers, num1, num2);
		System.out.println(Arrays.toString(result));
	}

}
