// Day 3 사칙연산, 배열, 수학 > 짝수는 싫어요
package Day03;

import java.util.*;

// 제한사항
// 1 ≤ n ≤ 100

// n	result
// 10	[1, 3, 5, 7, 9]
// 15	[1, 3, 5, 7, 9, 11, 13, 15]

public class Solution4 {
	
	public int[] solution(int n) {
        int[] answer = new int[n / 2 + n % 2];
        int index = 0;
        for(int i = 1; i <= n; i += 2) {
        	answer[index++] = i;
        }
        return answer;
    }
	
	public int[] solution2(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			if(i % 2 != 0) {
				list.add(i);
			}
		}
		int [] answer = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
	public ArrayList<Integer> solution3(int n) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			if(i % 2 != 0) {
				list.add(i);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int n = 49;
		int[] result = new Solution4().solution2(n);
		ArrayList<Integer> list = new Solution4().solution3(n);
		System.out.println(Arrays.toString(result));
		System.out.println(list);
	}

}
