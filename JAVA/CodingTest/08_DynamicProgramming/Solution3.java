// 동적프로그래밍 > 등굣길
package ex03;

import java.util.*;

public class Solution3 {
	public int solution(int m, int n, int[][] puddles) {
		int map[][] = new int[n][m];

		// 물웅덩이를 표시하는 코드
		for (int i = 0; i < puddles.length; i++) {
			map[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
		}

		map[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == -1) {
					continue;
				}
				if (i + 1 < n && map[i + 1][j] >= 0) { // go right!
					map[i + 1][j] += map[i][j] % 1000000007;
				}
				if (j + 1 < m && map[i][j + 1] >= 0) { // go bottom!
					map[i][j + 1] += map[i][j] % 1000000007;
				}
			}
		}
		
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j] +" ");
//			}
//			System.out.println();
//		}
		return map[n - 1][m - 1] % 1000000007;
	}
	public static void main(String[] args) {
//		m	n	puddles	return
//		4	3	[[2, 2]]	4
		int m = 3; 
		int n = 3;
		int[][] puddles = {};
		int result = new Solution().solution(m, n, puddles);
		System.out.println(result);
	}
}
