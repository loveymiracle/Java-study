public static void practice8() {
		// 다음과 같은 실행 예제를 구현하세요.
		// 4
		System.out.println("정수 입력 : ");
		int num7 = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i <= num7; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.printf("*");
			} System.out.println();
		}
	}
public static void practice8() {
		// 다음과 같은 실행 예제를 출력 하세요
		// *
		// **
		// ***
		// ****
		System.out.println("정수 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < (i + 1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
