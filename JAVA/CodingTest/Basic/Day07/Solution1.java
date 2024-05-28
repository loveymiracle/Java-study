// Day 7 문자열, 조건문, 수학, 반복문 > 특정 문자 제거하기
package Day07;

import java.util.*;

// 제한사항
// 1 ≤ my_string의 길이 ≤ 100
// letter은 길이가 1인 영문자입니다.
// my_string과 letter은 알파벳 대소문자로 이루어져 있습니다.
// 대문자와 소문자를 구분합니다.

// my_string	letter	result
// "abcdef"		"f"		"abcde"
// "BCBdbe"		"B"		"Cdbe"

public class Solution1 {
	
	public String solution(String my_string, String letter) {
		String answer = "";
		for(int i = 0; i < my_string.length(); i++) {
			char current = my_string.charAt(i);
			if(current != letter.charAt(0)) {
				answer += current;
			}
		}
        return answer;
    }
	
	public static void main(String[] args) {
		String my_string = "abcdef";
		String letter = "f";
		String result = new Solution1().solution(my_string, letter);
		System.out.println(result);
	}

}
