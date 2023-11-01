package com.ezen.myProject.domain;

import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {

	private int cno;
	private int bno;
	private String writer;
	private String content;
	private String reg_date;
}
