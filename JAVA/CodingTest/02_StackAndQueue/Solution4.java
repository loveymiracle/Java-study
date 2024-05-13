// 스택앤큐 > 프로세스
package ex04;

import java.util.*;

// priorities			location	return
// [2, 1, 3, 2]			2			1
// [1, 1, 9, 1, 1, 1]	0			5

// 전략 : 전형적인 Round 문제로 시뮬레이션 해보고 그대로 돌리면 끝난다!
// 간단한 풀이 시작
// priorities			location	return
// [2, 1, 3, 2]			2			1
// 정답 : [C, D, A, B]
// 재정리(문서이름, 우선순위) A-2 , B-1, C-3, D-2
// location의 의미는 index, 2=C
// -> C가 가장 처음으로 리턴 됨

//1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
//2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
//3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
//  3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.

// 실제 문제 풀이 시작, 예제와 같이 알파벳은 사용하지 않고, index로 다시 정리!
// 		[0-2, 1-1, 2-3, 3-2] // 문서index, 우선순위
// #1 pop 0-2, [1-1, 2-3, 3-2]
// push 0-2, [1-1, 2-3, 3-2, 0-2]
// #2 pop 1-1 [2-3, 3-2, 0-2]
// push 1-1, [2-3, 3-2, 0-2, 1-1]
// # pop 2-3 [3-2, 0-2, 1-1], index-2는 실행가능 ? 가능! 우선순위가 3임으로 가장크다.
//   -> push 없음! exit 배열로 추가 [2-3]
// #4 pop 3-2, [0-2, 1-1], index-3은 실행가능? 가능! 우선순위가 2인데, 같은 우선순위가 있지만 실행!
//   -> push 없음! exit 배열로 추가 [2-3, 3-2]
// #5 pop 0-2, [1-1]
//   -> push 없음! exit 배열로 추가 [2-3, 3-2, 0-2]
// #6 pop 1-1 []
//   -> push 없음! exit 배열로 추가 [2-3, 3-2, 0-2, 1-1]


public class Solution {
	
	public int solution(int[] priorities, int location) {
		Map<Integer, Integer> indexToPriorityMap = new HashMap<>();
		LinkedList<Integer> waitQueue = new LinkedList<>(); // 대기 큐
		LinkedList<Integer> exitQueue = new LinkedList<>(); // 종료 큐
		
		// 초기화 부
		for(int i = 0; i < priorities.length; i++) {
			waitQueue.add(i);
			indexToPriorityMap.put(i, priorities[i]);
		}
		System.out.println("waitQueue : " + waitQueue);
		System.out.println("Map" + indexToPriorityMap);
		System.out.println();
		
//		for(int k = 0; k < 10; k++) {
        while(true) {
//			int index = waitQueue.pop();
			int index = waitQueue.remove(0); // remove 제거가 되고 값을 가져올 수 있다.
			int priority = indexToPriorityMap.remove(index);
			int maxPriority = Collections.max(indexToPriorityMap.values());
			
			if(priority < maxPriority) { // 우선순위가 작을 때, queue에 다시 넣는다.
				waitQueue.add(index);
				indexToPriorityMap.put(index, priority);
			} else { // 우선순위가 남아있는 프로세스 중 가장 클 때!!
				exitQueue.add(index);
				// 종료 조건!
				if(waitQueue.size() == 1) {
					exitQueue.add(waitQueue.remove(0));
					break;
				}
			}
//			System.out.println("index : " + index + ", priority : " + priority); // for문 검증 
//			System.out.println("waitQueue : " + waitQueue); //
//			System.out.println("maxPriority : " + maxPriority); //
//			System.out.println("indxToPriorityMap : " + indexToPriorityMap); //
//			System.out.println("exitQueue : " + exitQueue); //
//			System.out.println("");
			
		}
        System.out.println("exitQueue : " + exitQueue);
        return exitQueue.indexOf(location) + 1;
        
    }
	
	 public static void main(String[] args) {
	    int[] priorities = {2, 1, 3, 2};
	    int location = 2;
	    int result = new Solution().solution(priorities, location);
	    System.out.println(result);
	}
}
