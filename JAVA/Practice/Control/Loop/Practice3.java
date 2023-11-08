public void practice3() {
		// 1부터 사용자에게 입력 받은 수까지의 정수들의 합을 출력 하세요.
		System.out.println("정수를 하나 입력하세요 : ");
		int value2 = Integer.parseInt(sc.nextLine());
		int sum = 0;
		
		for(int i = 1; i <= value2; i++) {
			System.out.print(i);
			sum += i;
			if(i == sum) {
				continue;
			} else {
				System.out.print(" + ");
			} 
		} System.out.println(" = " + sum);
	}
public static void practice3() {
		// 1부터 사용자에게 입력 받은 수 까지의 정수들의 합을 출력 하세요.
		// 명품문제!! 개발자가 끝까지 고생하는 패턴의 문제!!
		System.out.println("정수를 하나 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		if(num < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요.");
			return;
		}
		
		int sum = 0;
		for(int i = 1; i < num; i++) {
			sum += i;
			System.out.print(i + " + ");
			// 마지막 index를 돌리지 않는 방법, 많이 쓰는 패턴
			if(i < num) {
				System.out.print(" + ");
			}
		}
		System.out.println(" = " + sum);
	}
