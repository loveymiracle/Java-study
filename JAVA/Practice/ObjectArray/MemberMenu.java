package hw.member.view;

import java.util.Scanner;

import hw.member.controller.MemberController;
import hw.member.model.vo.Member;

public class MemberMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	private MemberController mc = new MemberController();
	
	public MemberMenu() {
		
	}
	
	public void mainMenu() {
		
		while (true) {
			System.out.println("최대 등록 가능한 회원 수는 " + MemberController.MAX_SIZE + "명입니다.");
			System.out.println("현재 등록된 회원 수는 " + mc.existMemberNum() + "명입니다.");
			
			if (mc.existMemberNum() == MemberController.MAX_SIZE) {
				System.out.println("1. 회원 등록(현재 인원 10명으로 가입 불가)\n2. 회원 검색\n3. 회원 정보 수\n4. 회원 삭제\n5. 모두 출력\n9. 끝내기\n메뉴 번호 : ");
			} else {
				System.out.println("1. 회원등록\n2. 회원 검색\n3. 회원 정보 수정\n4. 회원 삭제\n5. 모두 출력\n9. 끝내기\n메뉴 번호 : ");
			} int menuNum = Integer.parseInt(sc.nextLine());
			
			if (menuNum == 1) {
				insertMember();
			} else if (menuNum == 2) {
				searchMember();
			} else if (menuNum == 3) {
				updateMember();
			} else if (menuNum == 4) {
				deleteMember();
			} else if (menuNum == 5) {
				printAll();
			} else if (menuNum == 9) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void insertMember() {
		System.out.println("새 회원을 등록합니다.");
		
		boolean flag = false;
		
		String id = "";
		String name = "";
		String password = "";
		String email = "";
		char gender = ' ';
		int age = 0;
		
		while(flag == false) {
			System.out.println("아이디 : ");
			id = sc.nextLine();
			if(flag = mc.checkId(id)) {
				continue;
			}
			System.out.println("중복된 아이디 입니다. 다시 입력해주세요.");
		}
		flag = false;
		
		System.out.println("이름 : ");
		name = sc.nextLine();
		System.out.println("비밀번호 : ");
		password = sc.nextLine();
		System.out.println("이메일 : ");
		email = sc.nextLine();
		
		while (flag == false) {
			System.out.println("성별 : ");
			gender = sc.nextLine().charAt(0);
			if(gender == 'm' || gender == 'M' || gender == 'f' || gender == 'F') {
				flag = true;
				continue;
			}			
			System.out.println("성별을 다시 입력하세요.");
		}
		
		System.out.println("나이 : ");
		age = Integer.parseInt(sc.nextLine());
		mc.insertMember(id, name, password, email, gender, age);
	}
	
	public void searchMember() {
		System.out.println("1. 아이디로 검색하기\n2. 이름으로 검색하기\n3. 이메일로 검색하기\n9. 메인으로 돌아가기\n메뉴 번호 : ");
		int menuNum = Integer.parseInt(sc.nextLine());
		
		if(menuNum == 1) {
			searchId();
		} else if(menuNum == 2) {
			searchName();
		} else if(menuNum == 3) {
			searchEmail();
		} else if(menuNum == 9) {
			System.out.println("메인으로 돌아갑니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void searchId() {
		System.out.println("검색할 아이디 : ");
		String inputId = sc.nextLine();
		
		Member m = mc.searchId(inputId);
		if(m == null) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		System.out.println("찾으신 회원 조회 결과입니다.");
		System.out.println(m.getId() + '\t' + m.getName() + '\t' + m.getPassword() + '\t' + m.getGender() + '\t' + m.getAge());
	}
	
	public void searchName() {
		System.out.println("검색할 이름 : ");
		String inputName = sc.nextLine();
		
		Member memberArr[] = mc.searchName(inputName);
		if(memberArr == null) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		System.out.println("찾으신 회원 조회 결과입니다.");
		for(Member m : memberArr) {
			if(m == null) {
				break;
			}
			System.out.println(m.getId() + '\t' + m.getName() + '\t' + m.getPassword() + '\t' + m.getGender() + m.getAge());
		}
	}
	
	public void searchEmail() {
		System.out.println("검색할 이메일 : ");
		String inputEmail = sc.nextLine();
		
		Member memberArr[] = mc.searchEmail(inputEmail);
		if(memberArr == null) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		System.out.println("찾으신 회원 조회 결과입니다.");
		for(Member m : memberArr) {
			if (m == null) {
				break;
			}
			System.out.println(m.getId() + '\t' + m.getName() + '\t' + m.getPassword() + '\t' + m.getGender() + '\t' + m.getAge());
		}
	}
	
	public void updateMember() {
		System.out.print("1. 비밀번호 수정하기\n2. 이름 수정하기\n3. 이메일 수정하기\n9. 메인으로 돌아가기\n메뉴 선택 : ");
		int menuNum = Integer.parseInt(sc.nextLine());
		
		if(menuNum == 1) {
			updatePassword();
		} else if (menuNum == 2) {
			updateName();
		} else if (menuNum == 3) {
			updateEmail();
		} else if (menuNum == 9) {
			System.out.println("메인으로 돌아갑니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void updatePassword() {
		System.out.println("수정할 회원의 아이디 : ");
		String inputId = sc.nextLine();
		System.out.println("수정할 회원의 비밀번호 : ");
		String inputPassword = sc.nextLine();
		
		if(mc.updatePassword(inputId, inputPassword)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	
	public void updateName() {
		System.out.println("수정할 회원의 아이디 : ");
		String inputId = sc.nextLine();
		System.out.println("수정할 회원의 이름 : ");
		String inputName = sc.nextLine();
		
		if(mc.updateName(inputId, inputName)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	
	public void updateEmail() {
		System.out.println("수정할 회원의 아이디 : ");
		String inputId = sc.nextLine();
		System.out.println("수정할 회원의 이메일 : ");
		String inputEmail = sc.nextLine();
		
		if(mc.updateEmail(inputId, inputEmail)) {
			System.out.println("수정이 성공적으로 되었습니다.");
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	
	public void deleteMember() {
		System.out.print("1. 특정 회원 삭제하기\n2. 모든 회원 삭제하기\n9. 메인으로 돌아가기\n메뉴 번호 : ");
		int menuNum = Integer.parseInt(sc.nextLine());

		if (menuNum == 1) {
			deleteOne();
		} else if (menuNum == 2) {
			deleteAll();
		} else if (menuNum == 9) {
			System.out.println("메인으로 돌아갑니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}

	}

	public void deleteOne() {
		System.out.print("삭제할 회원의 아이디 : ");
		String inputId = sc.nextLine();

		System.out.print("정말 삭제하시겠습니까? (y/n) : ");
		char ch = sc.nextLine().charAt(0);

		if (ch == 'y' || ch == 'Y') {
			if (mc.delete(inputId)) {
				System.out.println("성공적으로 삭제되었습니다.");
			} else {
				System.out.println("존재하지 않는 아이디입니다.");
			}
		}
	}

	public void deleteAll() {
		System.out.print("정말 삭제하시겠습니까? (y/n) : ");
		char ch = sc.nextLine().charAt(0);

		if (ch == 'y' || ch == 'Y') {
			mc.delete();
			System.out.println("성공적으로 삭제하였습니다.");
		}
	}

	public void printAll() {
		if (mc.existMemberNum() == 0) {
			System.out.println("저장된 회원이 없습니다.");
			return;
		}
		Member memberArr[] = mc.printAll();
		for(Member m : memberArr) {
			if(m == null) {
				continue;
			}
			System.out.println(m.getId() + '\t' + m.getName() + '\t' + m.getPassword() + '\t' +m.getGender() + '\t' + m.getAge());
		}
	}
}
