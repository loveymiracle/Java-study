import java.util.Arrays;

// 코드는 제일 간결함
public class InsertionSort {

	// 단순 삽입 정렬
	static void insertionSort(int[] a, int n) {
		for(int i = 1; i < n; i++) {
			int j;
			int tmp = a[i];
			for(j = i; j > 0 && a[j - 1] > tmp; j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
	}
	

	public static void main(String[] args) {
		int[] a = {5, 3, 2, 11, 9, 1, 4, 8, 7};
		insertionSort(a, a.length);
		System.out.println(Arrays.toString(a));
	}
}
