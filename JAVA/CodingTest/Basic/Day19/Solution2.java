// Day 19 문자열, 배열, 조건문 > 잘라서 배열로 저장하기
package Day19;

import java.util.*;

// 문제 설명
// 문자열 my_str과 n이 매개변수로 주어질 때, my_str을 길이 n씩 잘라서 저장한 배열을
// return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ my_str의 길이 ≤ 100
// 1 ≤ n ≤ my_str의 길이
// my_str은 알파벳 소문자, 대문자, 숫자로 이루어져 있습니다.

// 입출력 예
// my_str				n	result
// "abc1Addfggg4556b"	6	["abc1Ad", "dfggg4", "556b"]
// "abcdef123"			3	["abc", "def", "123"]

public class Solution2 {
	
	public String[] solution(String my_str, int n) {
        String[] answer = new String[(my_str.length() + n - 1) / n];
        
        for(int i = 0; i < (my_str.length() + n - 1) / n; i++) {
        	int first = i * n;
        	int last = Math.min(first + n, my_str.length());
        	answer[i] = my_str.substring(first, last);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		String my_str = "abc1Addfggg4556b";
		int n = 6;
		String[] result = new Solution2().solution(my_str, n);
		System.out.println(Arrays.toString(result));
	}

}
