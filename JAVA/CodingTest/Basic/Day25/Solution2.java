// Day 25 이차원 리스트(배열) > 특별한 이차원 배열 2
package Day25;

// 문제 설명
// n × n 크기의 이차원 배열 arr이 매개변수로 주어질 때,
// arr이 다음을 만족하면 1을 아니라면 0을 return 하는 solution 함수를 작성해 주세요.

// 0 ≤ i, j < n인 정수 i, j에 대하여 arr[i][j] = arr[j][i]
// 제한사항
// 1 ≤ arr의 길이 = arr의 원소의 길이 ≤ 100
// 1 ≤ arr의 원소의 원소 ≤ 1,000
// 모든 arr의 원소의 길이는 같습니다.

// 입출력 예
// arr																					result
// [[5, 192, 33], [192, 72, 95], [33, 95, 999]]											1
// [[19, 498, 258, 587], [63, 93, 7, 754], [258, 7, 1000, 723], [587, 754, 723, 81]]	0

public class Solution2 {

	public int solution(int[][] arr) {
		int answer = 1;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i][j] != arr[j][i]) {
					return answer = 0;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[][] arr = { { 5, 192, 33 }, { 192, 72, 95 }, { 33, 95, 999 } };
		int result = new Solution2().solution(arr);
		System.out.println(result);
	}

}
