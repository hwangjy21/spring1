package com.ezen.myproject.service;

import com.ezen.myproject.domain.MemberVO;

public interface MemberService {

	int register(MemberVO mvo);

	MemberVO isUser(MemberVO mvo);

	int modify(MemberVO mvo);

}
