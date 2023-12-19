import java.util.Stack;

// 깊이 우선탐색 Stack으로 구현한 버전
public class DFS_Stack {
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
        dfs(graph, visited, start);
    }

	// 1 2 7 6 8 3 4 5 
	private static void dfs(int[][] graph, boolean[] visited, int start) {
		// 시작노드를 방문 처리
		visited[start] = true;
		System.out.print(start + " "); // 시작 노드 방문
		
		// 깊이 우선 탐색은 스택 자료구조 필요!
		Stack<Integer> stack = new Stack<>(); 
		stack.push(start); // 스택에 시작 노드 push
		
		while(!stack.isEmpty()) {
			int now = stack.peek(); // 위에 값을 가져오는 용도, 삭제X
			
			boolean hasNearNode = false; // 방문할 필요성이 있는지 판단하는 flag
			for(int i : graph[now]) {
				if(visited[i] == false) { // 방문이 필요할때
					hasNearNode = true;
					stack.push(i); 
					visited[i] = true;
					System.out.print(i +" "); // 방문 노드 출력!
					break;
				}
			}
			
			// 인접 노드를 모두 방문하면 노드 pop으로 제거
			if(hasNearNode == false) {
				stack.pop();
			}
		}
	}
}













