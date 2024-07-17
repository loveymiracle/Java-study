// Day 4 연산, 조건문 > 홀짝에 따라 다른 값 반환하기
package Day04;

import java.util.*;

// 제한사항
// 1 ≤ n ≤ 100

// n	result
// 7	16
// 10	220

public class Solution3 {
	public int solution(int n) {
		int sum = 0;
		if(n % 2 == 0) {
			for(int i = 2; i <=n; i += 2) {
				sum += i*i;
			}
		} else {
			for(int i = 1; i <=n; i += 2) {
				sum += i;
			}
		}
        return sum;
    }
	public static void main(String[] args) {
		int n = 10;
		int result = new Solution3().solution(n);
		System.out.println(result);
	}

}
