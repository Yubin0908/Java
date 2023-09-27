package com.lec.dto;

import java.sql.Timestamp;

public class BookDto {
	private int bid;
	private String btitle;
	private int bprice;
	private String bimg1;
	private String bimg2;
	private String bcontent;
	private int bdiscount;
	private Timestamp brdate;

	public BookDto() {}

	public BookDto(int bid, String btitle, int bprice, String bimg1, String bimg2, String bcontent, int bdiscount,
			Timestamp brdate) {
		this.bid = bid;
		this.btitle = btitle;
		this.bprice = bprice;
		this.bimg1 = bimg1;
		this.bimg2 = bimg2;
		this.bcontent = bcontent;
		this.bdiscount = bdiscount;
		this.brdate = brdate;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public String getBimg1() {
		return bimg1;
	}

	public void setBimg1(String bimg1) {
		this.bimg1 = bimg1;
	}

	public String getBimg2() {
		return bimg2;
	}

	public void setBimg2(String bimg2) {
		this.bimg2 = bimg2;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public int getBdiscount() {
		return bdiscount;
	}

	public void setBdiscount(int bdiscount) {
		this.bdiscount = bdiscount;
	}

	public Timestamp getBrdate() {
		return brdate;
	}

	public void setBrdate(Timestamp brdate) {
		this.brdate = brdate;
	}

	@Override
	public String toString() {
		return "BookDto [bid=" + bid + ", btitle=" + btitle + ", bprice=" + bprice + ", bimg1=" + bimg1 + ", bimg2="
				+ bimg2 + ", bcontent=" + bcontent + ", bdiscount=" + bdiscount + ", brdate=" + brdate + "]";
	}
	

	
}