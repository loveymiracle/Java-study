// Day 2 사칙연산, 조건문, 배열 > 숫자 비교하기
package Day02;

// 제한사항
// 0 ≤ num1 ≤ 10,000
// 0 ≤ num2 ≤ 10,000

// num1	num2	result
// 2	3		-1
// 11	11		1
// 7	99		-1

public class Solution2 {
	
    public int solution(int num1, int num2) {
    	int answer = 0;
        if(num1 == num2) {
        	return answer = 1;
        } else {
        	return answer = -1;
        }
    }
    
    public static void main(String[] args) {
		int num1 = 2;
		int num2 = 3;
		int result = new Solution2().solution(num1, num2);
		System.out.println(result);
	}

}
