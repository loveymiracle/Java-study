// Day 8 배열, 구현, 수학 > 외계행성의 나이
package Day08;

import java.util.*;

// 제한사항
// age는 자연수입니다.
// age ≤ 1,000
// PROGRAMMERS-962 행성은 알파벳 소문자만 사용합니다.

// age	result
// 23	"cd"
// 51	"fb"
// 100	"baa"

public class Solution2 {
	
	public String solution(int age) {
		StringBuilder answer = new StringBuilder();

	    String pattern = "abcdefghij";

	    while (age > 0) {
	    	System.out.println("age : " + age);
	        int index = age % 10;
	        System.out.println("index : " + index);
	        char current = pattern.charAt(index);
	        answer.insert(0, current);
	        age = age / 10;
	    }

	    return answer.toString();
	}
	
	public static void main(String[] args) {
		int age = 63;
		String result = new Solution2().solution(age);
		System.out.println(result);
	}

}
