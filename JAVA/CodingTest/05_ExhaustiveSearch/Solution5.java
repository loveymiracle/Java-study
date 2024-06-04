// 완전탐색 > 피로도
package ex05;

import java.util.*;

// k	dungeons					result
// 80	[[80,20],[50,40],[30,10]]	3
// 정렬을 하면 의미가 있는가 ? -> 정렬 의미 없음
// 전략 : 모든 경우의 수를 다 구하고, 최대로 많이 던전을 구한 수를 비교하여 최대 트리 신장 길이를 구한다!

public class Solution5 {
	int k;
	int[][] dungeons;
	int answer = -1; // 던전을 돌 수 있는 최대 크기
	Set<Integer> visitSet = new LinkedHashSet<>(); // 방문 순서가 유지되는 set
	
	// nowK : 소모된 피로도
	public void dfs(int nowK) {
		System.out.println("visitSet : " + visitSet);
		System.out.println("소모된 피로도 : " + nowK + "\n");
		answer = Integer.max(answer, visitSet.size());
		
		for(int i = 0; i < dungeons.length; i++) {
			if(visitSet.contains(i) == false && nowK + dungeons[i][0] <= k) {
				// 던전을 방문할 수 있을 때!
				// -> 던전을 방문하지 않았고, 요구피로도가 현재 피로도보다 낮을 때
				visitSet.add(i);
				dfs(nowK + dungeons[i][1]); // 소비될 피로도 재계산
				visitSet.remove(i);
			}
		}
		
	}
	
	public int solution(int k, int[][] dungeons) {
        this.k = k;
        this.dungeons = dungeons;
        dfs(0);
        return answer;
    }
	
	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 } };
		int result = new Solution().solution(k, dungeons);
		System.out.println(result);
	}

}
