import java.util.Arrays;

// 정렬 외우기 좋은 코드 ★★★★★
public class SelectionSort {
	 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }
    
    static void selectionSort(int[] a, int n) {
    	for(int i = 0; i < n - 1; i++) {
    		int min = i; // 시작하는 값을 가장 작은 값으로 지정
    		for(int j = i + 1; j < n; j++) 
    			if(a[j] < a[min]) {
    				min = j;
    			}
    		swap(a, i, min);
    	}
    }
    
    public static void main(String[] args) {
		int[] a = {5, 3, 2, 11, 9, 1, 4, 8, 7};
		selectionSort(a, a.length);
		System.out.println(Arrays.toString(a));
	}
}
