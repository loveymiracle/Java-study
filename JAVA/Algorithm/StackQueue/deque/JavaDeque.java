package ex03.deque;

import java.util.Deque;
import java.util.LinkedList;

public class JavaDeque {

	public static void main(String[] args) {
		Deque<Integer> deque = new LinkedList<>();
		deque.add(1);
		deque.add(2);
		deque.add(3);
		deque.add(4);
		deque.add(5);
		
		//deque를 Stack으로 활용할때
		while(!deque.isEmpty()) {
			System.out.println(deque.removeLast());
		}
		System.out.println("----------------------------------");
		
		deque.add(1);
		deque.add(2);
		deque.add(3);
		deque.add(4);
		deque.add(5);
		
		//deque를 queue으로 활용할때
		while(!deque.isEmpty()) {
			System.out.println(deque.removeFirst());
		}
	}
}
