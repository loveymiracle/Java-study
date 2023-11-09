public static void practice7() {
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고 1 ~ 10 사이의 난수를 발생시켜 배열에 초기화 한 후 출력하세요.
		int array4[] = new int[10];
		
		for(int i = 0; i < array4.length; i++) {
			array4[i] = r.nextInt(10)+1;
			System.out.print(array4[i] + " ");
		}
	}
public static void practice7_1() {
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고 1 ~ 10 사이의 난수를 발생시켜 배열에 초기화한 후 출력
		int array[] = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(10) + 1;
		}
		System.out.println(Arrays.toString(array));
	}
