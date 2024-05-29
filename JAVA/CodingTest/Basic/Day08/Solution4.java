// Day 8 배열, 구현, 수학 > 순서쌍의 개수
package Day08;

import java.util.*;

// 제한사항
// 1 ≤ n ≤ 1,000,000

// n	result
// 20	6
// 100	9

public class Solution4 {
	
	public int solution(int n) {
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				list.add(i);
			}
		}
		
		System.out.println(list);
		int answer = list.size();
		return answer;
	}
	
	public int solution2(int n) { // 시간 초과
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i *  j == n) {
					map.put(i, j);
				}
			}
		}
		System.out.println(map);
        int answer = map.size();
        return answer;
    }
	
	public int solution3(int n) {
		List<int[]> list = new ArrayList<>();
		
		for(int i =1; i<= n; i++) {
			if(n % i == 0) {
				int a = i;
				int b = n / i;
				list.add(new int[]{a, b});
			}
		}
		
//		for (int[] pair : list) {
//		    System.out.println("(" + pair[0] + ", " + pair[1] + ")");
//		}
		
		int answer = list.size();
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 100;
		int result = new Solution4().solution3(n);
		System.out.println(result);
	}

}
