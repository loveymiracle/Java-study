public void practice4() { // 일반 풀이!!
		// 키보드로 입력 받은 정수가 양수이면서 짝수일 때만 "짝수다"를 출력하고 짝수가 아니면 "홀수다"를 출력하세요.
		// 양수가 아니면 "양수만 입력해주세요."를 출력하세요.
		// -8
		System.out.println("숫자를 한 개 입력하세요 : ");
		int value3 = Integer.parseInt(sc.nextLine());
		if(value3 > 0) {
			if(value3 % 2 == 0) {
				System.out.println("짝수다");
			} else {
				System.out.println("홀수다");
			} 
		} else {
			System.out.println("양수만 입력해주세요.");
		}
	}
	public static void practice4_2() { // 권장 풀이
		// 키보드로 정수를 입력 받은 정수가 양수이면서 짝수일 때만 "짝수다"를 출력 하고
		// 짝수가 아니면 "홀수다"를 출력하세요.
		// 양수가 아니면 "양수만 입력해주세요".
		System.out.println("숫자를 한 개 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		// 예외처리부
		if (num <= 0) {
			System.out.println("양수만 입력해주세요.");
			return; // 리턴으로 예외 케이스 필터링을 하는 것을 추천한다!
		}
		
		// 정상부
		if ( num % 2 == 0) {
			System.out.println("짝수다");
		} else {
			System.out.println("홀수다");
		}
	}
