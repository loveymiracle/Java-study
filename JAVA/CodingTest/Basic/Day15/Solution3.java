// Day 15 문자열, 해시, 배열, 수학 > 한번만 등장한 문자
package Day15;

import java.util.*;

// 제한사항
// 0 < s의 길이 < 1,000
// s는 소문자로만 이루어져 있습니다.

// s			result
// "abcabcadc"	"d"
// "abdc"		"abcd"
// "hello"		"eho"

public class Solution3 {
	
	public String solution(String s) {
		Map<Character, Integer> map = new HashMap<>();
		StringBuilder answer = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		System.out.println(map);
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				answer.append(entry.getKey());
			}
		}
		
        return answer.toString();
    }
	
	public String solution2(String s) {
		String answer = "";
		String[] arr = s.split("");
		int cnt = 0;
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			cnt = 0;
			for(int j = 0; j < arr.length; j++) {
				if(arr[i].equals(arr[j])) {
					cnt++;
				}
			}
			if(cnt == 1) {
				answer += arr[i];
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String s = "aabbcc";
		String result = new Solution3().solution(s);
		String result2 = new Solution3().solution2(s);
		System.out.println(result);
		System.out.println(result2);
	}

}
