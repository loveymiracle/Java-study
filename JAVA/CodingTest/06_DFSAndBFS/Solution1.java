// DFS&BFS > 타겟 넘버
package ex01;

import java.util.*;

// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3

// numbers			target	return
// [1, 1, 1, 1, 1]	3		5
// [4, 1, 2, 1]	4	2

public class Solution {
	
//	boolean[] visited; // 필요 없는 문제, 순서가 정해지므로 depth는 길이로 고정된다.
	int answer = 0; // target 값과 일치하는 갯수! counter 변수
	
	//int level : 현재 트리의 길이, 초기는 0
	// int calcValue : 현재 계산값, 초기는 0
	// int[] numbers, int target : 상수로 사용할 변수들 (조작X)
	public void dfs(int level, int calcValue, int[] numbers, int target) {
		// break point 설계
		if(level == numbers.length) {
			System.out.println("\t".repeat(level) + "level : " + level + ", calcValue : " + calcValue);
			// 최종 레벨의 답!
			if(calcValue == target) {
				answer++;
			}
			return;
		}
		System.out.println("\t".repeat(level) + "level : " + level + ", num : " + numbers[level] + ", calcValue : " + calcValue);
		
		dfs(level + 1, calcValue + numbers[level], numbers, target); // +1
		dfs(level + 1, calcValue - numbers[level], numbers, target); // -1
	}
	
	public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
	
	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		int result = new Solution().solution(numbers, target);
		System.out.println(result);
	}

}
