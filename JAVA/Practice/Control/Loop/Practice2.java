public void practice2() {
		// 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 모든 숫자를 거꾸로 출력하세요.
		// 단, 입력한 수는 1보다 크거나 같아야 합니다.
		System.out.println("1이상의 숫자를 입력하세요 : ");
		int value1 = Integer.parseInt(sc.nextLine());
		
		if(value1 < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		} else {
			for(int i = value1; i > 0; i--) {
				System.out.print(i + " ");
			}
		}
	}
public static void practice2() {
		// 사용자로부터 한 개의 값을 입력 받아 1부터 그 숫자까지의 숫자들을 모두 출력
		// 단, 입력한 수는 1보다 크거나 같아야 합니다.
		System.out.println("1이상의 숫자를 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		// 필터링 패턴!!
		if(num < 1) {
			System.out.println("1이상의 숫자를 입력해주세요");
			return;
		}
		// 10 9 8 7 ... 1, 출력 안됨 : 0
		for(int i = num; i > 0; i--) {
			System.out.print(i + " ");
		}
		
		// 증감하는 식에서 -로 빼는 방법
		for(int i = 0; i < num; i++) {
			System.out.print((num - i) + " ");
		}
	}
