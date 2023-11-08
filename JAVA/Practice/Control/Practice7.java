public void practice7() {
		// 아이디, 비밀번호를 test/1212로 정하고 로그인 기능을 작성하세요.
		// 로그인 성공 시 "로그인 성공",
		// 아이디가 틀렸을 시 "아이디가 틀렸습니다.",
		// 비밀번호가 틀렸을 시 "비밀번호가 틀렸습니다."를 출력하세요.
		String id = "test";
		String pw = "1212";
		
		System.out.println("ID를 입력하세요.");
		String ID = sc.nextLine();
		System.out.println("PW를 입력하세요.");
		String PW = sc.nextLine();
		if(ID.equals(id) && PW.equals(pw)) {
			System.out.println("로그인 성공");
		} else if(!ID.equals(id)){
			System.out.println("아이디가 틀렸습니다.");
		} else if(!PW.equals(pw)) {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}
public static void practice7_1() { 
		// 아이디, 비밀번호를 test/1212로 정하고 로그인 기능을 작성하세요.
		// 로그인 성공 시 "로그인 성공" 아이디가 틀렸을 시 "아이디가 틀렸습니다.",
		// 비밀번호가 틀렸을 시 "비밀번호가 틀렸습니다."를 출력하세요.
		
		String userID = "test";
		String userPW = "1212";
		System.out.println("아이디 : ");
		String inputID = sc.nextLine();
		System.out.println("비밀번호 : ");
		String inputPW = sc.nextLine();
		
		if(inputID.equals(userID) && inputPW.equals(userPW)) {
			System.out.println("로그인 성공");
//		} else if(!inputID.equals(userID)) { //! 는 가독성이 안좋다고 생각.	
		} else if(inputID.equals(userID) == false) {
			System.out.println("아이디가 틀렸습니다.");
		} else if(inputPW.equals(userPW) == false) {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}
	public static void practice7_2() { // 권장 패턴
		// --> 정상 패턴을 먼저 아래에 배치하고 예외를 코드 상단에서 필터링 한다.
		
		// 아이디, 비밀번호를 test/1212로 정하고 로그인 기능을 작성하세요.
		// 로그인 성공 시 "로그인 성공" 아이디가 틀렸을 시 "아이디가 틀렸습니다.",
		// 비밀번호가 틀렸을 시 "비밀번호가 틀렸습니다."를 출력하세요.
		
		String userID = "test";
		String userPW = "1212";
		System.out.println("아이디 : ");
		String inputID = sc.nextLine();
		System.out.println("비밀번호 : ");
		String inputPW = sc.nextLine();
		
		// 필터링 패턴 = 예외를 제거해준다.
		if(userID.equals(inputID) == false) {
			System.out.println("아이디가 틀렸습니다.");
			return; // 필터링!!
		}
		
		if(userPW.equals(inputPW) == false) {
			System.out.println("비밀번호가 틀렸습니다.");
			return; // 필터링!!
		}
		// 예외 케이스 추가 !! -> 쉽게 가능하다.
		if(inputID.contains(userPW)) {
			System.out.println("ID에 비밀번호가 존재합니다.");
			return;
		}
		
		// 정상, 클린한 영역으로 문제 없는 알고리즘 배치
		System.out.println("로그인 성공");
	}
