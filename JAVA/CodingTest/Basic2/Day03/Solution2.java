// Day 3 연산 > 문자리스트를 문자열로 변환하기
package Day03;

import java.util.*;

// 제한사항
// 1 ≤ arr의 길이 ≤ 200
// arr의 원소는 전부 알파벳 소문자로 이루어진 길이가 1인 문자열입니다.

// arr				result
// ["a","b","c"]	"abc"

public class Solution2 {
	
	public String solution(String[] arr) {
		String answer = "";
		for(String s : arr) {
			answer += s;
		}
        return answer;
    }
	
	public static void main(String[] args) {
		String[] arr = { "a","b","c" };
		String result = new Solution2().solution(arr);
		System.out.println(result);
	}

}
