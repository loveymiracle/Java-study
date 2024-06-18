// Day 20 수학, 시뮬레이션, 문자열, 사칙연산 > 직사각형 넓이 구하기
package Day20;

// 문제 설명
// 2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다.
// 직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
// 가 담겨있는 배열 dots가 매개변수로 주어질 때, 직사각형의 넓이를 return 하도록 solution 함수를 완성해보세요.

// 제한사항
// dots의 길이 = 4
// dots의 원소의 길이 = 2
// -256 < dots[i]의 원소 < 256
// 잘못된 입력은 주어지지 않습니다.

// 입출력 예
// dots									result
// [[1, 1], [2, 1], [2, 2], [1, 2]]		1
// [[-1, -1], [1, 1], [1, -1], [-1, 1]]	4

public class Solution1 {

	public int solution(int[][] dots) {
		int minH = Integer.MAX_VALUE;
		int maxH = Integer.MIN_VALUE;
		int minW = Integer.MAX_VALUE;
		int maxW = Integer.MIN_VALUE;
		
		for(int[] dot : dots) {
			if(dot[0] < minW) {
				minW = dot[0];
			}
			if(dot[0] > maxW) {
				maxW = dot[0];
			}
			if(dot[1] < minH) {
				minH = dot[1];
			}
			if(dot[1] > maxH) {
				maxH = dot[1];
			}
			
		}
		int w = maxW - minW;
		int h = maxH - minH;
		int answer = w * h;
		return answer;
	}
	
	public int solution2(int[][] dots) {
		int topX = dots[0][0];
		int botX = dots[0][0];
		int topY = dots[0][1];
		int botY = dots[0][1];
		
		for(int[] n : dots) {
			if(n[0] >= topX) {
				topX = n[0];
			} else {
				botX = n[0];
			}
			if(n[1] >= topY) {
				topY = n[1];
			} else {
				botY = n[1];
			}
		}
		return (topX - botX) * (topY - botY);
	}
	
	

	public static void main(String[] args) {
		int[][] dots = { { 0, 1 }, { 0, 3 }, { 10, 3 }, { 10, 1 } };
		int result = new Solution1().solution(dots);
		int result2 = new Solution1().solution2(dots);
		System.out.println(result);
		System.out.println(result2);
	}
}
