package com.rest.content.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rest.content.model.vo.Cat;

// Pure REST(=json 유형과 동일한 객체를 보유하고 있을 때)페이지를 별다른 파싱 없이 변환 가능한 스킬 
public class RestTemplateTest {
	public static void main(String[] args) {
		RestTemplate rest = new RestTemplate();
		System.out.println("1. list 요청하기");
		Cat[] catArray = rest.getForObject("http://localhost/animal/cat", Cat[].class);
		if(catArray != null) {
			for(int i = 0; i < catArray.length; i++) {
				System.out.println(catArray[i].toString());
			}
		}
		System.out.println("---------------------------------------------------");
		

		System.out.println("2. 이름으로 list 요청하기");
		String name = "페르시안";
		catArray = rest.getForObject("http://localhost/animal/cat?name="+name, Cat[].class);
		if(catArray != null) {
			for(int i = 0 ; i< catArray.length; i++) {
				System.out.println(catArray[i].toString());
			}
		}
		System.out.println("--------------------------------------------------------");
		
		System.out.println("3. id로 요청하는 방법");
		Map<String, String> map = new HashMap<String, String>();
		map.put("animalName", "cat");
		map.put("id", "3");
		
		Cat cat = rest.getForObject("http://localhost/animal/{animalName}/{id}", Cat.class, map);
		if(cat != null) {
			System.out.println(cat);
		}
		System.out.println("--------------------------------------------------------");
		
		System.out.println("4. insert 하기");
		cat.setName("호랑이");
		ResponseEntity<Cat> result = rest.postForEntity("http://localhost/animal/cat", cat, Cat.class);
		HttpStatusCode status = result.getStatusCode();
		Cat cat2 = result.getBody();
		System.out.println("status : " + status.value());
		System.out.println("cat2 : " + cat2);
		System.out.println("--------------------------------------------------------");
		
		System.out.println("5. update 하기");
		cat2.setName("모르는 고양이222");
		rest.put("http://localhost/animal/cat/{id}", cat2, cat2.getId()); // update
		Cat updateCat = rest.getForObject("http://localhost/animal/cat/{id}", Cat.class, cat2.getId());
		System.out.println(updateCat);
		System.out.println("-------------------------------------------\n");
		
		
		System.out.println("6. delete 하기");
		rest.delete("http://localhost/animal/cat/{id}", cat2.getId());
		ResponseEntity<Cat> result2 = rest.getForEntity("http://localhost/animal/cat/{id}", Cat.class, cat2.getId());
		HttpStatusCode status2 = result2.getStatusCode();
		System.out.println(status2.value());
		System.out.println("-------------------------------------------\n");
	}

}
