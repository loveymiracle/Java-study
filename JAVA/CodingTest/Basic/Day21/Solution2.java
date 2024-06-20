// Day 21 문자열, 사칙연산, 시뮬레이션, 2차원배열, 수학, 배열 > 안전지대
package Day21;

import java.util.*;
import java.awt.Point;

// 문제 설명
// 다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
// 지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
// 지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때,
// 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// board는 n * n 배열입니다.
// 1 ≤ n ≤ 100
// 지뢰는 1로 표시되어 있습니다.
// board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.
// 입출력 예
// board																													result
// [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]									16
// [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]]									13
// [[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]]	0

public class Solution2 {

	public int solution(int[][] board) {
		int answer = 0;
		int n = board.length;
		Map<String, Point> map = new HashMap<>(); 
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] == 1) {
					map.put(i + ", " + j, new Point(i, j));
				}
			}
		}
		
		System.out.println(map.values());
		int[][] directions = {
	            {-1, -1}, {-1, 0}, {-1, 1},
	            { 0, -1},          { 0, 1},
	            { 1, -1}, { 1, 0}, { 1, 1}
	        };
		
		for(Point mine : map.values()) {
			int x = mine.x;
			int y = mine.y;
			for(int[] direction : directions) {
				int nx = x + direction[0];
				int ny = y + direction[1];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if(board[nx][ny] == 0) {
						board[nx][ny] = -1;
					}
				}
			}
		}
		
		for(int[] num : board) {
			System.out.println(Arrays.toString(num));
		}
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] == 0) {
					answer++;
				}
			}
		}
		
		return answer;
	}
	
	public int solution2(int[][] board) {
        int answer = 0;
        int length = board.length;
        int[][] tmp = new int[length + 2][length + 2];

        // 원래 보드를 tmp 배열의 내부에 복사
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < length + 1; j++) {
                tmp[i][j] = board[i - 1][j - 1];
            }
        }

        // 지뢰 주변을 표시
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < length + 1; j++) {
                if (tmp[i][j] == 1) {
                    for (int l = i - 1; l <= i + 1; l++) {
                        for (int m = j - 1; m <= j + 1; m++) {
                            if (tmp[l][m] != 1) {
                                tmp[l][m] = 2;
                            }
                        }
                    }
                }
            }
        }

        // 안전지대의 개수를 셈
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < length + 1; j++) {
                if (tmp[i][j] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 },
						  { 0, 0, 0, 0, 0 },
						  { 0, 0, 0, 0, 0 },
						  { 0, 0, 1, 0, 0 },
						  { 0, 0, 0, 0, 0 } };
		int result = new Solution2().solution(board);
		int result2 = new Solution2().solution2(board);
		System.out.println(result);
		System.out.println(result2);
	}

}
