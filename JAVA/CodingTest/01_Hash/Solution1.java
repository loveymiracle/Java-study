// 해시 > 폰켓몬
package ex01;

import java.util.*;


// nums				result		종류수		N/2
//[3,1,2,3]			2			3			2		답 : 3 > 2 = 2
//[3,3,3,2,2,4]		3			3			3		답 : 3 = 3 = 3
//[3,3,3,2,2,2]		2			2			3		답 : 2 < 3 = 2

public class Solution {
	public int solution(int[] nums) {
		// 중복을 제거하고 종류수를 구하는 과정
		Set<Integer> set = new HashSet<>();
		for(int num : nums) {
			set.add(num);
		}
		int N = nums.length / 2
		
		if(set.size() < N) {
			return set.size();
		} else {
			return N;
		}
    }
	
	public static void main(String[] args) {
//		int[] nums = {3, 1, 2, 3};
//		int[] nums = {3, 3, 3, 2, 2, 4};
		int[] nums = {3, 3, 3, 2, 2, 2};
		int result = new Solution().solution(nums);
		System.out.println(result);
	}
}
