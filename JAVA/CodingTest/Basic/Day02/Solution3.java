// Day 2 사칙연산, 조건문, 배열 > 분수의 덧셈
package Day02;

import java.util.Arrays;

// 제한사항
// 0 <numer1, denom1, numer2, denom2 < 1,000

//  numer1	denom1	numer2	denom2	result
//	1		2		3		4		[5, 4]
// 	9		2		1		3		[29, 6]

public class Solution3 {
	
	public int[] solution(int numer1, int denom1, int numer2, int denom2) {
		int numer = numer1 * denom2 + numer2 * denom1;
		int denom = denom1 * denom2;
		
		int max = 1;
		for(int i = 1; i <= numer && i <=denom; i++) {
			if(denom % i == 0 && numer % i == 0) {
				max = i;
			}
		}
		
		numer = numer / max;
		denom = denom / max;

		int[] answer = { numer, denom };
		return answer;
    }
	
	public static void main(String[] args) {
		int numer1 = 1;
		int denom1 = 2;
		int numer2 = 3;
		int denom2 = 4;
		int[] result = new Solution3().solution(numer1, denom1, numer2, denom2);
		System.out.println(Arrays.toString(result));
	}

}
