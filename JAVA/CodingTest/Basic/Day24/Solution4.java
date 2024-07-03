// Day 24 수학, 시뮬레이션, 문자열, 조건문, 반복문 > k의 개수
package Day24;

import java.util.*;

// 문제 설명
// 1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다. 정수 i, j, k가 매개변수로 주어질 때, i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ i < j ≤ 100,000
// 0 ≤ k ≤ 9

// 입출력 예
// i	j	k	result
// 1	13	1	6
// 10	50	5	5
// 3	10	2	0

public class Solution4 {
	
	public int solution(int i, int j, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        String zhK = String.valueOf(k);
        
        for(int a = i; a <= j; a++) {
        	sb.append(a);
        }
        System.out.println(sb);

        for(int b = 0; b < sb.length(); b++) {
        	if(sb.substring(b, b + zhK.length()).equals(zhK)) {
        		answer++;
        	}
        }
        return answer;
    }
	
	public int solution2(int i, int j, int k) {
		int answer = 0;
		String zhK = String.valueOf(k);
		char kChar = zhK.charAt(0);
		
		int len = 0;
		for(int n = i; n <= j; n++) {
			len += String.valueOf(n).length();
		}
		
		char[] tmp = new char[len];
		int idx = 0;
		
		for(int a = i; a <= j; a++) {
			char[] numChars = String.valueOf(a).toCharArray();
			for(char c : numChars) {
				tmp[idx++] = c;
			}
		}
		System.out.println(Arrays.toString(tmp));
		
		for(int b = 0; b < idx; b++) {
			if(tmp[b] == kChar) {
				answer++;
			}
		}
		return answer;
	}
	
	public int solution3(int i, int j, int k) {
		String str = "";
		for(int a = i; a <= j; a++) {
			str += a + "";
		}
		
		return str.length() - str.replace(k + "", "").length();
	}
	
	public static void main(String[] args) {
		int i = 1;
		int j = 13;
		int k = 1;
		int result = new Solution4().solution(i, j, k);
		int result2 = new Solution4().solution2(i, j, k);
		int result3 = new Solution4().solution3(i, j, k);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
	}

}
