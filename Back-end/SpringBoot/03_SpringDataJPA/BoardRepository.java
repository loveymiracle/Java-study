package com.jpa.model.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jpa.model.vo.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	// Query Methods 생성법
	// https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

	// 정렬기능 구현하는 방법
	// https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	// -> OrderBy 절 참고
	List<Board> findFirstByOrderByBnoDesc();
	List<Board> findTopByOrderByTitleDesc();
	// 2단 정렬 안된다!
//	List<Board> findAllOrderByTitleAndOrderByContent();
	
	// Paging and Sorting
	// -> page처리와 2단 정렬 이상의 복잡한 정렬도 가능한 방법
	// https://docs.spring.io/spring-data/jpa/reference/repositories/query-methods-details.html#repositories.special-parameters
	
	// 정렬을 지원하는 인자 = Sort
	List<Board> findAll(Sort sort);
	
	// 페이징 기능 + 정렬 = Pageable
	// Page 페이징 처리가 된 데이터도 물어서 전달해주는 객체
	Page<Board> findAll(Pageable pageable);

	// Title 검색(like+'%아이폰%') + 페이징 처리
	Page<Board> findByTitleContaining(String title, Pageable pageable);
	
	// Title + content 검색 (Containing) + 페이징 처리
	Page<Board> findByTitleContainingAndContentContaining(String title, String content, Pageable pageable);
	Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
	
	// Title + content + MemberID (Join된 결과 같이 검색) + 페이징 처리
	// Join이 필요한 경우 TableName_ColumnName 형식으로 들어가야한다.
	Page<Board> findByTitleContainingAndContentContainingAndMember_MemberIdContaining(String title, String content, String member_MemberId, Pageable pageable);
	int countByTitleContainingAndContentContainingAndMember_MemberIdContaining(String title, String content, String member_MemberId);

	
	// JPQL 활용 - DB 종속 없는 쿼리 작성
	// https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query.spel-expressions
	// https://taegyunwoo.github.io/jpa/JPA_ObjectQuery_Begin
	// https://taegyunwoo.github.io/jpa/JPA_ObjectQuery_JPQL_Join
	// JPQL을 사용하는 경우 Member와 같이 카멜 잘 지켜야한다.
	// -> build가 안되면 JPQL의 오류가 존재한다.
	@Query("select b from Board b "
			+ "join b.member m "
			+ "where b.title like :title "
			+ "order by b.bno desc ")
	List<Board> searchByTitle(@Param("title") String title);
	
	
	// -> nativeQuery인 경우는 오류가 발생해도 잡아주지 않는다!
	@Query(value = "SELECT B.*, M.* FROM BOARD B "
			+ "join Member M on B.member_mno = M.mno "
			+ "WHERE B.title like :title ORDER BY B.bno DESC", nativeQuery = true)
	List<Board> searchByTitle2(@Param("title") String title);
}














