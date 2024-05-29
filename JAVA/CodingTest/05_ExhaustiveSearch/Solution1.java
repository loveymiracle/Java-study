// 완전탐색 > 최소직사각형 
package ex01;

import java.util.*;


// sizes											result
// [[60, 50], [30, 70], [60, 30], [80, 40]]			4000
// [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]	120
// [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]	133
public class Solution1 {
	
	public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        
        for(int[] size : sizes) {
        	Arrays.sort(size);
        	w = Integer.max(w, size[0]);
        	h = Integer.max(h, size[1]);
        }
        return w * h;
    }

	public static void main(String[] args) {
		int[][] sizes = { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } };
		int result = new Solution().solution(sizes);
		System.out.println(result);
	}

}
