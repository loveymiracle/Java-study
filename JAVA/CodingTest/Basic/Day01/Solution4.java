// Day01 사칙연산 > 몫 구하기
package Day01;

// 제한사항
// 0 < num1 ≤ 100
// 0 < num2 ≤ 100

// num1	num2	result
// 10	5		2
// 7	2		3

public class Solution4 {
	
	public int solution(int num1, int num2) {
        int answer = num1 / num2;
        return answer;
    }
	
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 5;
		int result = new Solution4().solution(num1, num2);
		System.out.println(result);
	}

}
