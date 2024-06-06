// DFS&BFS > 네트워크
package ex02;

import java.util.*;

// n	computers							return
// 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
// 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1

// 전략 : 한곳을 방문하면 돌 수 있는 모든 루트를 돌고 나오고 카운팅 하는 전략
// dfs를 1레벨부터 설계한 코드

public class Solution2 {
	Set<Integer> visitedSet = new LinkedHashSet<>();
	
	// int index : 현재 방문 된 노드의 index
	void dfs(int index, int n, int[][] computers) {
		visitedSet.add(index); // 방문 했으니 체크
		// 돌 수 있는 노드를 모두 방문하여 visitedSet에 넣어준다.
		System.out.println("방문한 인덱스 : " + index + ", visitedSet : " + visitedSet);
		// 방문이 가능한 인접한 노드를 찾는 반복문
		for(int i = 0; i < computers[index].length; i++) {
			if(visitedSet.contains(i) == false && computers[index][i] == 1) {
				// 아직 방문하지 않았고, 연결 된 노드일 때
				dfs(i, n, computers);
			}
		}
	}
	
	public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i = 0; i < computers.length; i++) {
        	if(visitedSet.contains(i) == false) { // 방문하지 않았을 때!
        		dfs(i, n, computers);
        		answer++;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int result = new Solution().solution(n, computers);
		System.out.println(result);
	}

}
 
