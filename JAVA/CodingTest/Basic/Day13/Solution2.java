// Day 13 문자열, 배열, 사칙연산, 수학, 조건문 > 배열 원소의 길이
package Day13;

import java.util.*;

// 제한사항
// 1 ≤ strlist 원소의 길이 ≤ 100
// strlist는 알파벳 소문자, 대문자, 특수문자로 구성되어 있습니다.

// strlist							result
// ["We", "are", "the", "world!"]	[2, 3, 3, 6]
// ["I", "Love", "Programmers."]	[1, 4, 12]

public class Solution2 {

	public int[] solution(String[] strlist) {
		int[] answer = new int[strlist.length];
		
		for(int i = 0; i < strlist.length; i++) {
			answer[i] = strlist[i].length();
		}
		
		return answer;
	}

	public static void main(String[] args) {
		String[] strlist = { "We", "are", "the", "world!" };
		int[] result = new Solution2().solution(strlist);
		System.out.println(Arrays.toString(result));
	}

}
