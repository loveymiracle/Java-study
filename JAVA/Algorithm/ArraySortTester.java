import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysSortTester {

	public static void main(String[] args) {
		// 배열 정렬하는 방법
		
//		int[] array = {5, 3, 2, 13, 1, 4, 8, 7};
		Integer[] array = {5, 3, 2, 13, 1, 4, 8, 7};
		// 내부적으로는 퀵정렬로 정렬해준다. Dual-Pivot Quicksort
		//  O(n log(n)) 
//		Arrays.sort(array);
//		System.out.println(Arrays.toString(array));
		
		// 컬랙션 정렬하는 방법 
		List<Integer> list = new ArrayList<>(Arrays.asList(array));
		Collections.sort(list);
		System.out.println(list);
	}
}
