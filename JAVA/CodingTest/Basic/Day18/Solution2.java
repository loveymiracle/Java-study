// Day 18 문자열, 수학, 조건문, 정렬 > 제곱수 판별하기
package Day18;

// 문제 설명
// 어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다.
// 정수 n이 매개변수로 주어질 때, n이 제곱수라면 1을 아니라면 2를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ n ≤ 1,000,000

// n	result
// 144	1
// 976	2

public class Solution2 {
	
	public int solution(int n) {
        int answer = 0;
        int square = (int) Math.sqrt(n);
        
        if(square * square == n) {
        	answer = 1;
        } else {
        	answer = 2;
        }
        return answer;
    }
	
	public int solution2(int n) {
		if(n % Math.sqrt(n) == 0) {
			return 1;
		} else {
			return 2;
		}
	}
	
	public int solution3(int n) {
		int answer = 0;
		return Math.sqrt(n) % 1 == 0 ? 1 : 2;
	}
	
	public static void main(String[] args) {
		int n = 4;
		int result = new Solution2().solution(n);
		int result2 = new Solution2().solution2(n);
		int result3 = new Solution2().solution3(n);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
	}

}
