// Day 3 연산 >  더 크게 합치기
package Day03;

// 제한사항
// 1 ≤ a, b < 10,000

// a	b	result
// 9	91	991
// 89	8	898

public class Solution4 {
	
	public int solution(int a, int b) {
		String c = String.valueOf(a);
		String d = String.valueOf(b);
		String ab = c + d;
		String ba = d + c;
		
        return Math.max(Integer.parseInt(ab), Integer.parseInt(ba));
    }
	
	public static void main(String[] args) {
		int a = 9;
		int b = 27;
		int result = new Solution4().solution(a, b);
		System.out.println(result);
	}

}
