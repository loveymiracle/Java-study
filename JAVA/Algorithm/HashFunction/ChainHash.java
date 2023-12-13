
// Java - HashMap 구성되어 있는 방법 ★★★★★
// 체인법에 의한 해시 구성 코드
// 해시체인 기법 : Closed addressing hashing -> 주소를 다시 계산하지 않는 기법
//             key가 중복되는 경우 linkedList 연결한다.
// 단점 : hashTable을 많이 사용하는 경우 중복에 의해서 알고리즘 성능이 O(n)으로 떨어진다.
//       -> 그럴일 없다. 몇 억개(DB로 넘어가야 하는 숫자)가 있어도 평균적으로 O(2)정도로 떨어진다.

public class ChainHash<K,V> {
	 //--- 해시를 구성하는 노드 ---//
    class Node<K, V> {
        private K key;                 // 키값
        private V data;                // 데이터
        private Node<K,V> next;        // 뒤쪽 포인터(뒤쪽 노드에 대한 참조)

        //--- 생성자(constructor) ---//
        Node(K key, V data, Node<K,V> next) {
            this.key  = key;
            this.data = data;
            this.next = next;
        }

        //--- 키값을 반환 ---//
        K getKey() {
            return key;
        }

        //--- 데이터를 반환 ---//
        V getValue() {
            return data;
        }

        //--- 키의 해시값을 반환 ---//
        public int hashCode() {
            return key.hashCode();
        }
    }
    
    int size; 		   // 해시 테이블 크기
    Node<K,V>[] table; // 해시 테이블
    
    
    public ChainHash(int capacity) {
    	table = new Node[capacity];
    	this.size = capacity;
	}
    
    public int hashValue(Object key) {
    	return key.hashCode() % size; // 계산된 해시값을 table의 크기로 잘라주는 연산
    }
    
    // 키값을 통해 요소를 검색하는 방법 get
    public V search(K key) {
    	int hash = hashValue(key);  // key 해시값 계산
    	Node<K,V> p = table[hash];  // table에서 저장되어있던 값을 가져오는데,

    	// 값이 중복된 경우 next node를 통해서 key값과 일치하는 node 찾는 방법
    	while(p != null) { 
    		if(p.getKey().equals(key)) // 일치하는 값을 찾은 경우! 
    			return p.getValue();
    		p = p.next; // 다음 노드 탐색
    	}
    	return null; // 값을 못찾은 경우
    }
    
    
    // add : 값을 넣는 방법, put(Key, Value)
    public int add(K key, V data) {
    	int hash = hashValue(key);
    	Node<K,V> p = table[hash]; // 중복이 되는 경우 탐색해서 꼬리에 넣어야함으로 찾아옴
    	
    	while(p != null) {
    		if(p.getKey().equals(key)) {
    			// 중복된 경우 값을 다시 넣지 않고 기존값 유지
    			// HashMap 과는 다른 설계로 구성됨 -> 덮어쓰기
    			return 1;
    		}
    		p = p.next;
    	}
    	// 노드를 끝까지 탐색 한 곳
    	Node<K,V> temp = new Node<K, V>(key, data, table[hash]);
    	table[hash] = temp;
    	return 0;
    }
    
    // remove, key를 통해서
    public int remove(K key) {
    	int hash = hashValue(key);
    	Node<K,V> p = table[hash]; // chain의 첫번째 포인터
    	Node<K,V> pp = null; 	   // 앞노의 포인터
    	
    	while(p != null) {
    		if (p.getKey().equals(key)) { // 찾은 경우
    			if(pp == null) 
    				table[hash] = p.next;
    			else
    				pp.next = p.next;
    			return 0;
    		}
    		pp = p;
    		p = p.next; // 다음 노드로 이동
    	}
    	return 1; // 찾는 키가 없는 경우
    }
    
    //--- 해시 테이블을 덤프(dump) ---//
    public void dump() {
        for (int i = 0; i < size; i++) {
            Node<K,V> p = table[i];
            System.out.printf("%02d  ", i);
            while (p != null) {
                System.out.printf("→ %s (%s)  ", p.getKey(), p.getValue());
                p = p.next;
            }
            System.out.println();
        }
    }
}
