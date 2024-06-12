// 동적프로그래밍 > N으로 표현
package ex01;

import java.util.*;

// 제한사항
// N은 1 이상 9 이하입니다.
// number는 1 이상 32,000 이하입니다.
// 수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
// 최솟값이 8보다 크면 -1을 return 합니다.
// 입출력 예

// N	number	return
// 5	12		4
// 2	11		3

// 12 = 5 + 5 + (5 / 5) + (5 / 5)
// 12 = 55 / 5 + 5 / 5
// 12 = 55 + 5 / 5
// 괄호는 무시, 현상황에서의 사칙연산의 우선순위는 같다고 본다.
// 전략 : 트리를 만들어야 하는데 사칙연산을 고려하고, 자기 자신을 문자열로 더하는 케이스도 생각!
// 첫번째로 만들 반복문 : 5 55 555 ... 55555555 5가 8번 이상으로는 쓰이면 안된다!
// 두번째로 만들 반복문 : 5+5, 5-5, 5*5, 5/5 ...... 

public class Solution {
	int answer = Integer.MAX_VALUE; // 초기 값 = int의 범위를 벗어난 값
	
	// 재귀 함수
	// int nCount : n을 사용한 횟수
	// int result : 계산 된 값
	public void search(int nCount, int result, int N, int number) {
//		System.out.println("\t".repeat(nCount) + "result : " + result + ", nCount : " + nCount);
		if(nCount > 8) {
			return;
		}
		if(result == number) {
			System.out.println("정답 찾았음! nCount : " + nCount);
			answer = Integer.min(answer, nCount);
//			answer = answer >= nCount ? nCount : answer;
		}
		
		int calcN = N; // 다음 N의 임시 계산 값
		for(int i = 0; i < (8 - nCount); i++) {
			search(nCount + i + 1, result + calcN, N, number); // 사칙 연산 부
			search(nCount + i + 1, result - calcN, N, number); // 사칙 연산 부
			search(nCount + i + 1, result * calcN, N, number); // 사칙 연산 부
			search(nCount + i + 1, result / calcN, N, number); // 사칙 연산 부
			calcN = calcN * 10 + N; // 5, 55, 555, 5555 ...
		}
	}
	
	public int solution(int N, int number) {
        search(0, 0, N, number);
        if(answer == Integer.MAX_VALUE) {
        	return -1;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		int result = new Solution().solution(N, number);
		System.out.println(result); // 4
	}

}
