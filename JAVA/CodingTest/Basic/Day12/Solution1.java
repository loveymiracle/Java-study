// Day 12 문자열, 정렬, 사칙연산, 수학 > 모음 제거
package Day12;

import java.util.*;

// 제한사항
// my_string은 소문자와 공백으로 이루어져 있습니다.
// 1 ≤ my_string의 길이 ≤ 1,000

// my_string			result
// "bus"				"bs"
// "nice to meet you"	"nc t mt y"

public class Solution1 {
	
	public String solution(String my_string) {
		String str = "aeiou";
    StringBuilder answer = new StringBuilder();
        
    for(int i = 0; i < my_string.length(); i++) {
      char ch = my_string.charAt(i);
      if(str.indexOf(ch) == -1) {
        	answer.append(ch);
      }
    }
        
    return answer.toString();
  }
	
	public String solution2(String my_string) {
		return my_string.replaceAll("[aeiou]", "");
	}
	
	public static void main(String[] args) {
		String my_string = "nice to meet you";
		String result = new Solution1().solution(my_string);
		System.out.println(result);
	}

}
