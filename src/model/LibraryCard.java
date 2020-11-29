package model;
/**
 * 借书证实体信息
 * @author iot
 *
 */
public class LibraryCard {
	private String Borrowsno;//借书证号
	private String Sde;//学院
	private String Ssp;//专业
	private String Sname;//姓名
	private int BorrowMax;//借书上限
	
	public LibraryCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LibraryCard(String borrowsno, String sde, String ssp, String sname, int borrowMax) {
		super();
		Borrowsno = borrowsno;
		Sde = sde;
		Ssp = ssp;
		Sname = sname;
		BorrowMax = borrowMax;
	}

	public String getBorrowsno() {
		return Borrowsno;
	}
	public void setBorrowsno(String borrowsno) {
		Borrowsno = borrowsno;
	}
	public String getSde() {
		return Sde;
	}
	public void setSde(String sde) {
		Sde = sde;
	}
	public String getSsp() {
		return Ssp;
	}
	public void setSsp(String ssp) {
		Ssp = ssp;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public int getBorrowMax() {
		return BorrowMax;
	}
	public void setBorrowMax(int borrowMax) {
		BorrowMax = borrowMax;
	}
	
}
