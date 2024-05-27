// Day 6 문자열, 반복문, 출력, 배열, 조건문 > 문자 반복 출력하기
package Day06;

import java.util.*;

// 제한사항
// 2 ≤ my_string 길이 ≤ 5
// 2 ≤ n ≤ 10
// "my_string"은 영어 대소문자로 이루어져 있습니다.

// my_string	n	result
// "hello"		3	"hhheeellllllooo"

public class Solution4 {
	
	public String solution(String my_string, int n) {
		List<String> list = new ArrayList<>();
		for(int i = 0; i < my_string.length(); i++) {
			list.add(String.valueOf(my_string.charAt(i)).repeat(n));
		}
		
		StringBuilder answer = new StringBuilder();
        for(String str : list) {
        	answer.append(str);
        }
        return answer.toString();
    }
	
	public static void main(String[] args) {
		String my_string = "hello";
		int n = 3;
		String result = new Solution4().solution(my_string, n);
		System.out.println(result);
	}

}
