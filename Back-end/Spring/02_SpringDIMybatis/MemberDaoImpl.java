package com.mybatis.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.mybatis.member.model.vo.Member;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {

	@Override
	public int insertMember(SqlSessionTemplate session, Member member) {
		return session.insert("memberMapper.insertMember", member);
	}

	@Override
	public List<Member> selectMemberAll(SqlSessionTemplate session) {
		return session.selectList("memberMapper.selectMemberAll");
	}

	@Override
	public Member selectMemberById(SqlSessionTemplate session, String id) {
		return session.selectOne("memberMapper.selectMemberById", id);
	}

	@Override
	public int deleteMember(SqlSessionTemplate session, String id) {
		return session.delete("memberMapper.deleteMember", id);
	}

}
