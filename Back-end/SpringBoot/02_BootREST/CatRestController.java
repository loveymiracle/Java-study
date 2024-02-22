package com.rest.content.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.content.model.vo.Cat;
import com.rest.content.service.CatService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;

//@RestController : Rest 요청을 받는 Controller로 지칭하는 어노테이션,
//	무조건 REST 방식(=View를 사용하지 않음)으로 요청과 응답을 처리한다.
//Handler method의 ResponseBody가 자동으로 붙는다.
//Controller로 해도 기능상 문제는 없다.
//@RequestMapping : 최상위 리소스를 지칭하는 url, 현재는 cat(고양이) 정보만 다루는 REST로 가정

// postman : https://binit.tistory.com/17

//Swagger-ui : https://velog.io/@gmlstjq123/SpringBoot-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8%EC%97%90-Swagger-UI-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0

@Tag(name = "Cat Rest API", description = "Cat에 대한 정보를 제공합니다.")
// 아래 get,post 어노테이션에 'localhost/animal/cat' 주소를 생략할 수 있는 어노테이션
@RequestMapping("/animal/cat")
@RestController
public class CatRestController {
	
	@Autowired
	private CatService service;
	
	// 생성되고 나서
	@PostConstruct
	public void initPostConstruct() {
		System.out.println("@PostConstruct");
	}
	
	@Operation(summary = "cat 전체를 조회하거나 name으로 조회 가능", description = "인자가 없으면, 전체, 고양이의 이름으로 조회할 수 있습니다. 이름이 없는 경우 리턴값이 없습니다.")
	// 보안상 코드 다른 주소로부터 Ajax 요청을 거부하는 방법
	@CrossOrigin(origins = "http://localhost", maxAge = 3000)
	@GetMapping("") //@GetMapping("/animal/cat") 이지만 requestmapping에서 할당 , @GetMapping : REST에서 read할 때 사용하는 어노테이션
	public ResponseEntity<List<Cat>> getCatAllInfo(
			@RequestParam(name = "name", required = false) String name
			){
		if(name == null) {
			List<Cat> list = service.selectAll();
			return ResponseEntity.status(HttpStatus.OK).body(list);
		} else {
			List<Cat> list = service.selectByName(name);
			if(list.size() != 0) {
				return ResponseEntity.status(HttpStatus.OK).body(list);
			} else {
				return ResponseEntity.status(HttpStatus.OK).body(list);
			}
		}
	}
	
	@Operation(summary = "id로 조회하는 핸들러 메소드", description = "id를 path로 입력하세요. ex) /animal/cat/{id}")
	@CrossOrigin(origins = "http://localhost", maxAge = 3000)
	// /animal/cat/{id}
	@GetMapping("/{id}")
	public ResponseEntity<Cat> getCatAllInfo(@PathVariable("id") int id){
		Cat cat = service.selectById(id);
		if(cat != null) {
			return ResponseEntity.status(HttpStatus.OK).body(cat);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@CrossOrigin(origins = "http://localhost", maxAge = 3000)
	@PostMapping("/form") // create 전용, 쓰기 용도
	// -> HTML에서 form으로 받을 때 쓰는 방식! REST에서는 올바르지 않은 방식!
	public ResponseEntity<Cat> createCatForHtmlForm(Cat requestCat){
		int result = service.insertCat(requestCat);
		if(result > 0) {
			Cat cat = service.selectById(requestCat.getId()); 
			return ResponseEntity.status(HttpStatus.OK).body(cat);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	// @RequestBody : json으로 구성되어 있는 요청 값을 객체로 변환하는 어노테이션, 언마샬링 전용
	@CrossOrigin(origins = "http://localhost", maxAge = 3000)
	// POST : /animal/cat/{id}
	@PostMapping("") // create 전용, 쓰기 용도
	public ResponseEntity<Cat> createCat(@RequestBody Cat requestCat){
		int result = service.insertCat(requestCat);
		if(result > 0) {
			Cat cat = service.selectById(requestCat.getId());
			return ResponseEntity.status(HttpStatus.OK).body(cat);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@CrossOrigin(origins = "http://localhost", maxAge = 3000)
	// PUT : /animal/cat/
	@PutMapping("/{id}") // put : update 할 때 사용하는 어노테이션
	public ResponseEntity<Cat> updateCat(
			@PathVariable("id") int id, @RequestBody Cat requestCat){
		requestCat.setId(id);
		Cat cat = service.updateCat(requestCat);
		if(cat != null) {
			return ResponseEntity.status(HttpStatus.OK).body(cat);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@CrossOrigin(origins = "http://localhost", maxAge = 3000)
	// DELETE : /animal/cat/{id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Cat> deleteCat(@PathVariable("id") int id) {
		Cat cat = service.selectById(id);
		int result = service.deleteCat(id);
		if(result > 0) {
			return ResponseEntity.status(HttpStatus.OK).body(cat);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

}
