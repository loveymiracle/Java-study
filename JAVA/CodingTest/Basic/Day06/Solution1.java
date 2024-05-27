// Day 6 문자열, 반복문, 출력, 배열, 조건문 > 문자열 뒤집기
package Day06;

import java.util.*;

// 제한사항
// 1 ≤ my_string의 길이 ≤ 1,000

// my_string	return
// "jaron"	"noraj"
// "bread"	"daerb"

public class Solution1 {
	
	public String solution(String my_string) {
		List<String> list = new ArrayList<>();
		for(int i = 0; i < my_string.length(); i++) {
			list.add(String.valueOf(my_string.charAt(i)));
		}
		Collections.reverse(list);
		
		StringBuilder answer = new StringBuilder();
        for(String str : list) {
        	answer.append(str);
        }
        return answer.toString();
    }
	
	public static void main(String[] args) {
		String my_string = "jaron";
		String result = new Solution1().solution(my_string);
		System.out.println(result);
	}

}
