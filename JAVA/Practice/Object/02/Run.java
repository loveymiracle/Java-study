package hw.practice2.run;

import hw.practice2.model.vo.Book;

public class Run {
	
	public static void main(String[] args) {
		Book book1 = new Book(); 
		Book book2 = new Book("해리포터와 비밀의방", "믿음사", "jk 롤링)");
		Book book3 = new Book("자바의정석", "A사", "남궁성", 40000, 0.5);
		
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(book3.toString());
		
	}

}
