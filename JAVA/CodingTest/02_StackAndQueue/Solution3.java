// 스택앤큐 > 올바른괄호
package ex03;

import java.util.*;

// s			answer
// "()()"	true
// "(())()"	true
// ")()("	false
// "(()("	false

// Stack으로 풀지 않고 간단한 규칙으로 풀이 예정
// (   )   (   )
// +1  -1  +1  -1 (치환된 
// 1   0   1    0  = 0
// true는 정답이 0이고, 한번도 음수가 되지 않은 값!

// (  (  )  )  (  )
// +1 +1 -1 -1 +1 -1
// 1  2  1  0  1  0 = 0

// )  (  )  (
// -1 -> 음수인 경우 절대 정상이 될 수 없다! false 리턴!

// (  (  )  (
// +1 +1 -1  +1
// 1  2  1  2  = 2, 0이 아니므로 false!

public class Solution {
	
	boolean solution(String s) {
		int val = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				val += 1;
			} else {
				val -= 1;
			}
//			System.out.println(s.charAt(i));
//			System.out.println(val);
//			System.out.println();
			if(val < 0) {
				return false;
			}
		}
		if(val == 0) {
			return true;
		} else {
			return false;
		}
    }

    public static void main(String[] args) {
    	String s = ")()(";
    	boolean result = new Solution().solution(s);
    	System.out.println(result);
	}

}
