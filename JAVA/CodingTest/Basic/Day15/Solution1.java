// Day 15 문자열, 해시, 배열, 수학 > 영어가 싫어요
package Day15;

import java.util.*;

// 제한사항
// numbers는 소문자로만 구성되어 있습니다.
// numbers는 "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" 들이 공백 없이 조합되어 있습니다.
// 1 ≤ numbers의 길이 ≤ 50
// "zero"는 numbers의 맨 앞에 올 수 없습니다.

// numbers									result
// "onetwothreefourfivesixseveneightnine"	123456789
// "onefourzerosixseven"					14067

public class Solution1 {

	public long solution(String numbers) {
		Map<String, String> nums = new HashMap<>();
		nums.put("one", "1");
		nums.put("two", "2");
		nums.put("three", "3");
		nums.put("four", "4");
		nums.put("five", "5");
		nums.put("six", "6");
		nums.put("seven", "7");
		nums.put("eight", "8");
		nums.put("nine", "9");
		nums.put("zero", "0");
		
//		for(Map.Entry<String, String> entry : nums.entrySet()) {
//			numbers = numbers.replace(entry.getKey(), entry.getValue());
//		}
		
		for(String x : nums.keySet()) {
			numbers = numbers.replace(x, nums.get(x));
		}
		
		return Long.parseLong(numbers);
	}
	
	public long solution2(String numbers2) {
		return Long.parseLong(numbers2.replace("zero", "0").replace("one", "1")
				.replace("two", "2").replace("three", "3").replace("four", "4")
				.replace("five", "5").replace("six", "6").replace("seven", "7")
				.replace("eight", "8").replace("nine", "9"));
	}

	public static void main(String[] args) {
		String numbers = "onetwothreefourfivesixseveneightnine";
		String numbers2 = "onefourzerosixseven";
		long result = new Solution1().solution(numbers);
		long result2 = new Solution1().solution2(numbers2);
		System.out.println(result);
		System.out.println(result2);
	}

}
