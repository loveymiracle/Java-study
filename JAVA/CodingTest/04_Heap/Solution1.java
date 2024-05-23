// 힙 > 더 맵게
package ex01;

import java.util.*;
// 전략 : 전형적인 라운딩 문제! 돌려야하는 문제로 시뮬레이션 돌리듯이 풀이!

// 		scoville					K		return
// 		[1, 2, 3, 9, 10, 12]		7		2
//		s = n + (m * 2) // n이 낮은 수!
// #1	[1, 2, 3, 9, 10, 12]
//      [3, 9, 10, 12] pop[1, 2] -> 2개를 뽑아 스코빌지수 계산, 1 + (2 * 2) = 5
//      [3, 9, 10, 12, 5] push 5
//      [3, 9, 10, 12, 5] 정렬 수행!
//      [3, 5, 9, 10, 12] -> 검사 k=7 보다 작은 3, 5 있어서 실패! -> 다음 라운딩 실행
// #2   [9, 10, 12] pop[3, 5] -> 2개를 뽑아 스코빌지수 계산, 3 + (5 * 2) = 13
//      [9, 10, 12] push 13
//      [9, 10, 12, 13] 정렬 수행! -> 검사 k=7 보다 작은 값이 없음! -> 값 찾음 2를 리턴!
//      [9, 10, 12, 13]



public class Solution1 {
	
	public int solution(int[] scoville, int K) {
//        LinkedList<Integer> queue = new LinkedList<>(); // 링크드리스트로 풀 경우 시간 복잡도 : O(n^3)
		PriorityQueue<Integer> queue = new PriorityQueue(); // 시간복잡도 : O(n*nlogN) : 2.3차원 정도
        for(int num : scoville) {
        	queue.add(num);
        }
        
        int round = 0; // 리턴 할 라운드 값
        while(true) { // O(n)
        	// 체킹 부가 앞에 설계되어야 하는 알고리즘!
        	// -> 스코빌 지수가 모두 K 이상인 케이스가 존재하여 앞에서 체크!
        	System.out.println("queue전 : " + queue);
        	boolean isFinish = true;
        	for(int v : queue) { // O(n^2)
        		if(v < K) {
        			isFinish = false;
        			break;
        		}
        	}
        	
        	if(isFinish == true) {
        		return round;
        	}
        	
        	if(queue.size() < 2) { // 모든 스코빌지수가 K보다 작은 케이스
        		return -1;
        	}
        	
        	// 스코빌 지수 만드는 영역
        	int x = queue.poll(); // poll : 가장 앞에 값 가져오고 삭제하는 메소드
        	int y = queue.poll();
        	int s = x + (y * 2);
        	queue.add(s);
//        	Collections.sort(queue); // O(n^3).. LinkedList 는 정렬 필요..
        	System.out.println("queue후 : " + queue);
        	round++;
        	
        }
    }
	
	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		int result = new Solution().solution(scoville, K);
		System.out.println(result);
	}

}
