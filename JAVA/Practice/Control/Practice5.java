public void practice5() {
		// 주민번호를 이용하여 남자인지 여자인지 구분하여 출력하세요.
		// 132456-2123456
		System.out.println("주민번호를 입력하세요(- 포함) : ");
		String str = sc.nextLine();
  
		if(str.contains("-2") || str.contains("-4")) {
			System.out.println("여자");
		} else {
			System.out.println("남자");
		}
	}
public static void practice5_1() {
		// 주민번호를 이용하여 남자 여자 구별
		// 주민번호를 입력하세요(- 포함) : 132456-2123456
		System.out.println("주민번호를 입력하세요(- 포함) : ");
		String str = sc.nextLine();
		
		if(str.charAt(7) == '1' || str.charAt(7) == '3') {
			System.out.println("남자");
		} else {
			System.out.println("여자"	);
		}
	}
