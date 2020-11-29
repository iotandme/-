package model;
/**
 * 图书信息实体
 * @author iot
 *
 */

public class BookInfo {
	private String Bno;//图书编号
	private String Bname;//图书名称
	private String Bpress;//图书出版社
	private String Btime;//出版时间
	private String Bloca;//图书位置
	private int Bnum;//图书数量
	
	public BookInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BookInfo(String bno, String bname, String bpress, String btime, String bloca, int bnum) {
		super();
		Bno = bno;
		Bname = bname;
		Bpress = bpress;
		Btime = btime;
		Bloca = bloca;
		Bnum = bnum;
	}

	public String getBno() {
		return Bno;
	}
	public void setBno(String bno) {
		Bno = bno;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getBpress() {
		return Bpress;
	}
	public void setBpress(String bpress) {
		Bpress = bpress;
	}
	public String getBtime() {
		return Btime;
	}
	public void setBtime(String btime) {
		Btime = btime;
	}
	public String getBloca() {
		return Bloca;
	}
	public void setBloca(String bloca) {
		Bloca = bloca;
	}
	public int getBnum() {
		return Bnum;
	}
	public void setBnum(int bnum) {
		Bnum = bnum;
	}

}
