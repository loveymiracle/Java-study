// Day 24 수학, 시뮬레이션, 문자열, 조건문, 반복문 > 이진수 더하기
package Day24;

// 문제 설명
// 이진수를 의미하는 두 개의 문자열 bin1과 bin2가 매개변수로 주어질 때,
// 두 이진수의 합을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// return 값은 이진수를 의미하는 문자열입니다.
// 1 ≤ bin1, bin2의 길이 ≤ 10
// bin1과 bin2는 0과 1로만 이루어져 있습니다.
// bin1과 bin2는 "0"을 제외하고 0으로 시작하지 않습니다.

// 입출력 예
// bin1		bin2	result
// "10"		"11"	"101"
// "1001"	"1111"	"11000"

public class Solution2 {
	
	public String solution(String bin1, String bin2) {
        StringBuilder answer = new StringBuilder();
        int a = bin1.length() - 1;
        int b = bin2.length() - 1;
        int idx = 0;
        
        while (a >= 0 || b >= 0 || idx != 0) {
        	int sum = idx;
        	if(a >= 0) {
        		sum += bin1.charAt(a--) - '0';
        	}
        	if(b >= 0) {
        		sum += bin2.charAt(b--) - '0';
        	}
        	answer.append(sum % 2);
        	idx = sum / 2;
        }
        return answer.reverse().toString();
    }
	
	public String solution2(String bin1, String bin2) {
//		return Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));
		 return Integer.toString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2), 2);
	}
	
	public static void main(String[] args) {
		String bin1 = "10";
		String bin2 = "11";
		String result = new Solution2().solution(bin1, bin2);
		String result2 = new Solution2().solution2(bin1, bin2);
		System.out.println(result);
		System.out.println(result2);
	}

}
