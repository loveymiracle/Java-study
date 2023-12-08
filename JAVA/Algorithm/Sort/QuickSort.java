import java.util.Arrays;

public class QuickSort {

	  //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
    }
    
    // 퀵정렬 -> 재귀 호출
    static void quickSort(int[] a, int left, int right) { // 왼쪽의 index, right으로 가장 큰값
		int pl = left; // 왼쪽 커서, 비교할 인자의 왼쪽위치
		int pr = right; // 왼쪽 커서, , 비교할 인자의 오른쪽위치
		int x = a[(pl + pr) / 2]; // 피벗(가운데 요소)

		do {
			while(a[pl] < x) pl++;
			while(a[pr] > x) pr--;
			if(pl <= pr)
				swap(a, pl++, pr--);
		} while(pl <= pr);
		
		if(left < pr) quickSort(a, left, pr);
		if(pl < right) quickSort(a, pl, right);
    }
    
	
	public static void main(String[] args) {
		int[] a = {5, 3, 2, 11, 9, 1, 4, 8, 7};
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
