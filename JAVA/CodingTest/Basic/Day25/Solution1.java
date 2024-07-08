// Day 25 이차원 리스트(배열) > 정수를 나선형으로 배치하기
package Day25;

import java.util.Arrays;

// 문제 설명
// 양의 정수 n이 매개변수로 주어집니다. n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터
// 시계방향 나선형으로 배치한 이차원 배열을 return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ n ≤ 30
// 입출력 예
// n	result
// 4	[[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]
// 5	[[1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9]]

public class Solution1 {
	
	public int[][] solution(int n) {
        int[][] answer = new int [n][n];
        int idx = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        
        while (idx <= n * n) {
        	for(int i = left; i <= right; i++) { // (0,0), (0,1), (0,2), (0,3) // (1,1), (1,2)
        		answer[top][i] = idx++;
        		System.out.println("top = " + top + ", i = " + i + ", idx = " + idx);
        	}
        	top++;
        	
        	for(int i = top; i <= bottom; i++) { // (1,3), (2,3), (3,3) , (2,2)
        		answer[i][right] = idx++;
        		System.out.println("i = " + i + ", right = " + right +  ", idx = " + idx);
        	}
        	right--;
        	
        	for(int i = right; i >= left; i--) { // (3,2), (3,1), (3,0)
        		answer[bottom][i] = idx++;
        		System.out.println("bottom = " + bottom + ", i = " + i + ", idx = " + idx);
        	}
        	bottom--;
        	
        	for(int i = bottom; i >= top; i--) { // (2,0), (1,0)
        		answer[i][left] = idx++;
        		System.out.println("i = " + i + ", left = " + left + ", idx = " + idx);
        	}
        	left++;
        }
        return answer;
    }
	
	public int[][] solution2(int n) {
		int[][] answer = new int[n][n];
		int num = 1;
		int x = 0, y = 0;
		int dx[] = { 0, 1, 0, -1 };
		int dy[] = { 1, 0, -1, 0 };
		int direction = 0;
		
		while(num <= n * n) {
			System.out.println("x : " + x + ", y : " + y + ", num = " + num +
					", direction = " + direction);
			answer[x][y] = num++;
			
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			System.out.println("nx = " + nx + ", ny = " + ny);
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0) {
				System.out.println("Event !!");
				direction = (direction + 1) % 4;
				nx = x + dx[direction];
				ny = y + dy[direction];
			}
			
			x = nx;
			y = ny;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 4;
		int[][] result = new Solution1().solution(n);
		int[][] result2 = new Solution1().solution2(n);
		for(int[] num : result) {
			System.out.println(Arrays.toString(num));
		}
		for(int[] num : result2) {
			System.out.println(Arrays.toString(num));
		}
	}

}
