package com.ohalfmoon.jsp.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Reply {
	private Long rno;
	private String content;
	private Date regDate;
	private String writer;
	private Long bno;
	public Reply( String content , String writer, Long bno) {
		super();
//		this.rno = rno;
		this.content = content;
//		this.regDate = regDate;
		this.writer = writer;
		this.bno = bno;
	}
	
	
}

