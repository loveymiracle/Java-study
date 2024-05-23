// Day 5 수학, 배열 > 옷가게 할인 받기
package Day05;

import java.util.*;

// 제한사항
// 10 ≤ price ≤ 1,000,000
// price는 10원 단위로(1의 자리가 0) 주어집니다.
// 소수점 이하를 버린 정수를 return합니다.

// price	result
// 150,000	142,500
// 580,000	464,000

public class Solution1 {
	
	public int solution(int price) {
        double tmp = 0;
        if(price >= 500000) {
        	tmp = price * 0.8;
		} else if (300000 <= price && price < 500000) {
			tmp = price * 0.9;
		} else if (100000 <= price && price < 300000) {
        	tmp = price * 0.95;
        } else {
        	tmp = price;
        }
        return (int) tmp;
    }
	
	public static void main(String[] args) {
		int price = 150000;
		int result = new Solution1().solution(price);
		System.out.println(result);
	}

}
