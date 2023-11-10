
//Member의 제대로 된 버전! 이게 표준문법 
//ValueObject : VO('브이오')로 읽고, 데이터만 있는 객체의 표현법, 멤버변수 + 생성자 + getter, setter + 기타(toString)
//VO의 객체에서는 멤버변수를 private로 접근 제한한다.
//이유 : 외부에서 직접 변수로 접근하지 않고, getter/setter로 기능을 제한한다!
//만드는 방법은 자동완성으로 완성 시킨다!

//VO 만드는 방법! ★★★★★
//Step1. 객체에서 사용할 변수를 선언한다. 접근제한자 private로 통일한다. 올바른 타입을 활용
//Step2. alt + shift + s 혹은 우클릭 -> Source로 접근하고, 아래부터 자동으로 생성한다.
//     생성자, 필드 있는 생성자, toString, getter/setter 생성한다!
//Step3. TODO 주석 일부를 제거하고, 포멧팅을 맞춰준다.

public class MemberVO {
	private String name;
	private int age;
	private String phoneNum;
	private String address;
	
	// 인자 없는 생성자
	// super() : 부모의 생성자를 호출하는 키워드, 없어도 알아서 java가 스스로 호출한다.
	public MemberVO() {
		super();
	}
	
	// 모든 인자가 있는 생성자, 한번에 모든 값을 초기화 할 수 있다.
	// -> 때에 따라 생성자를 커스텀해서 자동 생성 시킬 수 있다.
	public MemberVO(String name, int age, String phoneNum, String address) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	
	// 만일 초기화 해야할 대상이 모든 멤버변수가 아닌 경우 제외하고 다시 생성한다.
	// -> 필수값과 옵션값을 구별해서 생성시킬 때 
	public MemberVO(String name, int age, String phoneNum) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
	}

	@Override // 상속에서 부모의 메소드를 재정의 = @Override 되었다는 것을 알리는 어노테이션
	// 어노테이션? java에서 부가적인 정보를 제공하거나 '@'을 통해 특수한 기능을 활용할 때 사용하는 문법
	// 지금은 생략해도 문제 없음
	public String toString() {
		return "MemberVO [name=" + name + ", age=" + age + ", phoneNum=" + phoneNum + ", address=" + address + "]";
	}

	// 만일 우리가 필요 없는 set, getter는 지울 수도 있다.
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
