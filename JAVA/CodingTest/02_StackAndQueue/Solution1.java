// 스택&큐 - 같은 숫자는 싫어

package ex01;

import java.util.*;

// arr				answer
// [1,1,3,3,0,1,1]	[1,3,0,1]
// [4,4,4,3,3]		[4,3]

// 손으로 풀어서 검증 한번하고 들어가는게 유리!
// -> index로 돌고 answer의 마지막 값과 다르면 추가!
// Step1 - [1, 1, 3, 3, 0, 1, 1] index = 0, read=1, answer = [1]
// Step2 - [1, 1, 3, 3, 0, 1, 1] index = 1, read=1, answer = [1] - answer에 이미 1이 있는 상태 -> 1을 버리고 다음
// Step3 - [1, 1, 3, 3, 0, 1, 1] index = 2, read=3, answer [1, 3] - answer 마지막 값이 1이므로 3을 추가!
// Step4 - [1, 1, 3, 3, 0, 1, 1] index = 3, read=3, answer [1, 3] - answer 마지막 값이 같은 값으로 스킵
// Step4 - [1, 1, 3, 3, 0, 1, 1] index = 4, read=0, answer [1, 3, 0] - answer 마지막 값과 다르니까 추가!
// Step4 - [1, 1, 3, 3, 0, 1, 1] index = 5, read=1, answer [1, 3, 0, 1] - answer 마지막 값과 다르니까 추가!
// Step5 - [1, 1, 3, 3, 0, 1, 1] index = 6, read=1, answer [1, 3, 0, 1] - answer 마지막 값과 같으니깐 스킵!

public class Solution {
	
	// 스택으로 풀지 않고 그냥 생각난 대로 푼 풀이!
	public int[] solution2(int []arr) {
        int[] answer = new int[arr.length];
        int count = 0; // 실제 답의 크기를 세는 counter
        int prev = -1; // 이전 값을 기억하는 변수, 초기값은 올 수 없는 -1로 초기화 한다.
        
        for(int i = 0; i < arr.length; i++) {
//        	System.out.println(arr[i]);
        	if(arr[i] != prev) {
        		answer[count++] = arr[i]; // 답 추가!
        		prev = arr[i]; // 이전 값 업데이트
        	} else {
        		continue; // skip!!
        	}
        }

        return Arrays.copyOf(answer, count);
    }
	
	// Stack 풀이 (문제 의도대로 풀어보기)
	// Stack : [1, 1, 3, 3, 0, 1, 1, -1] prev = -1
	// Stack : [1, 3, 3, 0, 1, 1, -1, 1] prev = -1, pop = 1, 비교해서 다르면 뒤로 추가!
	// Stack : [3, 3, 0, 1, 1, -1, 1] prev = 1, pop = 1, 같은 경우 버린다!
	// Stack : [3, 0, 1, 1, -1, 1, 3] prev = 1, pop = 3, 추가!
	// Stack : [0, 1, 1, -1, 1, 3] prev = 3, pop = 0, 추가!
	// Stack : [1, 1, -1, 1, 3, 0] prev = 3, pop = 0, 추가!
	public int[] solution(int []arr) {
//		Deque<Integer> deque = new LinkedList<>();  // LinkedList는 탐색은 O(n), 쓰기 삭제 O(1)
		Deque<Integer> deque = new ArrayDeque<>();  // ArrayDeque로 구성된 큐, 탐색 O(1), 쓰기 삭제, O(n)
		
		for(int i = 0; i < arr.length; i++) {
			deque.add(arr[i]);
		}
		deque.add(-1); // 종료점
		
//		int count = 0; // 임시 count;
		while(true) {
			System.out.println("deque(전) : " + deque);
			int first = deque.pop(); // pop : 앞에 값을 가져오는 함수, get + delete!
			if(first == -1) {
				break;
			}
			
			int second = deque.getFirst(); // getFirst : 앞에 값이 무엇인지를 가져오는 메소드, delete 되지 않음!
			System.out.println("first : " + first);
			System.out.println("second : " + second);
			
			if(first != second) {
				deque.add(first);
			}
			
			System.out.println("deque(후) : " + deque);
//			if(count == 10) { // 임시 break점
//				break;
//			}
		}
		System.out.println(deque);
		int count = 0;
		int[] answer = new int[deque.size()]; 
		while(!deque.isEmpty()) {
			answer[count++] = deque.pop();
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[] arr = { 1, 1, 3, 3, 0, 1, 1 };
		int[] result = new Solution().solution(arr);
		System.out.println(Arrays.toString(result));
	}

}
