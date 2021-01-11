package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 关闭操作数据库时产生的资源流
 * 
 * @author other,guaiu
 */
public final class DbClose {
	/**
	 * 关闭 添加功能 资源
	 * 
	 * @param pstmt,rs,conn
	 */
	public static void addClose(Statement pstmt, Connection conn) {
		/*
		 * 多个 try-catch 出发点：安全
		 */
		try {
			if (pstmt != null) {
				pstmt.close();
				System.out.println("PreparedStatement对象关闭成功");
			}
		} catch (SQLException e1) {
			System.out.println("PreparedStatement对象关闭失败");
			e1.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Connection对象关闭成功");
			}
		} catch (SQLException e) {
			System.out.println("Connection对象关闭失败");
			e.printStackTrace();
		}
	}

	/**
	 * 关闭资源
	 * 
	 * @param pstmt,rs,conn
	 */
	public static void queryClose(Statement pstmt, ResultSet rs, Connection conn) {
		try {
			if (pstmt != null) {
				pstmt.close();
				System.out.println("PreparedStatement对象关闭成功");
			}
		} catch (SQLException e1) {
			System.out.println("PreparedStatement对象关闭失败");
			e1.printStackTrace();
		}
		try {
			if (rs != null) {
				rs.close();
				System.out.println("ResultSet对象关闭成功");
			}
		} catch (SQLException e1) {
			System.out.println("ResultSet对象关闭失败");
			e1.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Connection对象关闭成功");
			}
		} catch (SQLException e) {
			System.out.println("Connection对象关闭失败");
			e.printStackTrace();
		}
	}

}
