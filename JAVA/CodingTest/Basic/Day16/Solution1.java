// Day 16 문자열, 수학, 배열, 조건문 > 편지
package Day16;

// 제한사항
// 공백도 하나의 문자로 취급합니다.
// 1 ≤ message의 길이 ≤ 50
// 편지지의 여백은 생각하지 않습니다.
// message는 영문 알파벳 대소문자, ‘!’, ‘~’ 또는 공백으로만 이루어져 있습니다.

// message				result
// "happy birthday!"	30
// "I love you~"		22

public class Solution1 {
	
	public int solution(String message) {
        int answer = message.length() * 2;
        return answer;
    }
	
	public static void main(String[] args) {
		String message = "happy birthday!";
		int result = new Solution1().solution(message);
		System.out.println(result);
	}

}
