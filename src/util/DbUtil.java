package util;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * ���ݿ⹤����
 * @author iot
 *
 */
public class DbUtil {
	private String dbUrl="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=LIBRARY";//���ݿ����ӵ�ַ
	private String dbUser = "sa";// ���Լ��������û����ֺ����룡����������������������
	private String dbPassword = "123456";
	private String jdbcName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Excepttion
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		return con;
	}
	/**
	 * �ر����ݿ�����
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
			System.out.println("���ݿ����ӳɹ���");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
	}
}
