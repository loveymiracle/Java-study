// Day 25 이차원 리스트(배열) > 정사각형으로 만들기
package Day25;

import java.util.Arrays;

// 문제 설명
// 이차원 정수 배열 arr이 매개변수로 주어집니다.
// arr의 행의 수가 더 많다면 열의 수가 행의 수와 같아지도록 각 행의 끝에 0을 추가하고,
// 열의 수가 더 많다면 행의 수가 열의 수와 같아지도록 각 열의 끝에 0을 추가한 이차원 배열을
// return 하는 solution 함수를 작성해 주세요.

// 제한사항
// 1 ≤ arr의 길이 ≤ 100
// 1 ≤ arr의 원소의 길이 ≤ 100
// arr의 모든 원소의 길이는 같습니다.
// 1 ≤ arr의 원소의 원소 ≤ 1,000
// 입출력 예
// arr																result
// [[572, 22, 37], [287, 726, 384], [85, 137, 292], [487, 13, 876]]	[[572, 22, 37, 0], [287, 726, 384, 0], [85, 137, 292, 0], [487, 13, 876, 0]]
// [[57, 192, 534, 2], [9, 345, 192, 999]]							[[57, 192, 534, 2], [9, 345, 192, 999], [0, 0, 0, 0], [0, 0, 0, 0]]
// [[1, 2], [3, 4]]													[[1, 2], [3, 4]]

public class Solution3 {

	public int[][] solution(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		
		if(row > col) {
			int[][] answer = new int[row][row];
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					answer[i][j] = arr[i][j];
				}
				answer[i][col] = 0;
			}
			return answer;
		} else if(col > row) {
			int[][] answer = new int[col][col];
			for(int i = 0; i < col; i++) {
				for(int j = 0; j < row; j++) {
					answer[j][i] = arr[j][i];
				}
				answer[row][i] = 0;
			}
			return answer;
		} else {
			return arr;
		}
	}
	
	public int[][] solution2(int[][] arr) {
		int a = arr.length;
		int b = arr[0].length;
		int[][] answer = a > b ? new int[a][a] : new int[b][b];
		// int max = Math.max(arr.length, arr[0].length);
		// int[][] answer = new int[max][max];
		
		for(int i = 0; i < a; i++) {
			for(int j = 0; j < b; j++) {
				answer[i][j] = arr[i][j];
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] arr = { { 57, 192, 534, 2 }, { 9, 345, 192, 999 } };
		int[][] result = new Solution3().solution(arr);
		int[][] result2 = new Solution3().solution2(arr);
		for (int[] num : result) {
			System.out.println(Arrays.toString(num));
		}
		for (int[] num : result2) {
			System.out.println(Arrays.toString(num));
		}
	}

}
