package ex03;

import java.util.*;

//# 힙(Heap) > 이중우선순위큐
//
//# operations	                                                return
//# ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	[0, 0]
//# ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]
//
// return : [최댓값, 최솟값]
//# 명령어	수신 탑(높이)
//# I 숫자	큐에 주어진 숫자를 삽입합니다.
//# D 1		큐에서 최댓값을 삭제합니다.
//# D -1	큐에서 최솟값을 삭제합니다.

public class Solution3 {
	
	// 주의할점 : PriorityQueue 평상시에 정렬된 상태로 유지가 되진 않는다!
	//          -> 정렬된 상태가아니고 트리 상태로 유지된다!!
	//          -> 그래서 접근시에는 반드시 PriorityQueue 메소드를 활용해한다.
	//           poll, remove, peek, and element access theelement at the head of the queue. 
	// peek : 제거없이 보기만할때
	// poll : 제거해서 값을 가져올때
	
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(String cmd : operations) {
//        	System.out.println(cmd);
        	if(cmd.contains("I")) {
        		queue.add(Integer.parseInt(cmd.split(" ")[1]));
        		System.out.println("추가! : " + Integer.parseInt(cmd.split(" ")[1]));
        	}
        	if(queue.isEmpty()) {
        		continue;
        	}
        	if(cmd.contains("D 1")) {
        		int max = Collections.max(queue);
        		queue.remove(max); // remove는 index가 아닌 Object로 취급하여 삭제한다.
        		System.out.println("@최대값 삭제 : " + max);
        	}
        	if(cmd.contains("D -1")) {
        		int val = queue.poll(); // 최소값을 삭제하는 PriorityQueue 전용 메소드!
        		System.out.println("최소값 삭제 : " + val);
        	}
        	if(queue.isEmpty()) {
        		return answer;
        	}
        }
        if(queue.isEmpty()) {
            return answer;
        }
        answer[0] = Collections.max(queue); // 최대값 가져오기
        answer[1] = queue.peek(); // 최소값 보기만할때
        return answer;
    }
    
    public static void main(String[] args) {
		String[] operations = { "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333" };
		int[] result = new Solution().solution(operations);
		System.out.println(Arrays.toString(result));
	}
}
