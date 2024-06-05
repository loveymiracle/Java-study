// Day 13 문자열, 배열, 사칙연산, 수학, 조건문 > 컨트롤 제트
package Day13;

import java.util.*;

// 제한사항
// 1 ≤ s의 길이 ≤ 200
// -1,000 < s의 원소 중 숫자 < 1,000
// s는 숫자, "Z", 공백으로 이루어져 있습니다.
// s에 있는 숫자와 "Z"는 서로 공백으로 구분됩니다.
// 연속된 공백은 주어지지 않습니다.
// 0을 제외하고는 0으로 시작하는 숫자는 없습니다.
// s는 "Z"로 시작하지 않습니다.
// s의 시작과 끝에는 공백이 없습니다.
// "Z"가 연속해서 나오는 경우는 없습니다.

// s				result
// "1 2 Z 3"		4
// "10 20 30 40"	100
// "10 Z 20 Z 1"	1
// "10 Z 20 Z"		0
// "-1 -2 -3 Z"		-3

public class Solution1 {
	
	public int solution(String s) {
		String[] num = s.split(" ");
		int answer = 0;
		int[] numbers = new int[num.length];
		
		for(int i = 0; i < num.length; i++) {
			if(num[i].equals("Z")) {
				numbers[i] = -Integer.parseInt(num[i - 1]);
			} else {
				numbers[i] = Integer.parseInt(num[i]);
			}
		}
		for(int n : numbers) {
			answer += n;
		}
        return answer;
    }
	
	public int solution2(String s) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		
		for(String w : s.split(" ")) {
			if(w.equals("Z")) {
				stack.pop();
			} else {
				stack.push(Integer.parseInt(w));
			}
		}
		System.out.println(stack);
		
		for(int n : stack) {
			answer += n;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		String s = "1 2 Z 3";
		int result = new Solution1().solution(s);
		int result2 = new Solution1().solution2(s);
		System.out.println(result);
		System.out.println(result2);
	}

}
