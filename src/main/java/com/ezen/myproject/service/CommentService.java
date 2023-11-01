package com.ezen.myproject.service;

import java.util.List;

import com.ezen.myproject.domain.CommentVO;

public interface CommentService {

	int post(CommentVO cvo);

	List<CommentVO> getlist(int bno);

	int edit(CommentVO cvo);

	int getdelete(int cno);

	CommentVO getDetail_c(int bno);

}
