// Day02 사칙연산, 조건문, 배열 > 두 수의 나눗셈
package Day02;

// 제한사항
// 0 < num1 ≤ 100
// 0 < num2 ≤ 100

// num1	num2	result
// 3	2		1500
// 7	3		2333
// 1	16		62

public class Solution1 {
	
	public int solution(int num1, int num2) {
        double answer = (double) num1 / num2 * 1000;
        return (int)answer;
    }
	
	public static void main(String[] args) {
		int num1 = 3;
		int num2 = 2;
		int result = new Solution1().solution(num1, num2);
		System.out.println(result);
	}

}
