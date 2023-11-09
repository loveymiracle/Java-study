
import java.util.Arrays;
import java.util.Random;

public class ArraysTest {
	public static void main(String[] args) {
		int[] array = new int[10];
		
		// 난수로 배열을 초기화 하는 방법
//		Random r = new Random();
		Random r = new Random(System.currentTimeMillis()); // 현재 시간을 난수 초기 seed 값으로 정하는 문법
		
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(10); // 0 ~ 9 까지 초기화
		}
		
		// 출력하는 방법
		System.out.println(Arrays.toString(array));
		
		// 배열에서 특정 값을 찾는 방법, 손으로 구현하는 방법
		int value = 5;  // 찾을 값
		int index = -1; // 배열에서의 찾는 값의 위치, why -1? 배열의 index는 0부터 시작, -1이면 못찾는 경우!
		for(int i = 0; i < array.length; i++) {
			if(array[i] == value) {
				index = i;
				System.out.println("탐색 완료!");
				break;
			}
		}
		if(index >= 0) {
			System.out.println("값을 찾았습니다. 찾은 index : " + index);
		} else {
			System.out.println("값을 찾을 수 없습니다.");
		}
		
		// 값을 정렬하는 방법
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		// 값을 찾는 방법2 - binarySearch() - 정렬되지 않으면 사용 불가능!
		int index2 = Arrays.binarySearch(array, 5); // 값을 찾으면 index를 반환하고 없으면 -1을 리턴
		System.out.println("index2 : " + index2);
		if(index2 >= 0) {
			System.out.println("값을 찾았습니다. 찾은 index2 : " + index);
		} else {
			System.out.println("값을 찾을 수 없습니다.");
		}
	}
}
