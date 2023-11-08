public void practice4() {
		// 사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
		// 만일 1 미만의 숫자가 입력됐다면 "1 이상의 숫자를 입력해주세요"를 출력하세요.
		System.out.println("첫 번째 숫자 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("두 번째 숫자 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		if(num1 <= 0 || num2 <= 0) {
			System.out.println("1이상의 숫자를 입력해주세요.");
		} else if (num2 > num1) {
			for(int i = num1; i <= num2; i++) {
				System.out.print(i + " ");
			}
		} else {
			for(int i = num2; i <= num1; i++) {
				System.out.print(i + " ");
			}
		}
	}
public static void practice4() {
		// -> 아래 처럼 반복된 코드를 유지보수 하면 반드시 사고 날 수 있다.
		// -> 코드의 반복은 좋지 않다.
		// 명품문제!! 주옥 같은 문제!
		// 사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
		// 만일 1 미만의 숫자가 입력됐다면 "1 이상의 숫자를 입력해주세요"를 출력
		// 첫 번째 숫자 : 8 , 첫 번째 숫자 : 4
		// 두 번째 숫자 : 4 , 두 번째 숫자 : 8
		// 4 5 6 7 8     , 4 5 6 7 8
		System.out.println("첫 번째 숫자 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("두 번째 숫자 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		if(num1 < 1 || num2 < 1) {
			System.out.println("1이상의 숫자를 입력해주세요.");
			return;
		}
		
		// 정상
		if(num1 < num2) {
			for(int i = num1; i <= num2; i++) {
				System.out.print(i + " "); // 요구사항 변경 ", " 하나만 적용..
			}
		} else { // 반대
			// 패턴이 반복 되는 구간
			for(int i = num2; i <= num1; i++) {
				System.out.print(i + " ");
			}
		}
	}
public static void practice4_1() { // 추천 패턴!!
		// 명품문제!! 주옥 같은 문제!
		// 사용자로부터 두 개의 값을 입력 받아 그 사이의 숫자를 모두 출력하세요.
		// 만일 1 미만의 숫자가 입력됐다면 "1 이상의 숫자를 입력해주세요"를 출력
		// 첫 번째 숫자 : 8 , 첫 번째 숫자 : 4
		// 두 번째 숫자 : 4 , 두 번째 숫자 : 8
		// 4 5 6 7 8     , 4 5 6 7 8
		System.out.println("첫 번째 숫자 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.println("두 번째 숫자 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		if(num1 < 1 || num2 < 1) {
			System.out.println("1이상의 숫자를 입력해주세요.");
			return;
		}
		
		// swap 패턴 -> A와 B를 바꾸는 패턴
		// ✭✭✭✭✭ 외워라!! -> 꼬리 물기 패턴으로!!
		if(num1 > num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		for(int i = num1; i <= num2; i++) {
			System.out.println(i + " ");
		}
	}
