package db;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * 连接sql server数据库
 * 
 * @author other,guaiu
 */
public final class DbConn {
	public static Connection getconn() {
		Connection conn = null;

		String user = "sa";
		String passwd = "123456";
		//String url = "jdbc:sqlserver://DESKTOP-P058HU6:1433;DatabaseName=goodsDatabase"; 
		//可以具体填电脑的名称，也可以用下一行那种写法
		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=goodsDatabase";
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

		// 加载驱动
		try {
			Class.forName(JDriver);
			System.out.println("数据库驱动成功");
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connection对象获取成功");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		System.out.println("返回Connection对象");
		return conn;
	}
}
