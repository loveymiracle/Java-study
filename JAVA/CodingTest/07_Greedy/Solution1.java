// 탐욕법 > 체육복
package ex01;

import java.util.*;

// n	lost	reserve		return
// 5	[2, 4]	[1, 3, 5]	5
// 5	[2, 4]	[3]			4
// 3	[3]		[1]			2

// 제한사항
// 전체 학생의 수는 2명 이상 30명 이하입니다.
// 체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
// 여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
// 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
// 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 
// 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.

// 풀이 시뮬레이션1
// n	lost	reserve		return
// 5	[2, 4]	[1, 3, 5]	5
// 전체 사람 : 	[1, 2, 3, 4, 5]
// lost : 	 	[   2,    4   ]
// reserve :    [1,    3,    5]
// 빌린 사람 :	    [   1,    3   ] 답은 5명

// 풀이 시뮬레이션2 - 자신 것을 도난 당한 케이스
// -> 먼저 적용해야 풀린다
// n	lost		reserve		return
// 5	[2, 3, 4]	[1, 3, 5]	5
//전체 사람 : 		[1, 2, 3, 4, 5]
//lost : 	 	[   2, 3, 4   ]
//reserve :    	[      3,    5]
//빌린 사람 :	    [   3  0  5   ] - ? 

public class Solution1 {
	
	public int solution(int n, int[] lost, int[] reserve) {
		Set<Integer> lostSet = new TreeSet<>();		// 순서보장 + 속도가 빨라서 set으로 전환
		Set<Integer> reserveSet = new TreeSet<>();	
		
		// 초기화 과정
		for(int num : lost) {
			lostSet.add(num);
		}
		
		for(int num : reserve) {
			// 본인 것을 도난 당한 케이스를 여기에 추가해야 답이 된다!
			if(lostSet.contains(num)) {
				lostSet.remove(num);
			} else {
				reserveSet.add(num);
			}
		}
		System.out.println("lostSet : " + lostSet);
		System.out.println("reserveSet : " + reserveSet);
		
		// 풀이과정
		int answer = n - lostSet.size(); // 안빌리고도 체육 수업이 가능한 사람
		System.out.println("계산 전 : " + answer);
		
		for (int lostNum : lostSet) {
//			// 자신이 잃어버린 경우 -> 여기 있으면 안된다! 사유 : 앞에 사람이
//			if (reserveSet.contains(lostNum)) {
//				System.out.println(lostNum + "가 자기껄 빌림! " + reserveSet);
//				reserveSet.remove(lostNum); // 빌리는 알고리즘
//				answer++;
//			}
			// 체격이 작은 사람껄 먼저 빌리는 알고리즘
			if (reserveSet.contains(lostNum - 1)) {
				System.out.println(lostNum + "가 작은거 빌림! " + reserveSet);
				reserveSet.remove(lostNum - 1); // 빌리는 알고리즘
				answer++;
			} else if (reserveSet.contains(lostNum + 1)) {
				System.out.println(lostNum + "가 큰거 빌림! " + reserveSet);
				reserveSet.remove(lostNum + 1);
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 3, 4 };
		int[] reserve = { 1, 3, 5 };
		int result = new Solution().solution(n, lost, reserve);
		System.out.println(result); // 5
	}
}
