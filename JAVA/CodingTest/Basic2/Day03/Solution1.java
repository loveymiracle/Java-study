// Day 3 연산 > 문자열 섞기
package Day03;

import java.util.*;

// str1		str2	result
// "aaaaa"	"bbbbb"	"ababababab"

public class Solution1 {
	
	public String solution(String str1, String str2) {
		List<String> strarr = new ArrayList<>();
		for(int i = 0; i < str1.length(); i++) {
			strarr.add(String.valueOf(str1.charAt(i)));
			strarr.add(String.valueOf(str2.charAt(i)));
		}
		
		StringBuilder answer = new StringBuilder();
		for(String c : strarr) {
			answer.append(c);
		}
		
        return answer.toString();
    }
	
	public static void main(String[] args) {
		String str1 = "aaaaa";
		String str2 = "bbbbb";
		String result = new Solution1().solution(str1, str2);
		System.out.println(result);
	}

}
