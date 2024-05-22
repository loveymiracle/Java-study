// 정렬 > 가장 큰 수
package ex02;

import java.util.*;

// numbers				return
// [6, 10, 2]			"6210"
// [3, 30, 34, 5, 9]	"9534330"

// 전략 -> numbers를 정렬시키는데, 앞에 배치하면 기대값이 높은 숫자부터 정렬시킨다!
// [6, 10, 2] -> [6, 2, 10] 이렇게 정렬되어야 가장 큰 값이 된다!
// [3, 30, 34, 5, 9] -> [9, 5, 34, 3, 30]
// 30, 3 -> 303 330, 기준은 두 수를 조합해서 더 큰 값이 되는 경우의 수를 더 높은 값으로 취급한다!

public class Solution2 {
	
	public String solution(int[] numbers) {
		List<String> list = new ArrayList<>();
		for(int num : numbers) {
			list.add(""+num);
		}
//		Collections.sort(list, new Comparator<String>(){
//			@Override
//			public int compare(String o1, String o2) {
//				return (o1 + o2).compareTo(o2 + o1);
//			}
//		});
		
		Collections.sort(list, (o1, o2)->{
			return (o1 + o2).compareTo(o2 + o1);
		});
		
		Collections.reverse(list);
		
		StringBuffer sb = new StringBuffer();
		for(String s : list) {
			if(s.equals("0") && sb.length() == 0) {
				continue;
			}
			sb.append(s);
		}
		
        return sb.length() == 0 ? "0" : sb.toString();
    }
	
	public static void main(String[] args) {
		int[] numbers = { 3, 30, 34, 5, 9 }; // { 0, 0, 0, 0, 0, 0, } -> 000000
		String result = new Solution().solution(numbers);
		System.out.println(result);
	}

}
