package com.ezen.myproject.handler;

import com.ezen.myproject.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class PagingHandler {
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int totalCount;
	private PagingVO pgvo;

public PagingHandler(PagingVO pgvo, int totalCount) {
	this.pgvo = pgvo;
	this.totalCount = totalCount;
	//1 2 3 ... 10 =>10 / pageNO 1~10까지는 endpage가 10
	//11 12 ...20 => 20 /pageNO 11~20까지는 endpage가 20...
	this.endPage = (int)Math.ceil(pgvo.getPageNO()/(double)pgvo.getQty())*pgvo.getQty();
	this.startPage= endPage-9;
	// endPage는 10,20,30... 형식으로만 구성.
	//realEndPage 실제 마지막 페이지...

	int realEndPage = (int)Math.ceil(totalCount/(double)pgvo.getQty());
	if(realEndPage< this.endPage) {
		this.endPage = realEndPage;
	}
	//startPage : 1, 11,21 ....
	this.prev = this.startPage>1;
	this.next =this.endPage<realEndPage;
	
}
}
