// Day 15 문자열, 해시, 배열, 수학 > 인덱스 바꾸기
package Day15;

import java.util.*;

// 제한사항
// 1 < my_string의 길이 < 100
// 0 ≤ num1, num2 < my_string의 길이
// my_string은 소문자로 이루어져 있습니다.
// num1 ≠ num2

// my_string	num1	num2	result
// "hello"		1		2		"hlelo"
// "I love you"	3		6		"I l veoyou"

public class Solution2 {
	
	public String solution(String my_string, int num1, int num2) {
		StringBuilder answer = new StringBuilder(my_string);
		
		char temp = answer.charAt(num1);
		answer.setCharAt(num1, answer.charAt(num2));
		answer.setCharAt(num2, temp);
		
        return answer.toString();
    }
	
	public String solution2(String my_string, int num1, int num2) {
		List<Character> clist = new ArrayList<>();
		StringBuilder answer = new StringBuilder();
		
		for(char c : my_string.toCharArray()) {
			clist.add(c);
		}
		Collections.swap(clist, num1, num2);
		
		for(char c : clist) {
			answer.append(c);
		}
		
		return answer.toString();
	}
	
	
	public static void main(String[] args) {
		String my_string = "hello";
		int num1 = 1;
		int num2 = 2;
		String result = new Solution2().solution(my_string, num1, num2);
		String result2 = new Solution2().solution2(my_string, num1, num2);
		System.out.println(result);
		System.out.println(result2);
	}

}
