package com.ezen.myproject.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ezen.myproject.domain.BoardVO;
import com.ezen.myproject.domain.PagingVO;

public interface BoardDAO {

	int insert(BoardVO bvo);

	List<BoardVO> getlist(PagingVO pgvo);

	BoardVO detail(int bno);

	void readCount(@Param("bno")int bno,@Param("cno")int cno);

	int modify(BoardVO bvo);

	int delete(int bno);

	int getTotalCount(PagingVO pgvo);

	List<BoardVO> getPageList(PagingVO pgvo);

}
