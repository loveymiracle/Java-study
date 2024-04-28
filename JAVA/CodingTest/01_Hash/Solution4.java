// 해시 > 의상
package ex04;

import java.util.*;

//clothes																						return
//[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	5
//[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]				3

// 코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다. 예를 들어 위 예시의 경우 동그란 안경과 검정 선글라스를 동시에 착용할 수는 없습니다.
// 착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산합니다.
// 코니는 하루에 최소 한 개의 의상은 입습니다.

// TC2 예시
// x = f(y), 같은 종류의 입력이 3이면 출력이 3이다.
// x = y, 2개 정답!
// (3 + 1) - 1 = 3, 마지막 -1의 의미 : 모두 입지 않는 날은 없으니까!

// TC1 예시
// headgear-2 , eyewear -1 일 때, 답은 5
// (2 + 1) * (1 + 1) - 1 = 5

// 수식 정리
// 유추식 = (의상의 종류 + 1) * (다른 의상의 종류 + 1) - 1
// 여기서의 +1 의상을 안입은 케이스!, -1 의상을 하나도 안입으면 안됨으로 -1 해야 한다.

public class Solution {
	
	public int solution(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();
		
		for(String[] arr : clothes) {
//			System.out.println(arr[0] + " " + arr[1]);
//			if(map.get(arr[1]) == null) {
//				map.put(arr[1], 0);
//			}
//			map.put(arr[1], map.get(arr[1] + 1));
			map.put(arr[1], map.getOrDefault(arr[1], 0) + 1); // 한줄 처리는 getOrDefault
		}
		System.out.println(map);
		int answer = 1;
		for(int value : map.values()) {
			answer *= (value + 1);
		}
		
        return answer - 1;
    }
	
	public static void main (String[] args) {
		String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		
		int result = new Solution().solution(clothes);
		System.out.println(result);
	}
}
