// Day 18 문자열, 수학, 조건문, 정렬 > 세균 증식
package Day18;

// 문제 설명
// 어떤 세균은 1시간에 두배만큼 증식한다고 합니다.
// 처음 세균의 마리수 n과 경과한 시간 t가 매개변수로 주어질 때
// t시간 후 세균의 수를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ n ≤ 10
// 1 ≤ t ≤ 15

// n	t	result
// 2	10	2048
// 7	15	229,376

public class Solution3 {
	
	public int solution(int n, int t) {
        int answer = n;
        for(int i = 0; i < t; i++) {
        	answer *= 2;
        	System.out.println("i = " + i + ", answer = " + answer);
        }
        return answer;
    }
	
	public int solution2(int n, int t) {
		int answer = 0;
		
		answer = n << t;
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 2;
		int t = 10;
		int result = new Solution3().solution(n, t);
		int result2 = new Solution3().solution2(n, t);
		System.out.println(result);
		System.out.println(result2);
	}

}
