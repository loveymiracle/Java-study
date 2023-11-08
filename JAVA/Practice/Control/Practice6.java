public void practice6() {
		// 나이를 키보드로 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 성인(19세 초과)인지 출력하세요.
		// 19
		System.out.println("나이 : ");
		int value4 = Integer.parseInt(sc.nextLine());
		if(value4 > 19) {
			System.out.println("성인");
		} else if(value4 <= 19 && value4 >13) {
			System.out.println("청소년");
		} else {
			System.out.println("어린이");
		}
	}
public static void practice6() {
		// 나이를 키보드로 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지,
		//성인(19세 초과) 인지 출력하세요.
		System.out.println("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		if(age <= 13) { // 13세 이하
			System.out.println("어린이");
		} else if(age > 13 && age <= 19) { // 13세 초과 ~ 19세 이하
			System.out.println("청소년");
		} else { // 19 > age
			System.out.println("성인");
		}
	}
