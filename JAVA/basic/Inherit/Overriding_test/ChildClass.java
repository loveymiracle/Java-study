
public class ChildClass extends SuperClass{
	// 접근 제한자 별로 상속 실습
	
	// 1. privateMethod -> 오버라이드 불가!
	// 이유 : private 접근제한자는 다른 클래스에서 볼 수 없다.
	
	// 2. defaultMehod -> 오버라이드 성공
	// 이유 : 같은 패키지임으로 default에 접근 가능하다.
	@Override
	void defaultMethod() {
		// TODO Auto-generated method stub
		super.defaultMethod();
	}
	
	// 3. protectedMethod -> 오버라이드 성공
	// 이유 : protected 접근제한자는 패키지와 상관 없이 부모자식간의 재사용 허용
	// protected 오버라이드 시 접근 제한자를 public으로 넓게 바꿀 수도 있다.
//	@Override
//	protected void protectedMethod() {
//		// TODO Auto-generated method stub
//		super.protectedMethod();
//	}
	
	// protected -> public 접근제한자 변경 가능!
	@Override
	public void protectedMethod() {
		// TODO Auto-generated method stub
		super.protectedMethod();
	}
	
	// 4. publicMethod -> 오버라이드 성공
	// 이유 : public은 어떤 제한도 없다.
	
	// 5. finalMethod -> 오버라이드 불가!!
	// 이유 : final 키워드가 오버라이드를 막는 키워드
	// -> Cannot override the final method from SuperClass
}
