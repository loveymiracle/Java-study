public static void practice10() {
		// 로또 번호 자동 생성기 프로그램을 작성하는데 중복 값 없이 오름 차순으로 정렬하여 출력하세요.
		int lotto = 6;
		int array7[] = new int[lotto];
		
		for(int i = 0; i < array7.length; i++) {
			array7[i] = r.nextInt(45) + 1;
			for(int j = 0; j < i; j++) {
				if(array7[i] == array7[j]) {
					i--;
				}
			}
		}
		Arrays.sort(array7);
		for(int k = 0; k < lotto; k++)
			System.out.print(array7[k] + " ");
	}
}
public static void practice10() {
		// 로또 번호 자동 생성기 프로그램을 작성하는데 중복 값 없이 오름차순으로 정렬하여 출력
		int array[] = new int[6];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(45) + 1; // 1 ~ 46 까지 랜덤값 추출
			for(int j = 0; j < 1; j++) {
				if(array[i] == array[j]) {
					i--;
					break;
				}
			}
		}
		// 정렬 전 값
		System.out.println(Arrays.toString(array));
//		Arrays.sort(array));
		
		//정렬 알고리즘 손으로 구현해보기 - 버블정렬
//		// sort 사용 권장!!
//		for(int i = 0; i < array.length; i++) {
//			for(int j = i; j < array.length; j++) {
//				if(array[i] > array[j]) {
//					int temp = array[i];
//					array[i] = array[j];
////					array[j] = temp;
//				}
//			}
//		}
	}
public void practice10_1() {
		// 로또 풀이 - 컬렉션 풀이, 코드 최적화!! 3 ~ 4 줄이면 로또 구현 완료
		// 코드 최적화지 성능, 메모리는 꽝!!!!!
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 45; i++) {
			list.add(i + 1);
		}
		Collections.shuffle(list); // 섞는 문법
		list = list.subList(0, 6); // 자르는 문법
		Collections.sort(list); // 정렬하는 방
		System.out.println(list);
	}
