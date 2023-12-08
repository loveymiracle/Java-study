import java.util.Arrays;


// 정렬 외우기 좋은 코드 ★★★★★
public class BubbleSort {
	
	 //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }
	

//    //--- 버블 정렬 ---//
    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++)
            for (int j = n - 1; j > i; j--)
                if (a[j - 1] > a[j])
                    swap(a, j - 1, j);
    }
	
	// 버블 정렬
//	static void bubbleSort(int[] a, int n) {
//		for(int i = 0; i < n - 1; i++) {
//			for(int j = n - 1; j > i; j--) {
//				System.out.println("i : " + i + ", j : " + j);
//				System.out.println("a[j - 1] : " + a[j - 1] + ", a[j] : " + a[j]);
//				System.out.println("스왑 전 : " + Arrays.toString(a));
//				if(a[j - 1] > a[j]) {
//					swap(a, j - 1, j);
//					System.out.println("스왑 발생!!");
//				}
//				System.out.println("스왑 후 : "+ Arrays.toString(a));
//				System.out.println();
//			}
//		}
//	}
	
	
	public static void main(String[] args) {
		int[] a = {5, 3, 2, 11, 9, 1, 4, 8, 7};
		bubbleSort(a, a.length);
		System.out.println(Arrays.toString(a));
	}
}
