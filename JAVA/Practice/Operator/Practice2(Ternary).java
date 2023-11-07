public void practice2() {
		// 키보드로 입력 받은 하나의 정수가 양수이면 "양수다", 양수가 아니면 "양수가 아니다"를 출력하세요.
		// ※ 삼항 연산자 사용해주세요!
		
		// 정수 : -9
		// 양수가 아니다 
		System.out.println("practice2!!");
		
		System.out.println("정수 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		String result = num > 0 ? "양수다" : "양수가 아니다";
		System.out.println(result);
	}
public void practice2() {
		// 키보드로 입력 받은 하나의 정수가 양수이면 "양수다", 양수가 아니면 "양수가 아니다"를 출력하세요.
		// ※ 삼항 연산자 사용해주세요!
		
		// 정수 : -9
		// 양수가 아니다 
		System.out.println("정수 : ");
		int num = Integer.parseInt(sc.nextLine());
		String result = num > 0 ? "참" : "거짓";
		System.out.println(result);
		System.out.println(num > 0 ? "참" : "거짓"); // 한줄에 출력 가능 !!
	}
