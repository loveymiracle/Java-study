// Day 16 문자열, 수학, 배열, 조건문 > 배열의 유사도
package Day16;

import java.util.*;

// 제한사항
// 1 ≤ s1, s2의 길이 ≤ 100
// 1 ≤ s1, s2의 원소의 길이 ≤ 10
// s1과 s2의 원소는 알파벳 소문자로만 이루어져 있습니다
// s1과 s2는 각각 중복된 원소를 갖지 않습니다.

// s1				s2							result
// ["a", "b", "c"]	["com", "b", "d", "p", "c"]	2
// ["n", "omg"]		["m", "dot"]				0

public class Solution4 {

	public int solution(String[] s1, String[] s2) {
		int answer = 0;
		for(String s : s1) {
			for(String st : s2) {
				if(s.equals(st)) {
					answer++;
				}
			}
		}
		return answer;
	}
	
	public int solution2(String[] s1, String[] s2) {
		int answer = 0;
		List<String> slist = new ArrayList<>(List.of(s1));
		
		for(String s : s2) {
			if(slist.contains(s)) {
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] s1 = { "a", "b", "c" };
		String[] s2 = { "com", "b", "d", "p", "c" };
		int result = new Solution4().solution(s1, s2);
		int result2 = new Solution4().solution2(s1, s2);
		System.out.println(result);
		System.out.println(result2);
	}

}
