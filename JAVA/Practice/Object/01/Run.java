package hw.practice1.run;

import hw.practice1.model.vo.Product;

public class Run {
	public static void main(String[] args) {
		Product p = new Product();
		p.setpName("로지텍 키보드");
		p.setBrand("로지텍");
		p.setPrice(100000);
		System.out.println(p.toString());
		System.out.println(p); // toString이 생략된 문법
	}

}
