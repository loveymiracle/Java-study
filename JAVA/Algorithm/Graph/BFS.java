import java.util.LinkedList;
import java.util.Queue;

// https://scshim.tistory.com/241 
// 너비우선 탐색
public class BFS {

	public static void main(String[] args) {
		// 각 노드가 연결된 정보를 2차원 배열 자료형으로 표현
		// 0은 존재하지 않는다.
		int[][] graph = { 
				{}, 
				{ 2, 3, 8 }, // 1
				{ 1, 7 },    // 2 
				{ 1, 4, 5 }, // 3
				{ 3, 5 },    // 4
				{ 3, 4 },    // 5
				{ 7 },       // 6
				{ 2, 6, 8 }, // 7
				{ 1, 7 } };  // 8
		
		// 각 노드가 방문된 정보를 1차원 배열 자료형으로 표현
		boolean[] visited = { false, false, false, false, false, false, false, false, false };
    	int start = 1; // 시작 노드
    	
    	// 그래프, 방문 여부, 시작 노드 = 변경 가능!!
    	bfs(graph, visited, start);
	}

	// 1 2 3 8 7 4 5 6 
	// 1 2 3 8 7 4 5 6 
	private static void bfs(int[][] graph, boolean[] visited, int start) {
		// 큐로 구현 필요
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		// 현재 노드는 방문 처리
		visited[start] = true;
		
		// 큐가 빌때까지 방문
		while(!queue.isEmpty()) {
			// 큐에서 하나의 원소를 픽
			int v = queue.poll();
			System.out.print(v + " "); // 방문 완료!
			
			// 인접한 노드 중 아직 방문하지 않은 노드는 큐에 삽입
			for(int i : graph[v]) {
				if(visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
