// Day 21 문자열, 사칙연산, 시뮬레이션, 2차원배열, 수학, 배열 > 숨어있는 숫자의 덧셈 2
package Day21;

import java.util.Arrays;

// 문제 설명
// 문자열 my_string이 매개변수로 주어집니다.
// my_string은 소문자, 대문자, 자연수로만 구성되어있습니다.
// my_string안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ my_string의 길이 ≤ 1,000
// 1 ≤ my_string 안의 자연수 ≤ 1000
// 연속된 수는 하나의 숫자로 간주합니다.
// 000123과 같이 0이 선행하는 경우는 없습니다.
// 문자열에 자연수가 없는 경우 0을 return 해주세요.

// 입출력 예
// my_string		result
// "aAb1B2cC34oOp"	37
// "1a2b3c4d123Z"	133

public class Solution1 {
	
	public int solution(String my_string) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < my_string.length(); i++) {
        	char c = my_string.charAt(i);
        	if(c >= '0' && c <= '9') { 
        		sb.append(c);
        	} else {
        		if(sb.length() > 0) {
        			answer += Integer.parseInt(sb.toString());
        			sb.setLength(0);
        		}
        	}
        }
        
        if(sb.length() > 0) {
        	answer += Integer.parseInt(sb.toString());
        }
        
        return answer;
    }
	
	public int solution2(String my_string) {
		int answer = 0;
		String[] strArr = my_string.replaceAll("[a-zA-Z]", " ").split(" ");
		System.out.println(Arrays.toString(strArr));
		
		for(String s : strArr) {
			if(!s.equals("")) {
				answer += Integer.valueOf(s);
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String my_string = "aAb120BcC34oOp";
		int result = new Solution1().solution(my_string);
		int result2 = new Solution1().solution2(my_string);
		System.out.println(result);
		System.out.println(result2);
	}

}
