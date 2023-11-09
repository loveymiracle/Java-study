public static void practice2() {
		// 길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여 역순으로 배열 인덱스에 넣은 후 그 값을 출력하세요.
    // 10 9 8 7 6 5 4 3 2 1
		int array1[] = new int[10];
		int num = array1.length;
		
		for(int i = 0; i < array1.length; i++) {
			array1[i] = num--;
			System.out.print(array1[i] + " ");
		}
	}
public static void practice2_1() {
		// 길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여 역순으로 배열 인덱스에 넣은 후 그 값 출력
		// 10 9 8 7 6 5 4 3 2 1
		int array[] = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = array.length - i;
		}
		System.out.println(Arrays.toString(array));
	}
