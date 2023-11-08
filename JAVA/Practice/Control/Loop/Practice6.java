
public static void practice6() {
		System.out.println("숫자 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		if(num > 9 || num < 1) {
			System.out.println("9이하의 숫자만 입력해주세요.");
			return;
		}
		
		for(int i = num; i <10; i++) {
			System.out.println("===== " + i + "단 =====");
			for(int j = 1; j <10; j++) {
				System.out.println("" + i + " * " + j + " = " + (i * j));
			}
		}
	}
