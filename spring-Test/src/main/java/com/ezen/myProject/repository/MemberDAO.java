package com.ezen.myProject.repository;

import com.ezen.myProject.domain.MemberVO;

public interface MemberDAO {

	MemberVO getUser(String id);

	int insert(MemberVO mvo);

	int update(MemberVO mvo);

}
