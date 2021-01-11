package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * �رղ������ݿ�ʱ��������Դ��
 * 
 * @author other,guaiu
 */
public final class DbClose {
	/**
	 * �ر� ��ӹ��� ��Դ
	 * 
	 * @param pstmt,rs,conn
	 */
	public static void addClose(Statement pstmt, Connection conn) {
		/*
		 * ��� try-catch �����㣺��ȫ
		 */
		try {
			if (pstmt != null) {
				pstmt.close();
				System.out.println("PreparedStatement����رճɹ�");
			}
		} catch (SQLException e1) {
			System.out.println("PreparedStatement����ر�ʧ��");
			e1.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Connection����رճɹ�");
			}
		} catch (SQLException e) {
			System.out.println("Connection����ر�ʧ��");
			e.printStackTrace();
		}
	}

	/**
	 * �ر���Դ
	 * 
	 * @param pstmt,rs,conn
	 */
	public static void queryClose(Statement pstmt, ResultSet rs, Connection conn) {
		try {
			if (pstmt != null) {
				pstmt.close();
				System.out.println("PreparedStatement����رճɹ�");
			}
		} catch (SQLException e1) {
			System.out.println("PreparedStatement����ر�ʧ��");
			e1.printStackTrace();
		}
		try {
			if (rs != null) {
				rs.close();
				System.out.println("ResultSet����رճɹ�");
			}
		} catch (SQLException e1) {
			System.out.println("ResultSet����ر�ʧ��");
			e1.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Connection����رճɹ�");
			}
		} catch (SQLException e) {
			System.out.println("Connection����ر�ʧ��");
			e.printStackTrace();
		}
	}

}
