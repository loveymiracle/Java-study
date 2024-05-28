// Day 7 문자열, 조건문, 수학, 반복문 > 양꼬치
package Day07;

import java.util.*;

// 제한사항
// 0 < n < 1,000
// n / 10 ≤ k < 1,000
// 서비스로 받은 음료수는 모두 마십니다.

// n	k	result
// 10	3	124,000
// 64	6	768,000

public class Solution3 {
	
	public int solution(int n, int k) {
		int food = 12000;
		int drink = 2000;
    int answer = n * food + k * drink - (n / 10) * drink;
        return answer;
  }
	
	public static void main(String[] args) {
		int n = 64;
		int k = 6;
		int result = new Solution3().solution(n, k);
		System.out.println(result);
	}

}
