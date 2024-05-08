// 스택앤큐 > 기능 개발
package ex02;

import java.util.*;

// progresses				speeds				return
// [93, 30, 55]				[1, 30, 5]			[2, 1]
// [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]

// 풀이 전략 -> 전형적인 Round를 돌리는 문제로 시뮬레이션을 해보고 그대로 구현하면 끝나는 문제!
// 	[93, 30, 55]		[1, 30, 5]		[2, 1]
//1	[94, 60, 60] -> 배포가능? X
//2 [95, 90, 65] -> 배포가능? X
//3 [96, 100, 70] -> 배포가능? 2번째가 100이긴 한데, 1번째가 96임으로 배포 불가능!
//4 [97, 100, 75] -> 배포가능? X
//5 [98, 100, 80] -> 배포가능? X
//6 [99, 100, 85] -> 배포가능? X
//7 [100, 100, 90] -> 배포가능? 1, 2번째가 100이상임으로 배포 가능! O, 답 : [2]
//8 [100, 100, 95] -> 배포가능? X
//9 [100, 100, 100] -> 배포가능? 3번째 배포 가능! 답 : [2, 1]

// 문제풀이 Step
// 1. Round 돌리는 반복문을 만든다.
// 2. 제대로 증감 하는지 확인
// 3. 정답과 유사하게 꾸미고
// 4. 마지막은 Break point를 잡아 알고리즘을 완성!

public class Solution {
	
	public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        int[] state = new int[progresses.length]; // 0 = 개발중, 1=배포가능, 2=배포끝
        int count = 0;
        int allFinishCount = 0; // 작업이 끝난 숫자
        
        // 임시 반복문 초기에는 for문 나중에는 while로 바꿔 break 지점을 정한다.!
//        for(int k =0; k < 10; k++) {
//        System.out.println("Round " + k + "시작!!");
         while(true) {
        	int finishCount = 0; // flag 변수, 0이 아닌 경우 배포가 될 수 있다는 숫자
        	// 초기에 Round를 돌리는 부
        	for(int i = 0; i < progresses.length; i++) {
        		progresses[i] += speeds[i]; // 증감부!!
        		// 개발이 끝나서 배포 가능한지 체크하는 if문
        		if(progresses[i] >= 100) { // state 업데이트!!
        			state[i] = 1;
        			progresses[i] = Integer.MIN_VALUE; // 최소값으로 초기화, 이후에는 100 이상이 될 일이  없다!
        			finishCount++; // 배포 가능 여부 업데이트!
        		}
        	}
        	System.out.println(Arrays.toString(progresses));
        	System.out.println(Arrays.toString(state));
        	
        	// 배포 체크
        	if(finishCount > 0) { // 배포가 가능할 때
        		allFinishCount += finishCount; // 실제 작업이 끝난 갯수!
        		int deployCount = 0; // 배포가 가능한 숫자
        		for(int i = 0; i < state.length; i++) {
        			if(state[i] == 0) { // 앞에 개발이 안된 경우
        				break;
        			}
        			if(state[i] == 1) { // 배포 가능할 때!!
        				deployCount++;
        				state[i] = 2; // 배포 완료!
        			}
        		}
        		System.out.println("배포 가능한 수 !! " + deployCount);
        		// 실제 정답 내는 곳
        		if(deployCount > 0) {
        			answer[count++] = deployCount;
        		}
        	}
        	
        	// finish 여부 체크 -> 앞에 할지 뒤에 들어갈지 모른다!
//        	System.out.println("Round " + k + "끝\n");
        	if(allFinishCount == progresses.length) {
        		break;
        	}
        }
        
        return Arrays.copyOf(answer, count);
    }
	
	 public static void main(String[] args) {
	    int[] progresses = {93, 30, 55};
	    int[] speeds = {1, 30, 5};
	    int[] result = new Solution().solution(progresses, speeds);
	    System.out.println(Arrays.toString(result));
	}

}
