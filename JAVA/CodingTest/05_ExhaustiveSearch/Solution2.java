// 완전 탐색 > 모의고사
package ex02;

import java.util.*;

// answers		return
// [1,2,3,4,5]	[1]
// [1,3,2,4,2]	[1,2,3]

// 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
// 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
// 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
public class Solution2 {
	
	public int[] solution(int[] answers) {
		List<Integer> list = new ArrayList<>();
		
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
        	if(answers[i] == student1[i % student1.length]) {
        		count[0]++;
        	}
        	if(answers[i] == student2[i % student2.length]) {
        		count[1]++;
        	}
        	if(answers[i] == student3[i % student3.length]) {
        		count[2]++;
        	}
        }
        System.out.println("count");
        System.out.println(Arrays.toString(count));
        
        int[] tmp = new int[count.length];
        for(int i = 0; i < count.length; i++) {
        	tmp[i] = count[i];
        }
        Arrays.sort(tmp);
        System.out.println("tmp");
        System.out.println(Arrays.toString(tmp));
        for(int i = 0; i < tmp.length; i++) {
        	if(count[i] == tmp[2]) {
        		list.add(i + 1);
        	}
        }
        System.out.println("list : " + list);
        answers = new int[list.size()];
        
        for(int i = 0; i < answers.length; i++) {
        	answers[i] = list.get(i);
        }
        return answers;
    }
	
	public static void main(String[] args) {
		int[] answers = { 1,2,3,4,5 };
		int[] result = new Solution().solution(answers);
		System.out.println(Arrays.toString(result));
	}
	
}
