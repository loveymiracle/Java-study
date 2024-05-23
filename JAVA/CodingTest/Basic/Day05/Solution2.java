// Day 5 수학, 배열 > 아이스 아메리카노
package Day05;

import java.util.*;

// 제한사항
// 0 < money ≤ 1,000,000

// money	result
// 5,500	[1, 0]
// 15,000	[2, 4000]

public class Solution2 {
	
	public int[] solution(int money) {
        int[] answer = new int[2];
        int price = 5500;
        int coffee = money / price;
        int charge = money % price;
        answer[0] = coffee;
        answer[1] = charge;
        return answer;
    }
	
	public static void main(String[] args) {
		int money = 15000;
		int[] result = new Solution2().solution(money);
		System.out.println(Arrays.toString(result));
	}

}
