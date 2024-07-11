// Day 2 출력, 연산 > 문자열 겹쳐쓰기
package Day02;

import java.util.*;

// 제한사항
// my_string와 overwrite_string은 숫자와 알파벳으로 이루어져 있습니다.
// 1 ≤ overwrite_string의 길이 ≤ my_string의 길이 ≤ 1,000
// 0 ≤ s ≤ my_string의 길이 - overwrite_string의 길이

// my_string		overwrite_string	s	result
// "He11oWor1d"		"lloWorl"			2	"HelloWorld"
// "Program29b8UYP"	"merS123"			7	"ProgrammerS123"

public class Solution5 {
	public String solution(String my_string, String overwrite_string, int s) {
		String tmp1 = my_string.substring(0, s);
		String tmp2 = my_string.substring(s+overwrite_string.length(), my_string.length());
		System.out.println(tmp1);
		System.out.println(tmp2);
        String answer = tmp1 + overwrite_string + tmp2;
        return answer;
    }
	
	public static void main(String[] args) {
		String my_string = "He11oWor1d";
		String overwrite_string ="lloWorl";
		int s = 2;
		String result = new Solution5().solution(my_string, overwrite_string, s);
		System.out.println(result);
	}

}
