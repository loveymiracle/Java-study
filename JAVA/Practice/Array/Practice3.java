public static void practice3() {
		// 사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고 1부터 입력 받은 값까지 배열에 초기화 한 후 출력 하세요.
    // 양의 정수 : 5
    // 1 2 3 4 5
		System.out.println("양의 정수 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		int array2[] = new int[num1];
		
		for(int i = 0; i < array2.length; i++) {
			array2[i] = i + 1;
			System.out.print(array2[i] + " ");
		}
	}
public static void practice3_1() {
		// 사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고 1부터 입력 받은 값까지 배열에 초기화한 후 출력
		// 양의 정수 : 5
		// 1 2 3 4 5
		System.out.println("양의 정수 : ");
		int num = Integer.parseInt(sc.nextLine());
		int array[] = new int[num];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		System.out.println(Arrays.toString(array));
	}
