    package ex01.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackCalculator {
	public static String postfixToInfix(String expression) {
		String answer = "";
		Stack<String> stack = new Stack<>();
		String[] op = { "+", "-", "*", "/", "(", ")" };

		for (char c : expression.toCharArray()) {
			if (Arrays.asList(op).contains(c + "")) {
				if (c == ')') {
					while (!stack.isEmpty() && stack.peek().charAt(0) != '(') {
						answer += stack.pop().charAt(0);
					}
					stack.pop();
				} else {
					while (!stack.isEmpty() && compareToOperation(c, stack.peek().charAt(0))) {
						answer += stack.pop();
					}
					stack.push(c + "");
				}
			} else {
				answer += c;
			}
		}

		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
		return answer;
	}

	public static boolean compareToOperation(char op1, char op2) {
		switch (op1) {
		case '+':
			if (op2 == '+' || op2 == '-' || op2 == '*' || op2 == '/') {
				return true;
			}
		case '-':
			if (op2 == '-' || op2 == '+' || op2 == '*' || op2 == '/') {
				return true;
			}
		case '*':
			if (op2 == '*' || op2 == '/') {
				return true;
			}
		case '/':
			if (op2 == '*' || op2 == '/') {
				return true;
			}
		}
		return false;
	}

	public static int getInfixResult(String expression) {
		int answer = 0;
		String[] op = { "+", "-", "*", "/" };
		Stack<Integer> stack = new Stack<>();

		for (char c : expression.toCharArray()) {
			if (Arrays.asList(op).contains(c + "")) {
				int second = stack.pop();
				int first = stack.pop();

				switch (c) {
				case '+':
					stack.push(first + second);
					break;
				case '-':
					stack.push(first - second);
					break;
				case '*':
					stack.push(first * second);
					break;
				case '/':
					stack.push(first / second);
					break;
				}
			} else {
				stack.push(Integer.parseInt(c + ""));
			}
		}
		answer = stack.pop();
		return answer;
	}

	public static void main(String[] args) {
		String infix = postfixToInfix("(4+7)+3*3");
		System.out.println("infix : " + infix);
		System.out.println("result : " + getInfixResult(infix));
	}
}
