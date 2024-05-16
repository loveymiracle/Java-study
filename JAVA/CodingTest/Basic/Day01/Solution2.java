// Day01 사칙연산 > 두수의 차
package Day01;

// 제한사항
// -50000 ≤ num1 ≤ 50000
// -50000 ≤ num2 ≤ 50000

// num1	num2	result
// 2	3		-1
// 100	2		98
public class Solution2 {
	
	public int solution(int num1, int num2) {
        int answer = num1 - num2;
        return answer;
    }
	
	public static void main(String[] args) {
		int num1 = 2;
		int num2 = 3;
		int result = new Solution2().solution(num1, num2);
		System.out.println(result);
		
	}

}
