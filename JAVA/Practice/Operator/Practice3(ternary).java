public void practice3() {
		// ex
    		// 키보드로 입력 받은 하나의 정수가 양수이면 "양수다",
		// 양수가 아닌 경우 중에서 0이면 "0이다", 0이 아니면 "음수다"를 출력하세요.
		// ※ 삼항 연산자 사용해주세요!

    		// answer  
		// 정수 : -9
		// 음수다
		System.out.println("practice3!!");
		System.out.println("정수 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		String result2 = num2 > 0 ? (num2 > 0 ? "양수다": "양수가 아니다") 
		                  : (num2 < 0 ? "음수다" : "0이다");
		System.out.println(result2);
	}
public void practice3() {
		// 키보드로 입력 받은 하나의 정수가 양수이면 "양수다",
		// 양수가 아닌 경우 중에서 0이면 "0이다", 0이 아니면 "음수다"를 출력하세요.
		// ※ 삼항 연산자 사용해주세요!
		
		// 정수 : -9
		// 음수다
		System.out.println("정수 : ");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println(num > 0? "양수다" : (num == 0 ? "0이다. " : "음수다")); // 한줄에 출력 가능
	}
