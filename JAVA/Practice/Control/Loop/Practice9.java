public static void practice9() {
		// 다음과 같은 실행 예제를 구현하세요.
		// 4
		System.out.println("정수 입력 : ");
		int num8 = Integer.parseInt(sc.nextLine());
		
		for(int i = num8; i > 0; i--) {
			for(int j = 1; j <= i; j++) {
				System.out.printf("*");
			} System.out.println();
		}
	}
}
public static void practice9() {
		// 8번 거꾸로
		System.out.println("정수 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < num; i++) {
			for(int j = num - i ; j > 0; j--) {
				System.out.println("*");
			}
		} 
		System.out.println();
	}
}
