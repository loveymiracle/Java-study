import java.util.Arrays;

// ★★★★★
// 이진 검색 : 정렬된 배열에서 반씩(binary)로 쪼개서 숫자를 탐색하는 기법
//           시간 복잡도 = O(log2n)
public class BinSearch {
	
	// 4
	// 1,2,4,8,[9],12,13,15,18,20
	// 이진 검색하는 메소드
	static int binSearch(int[] a, int n, int key) {
		int pl = 0; // left
		int pr = n - 1; // right
		
		do {
			int pc = (pl + pr) / 2; // center=중앙값
			if(a[pc] == key) 
				return pc; // 찾은 index 반환!
			else if (a[pc] < key) // 키값이 찾은 값보다 클때 -> 오른쪽 가야한다.
				pl = pc + 1; // 왼쪽의 범위를 줄이는 코드
			else // 키값이 찾은 값보다 작을때
				pr = pc - 1; // 오른쪽의 범위를 줄이는 코드
		} while(pl <= pr);
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,4,8,9,12,13,15,18,20};
		int index = Arrays.binarySearch(array, 13);
		System.out.println("index : " + index);
		System.out.println("value : " + array[index]);
		
		int index2 = binSearch(array, array.length, 13);
		System.out.println("index : " + index2);
		System.out.println("value : " + array[index2]);
	}
}
