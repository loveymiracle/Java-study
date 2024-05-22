// 정렬 > H-index
package ex03;

import java.util.*;

// citations		return
// [3, 0, 6, 1, 5]	3
// [10, 8, 5, 4, 3] 4
// [25, 8, 5, 3, 3] 3

// 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 
// h의 최댓값이 이 과학자의 H-Index입니다.
// 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때,
// 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.

public class Solution3 {
	
    public int solution(int[] citations) {
        List<Integer> list = new ArrayList<>();
        for(int num : citations) {
        	list.add(num);
        }
        Collections.sort(list);
        Collections.reverse(list);
        
        for(int i = 0; i < list.size(); i++) {
        	System.out.println("인용한 갯수 : " + (i + 1));
        	System.out.println("h 값 : " + list.get(i));
        	if(i >= list.get(i)) {
        		return i;
        	}
        }
        return list.size();
    }
    
    public static void main(String[] args) {
    	int[] citations = {3, 3, 3, 3};
    	int result = new Solution().solution(citations);
    	System.out.println(result);
	}

}
