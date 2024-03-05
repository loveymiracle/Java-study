package com.multi.bbs.board.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.multi.bbs.board.model.vo.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
	// Query Methods 생성법
	// https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	
	// join 되는 경우 TableName_ColumnName 형식으로 들어가야한다.
	List<Board> findByTitleContainingAndContentContainingAndMember_MemberIdContaining(String title, String content, String member_MemberId, Pageable pageable);
	int countByTitleContainingAndContentContainingAndMember_MemberIdContaining(String title, String content, String member_MemberId);
	
	List<Board> findByTitleContainingAndContentContainingAndMember_MemberIdContainingAndBoardCategory_typeIn(String title, String content, String member_MemberId, List<String> BoardCategory_types, Pageable pageable);
	int countByTitleContainingAndContentContainingAndMember_MemberIdContainingAndBoardCategory_typeIn(String title, String content, String member_MemberId, List<String> BoardCategory_types);
	
	
	// JPQL 활용 - DB 종속 없는 쿼리 작성
	// https://taegyunwoo.github.io/jpa/JPA_ObjectQuery_Begin
	// https://taegyunwoo.github.io/jpa/JPA_ObjectQuery_JPQL_Join
	@Query("select b from Board b "
			+ " join b.member m WHERE m.memberId like :memberId "
			+ " ORDER BY b.bno DESC LIMIT :limit OFFSET :offset")
	List<Board> findByMemberIdContaining(@Param("memberId") String memberId, @Param("limit") int limit,@ Param("offset") int offset );
	
	@Query("select count(*) from Board b "
			+ " join b.member m where m.memberId like :memberId")
	int countByMemberIdContaining(@Param("memberId") String memberId);
	
	// CriteriaQuery 사용
	// https://coding-start.tistory.com/90
	// 복잡한 쿼리를 작성하기 위해 Specification에 조건을 추가할 예정
	List<Board> findAll(Specification<Board> spec, Pageable pageable);
	int count(Specification<Board> spec);
}
