public void practice3() {
		// 키보드로 입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "홀수다"를 출력하세요.
		//5
		System.out.println("정수 : ");
		int value2 = Integer.parseInt(sc.nextLine());
		if(value2 % 2 == 0) {
			System.out.println("짝수다");
		} else {
			System.out.println("홀수다");
		}
	}
