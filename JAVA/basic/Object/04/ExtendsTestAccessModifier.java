
import hw.ex04.access_modifier.AccessModifier;

// 상속 시킬 클래스, 나중에 상속 때 다시 배울 예정...
public class ExtendsTestAccessModifier extends AccessModifier{
	
	public void testMethod() {
		// 상속된 클래스에서 접근 테스트
		publicValue 	= 1;	// O
		protectedValue  = 2;	// O
//		defaultValue 	= 3;	// default NG!
//		privateValue  	= 4;	// private NG!
	}

}
