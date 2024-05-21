// Day 3 사칙연산, 배열, 수학 > 최빈값 구하기
package Day03;

import java.util.*;

// 제한사항
// 0 < array의 길이 < 100
// 0 ≤ array의 원소 < 1000

// array				result
// [1, 2, 3, 3, 3, 4]	3
// [1, 1, 2, 2]			-1
// [1]					1

public class Solution3 {
	
	public int solution(int[] array) {
		int answer = 0;
		int[] count = new int[1000];
		int max = Integer.MIN_VALUE;
		
		for(int num : array) {
			count[num]++;
		}
		System.out.println(Arrays.toString(count));
		
		for(int i = 0; i < count.length; i++) {
			if(count[i] > max) {
				max = count[i];
				answer = i;
			} else if(max == count[i]) {
				answer = -1;
			}
		}
        return answer;
    }
	
	public int solution2(int[] array) {
		int answer = 0;
		int maxCount = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int num : array) {
			int count = map.getOrDefault(num, 0) + 1;
			System.out.println("C : "+count);
			System.out.println("maxC : "+maxCount);
			if(count > maxCount) {
				maxCount = count;
				answer = num;
			} else if(count == maxCount) {
				answer = -1;
			}
			map.put(num, count);
		}
		System.out.println(map);
		return answer;
	}
	
	public static void main(String[] args) {
		int[] array = { 999 };
		int result = new Solution3().solution(array);
		System.out.println(result);
	}

}
