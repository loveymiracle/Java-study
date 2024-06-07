// DFS&BFS > 단어 변환
package ex03;

import java.util.*;

// begin	target	words										return
// "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
// "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]			0

// ["hot", "dot", "dog", "lot", "log", "cog"]라면 -> "hit" -> "hot" -> "dot" -> "dog" -> "cog"

// 제한사항
// 각 단어는 알파벳 소문자로만 이루어져 있습니다.
// 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
// words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
// begin과 target은 같지 않습니다.
// 변환할 수 없는 경우에는 0를 return 합니다.


public class SolutionBase {
	
    int answer = 0;
    Set<String> visitedSet = new LinkedHashSet<>();
	
	// 글자 간에 다른 글자를 계산해오는 메소드
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
	
	// int index : 방문한 노드 , 초기값 -1 -> 아직 방문한 노드가 없을 때!
	// String word : 현재의 문자열
	// 상수 : String begin, String target, String[] words
	public void dfs(int index, String word, String begin, String target, String[] words) {
		System.out.println("word : " + word + ", visitedSet : " + visitedSet);
		for(int i = 0; i < words.length; i++) {
			if(visitedSet.contains(words[i]) == false && calcGap(word, words[i]) == 1) {
				// 아직 방문하지 않았고 , calcGap의 차이가 1일 때만 방문 가능!
				visitedSet.add(words[i]);
				dfs(i, words[i], begin, target, words);
				visitedSet.remove(words[i]); // 방문 해제!
			}
		}
	}
	
	public int solution(String begin, String target, String[] words) {
		this.answer = words.length; // 답이 가질 수 있는 최대 크기로 초기화
		dfs(-1, begin, begin, target, words);
        return answer;
    }
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		int result = new Solution().solution(begin, target, words);
		System.out.println(result);
	}

}
