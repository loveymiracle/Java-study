
// 깊이 우선 탐색! - 재귀버전 ★★★★★ 외우기 쉽다!
public class DFS_Recursion {
    public static void main(String[] args){
        // 각 노드가 연결된 정보를 2차원 배열 자료형으로 표현
        int[][] graph = {
        	{},
            {2, 3, 8},	// 1
            {1, 7},     // 2 O
            {1, 4, 5},	// 3
            {3, 5}, 	// 4
            {3, 4},		// 5
            {7},		// 6
            {2, 6, 8},	// 7 O
            {1, 7}};	// 8
        //각 노드가 방문된 정보를 1차원 배열 자료형으로 표현
        boolean [] visited = {false, false, false ,false ,false ,false ,false ,false, false};
    	int start = 1; // 시작 노드
    	
    	//  그래프  방문 여부  시작노드
        dfs(graph,visited, start);
    }
    
    // 1 2 7 6 8 3 4 5 
    // 1 2 7 6 8 3 4 5
	public static void dfs(int[][] graph, boolean[] visited, int start) {
		// 현재 노드를 방문 처리
		visited[start] = true;
		System.out.print(start + " "); // 방문 완료!
	
		// 인접 노드 탐색
		for(int i : graph[start]) { // 2V, 3, 8 -> 1, 7V -> 2V, 6V, 8V -> 
			// 방문하지 않은 노드만 재귀함수를 통해 방문 처리 수행!
			// -> 자동으로 스택 구조로 호출하게 됨
			if(visited[i] == false) {
				dfs(graph, visited, i);
			}
		}
	}
}
