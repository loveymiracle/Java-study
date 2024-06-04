// Day 12 문자열, 정렬, 사칙연산, 수학 > 숨어있는 숫자의 덧셈 (1)
package Day12;

import java.util.*;

// 제한사항
// 1 ≤ my_string의 길이 ≤ 1,000
// my_string은 소문자, 대문자 그리고 한자리 자연수로만 구성되어있습니다.

// my_string		result
// "aAb1B2cC34oOp"	10
// "1a2b3c4d123"	16

public class Solution3 {
	
	public int solution(String my_string) {
		List<Integer> nlist = new ArrayList<>();
		String num = "123456789";
		
		for(int i = 0; i < my_string.length(); i++) {
			char ch = my_string.charAt(i);
			if(num.indexOf(ch) != -1) {
				nlist.add(Character.getNumericValue(ch));
			}
		}
        int answer = 0;
        for(int number : nlist) {
        	answer += number;
        }
        return answer;
    }
	
	public int solution2(String my_string) {
		int answer = 0;
		
		for(char c : my_string.toCharArray()) {
			if( c >= '0' && c <= '9') {
				answer += c - '0';
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String my_string = "aAb1B2cC34oOp";
		int result = new Solution3().solution(my_string);
		System.out.println(result);
	}

}
