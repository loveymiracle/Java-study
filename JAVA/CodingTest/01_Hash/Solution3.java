// 해시 > 전화번호 목록
package ex03;

import java.util.HashSet;
import java.util.Set;

//	phone_book							return
//	["119", "97674223", "1195524421"]	false
//	["123","456","789"]					true
//	["12","123","1235","567","88"]		false

// 첫번째 시도 - 배열을 순회하여 서로 비교하여 진행 + 정렬 -> 실패!! 효율성 테스트에서 통과 못함!
// 전략 > 작은 문자열과 큰 문자열을 비교로 찾아낸다. 해시로 문자열을 치환하는 테크닉이 필요했던 문제
// 전략 풀이, 큰 문자열을 Set에 넣을때 잘라서 하나씩 넣어 비교한다.
// 예시) 1195524421 -> 119, 1195, 11955, 119552, 1955524 ... 1195524421 
//      -> 이렇게 생성된 9개의 문자열을 Set에 넣는다.
// 119문자와 119를 비교하는 방법 
// 


public class Solution {
	
    public boolean solution(String[] phone_book) {
    	Set<String> set = new HashSet<>(); // 시간복잡도 O(1), 전화번호
    	int min = Integer.MAX_VALUE; // 문자열을 자를 최소길이를 저장하는 변수
    	System.out.println("초기 min 값 : " + min);
    	
    	// set 초기화코드 + 문자열의 최소길이를 구하는 코드
    	for(String str : phone_book) {
    		set.add(str);
    		if(str.length() < min) {
    			min = str.length();
    		}
    	}
    	System.out.println(set);
    	System.out.println("min : " + min);
    	
    	// 2차원 반복문
    	for(String str : phone_book) {
    		for(int i = min; i < str.length(); i++) { // 문자열을 잘라서 비교하는 로직
    			String head = str.substring(0, i);
    			System.out.println(head);
    			if(set.contains(head) == true) { // 1차원을 줄여주는 코드 이코드가 없으면? for문 하나 더 필요!
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
   
    // HashSet을 안쓰는 풀이 -> 풀이 안될 예정!!
    public boolean solution2(String[] phone_book) {
    	
    	// 3차원 반복문
    	for(String str : phone_book) {
    		for(int i = 1; i < str.length(); i++) { // 문자열을 잘라서 비교하는 로직
    			String head = str.substring(0, i);
    			for(String compareStr : phone_book) {
    				if(head.equals(compareStr)) {
    					return false;
    				}
    			}
    		}
    	}
    	
    	return true;
    }
    
	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		boolean result = new Solution().solution(phone_book);
		System.out.println(result);
	}
}
