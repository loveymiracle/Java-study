// 정렬 > K번째 수
package ex01;

import java.util.*;

// array					commands							return
// [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]

// 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
//
// array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
// 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
// 2에서 나온 배열의 3번째 숫자는 5입니다.

public class Solution1 {
	
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // 초기화 부
        for(int i = 0; i < commands.length; i++) {
        	System.out.println(i+"번째");
        	int[] newArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
        	System.out.println(Arrays.toString(newArray));
        	Arrays.sort(newArray);
        	System.out.println(Arrays.toString(newArray));
        	answer[i] = newArray[commands[i][2] - 1];
        	System.out.println(Arrays.toString(answer));
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] answer = new Solution().solution(array, commands);
		System.out.println(Arrays.toString(answer));
		
	}

}
