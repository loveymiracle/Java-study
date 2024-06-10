// Day 16 문자열, 수학, 배열, 조건문 > 문자열 계산하기
package Day16;

// 제한사항
// 연산자는 +, -만 존재합니다.
// 문자열의 시작과 끝에는 공백이 없습니다.
// 0으로 시작하는 숫자는 주어지지 않습니다.
// 잘못된 수식은 주어지지 않습니다.
// 5 ≤ my_string의 길이 ≤ 100
// my_string을 계산한 결과값은 1 이상 100,000 이하입니다.
// my_string의 중간 계산 값은 -100,000 이상 100,000 이하입니다.
// 계산에 사용하는 숫자는 1 이상 20,000 이하인 자연수입니다.
// my_string에는 연산자가 적어도 하나 포함되어 있습니다.
// return type 은 정수형입니다.
// my_string의 숫자와 연산자는 공백 하나로 구분되어 있습니다.
// 입출력 예
// my_string	result
// "3 + 4"		7

public class Solution3 {
	
	public int solution(String my_string) {
		String[] parts = my_string.split(" ");
		int answer = Integer.parseInt(parts[0]);
        
        for(int i = 1; i < parts.length; i += 2) {
        	String oper = parts[i];
        	int num = Integer.parseInt(parts[i + 1]);
        	
        	if(oper.equals("+")) {
        		answer += num;
        	} else if(oper.equals("-")) {
        		answer -= num;
        	}
        }
        return answer;
    }
	
	public int solution2(String my_string) {
		int answer = 0;
		String[] s = my_string.split(" ");
		int oper = 1;
		
		for(String s1 : s) {
			if(s1.equals("+") || s1.equals("-")) {
				oper = s1.equals("-") ? -1 : 1;
			} else {
				answer += Integer.parseInt(s1) * oper;
			}
		}
		return answer;
 	}
	
	public static void main(String[] args) {
		String my_string = "3 + 4 - 2";
		int result = new Solution3().solution(my_string);
		int result2 = new Solution3().solution2(my_string);
		System.out.println(result);
		System.out.println(result2);
	}

}
