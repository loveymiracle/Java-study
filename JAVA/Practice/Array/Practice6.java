public void practice6() {
		// 사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고 배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
		// 그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
		System.out.println("정수 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		int array3[] = new int[num2];
		int sum = 0;
		
		System.out.println("배열 0번째 인덱스에 넣을 값 : ");
		int tmp = Integer.parseInt(sc.nextLine());
		array3[0] = tmp;
		System.out.println("배열 1번째 인덱스에 넣을 값 : ");
		int tmp1 = Integer.parseInt(sc.nextLine());
		array3[1] = tmp1;
		System.out.println("배열 2번째 인덱스에 넣을 값 : ");
		int tmp2 = Integer.parseInt(sc.nextLine());
		array3[2] = tmp2;
		System.out.println("배열 3번째 인덱스에 넣을 값 : ");
		int tmp3 = Integer.parseInt(sc.nextLine());
		array3[3] = tmp3;
		System.out.println("배열 4번째 인덱스에 넣을 값 : ");
		int tmp4 = Integer.parseInt(sc.nextLine());
		array3[4] = tmp4;
		
		for(int i = 0; i < array3.length; i++) {
			System.out.print(array3[i] + " ");			
		}
		sum = tmp + tmp1 + tmp2 + tmp3 + tmp4;
		System.out.println();
		System.out.println("총 합 : " + sum);
	}
public static void practice6() {
		// 사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고 배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화
		// 그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력
		// 정수 : 5 , 배열 0번째 : 4 , 배열 1번째 : -4 , 배열 2번째 : 3 , 배열 3번쨰 : -3 , 배열 4번째 : 2
		// 4 -4 3 -3 2
		// 총 합 : 2
		System.out.println("정수 : ");
		int num = Integer.parseInt(sc.nextLine());
		int array[] = new int[num];
		int sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			System.out.println("배열 " + i + "번째 인덱스에 넣을 값 : ");
			int temp = Integer.parseInt(sc.nextLine());
			array[i] = temp;
			sum += temp;
		}
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("\n총 합 : " + sum);
	}
