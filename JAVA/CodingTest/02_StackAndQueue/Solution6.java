// 스택앤큐 > 주식가격
package ex06;

import java.util.*;

// prices			return
// [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]

public class Solution {
	
	public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> deque = new ArrayDeque<>(); //  
//        Deque<Integer> deque = new LinkedList<>();  //
        
        // 초기화 부
        for(int price : prices) {
        	deque.add(price);
        }

        int index = 0; // answer의 다음 위치를 기억할 커서
        while(!deque.isEmpty()) {
        	int price = deque.pop();
        	int count = 0;
        	for(int cPrice : deque) {
        		count++;
        		if(price > cPrice) {
        			break;
        		}
        	}
        	answer[index++] = count;
        }
        
        
        return answer;
    }
	
	 public static void main(String[] args) {
	    int[] prices = { 1, 2, 3, 2, 3};
	    int[] result = new Solution().solution(prices);
	    System.out.println(Arrays.toString(result));
	}

}
