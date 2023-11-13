
// 회원정보를 관리하는 객체, VO(ValueObjefct) : 데이터를 담는 용도로만 활용하는 객체, 특별한 기능을 추가하는 것을 금지!
public class MemberVO {
	private String id;
	private String name;
	private int age;

	public MemberVO() {
		super();
	}

	public MemberVO(String id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		// TODO 나중에 사용자 정보 추가할 예정 (23.11.07)
		// TODO 사용예시, window -> show view -> task로 TODO가 붙은 주석을 찾을 수 있음.
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", age=" + age + "]";
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
}
