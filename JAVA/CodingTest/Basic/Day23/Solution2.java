// Day 23 배열, 정렬, 문자열 > 등수 매기기
package Day23;

import java.util.*;

// 문제 설명
// 영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다.
// 영어 점수와 수학 점수를 담은 2차원 정수 배열 score가 주어질 때,
// 영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 0 ≤ score[0], score[1] ≤ 100
// 1 ≤ score의 길이 ≤ 10
// score의 원소 길이는 2입니다.
// score는 중복된 원소를 갖지 않습니다.

// 입출력 예
// score																		result
// [[80, 70], [90, 50], [40, 70], [50, 80]]										[1, 2, 4, 3]
// [[80, 70], [70, 80], [30, 50], [90, 100], [100, 90], [100, 100], [10, 30]]	[4, 4, 6, 2, 2, 1, 7]

public class Solution2 {

	public int[] solution(int[][] score) {
		int[] answer = new int[score.length];
		int[] result = new int[score.length];

		for(int i = 0; i < score.length; i++) {
			result[i] = score[i][0] + score[i][1];
		}
		System.out.println(Arrays.toString(result));
	
		for(int i = 0; i < result.length; i++) {
			int idx = 1;
			for(int j = 0; j < result.length; j++) {
				System.out.println("i = " + i + " @@, j = " + j + " ##, idx = " + idx);
				if(result[i] < result[j]) {
					idx++;
					System.out.println("j = " + j + ", idx = " + idx);
				}
			}
			answer[i] = idx;
			System.out.println(Arrays.toString(answer));
		}
		return answer;
	}
	
	public int[] solution2(int[][] score) {
		List<Integer> result = new ArrayList<>();
		
		for(int[] num : score) {
			result.add(num[0] + num[1]);
		}
		result.sort(Comparator.reverseOrder());
		
		int[] answer = new int[score.length];
		for(int i = 0; i < score.length; i++) {
			answer[i] = result.indexOf(score[i][0] + score[i][1]) + 1;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] score = { { 80, 70 }, { 90, 50 }, { 40, 70 }, { 50, 80 } };
		int[] result = new Solution2().solution(score);
		int[] result2 = new Solution2().solution2(score);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(result2));
	}

}
