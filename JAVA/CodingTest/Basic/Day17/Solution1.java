// Day 17 문자열, 수학, 조건문, 배열, 사칙연산 > 숫자 찾기
package Day17;

// 제한사항
// 0 < num < 1,000,000
// 0 ≤ k < 10
// num에 k가 여러 개 있으면 가장 처음 나타나는 자리를 return 합니다.

// num		k	result
// 29183	1	3
// 232443	4	4
// 123456	7	-1

public class Solution1 {
	
	public int solution(int num, int k) {
		String number = String.valueOf(num);
		char target = (char) ('0' + k);
		for(int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			if(c == target) {
				return i + 1;
			}
		}
        return -1;
    }
	
	public int solution2(int num, int k) {
		return ("-" + num).indexOf(String.valueOf(k));
	}
	
	public int solution3(int num, int k) {
		String numStr = String.valueOf(num);
		String kStr = String.valueOf(k);
		
		int answer = numStr.indexOf(kStr);
		return answer < 0 ? -1 : answer + 1; 
	}
	
	public static void main(String[] args) {
		int num = 29183;
		int k = 1;
		int result = new Solution1().solution(num, k);
		int result2 = new Solution1().solution2(num, k);
		int result3 = new Solution1().solution3(num, k);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
	}

}
