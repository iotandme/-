package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.BorrowInfo;
import model.LibraryCard;
import util.StringUtil;

public class BorrowInfoDao {
	/**
	 * 借阅信息添加
	 * @param con
	 * @param borrowInfo
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,BorrowInfo borrowInfo)throws Exception{
		String sql = "INSERT INTO BorrowInfo VALUES(?,GETDATE(),?,NULL,dateadd(day,30,GETDATE()),NULL,NULL)";
		PreparedStatement pstmt =  con.prepareStatement(sql);
		pstmt.setString(1, borrowInfo.getBno());
		pstmt.setString(2, borrowInfo.getBorrowsno());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询借阅信息集合
	 * @param con
	 * @param bookInfo
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,BorrowInfo borrowInfo)throws Exception{
		StringBuffer sb = new StringBuffer("SELECT * FROM BorrowInfo ORDER BY Borrowtime DESC");
		if(StringUtil.isNoEmpty(borrowInfo.getBorrowsno())) {
			sb.append(" and Borrowsno LIKE '%"+borrowInfo.getBorrowsno()+"%'");
		}
		if(StringUtil.isNoEmpty(borrowInfo.getBno())) {
			sb.append(" and Bno LIKE '%"+borrowInfo.getBno()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	
	
	/**
	 * 更新借阅信息
	 * @param con
	 * @param bookInfo
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con)throws Exception {
		String sql ="update BorrowInfo set Overduetime = DATEDIFF(day, Expiretime , GETDATE()) "
				+ "where Rturntime IS NULL ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书归还信息更新
	 * @param con
	 * @param borrowInfo
	 * @return
	 * @throws Exception
	 */
	public int returnbook(Connection con ,BorrowInfo borrowInfo)throws Exception {
		String sql ="update BorrowInfo set  Rturntime = GETDATE(),Overduetime = DATEDIFF(day, Expiretime , GETDATE()) "
				+ "where Borrowsno =? AND Borrowtime = convert(datetime,?, 21) AND Bno =? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, borrowInfo.getBorrowsno());
		pstmt.setString(2, borrowInfo.getBorrowtime());
		pstmt.setString(3, borrowInfo.getBno());
		return pstmt.executeUpdate();
	}
	
}
