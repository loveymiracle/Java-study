
// 파일구조에서 활용하는 것으로 추정 -> 유한한 데이터 공간을 가질때 의미가 있다.
// 오픈 주소법(Open addressing hashing)?
// - 해시값이 중복되는 경우, 해시값 다시 계산해서 중복을 해결하는 방법 
// - 단점 : 주소가 가득 찬 경우에는 더이상 Table을 채울수 없기도 하고, 재해싱 자체에 한계가 존재한다. 
//         -> 매우치명적인 단점이라 Chain hash가 주류가 되었다.
// -> 해당 코드는 재해싱으로 구현되어 있다.

public class OpenHash<K, V> {
    //--- 버킷의 상태 ---//
    enum Status {OCCUPIED, EMPTY, DELETED};    // {데이터 저장, 비어있음, 삭제 완료}

    //--- 버킷 ---//
    static class Bucket<K,V> {
        private K key;                    // 키값
        private V data;                   // 데이터
        private Status stat;              // 상태

        //--- 생성자(constructor) ---//
        Bucket() {
            stat = Status.EMPTY;    // 버킷이 비어있음
        }

        //--- 모든 필드에 값을 설정 ---//
        void set(K key, V data, Status stat) {
            this.key  = key;            // 키값
            this.data = data;           // 데이터
            this.stat = stat;           // 상태
        }

        //--- 상태를 설정 ---//
        void setStat(Status stat) {
            this.stat = stat;
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

    private int size;               // 해시 테이블의 크기
    private Bucket<K,V>[] table;    // 해시 테이블

    //--- 생성자(constructor) ---//
    public OpenHash(int size) {
        try {
            table = new Bucket[size];
            for (int i = 0; i < size; i++)
                table[i] = new Bucket<K,V>();
            this.size = size;
        } catch (OutOfMemoryError e) {        // 테이블을 생성할 수 없음
            this.size = 0;
        }
    }
    
    
    // 해시값 구하는 메소드
    public int hashValue(Object key) {
    	return key.hashCode() % size;
    }
    
    // 재해시값 구하는 메소드 
    public int rehashValue(int hash) {
    	return (hash + 1) % size;
    }

    //--- 키값 key를 갖는 버킷 검색 ---//
    private Bucket<K,V> searchNode(K key) {
        int hash = hashValue(key);            // 검색할 데이터의 해시값
        Bucket<K,V> p = table[hash];          // 주목 버킷

        for (int i = 0; p.stat != Status.EMPTY && i < size; i++) {
            if (p.stat == Status.OCCUPIED && p.getKey().equals(key))
                return p;
            hash = rehashValue(hash);         // 재해시
            p = table[hash];
        }
        return null;
    }

    //--- 키값이 key인 요소를 검색(데이터를 반환)---//
    public V search(K key) {
        Bucket<K,V> p = searchNode(key);
        if (p != null)
            return p.getValue();
        else
            return null;
    }
    
    // add : 새로운 key-value 셋을 table는 넣는 메소드
    public int add(K key, V data) {
    	if(search(key) != null) { // 동일한 키값이 있다면 
    		return 1;
    	}
    	
    	int hash = hashValue(key);
    	Bucket<K,V> p = table[hash];
    	for(int i = 0; i < size; i++) {
    		if(p.stat == Status.EMPTY || p.stat == Status.DELETED) {
    			p.set(key, data, Status.OCCUPIED); // 데이터 채워넣는 코드
    			return 0; // 정상적으로 삽입된 경우
    		}
    		hash = rehashValue(hash); // 재해시
    		p = table[hash]; // 다음 테이블을 찍는 코드
    	}
    	return 2; // 해시 테이블이 가득 찬 경우! -> 더이상 추가 못하고 돌아감
    }
    
    //--- 키값이 key인 요소를 삭제 ---//
    public int remove(K key) {
        Bucket<K,V> p = searchNode(key);    // 주목 버킷
        if (p == null)
            return 1;                       // 이 키값은 등록되어 있지 않음

        p.setStat(Status.DELETED);
        return 0;
    }

    //--- 해시 테이블을 덤프(dump) ---//
    public void dump() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%02d ", i);
            switch (table[i].stat) {
             case OCCUPIED : 
                System.out.printf("%s (%s)\n", 
                                        table[i].getKey(), table[i].getValue());
                break;

             case EMPTY :
                 System.out.println("-- 비어있음 --");    break;

             case DELETED :
                 System.out.println("-- 삭제 완료 --");    break;
            }
        }
    }
}
