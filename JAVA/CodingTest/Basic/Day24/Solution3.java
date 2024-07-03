// Day 24 수학, 시뮬레이션, 문자열, 조건문, 반복문 > A로 B 만들기
package Day24;

import java.util.*;

// 문제 설명
// 문자열 before와 after가 매개변수로 주어질 때,
// before의 순서를 바꾸어 after를 만들 수 있으면 1을,
// 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.

// 제한사항
// 0 < before의 길이 == after의 길이 < 1,000
// before와 after는 모두 소문자로 이루어져 있습니다.

// 입출력 예
// before	after	result
// "olleh"	"hello"	1
// "allpe"	"apple"	0

public class Solution3 {
	
	public int solution(String before, String after) {
        int answer = 0;
        char[] beforeArr = before.toCharArray();
        char[] afterArr = after.toCharArray();
        Arrays.sort(beforeArr);
        Arrays.sort(afterArr);
        
        if(Arrays.equals(beforeArr, afterArr)) {
        	return answer = 1;
        }
        return answer;
    }
	
	public int solution2(String before, String after) {
		for(int i = 0; i < before.length(); i++) {
			after = after.replaceFirst(before.substring(i,i+1), "");
		}
		return after.length() == 0 ? 1 : 0;
	}
	
	public int solution3(String before, String after) {
		Set<String> permutations = new HashSet<>();
		generatePermutations(before, "", permutations);
		
		if(permutations.contains(after)) {
			return 1;
		}
		return 0;
	}
	
	private void generatePermutations(String str, String ans, Set<String> permutations) {
        if (str.length() == 0) {
            permutations.add(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            generatePermutations(ros, ans + ch, permutations);
        }
    }
	
	public static void main(String[] args) {
		String before = "olleh";
		String after = "hello";
		int result = new Solution3().solution(before, after);
		int result2 = new Solution3().solution2(before, after);
		int result3 = new Solution3().solution3(before, after);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
	}

}
