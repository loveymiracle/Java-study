package hw.practice3.run;

import hw.practice3.model.vo.Employee;

public class Run {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setEmpNo(10);
		e.setEmpName("홍길동");
		System.out.println(e);
	}
}
