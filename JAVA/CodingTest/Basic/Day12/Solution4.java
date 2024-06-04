// Day 12 문자열, 정렬, 사칙연산, 수학 > 소인수분해
package Day12;

import java.util.*;

// 제한사항
// 2 ≤ n ≤ 10,000

// n	result
// 12	[2, 3]
// 17	[17]
// 420	[2, 3, 5, 7]

public class Solution4 {
	
	public int[] solution(int n) {
//		Set<Integer> nset = new HashSet<>(); // 정렬x.. 테스트 13 실패..
		Set<Integer> nset = new TreeSet<>();
		
		while(n % 2 == 0) {
			nset.add(2);
			n /= 2;
		}
		
		for(int i = 3; i <= Math.sqrt(n); i += 2) {
			while (n % i == 0) {
				nset.add(i);
				n /= i;
			}
		}
		
		if(n > 2) {
			nset.add(n);
		}
		
        int[] answer = new int[nset.size()];
        int num = 0;
        for(int number : nset) {
        	answer[num++] = number;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 420;
		int[] result = new Solution4().solution(n);
		System.out.println(Arrays.toString(result));
	}

}
