	public static void practice9() {
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고 1 ~ 10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요.
		int sto = 10;
		int array6[] = new int[sto];
		
		for(int i = 0; i < array6.length; i++) {
			array6[i] = r.nextInt(10) + 1;
			for(int j = 0; j < i; j++) {
				if(array6[i] == array6[j]) {
					i--;
				}
			}
		}
		for(int k = 0; k < sto; k++) {
			System.out.print(array6[k] + " ");			
		}
	}
public static void practice9() {
		// 10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고 1 ~ 10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력
		// ※ 상식 컴퓨터의 사고법 : 무식하게 모든걸 확인해본다.
		// 9번 풀이 : 정석, 최적화된 풀이
		// -> 전략 : 중복이 되면 다시 뽑는다. (언제까지 ? 중복이 되지 않을 때까지)
		int array[] = new int[10];
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(10);
			System.out.println("현재 뽑은 값 : " + array[i] + "\t중간 : " + Arrays.toString(array));
			for(int j = 0; j < i; j++) {
				System.out.println("\tarray[i] : " + array[i] + ", array[j] : " + array[j]);
				if(array[i] == array[j]) { // 중복 확인하는 곳
					System.out.println("중복 확인!!!!!!!!@@@@@@@@@@@@@@@@@@@@@");
					i--;
					break;
				}
			}
		}
		
		System.out.println();
		System.out.println("결과 : " + Arrays.toString(array));
	}
	
	public static void practice9_1() {
		// 2번쨰 풀이 : shuffle 활용하는 방법 (카드 섞기 방법) 1부터 10까지 배열 한뒤 섞는다....
		// 해당 문제에서는 이 방법이 최적화 된 방법!
		int array[] = new int[10];
		for(int i = 0; i < 10; i++) {
			array[i] = i + 1;
		}
		
		// shuffle 알고리즘 : 두개의 랜덤 수를 뽑아서 서로 바꾸는 방법
		for(int i = 0; i < array.length * 2; i++) { // 여기서의 값이 반복할 횟수를 정함
			int rNum1 = r.nextInt(array.length); // index 범위에서 랜덤값이 뽑힘
			int rNum2 = r.nextInt(array.length);
			// swap 패턴
			int temp = array[rNum1];
			array[rNum1] = array[rNum2];
			array[rNum2] = temp;
		}
		System.out.println();
		System.out.println("결과 : " + Arrays.toString(array));
	}
