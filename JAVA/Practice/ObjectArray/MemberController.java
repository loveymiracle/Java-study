package hw.member.controller;

import hw.member.model.vo.Member;

public class MemberController {
	public static int MAX_SIZE = 10;
	private Member[] memberArray = new Member[MAX_SIZE];
	private int size = 0; 

	public MemberController() {
		for(Member m : memberArray) {
			m = null;
		}
	}
	public int existMemberNum() {
		return size;
	}
	
	public boolean checkId(String inputId) {
		for (Member m : memberArray ) {
			if(m==null) {
				continue;
			}
			if(m.getId().equals(inputId)) {
				return false;
			}
		}
		return true;
	}
	
	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		for(int i = 0; i <MAX_SIZE; i++) {
			if(memberArray[i] != null) {
				continue;
			}
			memberArray[i] = new Member(id, name, password, email, gender, age);
			size++;
			break;
		}
	}
	
	public Member searchId(String id) {
		for(Member m : memberArray) {
			if(m == null) {
				continue;
			} else if(m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}
	
	public Member[] searchName(String name) {
		Member nameArray[] = new Member[MAX_SIZE];
		int temp = 0;
		for(int i = 0; i < MAX_SIZE; i++) {
			if(memberArray[i] == null) {
				continue;
			}
			if(memberArray[i].getName().contains(name)) {
				nameArray[temp] = memberArray[i];
				temp++;
			}
		}
		if(temp == 0) {
			return null;
		} else {
			return nameArray;
		}
	}
	
	public Member[] searchEmail(String email) {
		Member emailArray[] = new Member[MAX_SIZE];
		int temp = 0;
		for(int i = 0; i < MAX_SIZE; i++) {
			if(memberArray[i] == null) {
				continue;
			}
			if(memberArray[i].getEmail().contains(email)) {
				emailArray[temp] = memberArray[i];
				temp++;
			}
		}
		if(temp == 0) {
			return null;
		} else {
			return emailArray;
		}
		
	}
	
	public boolean updatePassword(String id, String password) {
		for(Member m : memberArray) {
			if(m == null) {
				continue;
			}
			if(m.getId().equals(id)) {
				m.setPassword(password);
				return true;
			}
		}
		return false;
	}
	
	public boolean updateName(String id, String name) {
		for(Member m : memberArray) {
			if(m == null) {
				continue;
			}
			if(m.getId().equals(id)) {
				m.setName(name);;
				return true;
			}
		}
		return false;
	}
	
	public boolean updateEmail(String id, String email) {
		for(Member m : memberArray) {
			if(m == null) {
				continue;
			}
			if(m.getId().equals(id)) {
				m.setEmail(email);
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(String id) {
		for(int i = 0; i < MAX_SIZE; i++) {
			if(memberArray[i] == null) {
				continue;
			}
			if(memberArray[i].getId().equals(id)) {
				memberArray[i] = null;
				size--;
				return true;
			}
		}
		return false;
	}
	
	public void delete() {
		for(int i = 0; i < MAX_SIZE; i++) {
			memberArray[i] = null;
			size = 0;
		}
	}
	
	public Member[] printAll() {
		return memberArray;
	}
}
