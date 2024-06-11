// Day 17 문자열, 수학, 조건문, 배열, 사칙연산 > 자릿수 더하기
package Day17;

// 문제 설명
// 정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요

// 제한사항
// 0 ≤ n ≤ 1,000,000

// n		result
// 1234		10
// 930211	16

public class Solution3 {
	
	public int solution(int n) {
        int answer = 0;
        String num = String.valueOf(n);
        String[] number = num.split("");
        for(int i = 0; i < number.length; i++) {
        	answer += Integer.parseInt(number[i]);
        }
        return answer;
    }
	
	public int solution2(int n) {
		int answer = 0;
		
		while(n > 0) {
			answer += n % 10;
			n /= 10;
			System.out.println("answer = " + answer + ", n = " + n);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 1234;
		int result = new Solution3().solution(n);
		int result2 = new Solution3().solution2(n);
		System.out.println(result);
		System.out.println(result2);
	}

}
