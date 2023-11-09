
import java.util.Arrays;

public class ArrayCopy {
	// 얕은 복사 : 배열의 주소지만 복사하여 동일한 배열을 활용하는 기법, 바로가기, link (Shallow copy)
	// 깊은 복사 : 배열의 주소지가 아니고, 실제 배열을 물리적으로 복사하는 기법, 복사하기, copy (Deep copy)
	
	public static void main(String[] args) {
		// 얕은 복사 해보기 (Shallow copy)
		int[] array1 = { 0, 1, 2, 3, 4, 5 };
		int[] array2 = array1; // 얕은 복사! Shallow copy
		
		System.out.println("변경 전");
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		array1[0] = 5;
		System.out.println("변경 후");
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		
		// 깊은 복사 해보기 (Deep copy)
		int[] array3 = { 0, 1, 2, 3, 4, 5, 6, 7 };
		int[] array4 = null; // 깊은 복사 할 곳
		
		// 1. 고전적인 방법 = 직접 배열을 생성하고 하나씩 복사하는 방법, 손으로 하는 방법...
		array4 = new int[array3.length]; // 복사할 대상의 크기로 배열 선언
		for(int i = 0; i < array3.length; i++) {
			array4[i] = array3[i]; // 복사
		}
		array4[0] = 1;
		System.out.println("array3 : " + Arrays.toString(array3));
		System.out.println("array4 : " + Arrays.toString(array4));
		
		// 2. 배열 복사 시 제일 많이 쓰는 문장 ✭✭✭✭✭(매우 유용!)
		array4 = Arrays.copyOf(array3, array3.length);
		array4[0] = 2;
		System.out.println("array3 : " + Arrays.toString(array3));
		System.out.println("array4 : " + Arrays.toString(array4));
		
		// 3. 다른 문법
		array4 = array3.clone();
		array4[0] = 3;
		System.out.println("array3 : " + Arrays.toString(array3));
		System.out.println("array4 : " + Arrays.toString(array4));
		
		// 4. 기타 - System.arraycopy -> 매우 복잡해서 추천하지 않음.
//		System.arraycopy(array3, 0, array4, 0, 0);
	}
}
