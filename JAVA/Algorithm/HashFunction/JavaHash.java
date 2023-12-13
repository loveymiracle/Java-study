import java.util.Arrays;

public class JavaHash {
	
	public static void main(String[] args) {
		String str1 = "홍길동";
		String str2 = "최길동"; 
		String str3 = "이길동"; 
		String str4 = "길길동"; 
		System.out.println(str1.hashCode()); 
		System.out.println(str2.hashCode()); 
		System.out.println(str3.hashCode()); 
		System.out.println(str4.hashCode()); 
		
//		HashMap<Integer, String> map = new HashMap<>();
//		map.put(str1.hashCode(), str1);
//		map.put(str2.hashCode(), str2);
		
		String[] hashTable = new String[10];
		hashTable[str1.hashCode() % hashTable.length] = str1;
		hashTable[str2.hashCode() % hashTable.length] = str2;
		hashTable[str3.hashCode() % hashTable.length] = str3;
		hashTable[str4.hashCode() % hashTable.length] = str4;
		
		System.out.println(Arrays.toString(hashTable));
		
		// 해쉬 알고리즘을 통해서 배열에 홍길동이 있는지 확인하는 방법
		// 시간복잡도 : O(1)!!! 빠른 알고리즘
		String name = "홍길동";
		System.out.println(hashTable[name.hashCode() % hashTable.length]);
		
		// 선형 탐색 알고리즘
		// 시간복잡도 : O(n) = 최악의 경우 끝까지 배열을 탐색해야하기 때문
		for(int i = 0; i < hashTable.length; i++) {
			if(name.equals(hashTable[i])) {
				System.out.println("찾았습니다!");
				System.out.println(hashTable[i]);
			}
		}
		
	}

}
