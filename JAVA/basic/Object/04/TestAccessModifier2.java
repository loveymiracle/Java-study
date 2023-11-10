
//외부 패키지에서 Class를 가져올 때 쓰는 import
import com.multi.ex04.access_modifier.AccessModifier;

// 다른 패키지의 Class 영역
public class TestAccessModifier {
	public static void main(String[] args) {
		// AccessModifier 다른 패키지에서 멤버변수 접근 테스트
		AccessModifier test = new AccessModifier();
		test.publicValue 	= 1;	// public O
//		test.protectedValue = 2;	// protected X
//		test.defaultValue 	= 3;	// default X
//		test.privateValue  	= 4;	// Error! private은 외부에서 절대 접근 불가능!
	}
}
