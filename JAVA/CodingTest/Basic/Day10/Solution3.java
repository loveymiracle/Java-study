// Day 10 조건문, 배열, 수학, 시뮬레이션 > 공 던지기
package Day10;

import java.util.*;

// 제한사항
// 2 < numbers의 길이 < 100
// 0 < k < 1,000
// numbers의 첫 번째와 마지막 번호는 실제로 바로 옆에 있습니다.
// numbers는 1부터 시작하며 번호는 순서대로 올라갑니다.

// numbers				k	result
// [1, 2, 3, 4]			2	3
// [1, 2, 3, 4, 5, 6]	5	3
// [1, 2, 3]			3	2

public class Solution3 {
	
	public int solution(int[] numbers, int k) {
        int len = numbers.length;
        System.out.println("길이는 " + len);
        int index = ((k - 1) * 2) % len;
        System.out.println("던지는 친구는 " + index);
        return numbers[index];
    }
	
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 5, 6 };
		int k = 5;
		int result = new Solution3().solution(numbers, k);
		System.out.println(result);
	}
	

}
