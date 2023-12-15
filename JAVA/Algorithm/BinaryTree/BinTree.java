import java.util.Comparator;

// 이진 검색 트리
public class BinTree<K, V> {
	static class Node<K, V> {
		private K key; // 키 값
		private V data; // 데이터 값
		private Node<K, V> left; // 왼쪽 자식
		private Node<K, V> right; // 오른쪽 자식

		// --- 생성자(constructor) ---//
		Node(K key, V data, Node<K, V> left, Node<K, V> right) {
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}

		// --- 키값을 반환 ---//
		K getKey() {
			return key;
		}

		// --- 데이터를 반환 ---//
		V getValue() {
			return data;
		}

		// --- 데이터를 표시 ---//
		void print() {
			System.out.println(data);
		}
	}
	
	private Node<K, V> root; // 루트 최상위 부모
	private Comparator<? super K> comparator = null; // 비교 알고리즘을 외부에서 주입 할 예정


    //--- 생성자(constructor) ---//
    public BinTree() {
        root = null;
    }

    //--- 생성자(constructor) ---//
    public BinTree(Comparator<? super K> c) {
        this();
        comparator = c;
    }

    //--- 두 키값을 비교 ---//
    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2)
                                    : comparator.compare(key1, key2);
    }

	// 키로 탐색하는 로직
    // 큰값은 오른쪽, 작은값은 왼쪽에 삽입되어 있다는 전제
    public V search(K key) {
    	Node<K,V> p = root; // 루트가 시작점
    	while(true) {
    		if (p == null) 
    			return null;
    		int cond = comp(key, p.getKey()); // 키가 같으면 0, 작으면 -1, 크면 + 1
    		if(cond == 0)  // 값을 찾은 경우
    			return p.getValue();
    		else if(cond < 0) 
    			p = p.left;	 // 작으면 왼쪽 트리로 탐색
    		else 
    			p = p.right;  // 큰경우 오른쪽 트리로 탐색
    	}
    }
	
    // node를 뿌리로하는 서브트리에 node를 넣는 메소드 -> 재귀로 구성
    private void addNode(Node<K,V> node, K key, V data) {
    	int cond = comp(key, node.key);
    	if(cond == 0) { // 같이 이미 존재할때
    		return;
    	} else if(cond < 0) { // key값이 작을 때 -> 왼쪽 서브트리에서 삽입하거나 탐색필요
    		if(node.left == null)
    			node.left = new Node<K,V>(key, data, null, null);
    		else
    			addNode(node.left, key, data);
    	} else { // key값이 클 때 -> 오른쪽 서브트리에서 삽입하거나 탐색필요
    		if(node.right == null)
    			node.right = new Node<K,V>(key, data, null, null);
    		else
    			addNode(node.right, key, data);
    	}
    }
	
    //--- 노드 삽입 ---//
    public void add(K key, V data) {
        if (root == null)
            root = new Node<K,V>(key, data, null, null);
        else
            addNode(root, key, data);
    }
	

    //--- 키값이 key인 노드를 삭제 --//
    public boolean remove(K key) {
        Node<K,V> p = root;                    // 스캔 중인 노드
        Node<K,V> parent = null;               // 스캔 중인 노드의 부모노드
        boolean isLeftChild = true;            // p는 parent의 왼쪽 자식노드인가?

        while (true) {
            if (p == null)                           // 더 이상 나아갈 수 없으면
                return false;                        // …그 키값은 존재하지 않음
            int cond = comp(key, p.getKey());        // key와 노드 p의 키값을 비교
            if (cond == 0)                           // 같으면
                break;                               // …검색 성공
            else {
                parent = p;                          // 가지로 내려가기 전에 부모를 설정
                if (cond < 0) {                      // key 쪽이 작으면
                    isLeftChild = true;              // …왼쪽의 자식으로 내려감
                    p = p.left;                      // …왼쪽 서브트리에서 검색
                } else {                             // key 쪽이 크면
                    isLeftChild = false;             // …오른쪽의 자식으로 내려감
                    p = p.right;                     // …오른쪽 서브트리에서 검색
                }
            }
        }

        if (p.left == null) {                         // p에 왼쪽의 자식이 없음
            if (p == root)                     
                root = p.right;
            else if (isLeftChild)
                parent.left  = p.right;                    // 부모의 왼쪽 포인터가 오른쪽 자식을 가리킴
            else
                parent.right = p.right;                    // 부모의 오른쪽 포인터가 오른쪽 자식을 가리킴
        } else if (p.right == null) {                      // p에 오른쪽 자식이 없음…
            if (p == root)
                root = p.left;
            else if (isLeftChild)
                parent.left  = p.left;                    // 부모의 왼쪽 포인터가 왼쪽 자식을 가리킴
            else
                parent.right = p.left;                    // 부모의 오른쪽 포인터가 왼쪽 자식을 가리킴
        } else {
            parent = p;
            Node<K,V> left = p.left;                     // 서브트리 가운데 최대 노드
            isLeftChild = true;
            while (left.right != null) {                 // 최대 노드의 left를 검색
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            p.key  = left.key;                           //  left의 키값을 p로 이동
            p.data = left.data;                          //  left의 데이터를 p로 이동
            if (isLeftChild)
                parent.left  = left.left;                // left를 삭제
            else
                parent.right = left.left;                // left를 삭제
        }
        return true;
    }

    //--- node를 루트로 하는 서브트리의 노드를 키값의 오름차순으로 표시 ---//
    //  -> 중위 탐색
    private void printSubTree(Node node) {
        if (node != null) {
            printSubTree(node.left);                            // 왼쪽 서브트리를 키값의 오름차순으로 표시
            System.out.println(node.key + " " + node.data);     // node를 표시
            printSubTree(node.right);                           // 오른쪽 서브트리를 키값의 오름차순으로 표시
        }
    }

    //--- 전체 노드를 키값의 오름차순으로 표시 ---//
    public void print() {
        printSubTree(root);
    }
}
