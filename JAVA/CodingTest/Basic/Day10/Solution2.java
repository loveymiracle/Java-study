// Day 10 조건문, 배열, 수학, 시뮬레이션 > 2차원으로 만들기
package Day10;

import java.util.*;

// 제한사항
// num_list의 길이는 n의 배 수개입니다.
// 0 ≤ num_list의 길이 ≤ 150
// 2 ≤ n < num_list의 길이

// num_list								n	result
// [1, 2, 3, 4, 5, 6, 7, 8]				2	[[1, 2], [3, 4], [5, 6], [7, 8]]
// [100, 95, 2, 4, 5, 6, 18, 33, 948]	3	[[100, 95, 2], [4, 5, 6], [18, 33, 948]]

public class Solution2 {
	
	public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        
        for(int i = 0; i < num_list.length; i++) {
        	int row = i / n;
        	int col = i % n;
        	answer[row][col] = num_list[i];
        }
        return answer;
    }
	
	public int[][] solution2(int[] num_list, int n) {
		int[][] answer = new int[num_list.length/n][n];
		int tmp = 0;
		
		for(int i = 0; i < num_list.length/n; i++) {
			for(int j = 0; j < n; j++) {
				answer[i][j] = num_list[tmp];
				tmp++;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[] num_list = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int n = 2;
		int[][] result = new Solution2().solution(num_list, n);
		for(int[] row : result) {
			System.out.println(Arrays.toString(row));
		}
		int[][] result2 = new Solution2().solution2(num_list, n);
		for(int[] row : result2) {
			System.out.println(Arrays.toString(row));
		}
	}

}
