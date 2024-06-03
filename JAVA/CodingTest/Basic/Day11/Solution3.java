// Day 11 수학, 반복문 > 최댓값 만들기 (1)
package Day11;

import java.util.*;

// 제한사항
// 0 ≤ numbers의 원소 ≤ 10,000
// 2 ≤ numbers의 길이 ≤ 100

// numbers					result
// [1, 2, 3, 4, 5]			20
// [0, 31, 24, 10, 1, 9]	744

public class Solution3 {

	public int solution(int[] numbers) {
		List<Integer> list = new ArrayList<>();
		for (int num : numbers) {
			list.add(num);
		}
		Collections.sort(list);
		int answer = list.get(list.size() - 1) * list.get(list.size() - 2);
		return answer;
	}
	
	public int solution2(int[] numbers) {
		Arrays.sort(numbers);
		int answer = numbers[numbers.length-1] * numbers[numbers.length-2];
		return answer;
	}
	
	public int solution3(int[] numbers) {
		int answer = 0;
		int max1 = 0;
		int max2 = 0;
		int num = 0;
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] > max1) {
				max1 = numbers[i];
				num = i;
			}
		}
		
		for(int i = 0; i < numbers.length; i++) {
			if(i == num) {
				continue;
			} else if(numbers[i] > max2 && numbers[i] <= max1) {
				max2 = numbers[i];
			}
		}
		answer = max1 * max2;
		return answer;
	}
	
	public int solution4(int[] numbers) { // 선택정렬
		System.out.println("초기 : " + Arrays.toString(numbers));
		for(int i = 0; i < numbers.length; i++) {
			for(int j = i; j < numbers.length; j++) {
				System.out.println("i는 " + i + ", " + numbers[i] + " j는 " + j + ", " + numbers[j] + ", result = " + Arrays.toString(numbers));
				if(numbers[j] < numbers[i]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(numbers));
		int answer = numbers[numbers.length - 2] * numbers[numbers.length - 1];
		return answer;
	}

	public static void main(String[] args) {
		int[] numbers = { 0, 31, 24, 10, 1, 9 };
		int result = new Solution3().solution(numbers);
		int result2 = new Solution3().solution2(numbers);
		int result3 = new Solution3().solution3(numbers);
		int result4 = new Solution3().solution4(numbers);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
	}

}
