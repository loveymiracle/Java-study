public static void practice8() {
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고 1 ~ 10 사이의 난수를 발생시켜 배열에 초기화 한 후 배열 전체 값과 그 값 중에서 최대값과 최소값 출력.
		int array5[] = new int[10];
		
		for(int i = 0; i < array5.length; i++) {
			array5[i] = r.nextInt(10) + 1;
			System.out.print(array5[i] + " ");
		}
		Arrays.sort(array5);
//		System.out.println(Arrays.toString(array5));
		System.out.println();
		System.out.print("최대값 : " + array5[array5.length-1] + " ");
		System.out.println();
		System.out.print("최소값 : " + array5[0] + " ");
	}
public static void practice8() {
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고 1 ~ 10 사이의 난수를 발생시켜 배열에 초기화 후 
		// 배열 전체 값과 그 값 중에서 최대값과 최소값을 출력
		// 최대값 : , 최소값 : 
		int array[] = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(10) + 1;
		}
		System.out.println(Arrays.toString(array));
		
		// 최소, 최대값 구하는 방법 -> 패턴화 시켜서 외웠다.
		int max = Integer.MIN_VALUE; // int type이 가질 수 있는 최소값
		int min = Integer.MAX_VALUE; // int type이 가질 수 있는 최대값
		for(int i = 0; i < array.length; i++) {
			if(min > array[i]) {
				min = array[i];				
			}
			if(max < array[i]) {
				max = array[i]; 
			}
		}
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
	}
	
	public static void practice8_1() {
		// 다른 풀이, 정렬을 통해 최대, 최소값을 가져오는 방법
		// -> 8번은 코드는 복잡, 성능은 우월, 8_1번은 코드는 간단, 성능은 떨어짐.
		// -> 상충관계를 가지는데 무엇이 좋을지는 도메인(현장)에 따라 달라진다.
		int array[] = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(10) + 1;
		}
		System.out.println(Arrays.toString(array));
		int array2[] = array.clone(); // 기존 값을 유지시켜야 할 때 (깊은 복사방법)
		Arrays.sort(array2); // 정렬하는 메소드
		System.out.println("최대값 : " + array2[array2.length -1]); // 최대 인덱스를 가져오는 방법!
		System.out.println("최소값 : " + array2[0]);
	}
