// Day 14 조건문, 반복문, 시뮬레이션, 문자열 > 대문자와 소문자
package Day14;

import java.util.*;

// 제한사항
// 1 ≤ my_string의 길이 ≤ 1,000
// my_string은 영어 대문자와 소문자로만 구성되어 있습니다.
// 입출력 예
// my_string	result
// "cccCCC"		"CCCccc"
// "abCdEfghIJ"	"ABcDeFGHij"

public class Solution4 {
	
	public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < my_string.length(); i++) {
        	char c = my_string.charAt(i);
        	if(c >= 'a' && c <= 'z') {
        		answer.append(Character.toUpperCase(c));
        	} else {
        		answer.append(Character.toLowerCase(c));
        	}
        }
        return answer.toString();
    }
	
	public String solution2(String my_string) {
		String answer = "";
		
		for(int i = 0; i < my_string.length(); i++) {
			char c = my_string.charAt(i);
			if(c >= 'a' && c <= 'z') {
				c -= 32;
			} else {
				c += 32;
			}
			answer += c;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String my_string = "cccCCC";
		String result = new Solution4().solution(my_string);
		String result2 = new Solution4().solution2(my_string);
		System.out.println(result);
		System.out.println(result2);
	}

}
