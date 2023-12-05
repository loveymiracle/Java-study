package ex02.list;

import java.util.Comparator;

public class LinkedList<E> {
	// 노드, 향후 프로그래밍때는 Class 내부에 Class 선언 금기
	class Node<E>{
		E data;	// 데이터
		Node<E> next; // 다음 객체의 포인터(주소), 만일 다음이 없다면 null로 초기화
		
		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	Node<E> head;	// 최초 노드 포언터
	Node<E> crnt;	// 선택 포인터, current
	
	public LinkedList() {
		head = crnt = null;
	}
	
	// 머리노드 삽입
	public void addFirst(E obj) {
		Node<E> ptr = head; // 삽입 전에 노드
		head = crnt = new Node<E>(obj, ptr); // head를 새로운 값으로 초기화
	}
	
	// 꼬리노드 삽입
	public void addLast(E obj) {
		if(head == null) { // 리스가 비었을 때
			addFirst(obj);
		}else {
			Node<E> ptr = head;
			while(ptr.next != null) { // 끝까지 순회하는 방법
				ptr = ptr.next;
			}
			// 노드의 끝까지 도달 했을때
			ptr.next = crnt = new Node<E>(obj, null);
			// 마지막 노드의 next값은 새로운 값으로 초기화하는 방법
		}
	}
	
	// 노드 검색
	public E search(E obj, Comparator<E> c) { // obj = 검색할 객체, Comparator 비교시킬 알고리즘
		Node<E> ptr = head;
		
		while(ptr != null) {
			if(c.compare(obj, ptr.data) == 0) { // 일치, 검색 성공!
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next; // 뒤쪽 포인터로 교체 다음 탐색 시도
		}
		return null; // 검색 실패 상황
	}
	
	// 머리 노드 삭제
	public void removeFirst() {
		if(head != null) {
			head = crnt = head.next;
		}
	}
	
	// 꼬리 노드 삭제
	public void removeLast() {
		if(head == null) {
			return;
		}
		if(head.next == null) {
			removeFirst();
			return;
		}
		
		Node<E> ptr = head;	 // 현재 노드
		Node<E> prev = head; // 이전(앞쪽 노드), Previous
		
		while(ptr.next != null) {
			prev = ptr;
			ptr = ptr.next;
		}
		prev.next = null; // 마지막 노드 삭제
		crnt = prev;
	}
	
	
	// 특정 노드 삭제
	public void remove(Node p) {
		if(head == null) {
			return;
		}
		if(p == head) {
			removeFirst();
			return;
		}
		
		Node<E> ptr = head;
		while(ptr.next != p) {
			ptr = ptr.next;
			if(ptr == null) { // p가 리스트에 없는 경우
				return;
			}
		}
		ptr.next = p.next;
		crnt = ptr;
	}
	

    //--- 선택 노드 삭제 ---//
    public void removeCurrentNode() {
        remove(crnt);
    }

    //--- 전체노드 삭제 ---//
    public void clear() {
        while (head != null)        // 비게 될 때까지
            removeFirst();          // 머리 노드 삭제
        crnt = null;
    }

    //--- 선택 노드를 하나 뒤쪽으로 진행 ---//
    public boolean next() {
        if (crnt == null || crnt.next == null)
            return false;           // 나아갈 수 없음
        crnt = crnt.next;
        return true;
    }

    //--- 선택 노드 표시 ---//
    public void printCurrentNode() {
        if (crnt == null)
            System.out.println("주목노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    //--- 전체 노드 표시 ---//
    public void dump() {
        Node<E> ptr = head;

        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
