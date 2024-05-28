// Day 7 문자열, 조건문, 수학, 반복문 > 각도기
package Day07;

import java.util.*;

// 제한사항
// 0 < angle ≤ 180
// angle은 정수입니다.

// angle	result
// 70	1
// 91	3
// 180	4

public class Solution2 {
	
	public int solution(int angle) {
        int answer = 0;
        if(angle == 180) {
        	answer = 4;
        } else if(90 < angle && angle < 180) {
        	answer = 3;
        } else if(angle == 90) {
        	answer = 2;
        } else {
        	answer = 1;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int angle = 70;
		int result = new Solution2().solution(angle);
		System.out.println(result);
	}

}
