// Day 6 문자열, 반복문, 출력, 배열, 조건문 > 직각삼각형 출력하기
package Day06;

import java.util.*;

public class Solution2 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++) {
        	System.out.println("*".repeat(i));
        }
    }

}
