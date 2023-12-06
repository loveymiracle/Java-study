package ex01.stack;

public class IntStack {
	int[] stack; 		// 스택용 배열
	int capacity;		// 스택의 용량(크기)
	int ptr; 			// 스택의 포인터 (가장 윗쪽을 가르침)
	
    //--- 실행시 예외: 스택이 비어있음 ---//
    public class EmptyIntStackException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public EmptyIntStackException() { }
    }

    //--- 실행시 예외: 스택이 가득 참 ---//
    public class OverflowIntStackException extends RuntimeException {
		private static final long serialVersionUID = 1L;
		public OverflowIntStackException() { }
    }
    
    public IntStack(int capacity) {
    	ptr = 0;
    	this.capacity = capacity;
    	stack = new int[capacity];
    }
    
    // 스택에 x값을 top에 넣는 방법
    public int push(int x) throws OverflowIntStackException{
    	if(ptr >= capacity) { // 스택이 가득 참
    		throw new OverflowIntStackException();
    	}
    	stack[ptr++] = x;
    	return x;
    }
    
    // top 값을 제거하는 방법
    public int pop() throws EmptyIntStackException{
    	if(ptr <= 0) { // 스택이 비어 있는 경우
    		throw new EmptyIntStackException();
    	}
    	return stack[--ptr];
    }
    
    // top 값을 보여주는 방법, 제거는 되지 않음!
    public int peek() throws EmptyIntStackException{
    	if(ptr <= 0) { // 스택이 비어 있는 경우
    		throw new EmptyIntStackException();
    	}
    	return stack[ptr-1];
    }
    
    // 스택을 비우는 방법
    public void clear() {
    	ptr = 0;
    }
    
    // 스택에서 x 값을 찾아 index로 반환하는 방법
    public int indexOf(int x) {
    	for(int i = ptr - 1; i >=0; i--) { // top부터 찾는 선형 검색
    		if(stack[i] == x) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    //--- 스택의 크기를 반환 ---//
    public int getCapacity() {
        return capacity;
    }

    
    //--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
    public int size() {
        return ptr;
    }

    //--- 스택이 비어있는가? ---//
    public boolean isEmpty() {
        return ptr <= 0;
    }

    //--- 스택이 가득 찼는가? ---//
    public boolean isFull() {
        return ptr >= capacity;
    }

    //--- 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시 ---//
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어있습니다.");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stack[i] + " ");
            System.out.println();
        }
    }
}
