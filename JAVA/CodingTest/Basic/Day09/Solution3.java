// Day 9 수학, 문자열, 해시, 완전탐색, 조건문 > 가위 바위 보
package Day09;

import java.util.*;

// 제한사항
// 0 < rsp의 길이 ≤ 100
// rsp와 길이가 같은 문자열을 return 합니다.
// rsp는 숫자 0, 2, 5로 이루어져 있습니다.

// rsp		result
// "2"		"0"
// "205"	"052"

public class Solution3 {
	
	public String solution(String rsp) {
        String answer = "";
        String[] turn = rsp.split("");
        
        for(int i = 0; i < turn.length; i++) {
        	if(turn[i].equals("0")) {
        		turn[i] = "5";
        		answer += turn[i];
        	} else if(turn[i].equals("2")) {
        		turn[i] = "0";
        		answer += turn[i];
        	} else {
        		turn[i] = "2";
        		answer += turn[i];
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		String rsp = "205";
		String result = new Solution3().solution(rsp);
		System.out.println(result);
	}

}
