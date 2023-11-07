public void practice4() {
		// ex
    // 키보드로 입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "홀수다"를 출력하세요.
		// ※ 삼항 연산자 사용해주세요!

    // answer
		// 정수 : 5
		// 홀수다 
		System.out.println("practice4!!");
		System.out.println("정수 : ");
		int num3 = Integer.parseInt(sc.nextLine());
		
		String result3 = num3 / 2 == 0 ? "짝수다": "홀수다";
		System.out.println(result3);
	}
}
