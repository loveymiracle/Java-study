// 힙 > 디스크컨트롤러
package ex02;

import java.util.*;

// 풀이 전략 : 시뮬레이션으로 풀어야하고, 우선순위 알고리즘을 유추해야 하는데 여러 방법을 실험하여 알아야하는 문제!
// jobs						return
// [[0, 3], [1, 9], [2, 6]]	9

public class Solution2 {
	
	// Heap을 안쓰고 생각나는 대로 풀이한 방법
	public int solution(int[][] jobs) {
		List<int[]> queue = new ArrayList<>();
		
		for(int arr[] : jobs) {
			queue.add(arr);
		}
		
		// 정렬이 필요한가? -> 문제로는 필요 없다. 근데 그냥 했다.
		// --> 결론 없으면 안되는 TC 존재하였음.
//		Collections.sort(queue, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[0] - o2[0];
//			}
//		});
		Collections.sort(queue,(o1,o2)->{
			return o1[0]-o2[0];
		});
		for(int arr[] : queue) {System.out.print(Arrays.toString(arr) + ", ");} System.out.println();
		
		int now = 0; // 현재 시간
		int answer = 0;
		
		while(!queue.isEmpty()) {
			System.out.println("queue 전, now : " + now);
			for(int arr[] : queue) {System.out.print(Arrays.toString(arr) + ", ");} System.out.println();
			// 스케줄을 찾아오는 로직
			int pickIndex = -1; // flag
			for(int i = 0; i < queue.size(); i++) {
				if(queue.get(i)[0] <= now) { // 현재 시간에 실행 가능한 스케줄
					// 응답시간이 적게 걸리는 스케줄을 탐색하는 과정
					if(pickIndex == -1 || queue.get(i)[1] < queue.get(pickIndex)[1]) {
						pickIndex = i;
					}
				} else {
					break;
				}
			}
			
			// 현재 시간 계산하는 로직
			if(pickIndex >= 0) {
				answer += now - queue.get(pickIndex)[0] + queue.get(pickIndex)[1]; // 실제 실행 및 대기시간을 구하는 방법
				now += queue.get(pickIndex)[1]; // 다음 실행시간
				queue.remove(pickIndex);
			} else { // 실행할게 없는 경우
				now++; // 에이징
			}
			System.out.println("queue 후");
			for(int arr[] : queue) {System.out.print(Arrays.toString(arr) + ", ");} System.out.println();
		}
		return answer / jobs.length;
    }
	
	// 정석적인 Heap으로 풀이한 방법
	public int solution2(int[][] jobs) {
		// 실행 시간순으로 정렬시킨 큐 기준 : job[0]
    	PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2)->{
    		return Integer.compare(o1[0], o2[0]);
    	});
    	for(int arr[] : jobs) {
    		queue.add(arr);
    	}
    	
    	int now = 0; // 현재시간
    	int answer = 0;
    	
    	while(!queue.isEmpty()) {
    		// 실행시간으로 정렬한 큐 : job[1]
        	PriorityQueue<int[]> priorityCheckQueue = new PriorityQueue<>((o1, o2)->{
        		return Integer.compare(o1[1], o2[1]);	
        	});
        	for(int[] job : queue) {
        		if(job[0] <= now) {
        			priorityCheckQueue.add(job);
        		}
        	}
    		
    		if(priorityCheckQueue.isEmpty() == false) {
    			int job[] = priorityCheckQueue.poll();
    			answer += now - job[0] + job[1]; // 현실 모든 실행 시간을 계산하는 방법
    			now += job[1]; // 다음 실행시간
    			queue.remove(job);
    		}else { // 실행할께 없을때 pickIndex == -1
    			now += 1; // 에이징 
    		}
    	}
    	return answer / jobs.length; // 평균 실행시간
    }
	
	public static void main(String[] args) {
		int[][] jobs = {{ 0, 3 }, { 2, 6 }, { 1, 9 }};
		int result = new Solution().solution(jobs);
		int result2 = new Solution().solution2(jobs);
		System.out.println(result);
		System.out.println(result2);
	}
}
