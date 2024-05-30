// Day 9 수학, 문자열, 해시, 완전탐색, 조건문 > 구슬을 나누는 경우의 수
package Day09;

import java.util.*;

// 제한사항
// 1 ≤ balls ≤ 30
// 1 ≤ share ≤ 30
// 구슬을 고르는 순서는 고려하지 않습니다.
// share ≤ balls

// balls	share	result
// 3		2		3
// 5		3		10

public class Solution4 {
	
	public int solution(int balls, int share) {
		long answer = 1;
		int num = 1;
		
		for(int i = share+1; i <= balls; i++) {
			answer *= i;
			System.out.println("i : " + i + ", answer = " + answer);
			answer /= num;
			System.out.println("num : " + num + ", answer = " + answer);
			num++;
		}
        return (int)answer;
    }
	
	public int solution1(int balls, int share) {
		if(balls <= share) {
			return 1;
		} else {
			return (int) Math.round(fact(balls) / (fact(balls-share)*fact(share)));
		}
	}
	
	public double fact(int num) {
		if(num == 1) {
			return 1;
		} else {
			return num * fact(num-1);
		}
	}
	
	public static void main(String[] args) {
		int balls = 5;
		int share = 3;
		int result = new Solution4().solution(balls, share);
		System.out.println(result);
	}

}
