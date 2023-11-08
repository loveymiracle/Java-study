public void practice8() {
		// 키보드로 두 개의 정수와 연산 기호를 입력 받아 연산 기호에 맞춰 연산 결과를 출력하세요.
		// (단, 두 개의 정수 모두 양수일 때만 작동하며 없는 연산 기호를 입력 했을 시 " 잘못 입력하셨습니다. 프로그램을 종료합니다." 출력)
		System.out.println("피연산자1 입력 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("피연산자2 입력 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.println("연산자를 입력(+,-,*,/,%) : ");
		String symbol = sc.nextLine();
		
		double result = 0.0;
		
		switch(symbol) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = (double)num1 / num2;
			break;
		case "%":
			result = num1 % num2;
			break;
		default:
			System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
		} System.out.println(num1 + " " + symbol + " " + num2 + " = " + result);
	} 
	public static void practice8() {
		// 키보드로 두 개의 정수와 연ㅅ나 기호를 입력 받아 연산 기호에 맞춰 연산 결과를 출력
		// (단, 두개의 정수 모두 양수일 때만 작동하며 없는 연산 기호를 입력 했을 시 
		// "잘못 입력하셨습니다. 프로그램을 종료합니다." 출력)
		// 반드시 switch 문으로 작성!
		
		// 피연산자1 입력 : 15, 피연산자2 입력 : 4
		// 연산자를 입력(+,-,*,/,%) : /
		// 15 / 4 = 3.750000
		System.out.println("피연산자1 입력 : ");
		int operand1 = Integer.parseInt(sc.nextLine());
		System.out.println("피연산자2 입력 : ");
		int operand2 = Integer.parseInt(sc.nextLine());
		System.out.println("연산자를 입력(+,-,*/,%) : ");
		String operator = sc.nextLine();
		
		if(operand1 < 1 || operand2 < 1) {
			System.out.println("양수가 아닙니다!");
			return;
		}
		
		String result = ""; // 문자열 초기화하는 꼼수문법 ✭✭✭✭✭
		
		switch(operator) {
			case "+" : result += (operand1 + operand2); break;
			case "-" : result += (operand1 - operand2); break;
			case "*" : result += (operand1 * operand2); break;
			case "/" : result += String.format("%.6f", ((double)operand1 / operand2)); break;
			case "%" : result += (operand1 % operand2); break;
			default : System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다."); return;
		}
		
		System.out.println(operand1 + " " + operator + " " + operand2 + " = " + result);
	}
}
