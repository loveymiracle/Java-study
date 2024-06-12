package Day18;

import java.util.*;

// 문제 설명
// 영어 대소문자로 이루어진 문자열 my_string이 매개변수로 주어질 때,
// my_string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.

// 제한사항
// 0 < my_string 길이 < 100

// my_string	result
// "Bcad"		"abcd"
// "heLLo"		"ehllo"
// "Python"		"hnopty"

public class Solution4 {
	
	public String solution(String my_string) {
        String str = my_string.toLowerCase();
        char[] charArray = str.toCharArray(); // char[] charArray = my_string.toLowerCase().toCharArray();
        Arrays.sort(charArray);
        String answer = new String(charArray);
        return answer;
    }
	
	public static void main(String[] args) {
		String my_string = "Bcad";
		String result = new Solution4().solution(my_string);
		System.out.println(result);
	}

}
