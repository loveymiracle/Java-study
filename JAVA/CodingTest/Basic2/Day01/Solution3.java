// Day 1 출력 > 문자열 반복해서 출력하기
package Day01;

import java.util.*;

public class Solution3 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }

        System.out.println(sb.toString());
    }

}
