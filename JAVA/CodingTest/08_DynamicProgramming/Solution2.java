// 동적프로그래밍 > 정수 삼각형
package ex02;

import java.util.*;

// triangle													result
// [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30

public class Solution2 {
	public int solution(int[][] triangle) {
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				int lParents = j - 1 < 0 ? 0 : j - 1; // 왼쪽부모에서 인덱스가 음수가 되는걸 차단
				int rParents = j + 1 >= triangle[i-1].length ? triangle[i-1].length-1 : j; // 오른쪽 부모다 index를 벗어난 경우도 차단
				triangle[i][j] += Integer.max(triangle[i-1][lParents], triangle[i-1][rParents]); // 부모중에 큰값을 상속받는 과정
				max = Integer.max(triangle[i][j], max); // 여태것 더한값중에 가장 큰값 탐색
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		int result = new Solution().solution(triangle);
		System.out.println(result);
	}
	
}
