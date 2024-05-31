// Day 10 조건문, 배열, 수학, 시뮬레이션 > 점의 위치 구하기
package Day10;

import java.util.*;

// 제한사항
// dot의 길이 = 2
// dot[0]은 x좌표를, dot[1]은 y좌표를 나타냅니다
// -500 ≤ dot의 원소 ≤ 500
// dot의 원소는 0이 아닙니다.

// dot		result
// [2, 4]	1
// [-7, 9]	2

public class Solution1 {
	
	public int solution(int[] dot) {
		int answer = 0;
		if(dot[0] > 0) {
			if(dot[1] > 0) {
				answer = 1;
			} else {
				answer = 4;
			}
		} else {
			if(dot[1] > 0) {
				answer = 2;
			} else {
				answer = 3;
			}
		}
        return answer;
    }
	
	public static void main(String[] args) {
		int[] dot = { 2, 4 };
		int result = new Solution1().solution(dot);
		System.out.println(result);
	}

}
