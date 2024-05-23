// Day 5 수학, 배열 > 배열 뒤집기
package Day05;

import java.util.*;

// 제한사항
// 1 ≤ num_list의 길이 ≤ 1,000
// 0 ≤ num_list의 원소 ≤ 1,000\

// num_list					result
// [1, 2, 3, 4, 5]			[5, 4, 3, 2, 1]
// [1, 1, 1, 1, 1, 2]		[2, 1, 1, 1, 1, 1]
// [1, 0, 1, 1, 1, 3, 5]	[5, 3, 1, 1, 1, 0, 1]

public class Solution4 {
	
	public List<Integer> solution(int[] num_list) {
		List<Integer> list = new ArrayList<>();
		for(int num : num_list) {
			list.add(num);
		}
		Collections.reverse(list);
        return list;
    }
	
	public static void main(String[] args) {
		int[] num_list = { 1, 2, 3, 4, 5 };
		List<Integer> result = new Solution4().solution(num_list);
		System.out.println(result);
	}
	
}
