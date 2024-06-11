// Day 17 문자열, 수학, 조건문, 배열, 사칙연산 > OX퀴즈
package Day17;

import java.util.Arrays;

// 문제 설명
// 덧셈, 뺄셈 수식들이 'X [연산자] Y = Z' 형태로 들어있는 문자열 배열 quiz가 매개변수로 주어집니다.
// 수식이 옳다면 "O"를 틀리다면 "X"를 순서대로 담은 배열을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 연산 기호와 숫자 사이는 항상 하나의 공백이 존재합니다. 단 음수를 표시하는 마이너스 기호와 숫자 사이에는 공백이 존재하지 않습니다.
// 1 ≤ quiz의 길이 ≤ 10
// X, Y, Z는 각각 0부터 9까지 숫자로 이루어진 정수를 의미하며, 각 숫자의 맨 앞에 마이너스 기호가 하나 있을 수 있고 이는 음수를 의미합니다.
// X, Y, Z는 0을 제외하고는 0으로 시작하지 않습니다.
// -10,000 ≤ X, Y ≤ 10,000
// -20,000 ≤ Z ≤ 20,000
// [연산자]는 + 와 - 중 하나입니다.

// quiz															result
// ["3 - 4 = -3", "5 + 6 = 11"]									["X", "O"]
// ["19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"]	["O", "O", "X", "O"]

public class Solution4 {

	public String[] solution(String[] quiz) {
		String[] answer = new String[quiz.length];
		
		for(int i = 0; i < quiz.length; i++) {
			String[] questions = quiz[i].split(" ");
			int num1 = Integer.parseInt(questions[0]);
			String operator = questions[1];
			int num2 = Integer.parseInt(questions[2]);
			int result = Integer.parseInt(questions[4]);
			boolean isCorrect = false;
			
			if(operator.equals("+")) {
				isCorrect = (num1 + num2 == result);
			} else if(operator.equals("-")) {
				isCorrect = (num1 - num2 == result);
			}
			
			if(isCorrect) {
				answer[i] = "O";
			} else {
				answer[i] = "X";
			}
		}
		return answer;
	}
	
	public String[] solution2(String[] quiz) {
        for(int i = 0; i < quiz.length; i++){
            String[] text = quiz[i].split(" ");
            int result = Integer.parseInt(text[0]) + ( Integer.parseInt(text[2]) * ( text[1].equals("+") ? 1 : -1) );
            quiz[i] = result == Integer.parseInt(text[4])? "O": "X";
        }
        return quiz;
    }


	public static void main(String[] args) {
		String[] quiz = { "3 - 4 = -3", "5 + 6 = 11" };
		String[] result = new Solution4().solution(quiz);
		String[] result2 = new Solution4().solution2(quiz);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(result2));
	}

}
