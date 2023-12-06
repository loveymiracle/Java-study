package ex02.queue;

public class IntQueue {
	int[] queue;		// 큐 배열
	int capacity;		// 큐의 크기
	int front;			// 큐의 시작점, 빠져 나가는 지점
	int rear;			// 큐의 끝, 삽입 지점
	int num;			// 현재 데이터 갯수
	
    //--- 실행시 예외 : 큐가 비어있음 ---//
    public class EmptyIntQueueException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public EmptyIntQueueException() { }
    }

    //--- 실행시 예외 : 큐가 가득 찼음 ---//
    public class OverflowIntQueueException extends RuntimeException {
    	private static final long serialVersionUID = 1L;
        public OverflowIntQueueException() { }
    }
    
    public IntQueue(int capacity) {
    	this.capacity = capacity;
    	queue = new int[capacity];
    }
    
    // 인큐 enque 데이터를 넣는 방법
    public int enque(int x) throws OverflowIntQueueException{
    	if(num >= capacity) {
    		throw new OverflowIntQueueException();
    	}
    	queue[rear++] = x;
    	num++;
    	if(rear == capacity) { // 원형큐로 동작하는 방법1
    		rear = 0;
    	}
		return x;
    }
    
    // 디큐 데이터를 빼는 방법
    public int deque() throws EmptyIntQueueException{
    	if(num <= 0) {
    		throw new EmptyIntQueueException();
    	}
    	int x = queue[front++];
    	num--;
    	if(front == capacity) { // 원형큐로 동작시키는 방법2
    		front = 0;
    	}
    	return x;
    }
    
    // 큐데이터 front 데이터를 보기만 하는 기능, 삭제는 안됨!!
    public int peek() throws EmptyIntQueueException{
    	if(num <= 0) {
    		throw new EmptyIntQueueException();
    	}
    	return queue[front];
    }
    
    // 큐 비우는 방법
    public void clear() {
    	num = front = rear = 0;
    }
    

    //--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;
            if (queue[idx] == x)                // 검색 성공
                return idx;
        }
        return -1;                            // 검색 실패
    }

    //--- 큐의 크기를 반환 ---//
    public int getCapacity() {
        return capacity;
    }

    //--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
    public int size() {
        return num;
    }

    //--- 큐가 비어있는가? ---//
    public boolean isEmpty() {
        return num <= 0;
    }

    //--- 큐가 가득 찼는가? ---//
    public boolean isFull() {
        return num >= capacity;
    }

    //--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
    public void dump() {
    	System.out.println("front : " + front);
    	System.out.println("rear : " + rear);
        if (num <= 0)
            System.out.println("큐가 비어있습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(queue[(i + front) % capacity] + " ");
            System.out.println();
        }
    }
    
}
