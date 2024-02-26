package com.mybatis.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.mybatis.member.model.vo.Member;

// 예시적인 admin Member dao로 실제 admin 관리가 다른 DB에서 이뤄진다는 전제일 때
@Repository("adminMemberDao")
public class MemberAdminDaoImpl implements MemberDao {

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
