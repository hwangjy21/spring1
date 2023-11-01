package com.ezen.myProject.service;

import java.util.List;

import com.ezen.myProject.domain.CommentVO;

public interface CommentService {

	int post(CommentVO cvo);

	List<CommentVO> getList(int bno);

	int edit(CommentVO cvo);

	int remove(int cno);

}
