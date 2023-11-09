public static void practice5() {
		// 문자열을 입력 받아 문자 하나하나를 배열에 넣고 검색할 문자가 문자열에 몇 개 들어가 있는지 개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력 하세요.
		String str = null;
		System.out.println("문자열 : ");
		str = sc.nextLine();
		System.out.println("문자 : ");
		char ch = sc.nextLine().charAt(0);
		
		char charArray[] = new char[str.length()];
		int index = -1;
		
		for(int i = 0; i < charArray.length; i++) {
			charArray[i] = str.charAt(i);
		}
		System.out.println(str + "에" + ch +"가 존재하는 위치(인덱스) : ");
		for(int j = 0; j < charArray.length; j++) {
			if(charArray[j] == ch) {
				System.out.print(j + " ");
				j++ ;
			}
		}
		System.out.println();
		System.out.println(ch + " 개수 : " + index);
	}
public static void practice5_1() {
		// 문자열을 입력 받아 문자 하나하나를 배열에 넣고 검색할 문자가 문자열에 몇 개 들어가 있는지 개수와 몇 번쨰 인덱스에 위치하는지 인덱스를 출력
		// 문자열 : application
		// 문자 : i
		// application에 i가 존재하는 위치(인덱스) : 4 8
		// i 개수 : 2
		System.out.println("문자열 : ");
		String str = sc.nextLine();
		
		System.out.println("문자 : ");
		char charValue = sc.nextLine().charAt(0);
		
		//str.length() : 문자열의 길이를 알아오는 메소드
		char array[] = new char[str.length()];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = str.charAt(i);
		}
//		System.out.println(Arrays.toString(array));
		System.out.println(str + "에 " + charValue + "가 존재하는 위치(인덱스) : ");
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == charValue) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println();
		System.out.println(charValue + " 개수 : " + count);
	}
	
