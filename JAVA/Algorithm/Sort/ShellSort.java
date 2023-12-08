import java.util.Arrays;

public class ShellSort {
	
	//	쉘정렬
	static void shellSort(int[] a, int n) { 
		for(int h = n / 2; h > 0; h /= 2) { // 반으로 쪼개서 중간값을 구하는 로직
			for(int i = h; i < n; i++){
				int j;
				int tmp = a[i];
				for(j = i - h; j >= 0 && a[j] > tmp; j-=h ) { 
					a[j + h] = a[j];
				}
				a[j + h] = tmp; 
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {5, 3, 2, 11, 9, 1, 4, 8, 7};
		shellSort(a, a.length);
		System.out.println(Arrays.toString(a));
	}
}
