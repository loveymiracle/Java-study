// Day 12 문자열, 정렬, 사칙연산, 수학 > 문자열 정렬하기 (1)
package Day12;

import java.util.*;

// 제한사항
// 1 ≤ my_string의 길이 ≤ 100
// my_string에는 숫자가 한 개 이상 포함되어 있습니다.
// my_string은 영어 소문자 또는 0부터 9까지의 숫자로 이루어져 있습니다. - - -

// my_string	result
// "hi12392"	[1, 2, 2, 3, 9]
// "p2o4i8gj2"	[2, 2, 4, 8]
// "abcde0"		[0]

public class Solution2 {
	
	public int[] solution(String my_string) {
		List<Integer> nlist = new ArrayList<>();
		String num = "1234567890";
		for(int i = 0; i < my_string.length(); i++) {
			char ch = my_string.charAt(i);
			if(num.indexOf(ch) != -1) {
				nlist.add(Character.getNumericValue(ch));
			}
		}
		Collections.sort(nlist);
		
        int[] answer = new int[nlist.size()];
        for(int i = 0; i < nlist.size(); i++) {
        	answer[i] = nlist.get(i);
        }
        return answer;
    }
	
	public int[] solution2(String my_string) {
		my_string = my_string.replaceAll("[a-z]", "");
		int[] answer = new int[my_string.length()];
		
		for(int i = 0; i < my_string.length(); i++) {
			answer[i] = my_string.charAt(i) - '0'; // 해당 문자를 정수로 변환하는 방법
		}
		Arrays.sort(answer);
		
		return answer;
	}
	
	public static void main(String[] args) {
		String my_string = "hi12392";
		int[] result = new Solution2().solution(my_string);
		System.out.println(Arrays.toString(result));
	}

}
