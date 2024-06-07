// DFS&BFS > 단어 변환
package ex03;

import java.util.*;

//begin	target	words										return
//"hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
//"hit"	"cog"	["hot", "dot", "dog", "lot", "log"]			0


// ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"

public class Solution3 {
	int answer = 0;
	Set<String> vistedSet = new LinkedHashSet<>(); // 방문한 노드를 기억할 장소
	
	// 글자간에 다른 글자를 계산해오는 메소드
	// -> 이 메소드는 계산시간이 극도록 적어야 효용이 있다!
	public int calcGap(String target, String word) {
		int gap = 0;
		for(int i = 0; i < target.length(); i++) {
			if(target.charAt(i) != word.charAt(i)) {
				gap++;
				if(gap >= 2) return 2; // 알고리즘 단축용, 어차피 1글자 차이가 중요!
			}
		}
		return gap;
	}
	
	// index : 방문한 노드, 초기값 -1 -> 아직 방문한 노드가 없을때!
	// String word : 현재의 문자열 -> 바뀔값
	// 상수 : String begin, String target, String[] words
	public void dfs(int index, String word, String begin, String target, String[] words) {
		System.out.println("word : " + word + ", vistedSet : " + vistedSet);
		if(index != -1 && word.equals(target)) {
			System.out.println("찾은 결과! " + vistedSet.size());
			answer = Integer.min(answer, vistedSet.size());
			return;
		}
		for(int i = 0; i< words.length; i++) {
			if(vistedSet.contains(words[i]) == false && calcGap(word, words[i]) == 1) {
				// 아직 방문하지 않았고, clacGap의 차이가 1일때만 방문 가능!
				vistedSet.add(words[i]); // 방문 체크
				dfs(i, words[i], begin, target, words);
				vistedSet.remove(words[i]); // 방문 해제!
			}
		}
	}
	
	public int solution(String begin, String target, String[] words) {
		this.answer = words.length; // 답이 가질수 있는 최대 크기로 초기화
		dfs(-1, begin, begin, target, words);
		// 못찾은 경우 필터링
		if(answer == words.length) { // 초기랑 같을때
			return 0;
		}
        return answer;
    }
    
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		int result = new Solution().solution(begin, target, words);
		System.out.println(result);
	}
}
