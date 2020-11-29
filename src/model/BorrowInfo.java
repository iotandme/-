package model;
/**
 * ������Ϣʵ��
 * @author iot
 *
 */
public class BorrowInfo {
	private String Bno;//ͼ����
	private String Borrowtime;//����ʱ��
	private String Borrowsno;//����֤��
	private String Rturntime;//�黹ʱ��
	private String Expiretime;//����ʱ��
	private String Overduetime;//����ʱ��
	private double Fine;//������
	
	public BorrowInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BorrowInfo(String bno, String borrowsno) {
		super();
		Bno = bno;
		Borrowsno = borrowsno;
	}

	public BorrowInfo(String bno, String borrowtime, String borrowsno) {
		super();
		Bno = bno;
		Borrowtime = borrowtime;
		Borrowsno = borrowsno;
	}

	public BorrowInfo(String bno, String borrowtime, String borrowsno, String rturntime, String expiretime,
			String overduetime, double fine) {
		super();
		Bno = bno;
		Borrowtime = borrowtime;
		Borrowsno = borrowsno;
		Rturntime = rturntime;
		Expiretime = expiretime;
		Overduetime = overduetime;
		Fine = fine;
	}

	
	public String getBno() {
		return Bno;
	}
	public void setBno(String bno) {
		Bno = bno;
	}
	public String getBorrowtime() {
		return Borrowtime;
	}
	public void setBorrowtime(String borrowtime) {
		Borrowtime = borrowtime;
	}
	public String getBorrowsno() {
		return Borrowsno;
	}
	public void setBorrowsno(String borrowsno) {
		Borrowsno = borrowsno;
	}
	public String getRturntime() {
		return Rturntime;
	}
	public void setRturntime(String rturntime) {
		Rturntime = rturntime;
	}
	public String getExpiretime() {
		return Expiretime;
	}
	public void setExpiretime(String expiretime) {
		Expiretime = expiretime;
	}
	public String getOverduetime() {
		return Overduetime;
	}
	public void setOverduetime(String overduetime) {
		Overduetime = overduetime;
	}
	public double getFine() {
		return Fine;
	}
	public void setFine(double fine) {
		Fine = fine;
	}
	
}
