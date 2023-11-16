package com.lec.ch16e.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Board {
	private int bid;
	private String bname;
	private String btitle;
	private String bcontent;
	private String bimg;
	private Date bdate;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bip;
	private int startRow;
	private int endRow;
}
