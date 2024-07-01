// Day 23 배열, 정렬, 문자열 > 옹알이 (1)
package Day23;

import java.util.Arrays;

// 문제 설명
// 머쓱이는 태어난 지 6개월 된 조카를 돌보고 있습니다.
// 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음을
// 최대 한 번씩 사용해 조합한(이어 붙인) 발음밖에 하지 못합니다.
// 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ babbling의 길이 ≤ 100
// 1 ≤ babbling[i]의 길이 ≤ 15
// babbling의 각 문자열에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다.
// 즉, 각 문자열의 가능한 모든 부분 문자열 중에서 "aya", "ye", "woo", "ma"가 한 번씩만 등장합니다.
// 문자열은 알파벳 소문자로만 이루어져 있습니다.

// 입출력 예
// babbling										result
// ["aya", "yee", "u", "maa", "wyeoo"]			1
// ["ayaye", "uuuma", "ye", "yemawoo", "ayaa"]	3

public class Solution3 {

	public int solution(String[] babbling) {
		String[] str = {"aya", "ye", "woo", "ma"};
		int answer = 0;
		
		System.out.println(Arrays.toString(babbling));
		for(int i = 0; i < babbling.length; i++) {
			for(int j = 0; j < str.length; j++) {
				babbling[i] = babbling[i].replace(str[j], " ");
				System.out.println(" 바뀐 값 : " + babbling[i] + ", 바꿀 값 : " + str[j]);
				System.out.println(Arrays.toString(babbling));
			}
			
			if(babbling[i].trim().length() == 0) {
				answer++;
			}
		}
		return answer;
	}
	
	public int solution2(String[] babbling2) {
        String[] str = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for (String babble : babbling2) {
            String temp = babble;
            for (String s : str) {
                temp = temp.replaceAll(s, " ");
            }
            temp = temp.replaceAll(" ", "");
            if (temp.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
	
	public int solution3(String[] babbling3) {
		int answer = 0;
		
		for(int i = 0; i < babbling3.length; i++) {
			if(babbling3[i].matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$")) {
				answer++;
			}
		}
		return answer;
	}
	
	public int solution4(String[] babbling4) {
		int answer = 0;
		
		for(int i = 0; i < babbling4.length; i++) {
			babbling4[i] = babbling4[i].replace("aya", "1");
			babbling4[i] = babbling4[i].replace("ye", "1");
			babbling4[i] = babbling4[i].replace("woo", "1");
			babbling4[i] = babbling4[i].replace("ma", "1");
			babbling4[i] = babbling4[i].replace("1", "");
			
			if(babbling4[i].isEmpty()) {
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String[] babbling = { "aya", "yee", "u", "maa", "wyeoo" };
		String[] babbling2 = { "aya", "yee", "u", "maa", "wyeoo" };
		String[] babbling3 = { "aya", "yee", "u", "maa", "wyeoo" };
		String[] babbling4 = { "aya", "yee", "u", "maa", "wyeoo" };
		int result = new Solution3().solution(babbling);
		int result2 = new Solution3().solution2(babbling2);
		int result3 = new Solution3().solution3(babbling3);
		int result4 = new Solution3().solution4(babbling4);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
	}

}
