package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.LibraryCard;
import util.StringUtil;

/**
 * 借书证信息Dao类
 * @author iot
 *
 */
public class LibraryCardDao {
	/**
	 * 借书证信息添加
	 * @param con
	 * @param libraryCard
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,LibraryCard libraryCard)throws Exception{
		String sql = "INSERT INTO LibraryCard VALUES(?,?,?,?,?)";
		PreparedStatement pstmt =  con.prepareStatement(sql);
		pstmt.setString(1, libraryCard.getBorrowsno());
		pstmt.setString(2, libraryCard.getSde());
		pstmt.setString(3, libraryCard.getSsp());
		pstmt.setString(4, libraryCard.getSname());
		pstmt.setInt(5, libraryCard.getBorrowMax());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询借书证信息集合
	 * @param con
	 * @param bookInfo
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,LibraryCard libraryCard)throws Exception{
		StringBuffer sb = new StringBuffer("SELECT * FROM LibraryCard ");
		if(StringUtil.isNoEmpty(libraryCard.getBorrowsno())) {
			sb.append(" and Borrowsno LIKE '%"+libraryCard.getBorrowsno()+"%'");
		}
		if(StringUtil.isNoEmpty(libraryCard.getSname())) {
			sb.append(" and Sname LIKE '%"+libraryCard.getSname()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 删除借书证信息
	 * @param con
	 * @param Bno
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String Borrowsno )throws Exception{
		String sql = "delete from LibraryCard where Borrowsno =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, Borrowsno);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 更新借书证信息
	 * @param con
	 * @param bookInfo
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con ,LibraryCard libraryCard)throws Exception {
		String sql ="update LibraryCard set Sde=?,Ssp=?,Sname=?,BorrowMax =? where Borrowsno =? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, libraryCard.getSde());
		pstmt.setString(2, libraryCard.getSsp());
		pstmt.setString(3, libraryCard.getSname());
		pstmt.setInt(4, libraryCard.getBorrowMax());
		pstmt.setString(5, libraryCard.getBorrowsno());
		
		return pstmt.executeUpdate();
	}
}
