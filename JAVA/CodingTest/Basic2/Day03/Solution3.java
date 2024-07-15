// Day 3 연산 > 문자열 곱하기
package Day03;

// 제한사항
// 1 ≤ my_string의 길이 ≤ 100
// my_string은 영소문자로만 이루어져 있습니다.
// 1 ≤ k ≤ 100

// my_string	k	result
// "string"		3	"stringstringstring"
// "love"		10	"lovelovelovelovelovelovelovelovelovelove"

public class Solution3 {
	
	public String solution(String my_string, int k) {
        String answer = my_string.repeat(k);
        return answer;
    }
	
	public static void main(String[] args) {
		String my_string = "string";
		int k = 3;
		String result = new Solution3().solution(my_string, k);
		System.out.println(result);
	}

}
