package com.jpa.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpa.model.vo.Member;

// 이전 구조로 DAO에 해당되는 객체

// JpaRepository<T, ID> : T는 Repository 사용할 Class Type, ID는 PK의 Type
public interface MemberRepository extends JpaRepository<Member, Integer> {

	/*
	  기본적으로 제공되는 crud 기능 메소드들
	  <S extends T> S save(S entity); // insert or update, key값이 있는지 확인한 뒤 선택
	  Optional<T> findById(ID primaryKey);  // Int type의 PK(mno) id로 찾아오기 
	  Iterable<T> findAll(); // 전체 객체 가져오기   
	  long count(); // 현재 갯수 
	  void delete(S id); // 삭제              
	  boolean existsById(ID primaryKey); // id 존재 여부   
	  ... 기본적인 CRUD를 쿼리 제공해줌
	 */
	
	// Query Methods 생성법
	// https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	
	// findByXXX : select + where절
	// select * from member where name = '홍길동'
	List<Member> findByName(String name); // sql 대신 query method 생성하는 방법
	// select * from member where name like '홍길'
	List<Member> findByNameLike(String name); // like절만 완성
	// select * from member where name like '%홍길%'
	List<Member> findByNameContaining(String name); // Containing은 like + %파라미터%
	// select * from member where name in ('길동', '홍길' ... )
	List<Member> findByNameIn(List<String> nameList); // Containing은 like + %파라미터%
	// select * from member where memberId = 'test1'
	Member findByMemberId(String memberId);
	
	// and or절 실습
	List<Member> findByNameAndAddress(String name, String address);
	List<Member> findByNameContainingOrAddressContaining(String name, String address);
	List<Member> findByNameContainingAndAddressContaining(String name, String address);
	
	// countByXXX : 갯수를 세어오는 메소드
	long countByName(String name);
	
	// deleteByXXX
	long deleteByName(String name);
	
	
	// @Query 어노테이션을 통해 Query를 직접 입력하는 방법도 존재한다. -> 여기서 쿼리는 JPQL이다.
	// nativeQuery 옵션으로 nativeQuery 작성 가능
	// JPQL 활용 - DB 종속 없는 쿼리 작성
	// https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query.spel-expressions
	// https://taegyunwoo.github.io/jpa/JPA_ObjectQuery_Begin
	// https://taegyunwoo.github.io/jpa/JPA_ObjectQuery_JPQL_Join
	
	// JPQL을 따르는 쿼리
	// search로 시작함으로 Query Methods에 해당하지 않는 코드
	@Query(value = "select m from Member m "
					+ "	where name like :name and address like :address "
					+ "	order by mno desc")
	List<Member> searchByNameAndAddress(@Param(value="name")String name, 
											@Param(value = "address") String address);
	
	// Mysql - SQL을 따르는 쿼리 (nativeQuery)
	// search로 시작함으로 Query Methods에 해당하지 않는 코드
	@Query(value = "select * from Member "
			+ "	where name like :name and address like :address "
			+ "	order by mno desc", nativeQuery = true)
	List<Member> searchByNameAndAddress2(@Param(value="name")String name, 
			@Param(value = "address") String address);
}
