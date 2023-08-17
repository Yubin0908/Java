package com.lec.ex3supermarket;

//CID, CTEL, CNAME, POINT, CAMOUNT, LEVELNAME, FORLEVELUP
public class CustomerDto {

	private int cid;
	private String ctel;
	private String cname;
	private int point;
	private int camount;
	private String levelname;
	private int forlevelup;

	public CustomerDto(int cid, String ctel, String cname, int point, int camount, String levelname, int forlevelup) {
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.point = point;
		this.camount = camount;
		this.levelname = levelname;
		this.forlevelup = forlevelup;
	}

	@Override
	public String toString() {
		return cid + "\t" + ctel + "\t" + cname + "\t" + point + "\t" + camount + "\t" + levelname + "\t" + forlevelup;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCtel() {
		return ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getCamount() {
		return camount;
	}

	public void setCamount(int camount) {
		this.camount = camount;
	}

	public String getLevelname() {
		return levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	public int getForlevelup() {
		return forlevelup;
	}

	public void setForlevelup(int forlevelup) {
		this.forlevelup = forlevelup;
	}

}
