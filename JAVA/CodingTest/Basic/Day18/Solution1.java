// Day 18 문자열, 수학, 조건문, 정렬 > 문자열안에 문자열
package Day18;

// 문제 설명
// 문자열 str1, str2가 매개변수로 주어집니다.
// str1 안에 str2가 있다면 1을 없다면 2를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ str1의 길이 ≤ 100
// 1 ≤ str2의 길이 ≤ 100
// 문자열은 알파벳 대문자, 소문자, 숫자로 구성되어 있습니다.

// str1						str2	result
// "ab6CDE443fgh22iJKlmn1o"	"6CD"	1
// "ppprrrogrammers"		"pppp"	2
// "AbcAbcA"				"AAA"	2

public class Solution1 {
	
	public int solution(String str1, String str2) {
        int answer = 0;
        if(str1.contains(str2)) {
        	answer = 1;
        } else {
        	answer = 2;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		String str1 = "ab6CDE443fgh22iJKlmn1o";
		String str2 = "6CD";
		int result = new Solution1().solution(str1, str2);
		System.out.println(result);
	}

}
