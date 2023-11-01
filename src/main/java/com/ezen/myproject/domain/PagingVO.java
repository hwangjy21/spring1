package com.ezen.myproject.domain;


import lombok.Getter;

import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class PagingVO {
 private int pageNO; //현재 화면에 출력되는 페이지네이션 번호
 private int qty; // 한 페이지당 보여지는 게시글 수(10개)
 
 private String type; //검색 타입
  
 private String keyword; //검색어

public PagingVO() {
this(1,10);
}
 
public PagingVO(int pageNO, int qty) {
// 페이지 생성자
	this.pageNO = pageNO;
	this.qty = qty;
}

public int getPageStart() {
	
	//DB상에서 limit의 시작값을 구하는 메서드
	//limit는 0부터 시작 10개씩. limit 0,10
	
	return (this.pageNO-1)*qty;
}

//여러가지 타입을 같이 검색하기 위해서 타입을 배열로 구분
public String[] getTypeArray() {
	return this.type == null? new String[]{} :this.type.split("");
}
 
}
