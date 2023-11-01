package com.ezen.myproject.service;

import java.util.List;

import com.ezen.myproject.domain.BoardVO;
import com.ezen.myproject.domain.PagingVO;

public interface BoardService {

	int register(BoardVO bvo);

	List<BoardVO> getList(PagingVO pgvo);

	BoardVO getDetail(int bno);

	int getModify(BoardVO bvo);

	int getdelete(int bno);

	int getTotalCount(PagingVO pgvo);

	List<BoardVO> getPageList(PagingVO pgvo);

}
