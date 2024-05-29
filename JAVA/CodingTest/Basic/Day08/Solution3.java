// Day 8 배열, 구현, 수학 > 진료순서 정하기
package Day08;

import java.util.*;

// 제한사항
// 중복된 원소는 없습니다.
// 1 ≤ emergency의 길이 ≤ 10
// 1 ≤ emergency의 원소 ≤ 100

// emergency				result
// [3, 76, 24]				[3, 1, 2]
// [1, 2, 3, 4, 5, 6, 7]	[7, 6, 5, 4, 3, 2, 1]
// [30, 10, 23, 6, 100]		[2, 4, 3, 5, 1]

public class Solution3 {
	
	public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        for(int i = 0; i < emergency.length; i++) {
        	for(int j = 0; j < emergency.length; j++) {
        		if(emergency[i] <= emergency[j]) {
        			answer[i] += 1;
        		}
        	}
        }
        return answer;
    }
	
	public int[] solution2(int[] emergency) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] emergencySort = Arrays.copyOfRange(emergency,  0, emergency.length);
		System.out.println("정렬 전 : " + Arrays.toString(emergencySort));
		Arrays.sort(emergencySort);
		System.out.println("정렬 후 : " + Arrays.toString(emergencySort));
		int size = emergency.length;
		
		for(int i = 0; i <emergencySort.length; i++) {
			int e = emergencySort[i];
			System.out.println("e : " + e + ", size : " + (size-i));
			map.put(e,  size-i);
		}
		System.out.println("해쉬맵 : " + map);
		
		for(int i = 0; i < emergency.length; i++) {
			emergency[i] = map.get(emergency[i]);
			System.out.println("i : " + i +", emer[i] : " + emergency[i]);
		}
		return emergency;
	}
	
	public static void main(String[] args) {
		int[] emergency = { 30, 10, 23, 6, 100 };
		int[] result = new Solution3().solution2(emergency);
		System.out.println(Arrays.toString(result));
	}

}
