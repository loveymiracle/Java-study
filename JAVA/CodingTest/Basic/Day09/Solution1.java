// Day 9 수학, 문자열, 해시, 완전탐색, 조건문 > 개미 군단
package Day09;

import java.util.*;

// 제한사항
// hp는 자연수입니다.
// 0 ≤ hp ≤ 1000

// hp	result
// 23	5
// 24	6
// 999	201

public class Solution1 {
	
	public int solution(int hp) {
		int gant = 5;
		int sant = 3;
		int ant = 1;
        
        int rhp = hp;
        int answer = 0;
        int num = 0;
        
        if(hp > 0) {
        	num = hp / gant;
        	rhp = hp % gant;
        	answer += num;
        }
        
        if(rhp > 0) {
        	num = rhp / sant;
        	rhp = rhp % sant;
        	answer += num;
        }
        
        if(rhp > 0) {
        	num = rhp / ant;
        	rhp = rhp % ant;
        	answer += num;
        }
        
        return answer;
    }
	
	public int solution1(int hp) {
		int answer = 0;
		int[] ants = { 5, 3, 1 };
		
		for(int i = 0; i < ants.length; i++) {
			if(hp / ants[i] > 0) {
				answer += hp / ants[i];
				hp = hp % ants[i];
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int hp = 23;
		int result = new Solution1().solution(hp);
		int result1 = new Solution1().solution1(hp);
		System.out.println(result);
		System.out.println(result1);
	}

}
