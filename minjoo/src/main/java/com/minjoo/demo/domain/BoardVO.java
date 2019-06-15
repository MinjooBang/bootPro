package com.minjoo.demo.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private long bno;
	private String title;
	private String contents;
	private String writer;
	private Date regdate;
	private Date updatedate;
	
	private int replyCnt;

}
