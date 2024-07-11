// Day 2 출력, 연산 > 홀짝 구분하기
package Day02;

import java.util.*;

public class Solution4 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n + " is " + (n % 2 == 0 ? "even" : "odd"));
        
        if(n % 2 == 0) {
        	System.out.println(n + " is even");
        } else {
        	System.out.println(n + " is odd");
        }
    }

}
