package db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * ����sql server���ݿ�
 * 
 * @author other,guaiu
 */
public final class DbConn {
	public static Connection getconn() {
		Connection conn = null;

		String user = "sa";
		String passwd = "123456";
		//String url = "jdbc:sqlserver://DESKTOP-P058HU6:1433;DatabaseName=goodsDatabase"; 
		//���Ծ�������Ե����ƣ�Ҳ��������һ������д��
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=goodsDatabase";
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

		// ��������
		try {
			Class.forName(JDriver);
			System.out.println("���ݿ������ɹ�");
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connection�����ȡ�ɹ�");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�������ݿ�����ʧ��");
			System.exit(0);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("�������ݿ�����ʧ��");
			System.exit(0);
		}
		System.out.println("����Connection����");
		return conn;
	}
}
