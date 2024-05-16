// 스택앤큐 > 다리를 지나는 트럭

package ex05;

import java.util.*;

// bridge_length	weight	truck_weights					return
// 2				10		[7,4,5,6]						8
// 100				100		[10]							101
// 100				100		[10,10,10,10,10,10,10,10,10,10]	110

public class Solution {
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		// waitQueue - 트럭이 대기하는 큐
		LinkedList<Integer> waitQueue = new LinkedList<>();
		// 트럭의 인덱스와 현재 건넌 다리 길이를 가져오는 Map - 에이징 나이를 먹일 자료구조!
		// -> 다리에 올라간 트럭을 추적하는 자료구조
		Map<Integer, Integer> truckIndexToMoveBridgeLengthMap = new HashMap<>();
		
		// 초기화 코드
		for(int i = 0; i < truck_weights.length; i++) {
			waitQueue.add(i); // index로 truck_weights를 추정할 수 있도록 index로 정리함 , push 뒤로 집어넣는 것 , add 앞으로 집어 넣는 것
		}
//		System.out.println(waitQueue);
		
		int round = 1; // 시간
		int nowWeight = 0; // 현재 다리에 올라간 트럭들의 무게
		int finishCount = 0; // 트럭이 건너간 갯수
		
//		for(int k = 0; k < 10; k++) {
		while(true) {
			// 트럭이 현재 다리에 올라갈 수 있는가 ?
			// -> 첫번째 다리에 트럭이 올라갈 수 있는 길이가 있는가 ?
			if(finishCount < truck_weights.length && truckIndexToMoveBridgeLengthMap.size() < bridge_length) {
				// -> 두번째 다리에 무게제한에 걸리지 않는가 ?
				int nextWeight = nowWeight + truck_weights[waitQueue.get(0)]; // 다음 다리의 무게
				if(nextWeight <= weight) { // 다리의 무게제한 안쪽일 때
					// 트럭이 다리에 올라가는 구문
					int index = waitQueue.remove(0);
					finishCount++;
					nowWeight = nextWeight;
					truckIndexToMoveBridgeLengthMap.put(index, 0);
				}
				
			}
			// 트럭이 다리를 건넌 길이를 계산하고(에이징), 트럭이 실제 다리 끝에 도달했는지 확인하는 구문
			Set<Integer> keySet = truckIndexToMoveBridgeLengthMap.keySet();
			List<Integer> finishQueue = new LinkedList<>();
			for(Integer key : keySet) {
				int move = truckIndexToMoveBridgeLengthMap.get(key) + 1; // 다리 건너는 계산
				if(move == bridge_length) {
					finishQueue.add(key);
				} else {
					truckIndexToMoveBridgeLengthMap.put(key, move); // 다리 건넌것 업데이트
				}
			}
			
			// 다리를 건넌 트럭이 있는 경우
			for(int index : finishQueue) {
				truckIndexToMoveBridgeLengthMap.remove(index); // 다리에서 제거
				nowWeight -= truck_weights[index]; // 다리에 올라간 트럭의 무게를 재계산
			}
			round++;
			
			// 기다리는 트럭이 없고, 다리위에 있는 모든 트럭이 건넜을 때
			if(waitQueue.size() == 0 && truckIndexToMoveBridgeLengthMap.isEmpty() == true) {
				break;
			}
			
			System.out.println("round : " + (round - 1));
			System.out.println("nowWeight : " + nowWeight);
			System.out.println("map : " + truckIndexToMoveBridgeLengthMap);
			System.out.println("waitQueue : " + waitQueue);
			System.out.println("finishCount : " + finishCount);
			System.out.println();
			
		}
        return round;
    }
	
	public static void main(String[] args) {
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10};
//		int bridge_length = 2;
//		int weight = 10;
//		int[] truck_weights = {7,4,5,6};
		int bridge_length = 100;
		int weight = 100;
		int[] truck_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		int result = new Solution().solution(bridge_length, weight, truck_weights);
		System.out.println(result);
	}

}
