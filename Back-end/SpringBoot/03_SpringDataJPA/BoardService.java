package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpa.model.repository.BoardRepository;
import com.jpa.model.vo.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository repo;
	
	public List<Board> findAllSortByBnoDesc() {
//		return repo.findFirstByOrderByBnoDesc();
		// Sort 객체 사용방법
		Sort sort = Sort.by("bno").descending();
		return repo.findAll(sort);
	}
	
	// 2단 정렬하는 방법
	public List<Board> findAllSortByTitleAndSortByContent() {
		Sort sort = Sort.by("title").descending().and(Sort.by("content").ascending());
		return repo.findAll(sort);
	}
	
	// page는 0부터 시작한다.
	public Page<Board> findAllByPaging(int page, int pageSize) {
		Sort sort = Sort.by("bno").descending();
		PageRequest request = PageRequest.of(page, pageSize, sort);
		return repo.findAll(request);
	}
	
	
	public Page<Board> findByTitle(String title, int page, int pageSize) {
		Sort sort = Sort.by("bno").descending();
		PageRequest request = PageRequest.of(page, pageSize, sort);
		return repo.findByTitleContaining(title, request);
	}
	
	public Page<Board> findByTitleAndContent(String title, String content, int page, int pageSize){
		Sort sort = Sort.by("bno").descending();
		PageRequest request = PageRequest.of(page, pageSize, sort);
		return repo.findByTitleContainingAndContentContaining(title, content, request);
	}
	
	public Page<Board> findByTitleAndContentAndMemberId(String title, String content, String memberId, int page, int pageSize){
		Sort sort = Sort.by("bno").descending();
		PageRequest request = PageRequest.of(page, pageSize, sort);
		return repo.findByTitleContainingAndContentContainingAndMember_MemberIdContaining(title, content, memberId, request);
	}
	
	public List<Board> findByTitle1(String title){
		return repo.searchByTitle("%"+title+"%");
	}
	
	public List<Board> findByTitle2(String title){
		return repo.searchByTitle2("%"+title+"%");
	}
	
	public long count() {
		return repo.count();
	}
}
