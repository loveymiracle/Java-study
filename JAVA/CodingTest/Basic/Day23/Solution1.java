// Day 23 배열, 정렬, 문자열 > 특이한 정렬
package Day23;

import java.util.*;

// 문제 설명
// 정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다. 이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다. 정수가 담긴 배열 numlist와 정수 n이 주어질 때 numlist의 원소를 n으로부터 가까운 순서대로 정렬한 배열을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ n ≤ 10,000
// 1 ≤ numlist의 원소 ≤ 10,000
// 1 ≤ numlist의 길이 ≤ 100
// numlist는 중복된 원소를 갖지 않습니다.

// 입출력 예
// numlist							n	result
// [1, 2, 3, 4, 5, 6]				4	[4, 5, 3, 6, 2, 1]
// [10000,20,36,47,40,6,10,7000]	30	[36, 40, 20, 47, 10, 6, 7000, 10000]

public class Solution1 {

	public int[] solution(int[] numlist, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < numlist.length; i++) {
			map.put(numlist[i], Math.abs(n - numlist[i]));
		}
		
		List<Map.Entry<Integer, Integer>> nList = new ArrayList<>(map.entrySet());
		nList.sort((entry1, entry2) -> {
            int valueComparison = entry1.getValue().compareTo(entry2.getValue());
            if (valueComparison != 0) {
                return valueComparison;
            } else {
                return entry2.getKey().compareTo(entry1.getKey());
            }
        });
		
		int[] answer = new int[nList.size()];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = nList.get(i).getKey();
		}
		return answer;
	}
	
	public int[] solution2(int[] numlist, int n) {
		int len = numlist.length;
		
		for(int i = 0; i < len - 1; i++) {
			for(int j = i + 1; j < len; j++) {
				int a = (numlist[i] - n) * (numlist[i] > n ? 1 : -1);
				int b = (numlist[j] - n) * (numlist[j] > n ? 1 : -1);
				if(a > b || (a == b && numlist[i] < numlist[j])) {
					int tmp = numlist[i];
					numlist[i] = numlist[j];
					numlist[j] = tmp;
				}
			}
		}
		return numlist;
	}

	public static void main(String[] args) {
		int[] numlist = { 1, 2, 3, 4, 5, 6 };
		int n = 4;
		int[] result = new Solution1().solution(numlist, n);
		int[] result2 = new Solution1().solution2(numlist, n);
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(result2));
	}

}
