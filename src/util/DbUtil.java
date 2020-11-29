package util;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 数据库工具类
 * @author iot
 *
 */
public class DbUtil {
	private String dbUrl="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=LIBRARY";//数据库连接地址
	private String dbUser = "sa";// 你自己创建的用户名字和密码！！！！！！！！！！！！
	private String dbPassword = "123456";
	private String jdbcName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Excepttion
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		return con;
	}
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}	
	}
	public static void main(String[] args) {
	     DbUtil dbUtil = new DbUtil();
	     try {
			dbUtil.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}
