// Day 17 문자열, 수학, 조건문, 배열, 사칙연산 > n의 배수 고르기
package Day17;

import java.util.*;

// 제한사항
// 1 ≤ n ≤ 10,000
// 1 ≤ numlist의 크기 ≤ 100
// 1 ≤ numlist의 원소 ≤ 100,000

// n	numlist							result
// 3	[4, 5, 6, 7, 8, 9, 10, 11, 12]	[6, 9, 12]
// 5	[1, 9, 3, 10, 13, 5]			[10, 5]
// 12	[2, 100, 120, 600, 12, 12]		[120, 600, 12, 12]

public class Solution2 {

	public int[] solution(int n, int[] numlist) {
		List<Integer> nlist = new ArrayList<>();
		for(int i = 0; i < numlist.length; i++) {
			if(numlist[i] % n == 0) {
				nlist.add(numlist[i]);
			}
		}
		int[] answer = new int[nlist.size()];
		for(int i = 0; i < nlist.size(); i++) {
			answer[i] = nlist.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
		int n = 5;
		int[] numlist = { 1, 9, 3, 10, 13, 5 };
		int[] result = new Solution2().solution(n, numlist);
		System.out.println(Arrays.toString(result));
	}

}
