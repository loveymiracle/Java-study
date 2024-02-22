package com.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.model.repository.MemberRepository;
import com.jpa.model.vo.Member;

@Service
public class MemberService {

	@Autowired
	private MemberRepository repo;

	public Optional<Member> login(String memberId, String password) {
		Member loginMember = repo.findByMemberId(memberId);
		if(loginMember != null && loginMember.getPassword().equals(password)) {
			return Optional.of(loginMember);
		}else {
			return Optional.empty();
		}
	}
	
	public List<Member> findAll() {
		return repo.findAll();
	}
	
	public long count() {
		return repo.count();
	}

	public Optional<Member> findByMno(int mno) {
		return repo.findById(mno);
	}
	
	public List<Member> findByName(String name) {
//		return repo.findByName(name);
//		return repo.findByNameLike(name);
		return repo.findByNameContaining(name);
	}

	public List<Member> findByNameAndAddress(String name, String address) {
		return repo.findByNameAndAddress(name, address);
//		return repo.searchByNameAndAddress(name, address);
//		return repo.searchByNameAndAddress2(name, address);
	}

	public List<Member> findByNameAndAddress2(String name, String address) {
		return repo.findByNameContainingAndAddressContaining(name, address);
	}
	
	public Member insert(Member member) {
		return repo.save(member);
	}
	
	public Member update(Member member) {
		return repo.save(member);
	}
	
	public boolean delete(int mno) {
		if(repo.existsById(mno) == false) {
			return false;
		}
		repo.deleteById(mno);
		return true;
	}
}
