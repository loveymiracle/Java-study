// Day 10 조건문, 배열, 수학, 시뮬레이션 > 배열 회전시키기
package Day10;

import java.util.*;

// 제한사항
// 3 ≤ numbers의 길이 ≤ 20
// direction은 "left" 와 "right" 둘 중 하나입니다.

// numbers						direction	result
// [1, 2, 3]					"right"		[3, 1, 2]
// [4, 455, 6, 4, -1, 45, 6]	"left"		[455, 6, 4, -1, 45, 6, 4]

public class Solution4 {
	
	public int[] solution(int[] numbers, String direction) {
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
		
		if(direction.equals("right")) {
			int tmp = list.remove(numbers.length-1);
			list.add(0, tmp);
		} else {
			int tmp = list.remove(0);
			list.add(tmp);
		}
		
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        return answer;
    }
	
	public int[] solution2(int[] numbers, String direction) {
		int[] answer = new int[numbers.length];
		
		if(direction.equals("right")) {
			answer[0] = numbers[numbers.length - 1];
			for(int i = 0; i < numbers.length - 1; i++) {
				answer[i + 1] = numbers[i];
			}
		} else {
			answer[answer.length - 1] = numbers[0];
			for(int i = 1; i < numbers.length; i++) {
				answer[i - 1] = numbers[i];
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3 };
		String direction = "right";
		int[] result = new Solution4().solution(numbers, direction);
		System.out.println(Arrays.toString(result));
		int[] result2 = new Solution4().solution2(numbers, direction);
		System.out.println(Arrays.toString(result2));
	}

}
