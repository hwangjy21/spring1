package com.ezen.myproject.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ezen.myproject.domain.CommentVO;
import com.ezen.myproject.repository.CommentDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

	@Inject
	private CommentDAO cdao;

	@Override
	public int post(CommentVO cvo) {
		// TODO Auto-generated method stub
		return cdao.insert(cvo);
	}

	@Override
	public List<CommentVO> getlist(int bno) {
		// TODO Auto-generated method stub
		return cdao.getList(bno);
	}

	@Override
	public int edit(CommentVO cvo) {

		return cdao.update(cvo);
	}

	@Override
	public int getdelete(int cno) {
		
		return cdao.delete(cno);
	}

	@Override
	public CommentVO getDetail_c(int cno) {
		// TODO Auto-generated method stub
		return cdao.getDetail_c(cno);
	}
}
