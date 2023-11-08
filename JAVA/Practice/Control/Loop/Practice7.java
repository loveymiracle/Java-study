public static void practice7() {
		// 사용자로부터 시작 숫자와 공차를 입력 받아 일정한 값으로 숫자가 커지거나 작아지는 프로그램을 구현하세요.
		// 단, 출력 되는 숫자는 총 10개 입니다.
		System.out.println("시작 숫자 : ");
		int num5 = Integer.parseInt(sc.nextLine());
		System.out.println("공차 : ");
		int num6 = Integer.parseInt(sc.nextLine());
		int count = 0;
		
		for(int i = 0; ; i += num6) {
			count++ ;
			if(count < 11) {
				System.out.print(num5 + i + " ");
			} else {
				break;
			}
		}
	}
public static void practice7() {
		// 사용자로부터 시작 숫자와 공차를 입력 받아 일정한 값으로 숫자가 커지거나 작아지는 프로그램 구현
		// 단, 출력 되는 숫자는 총 10개 입니다.
		// 시작 숫자 : 4 , 공차 : 3
		// 4 7 10 13 16 19 22 25 28 31
		System.out.println("시작 숫자 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("공차 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < 10; i++) {
			int num3 = num1 + (num2 * i);
			System.out.print(num3 + " ");
		}
	}
