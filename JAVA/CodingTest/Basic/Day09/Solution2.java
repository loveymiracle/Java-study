// Day 9 수학, 문자열, 해시, 완전탐색, 조건문 > 모스부호 (1)
package Day09;

import java.util.*;

// 제한사항
// 1 ≤ letter의 길이 ≤ 1,000
// return값은 소문자입니다.
// letter의 모스부호는 공백으로 나누어져 있습니다.
// letter에 공백은 연속으로 두 개 이상 존재하지 않습니다.
// 해독할 수 없는 편지는 주어지지 않습니다.
// 편지의 시작과 끝에는 공백이 없습니다.

// letter						result
// ".... . .-.. .-.. ---"		"hello"
// ".--. -.-- - .... --- -."	"python"

public class Solution2 {
	
	String[] morse = {".-","-...","-.-.","-..",".",
					"..-.","--.","....","..",".---",
					"-.-",".-..","--","-.","---",
					".--.","--.-",".-.","...","-",
					"..-","...-",".--","-..-","-.--","--.."};
	
	public String solution(String letter) {
        String answer = "";
        int ascii = 97;
        String[] e = letter.split(" ");
        
        for(String es : e) {
        	for(int i = 0; i < morse.length; i++) {
        		if(morse[i].equals(es)) {
        			answer += (char)(ascii + i);
        		}
        	}
        }
        return answer;
    }
	
	public String solution1(String letter) {
		String answer ="";
		Map<String, String> m = new HashMap<>() {
			{
				put(".-","a");
				put("-...","b");
				put("-.-.","c");
				put("-..","d");
				put(".","e");
				put("..-.","f");
				put("--.","g");
				put("....","h");
				put("..","i");
				put(".---","j");
				put("-.-","k");
				put(".-..","l");
				put("--","m");
				put("-.","n");
				put("---","o");
				put(".--.","p");
				put("--.-","q");
				put(".-.","r");
				put("...","s");
				put("-","t");
				put("..-","u");
				put("...-","v");
				put(".--","w");
				put("-..-","x");
				put("-.--","y");
				put("--..","z");
			}
		};
		String[] letters = letter.split(" ");
		
		for(String str : letters) {
			System.out.println(str);
			answer += m.get(str);
			System.out.println(answer);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		String letter = ".... . .-.. .-.. ---";
		String result = new Solution2().solution(letter);
		String result1 = new Solution2().solution1(letter);
		System.out.println(result);
		System.out.println(result1);
	}

}
