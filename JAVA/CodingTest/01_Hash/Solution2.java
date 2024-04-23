// 해시 > 완주하지 못한 선수
package ex02;

import java.util.*;

//participant										completion									return
//["leo", "kiki", "eden"]							["eden", "kiki"]							"leo"
//["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
//["mislav", "stanko", "mislav", "ana"]				["stanko", "ana", "mislav"]					"mislav"

// 문제 풀이 전에 반드시 손으로 시뮬레이션을 해봐야한다!
// completion 베이스로 반복문으로 돌리고, participant에서 이름을 하나씩 지우는 전략!
// ["leo", "kiki", "eden"] 	["eden", "kiki"]
// ["leo", "kiki", ] 		["eden", "kiki"], 선택 : "eden"
// ["leo", "", ]			["eden", "kiki"], 선택 : "kiki"
// ["leo", "", ]			["eden", "kiki"], 선택 : 없음! 반복문 끝 -> leo반
public class Solution {
	
	// List 기준으로 풀이!
	// -> 실패하는 풀이, 이유 : 시간초과!! 시간복잡도 : O(n^3)
	public String solution2(String[] participant, String[] completion) {
		List<String> participantList = new ArrayList<>();
//		participantList = Arrays.asList(participant); // 이렇게 쓰면 안된다!
//		participantList = new ArrayList<>(Arrays.asList(participant)); // asList 올바른 사용법
		
		// 가장 기초적인 초기화문!
		for(String name : participant) {
			participantList.add(name);
		}
//		System.out.println(participantList);
		
		// 찾아서 제거하는 코드부
		for(String name : completion) { // 1차원
			for(int i = 0; i < participantList.size(); i++) { // 2차원
				if(participantList.get(i).equals(name)) { // 3차원 -> 문자열 비교는 반복문으로 한다.
//					System.out.println("@@" + participantList.get(i));
					participantList.remove(i);
//					System.out.println("@@@###" + participantList);
					break;
				}
			}
			// 2줄로 단축하는 방법
//			int index = participantList.indexOf(name);
//			participantList.remove(index);
		}
		
		
		return participantList.get(0);
    }
	
	// map을 사용하는 솔루션!
	public String solution(String[] participant, String[] completion) {
		//   이름      사람수
		Map<String, Integer> pMap = new HashMap<>(); // participant Map
		
		for(String name : participant) {
//			// 초기화 문
//			if(pMap.containsKey(name) == false) { // 기존 값이 없을 때!
//				pMap.put(name, 0);
//			}
//			// 정상적인 추가하는 문장
//			pMap.put(name, pMap.get(name)+1);
			
			// 위에 문장 한줄로 줄이는 방법!
			pMap.put(name,  pMap.getOrDefault(name, 0) + 1);
		}
		System.out.println("지우기 전 : " + pMap); // {ana=1, mislav=2, stanko=1}
		
		for(String name : completion) {
			int num = pMap.get(name) - 1;
//			System.out.println(pMap);
			if(num == 0) {
				pMap.remove(name); // Map 에서 이름을 지우는 과정!
			} else {
				pMap.put(name, num); // -1 update 하는 과정
			}
		}
		return pMap.keySet().iterator().next();
    }
	
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		String result = new Solution().solution(participant,  completion);
		System.out.println(result);
	}
}
