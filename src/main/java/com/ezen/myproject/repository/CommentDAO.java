package com.ezen.myproject.repository;

import java.util.List;

import com.ezen.myproject.domain.CommentVO;

public interface CommentDAO {

	int insert(CommentVO cvo);


	int update(CommentVO cvo);


	int delete(int cno);


	List<CommentVO> getList(int bno);


	CommentVO getDetail_c(int cno);

}
