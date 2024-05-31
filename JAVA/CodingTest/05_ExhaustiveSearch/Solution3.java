// 완전탐색 > 소수 찾기
package ex03;

import java.util.*;

// numbers	return
// "17"		3
// "011"	2

// 풀이 전략
// step1. DFS(재귀함수)를 통해 조합될 수 있는 경우의 수를 모두 탐색한다.
// step2. 만들어진 숫자를 소수판별하여 정답을 모은다.
// -> 만댝 파이썬으로 풀면 permutations(순열) vs combination(조합) 중 permutations로 풀어야 한다 --> 케이스가 많다!

public class Solution3 {
	
	char[] numberArr; // 만들어진 숫자를 저장할 Array, 문자열로 만들면 성능에서 문제 발생 가능!!
	String numbers; // 받은 문자열
	boolean[] visited; // 배열 또는 set으로 만들어지는 배열, 방문 여부를 저장한다.
//	Set<Integer> set = new HashSet<>(); // 정답인 소수를 담을 set
	Set<Integer> set = new LinkedHashSet<>(); // LinkedHashSet : 넣는 순서 유지 된다.
	
	// 소수 판단용, 외워야한다.
	public boolean isPrime(int n) {
		if (n == 1 || n == 0)
			return false;
		for (int i = 2; i < (n / 2) + 1; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	
	// 재귀 함수 : 자신이 자신을 호출하는 함수, Stack의 원리를 사용한다
	// 재귀 들의 인자는 필요한 모든 값을 가질 때도 있고, 전역으로 빼서 설계할 수 도 있다.
	// level : 현재 자기가 돌고 있는 트리의 레벨, 초기값은 0
	// length : 트리 레벨의 최대크기 - 
	public void dfs(int level, int length) {
		System.out.println("\t".repeat(level) + "level : " + level + ", " + Arrays.toString(numberArr));
		// 정답 체크부 !
		if(level != 0) {
			int num = Integer.parseInt(new String(numberArr).substring(0, level));
			System.out.println(num);
			if(isPrime(num)) { // 소수 판별
				set.add(num); // 답을 넣는다.
			}
		}
		
		// 재귀 설계의 가장 기초는 언제 끝날 것인지에 대한 break 문이 핵심!
		if(level == length) { // 내가 정한 트리의 길이까지만 돌게끔 설계
			return;
		}
		
		// 실제 순회하는 코드
		for(int i = 0; i < numbers.length(); i++) {
			if(visited[i] == false) {
				visited[i] = true; // 마킹부
				numberArr[level] = numbers.charAt(i); // 문자열 만드는 부
				dfs(level + 1, length); // 자신을 호출하는 재귀부!
				visited[i] = false;
			}
		}
		
	}
	
	public int solution(String numbers) {
		visited = new boolean[numbers.length()];
		numberArr = new char[numbers.length()];
		this.numbers = numbers;
		dfs(0, numbers.length());
		System.out.println(set);
        return set.size();
    }
	
	public static void main(String[] args) {
		String numbers = "123";
		int result = new Solution().solution(numbers);
		System.out.println(result);
	}

}
