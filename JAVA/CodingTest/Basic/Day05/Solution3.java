// Day 5 수학, 배열 > 나이 출력
package Day05;

import java.util.*;

// 제한사항
// 0 < age ≤ 120
// 나이는 태어난 연도에 1살이며 매년 1월 1일마다 1살씩 증가합니다.

// age	result
// 40	1983
// 23	2000

public class Solution3 {
	
	public int solution(int age) {
		int year = 2022;
        int answer = year - age + 1;
        return answer;
    }
	
	public static void main(String[] args) {
		int age = 23;
		int result = new Solution3().solution(age);
		System.out.println(result);
	}

}
