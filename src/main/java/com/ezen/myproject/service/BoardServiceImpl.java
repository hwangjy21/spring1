package com.ezen.myproject.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ezen.myproject.domain.BoardVO;
import com.ezen.myproject.domain.PagingVO;
import com.ezen.myproject.repository.BoardDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
@Inject
private BoardDAO bdao;

@Override
public int register(BoardVO bvo) {
log.info("레지스터 등록 들어옴");
	return bdao.insert(bvo);
}

@Override
public List<BoardVO> getList(PagingVO pgvo) {
	// TODO Auto-generated method stub
	
	
	return bdao.getlist(pgvo);
}

@Override
public BoardVO getDetail(int bno) {
	
	//read_count+1

	log.info("디테일 서비스 들어옴");
	bdao.readCount(bno,1);
	return bdao.detail(bno);
}

@Override
public int getModify(BoardVO bvo) {
	//수정할 때 들어가는 부당 read_count 2개 빼주기
	//read_count-2
	bdao.readCount(bvo.getBno(),-2);
	return bdao.modify(bvo);
}

@Override
public int getdelete(int bno) {
	log.info("삭제 서비스 들어옴");
	return bdao.delete(bno);
}

@Override
public int getTotalCount(PagingVO pgvo) {
log.info("전체 갯수 세기 들어옴");
	return bdao.getTotalCount(pgvo);
}

@Override
public List<BoardVO> getPageList(PagingVO pgvo) {
	log.info("페이지 리스트 들어옴");
	return bdao.getPageList(pgvo);
}

}
