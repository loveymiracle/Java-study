정렬 알고리즘 손으로 구현해보기 - 버블정렬
		// sort 사용 권장!!
		for(int i = 0; i < array.length; i++) {
			for(int j = i; j < array.length; j++) {
				if(array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
