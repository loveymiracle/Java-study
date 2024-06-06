// Day 14 조건문, 반복문, 시뮬레이션, 문자열 > 암호해독
package Day14;

import java.util.*;

// 제한사항
// 1 ≤ cipher의 길이 ≤ 1,000
// 1 ≤ code ≤ cipher의 길이
// cipher는 소문자와 공백으로만 구성되어 있습니다.
// 공백도 하나의 문자로 취급합니다.

// cipher						code	result
// "dfjardstddetckdaccccdegk"	4		"attack"
// "pfqallllabwaoclk"			2		"fallback"

public class Solution3 {

	public String solution(String cipher, int code) {
		StringBuilder answer = new StringBuilder();
		for (int i = 1; i <= cipher.length(); i++) {
			if (i % code == 0) {
				char c = cipher.charAt(i - 1);
				answer.append(c);
			}
		}
		return answer.toString();
	}
	
	public String solution2(String cipher, int code) {
		String answer = "";
		for(int i = code - 1; i < cipher.length(); i += code) {
			answer += cipher.substring(i, i+1);
		}
		return answer;
	}

	public static void main(String[] args) {
		String cipher = "dfjardstddetckdaccccdegk";
		int code = 4;
		String result = new Solution3().solution(cipher, code);
		String result2 = new Solution3().solution2(cipher, code);
		System.out.println(result);
		System.out.println(result2);
	}

}
