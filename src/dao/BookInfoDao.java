package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.BookInfo;
import util.StringUtil;

/**
 * 图书信息Dao类
 * @author iot
 *
 */
public class BookInfoDao {
	/**
	 * 图书信息添加
	 * @param con
	 * @param bookInfo
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,BookInfo bookInfo)throws Exception{
		String sql = "INSERT INTO BookInfo VALUES(?,?,?,convert(date,?, 23),?,?)";
		PreparedStatement pstmt =  con.prepareStatement(sql);
		pstmt.setString(1, bookInfo.getBno());
		pstmt.setString(2, bookInfo.getBname());
		pstmt.setString(3, bookInfo.getBpress());
		pstmt.setString(4, bookInfo.getBtime());
		pstmt.setString(5, bookInfo.getBloca());
		pstmt.setInt(6, bookInfo.getBnum());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询图书信息集合
	 * @param con
	 * @param bookInfo
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,BookInfo bookInfo)throws Exception{
		StringBuffer sb = new StringBuffer("SELECT * FROM BookInfo ");
		if(StringUtil.isNoEmpty(bookInfo.getBno())) {
			sb.append(" and Bno LIKE '%"+bookInfo.getBno()+"%'");
		}
		if(StringUtil.isNoEmpty(bookInfo.getBname())) {
			sb.append(" and Bname LIKE '%"+bookInfo.getBname()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 删除图书信息
	 * @param con
	 * @param Bno
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String Bno )throws Exception{
		String sql = "delete from BookInfo where Bno =?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, Bno);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 更新图书信息
	 * @param con
	 * @param bookInfo
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con ,BookInfo bookInfo)throws Exception {
		String sql ="update BookInfo set Bname=?,Bpress=?,Btime=convert(date,?, 23),Bloca =?,Bnum=? where Bno =? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookInfo.getBname());
		pstmt.setString(2, bookInfo.getBpress());
		pstmt.setString(3, bookInfo.getBtime());
		pstmt.setString(4, bookInfo.getBloca());
		pstmt.setInt(5, bookInfo.getBnum());
		pstmt.setString(6, bookInfo.getBno());
		return pstmt.executeUpdate();
	}
}
