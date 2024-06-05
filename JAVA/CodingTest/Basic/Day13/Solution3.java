// Day 13 문자열, 배열, 사칙연산, 수학, 조건문 > 중복된 문자 제거
package Day13;

import java.util.*;

// 제한사항
// 1 ≤ my_string ≤ 110
// my_string은 대문자, 소문자, 공백으로 구성되어 있습니다.
// 대문자와 소문자를 구분합니다.
// 공백(" ")도 하나의 문자로 구분합니다.
// 중복된 문자 중 가장 앞에 있는 문자를 남깁니다.

// my_string			result
// "people"				"peol"
// "We are the world"	"We arthwold"

public class Solution3 {
	
	public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < my_string.length(); i++) {
        	char ch = my_string.charAt(i);
        	if(set.contains(ch)) {
        		continue;
        	}
        	
        	set.add(ch);
        	answer.append(ch);
        }
        
        return answer.toString();
    }
	
	public String solution2(String my_string) {
		String answer = "";
		
		for(int i = 0; i < my_string.length(); i++) {
			System.out.println("i는 : " + i + " , @@" + my_string.indexOf(my_string.charAt(i)));
			if(i == my_string.indexOf(my_string.charAt(i))) {
				answer += my_string.charAt(i);
				System.out.println(answer);
			}
		}
		return answer;
	}
	
	public String solution3(String my_string) {
		String[] answer = my_string.split("");
		System.out.println("배열은 " + Arrays.toString(answer));
		Set<String> set = new LinkedHashSet<>(Arrays.asList(answer));
		System.out.println("set은 " + set);
		return String.join("", set);
	}
	
	public static void main(String[] args) {
		String my_string = "We are the world";
		String result = new Solution3().solution(my_string);
		String result2 = new Solution3().solution2(my_string);
		String result3 = new Solution3().solution3(my_string);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
	}
}
