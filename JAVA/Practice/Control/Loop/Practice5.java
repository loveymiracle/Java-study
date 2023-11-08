
public static void practice5() {
		// 사용자로부터 입력 받은 숫자로 구구단 출력!
		// 숫자 : 4
		// ===== 4단 =====
		// 4 * 1 = 4
		System.out.println("숫자 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println("===== " + num + "단 =====");
		for(int i = 1; i < 10; i++) {
			System.out.println("" + num + " * " + i + " = " + (i * num));
		}
	}
