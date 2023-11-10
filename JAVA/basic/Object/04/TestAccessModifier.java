
// 같은 패키지 내 Class 영역
public class TestAccessModifier {
	public static void main(String[] args) {
		// AccessModifier 같은 패키지에서 멤버변수 접근 테스트
		AccessModifier test = new AccessModifier();
		test.publicValue 	= 1;	// public O
		test.protectedValue = 2;	// protected O
		test.defaultValue 	= 3;	// default O
//		test.privateValue  	= 4;	// Error! private은 외부에서 절대 접근 불가능!
		// The field AccessModifier.privateValue is not visible : 보이지 않는다! 
		// -> private 접근 제한 할 때 나오는 에러
	}
}
