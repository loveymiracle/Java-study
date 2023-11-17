package hw.ex01.object;

import java.util.Objects;

// 클론 메소드 만드는 방법
//1. implements Cloneable을 선언한다.
//2. clone 메소드를 오버라이드 한다.
//3. protected -> public, throws CloneNotSupportedException 문장을 지운다.
// 그리고 try-catch문으로 예외처리를 해준다. return null을 마지막줄에 추가
// 4. return type을 Member로 바꾸고 casting으로 Member 객체로 돌려준다.

public class Member {
	private String id;
	private String name;
	private int age;

	public Member() {
		super();
	}

	public Member(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	@Override
	public Member clone() {
		try {
			return (Member)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
