// Day 4 수학, 배열 > 피자 나눠 먹기 (3)
package Day04;

import java.util.*;

// 제한사항
// 2 ≤ slice ≤ 10
// 1 ≤ n ≤ 100

// slice	n	result
// 7		10	2 
// 4		12	3

public class Solution3 {
	public int GCD(int n, int m) {
		if (n % m == 0) {
			return m;
		}
		return GCD(m, n % m);
	}
	
	public int LCM(int n, int m) {
		return n * m / GCD(n, m);
	}
	
	public int solution(int slice, int n) {
        int answer = 0;
        if(n % slice == 0) {
        	answer = n / slice; 
        } else {
        	answer = n / slice + 1;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int slice = 7;
		int n = 10;
		int result = new Solution3().solution(slice, n);
		System.out.println(result);
	}

}
