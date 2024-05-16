// Day01 사칙연산 > 두수의 곱
package Day01;

// 제한사항
// 0 ≤ num1 ≤ 100
// 0 ≤ num2 ≤ 100

// num1	num2	result
// 3	4		12
// 27	19		513

public class Solution3 {
	
	public int solution(int num1, int num2) {
        int answer = num1 * num2;
        return answer;
    }
	
	public static void main(String[] args) {
		int num1 = 3;
		int num2 = 4;
		int result = new Solution3().solution(num1, num2);
		System.out.println(result);
	}

}
