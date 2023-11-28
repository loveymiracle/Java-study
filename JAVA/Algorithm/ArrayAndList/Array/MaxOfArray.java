package ex01.array;

import java.util.Scanner;

public class MaxOfArray {

	private static int maxOf(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	// 배열 = {선형} 탐색
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("키의 최댓값을 구합니다.");
		System.out.print("사람 수: ");
		int num = stdIn.nextInt(); // 배열의 요솟수를 입력받음

		int[] height = new int[num]; // 요솟수가 num인 배열을 생성

		for (int i = 0; i < num; i++) {
			System.out.print("height[" + i + "] : ");
			height[i] = stdIn.nextInt();
		}

		System.out.println("최댓값은 " + maxOf(height) + "입니다.");
	}

}
