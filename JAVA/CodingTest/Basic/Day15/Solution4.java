// Day 15 문자열, 해시, 배열, 수학 > 약수 구하기
package Day15;

import java.util.*;

// 제한사항
// 1 ≤ n ≤ 10,000

// n	result
// 24	[1, 2, 3, 4, 6, 8, 12, 24]
// 29	[1, 29]

public class Solution4 {
	
	public int[] solution(int n) {
		List<Integer> nlist = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			if(n % i == 0) {
				nlist.add(i);
			}
		}
		System.out.println(nlist);
		
        int[] answer = new int[nlist.size()];
        for(int i = 0; i < nlist.size(); i++) {
        	answer[i] = nlist.get(i);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 24;
		int[] result = new Solution4().solution(n);
		System.out.println(Arrays.toString(result));
	}

}
