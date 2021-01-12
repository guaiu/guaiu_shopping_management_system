package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbClose;
import db.DbConn;
import entity.User;

/**
 * ���ݿ�user�����
 * 
 * @author guaiu
 *
 */
public class UserDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/**
	 * ������û�
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean addUser(User user) {
		boolean bool = false;
		conn = DbConn.getconn();
		String sql = "INSERT INTO MYUSER(USERNAME,USERPASSWORD) VALUES(?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getUserpassword());
			System.out.println("prepareStatement�������óɹ�");

			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
				System.out.println("prepareStatement����ִ�гɹ�");
			} else {
				System.out.println("prepareStatement����ִ��ʧ��");
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.addClose(pstmt, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����booleanֵ");
		return bool;
	}

	/**
	 * �����û���Ϣ
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean updateUser(User user) {
		boolean bool = false;
		conn = DbConn.getconn();
		String sqlName = "UPDATE MYUSER SET USERNAME=?,USERPASSWORD=? WHERE USERID=?";

		try {
			pstmt = conn.prepareStatement(sqlName);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getUserpassword());
			pstmt.setInt(3, user.getUserid());
			System.out.println("prepareStatement�������óɹ�");

			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
				System.out.println("prepareStatement����ִ�гɹ�");
			} else {
				System.out.println("prepareStatement����ִ��ʧ��");
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.addClose(pstmt, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����booleanֵ");
		return bool;
	}

	/**
	 * ɾ��ָ��userid���û���Ϣ
	 * 
	 * @param userid
	 * @return boolean
	 */
	public boolean deleteUser(int userid) {
		boolean bool = false;
		conn = DbConn.getconn();
		String sql = "DELETE FROM MYUSER WHERE USERID=?";

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			pstmt.setInt(1, userid);
			System.out.println("prepareStatement�������óɹ�");
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
				System.out.println("prepareStatement����ִ�гɹ�");
			} else {
				System.out.println("prepareStatement����ִ��ʧ��");
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.addClose(pstmt, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����booleanֵ");
		return bool;
	}

	/**
	 * ��ѯ�����û���Ϣ��Ĭ������
	 * 
	 * @return ArrayList<User>
	 */
	public ArrayList<User> displayUser() {
		ArrayList<User> userList = new ArrayList<User>();
		conn = DbConn.getconn();
		String sql = "SELECT * FROM MYUSER";

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			System.out.println("prepareStatement�������óɹ�"); // ������

			rs = pstmt.executeQuery();
			System.out.println("prepareStatement����ִ�гɹ�");

			while (rs.next()) {
				int id = rs.getInt(1);
//				int id = rs.getInt("id"); //˫����+������,Ҳ�������ֱ�ʾ.
				String name = rs.getString(2);
				String password = rs.getString(3);

				User user = new User(id, name, password); // ����User���󣬲���ֵ.
				userList.add(user); // �����Ϣ��ArrayList<User>��.
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����ArrayList<User> userList");
		return userList;

	}

	/**
	 * ����id��ȷ��ѯ ��ע������ֵArrayList<User> ��̫ǡ������Ϊid���о���Ψһ�ԣ�ʵ������Զֻ����0������1��User
	 * 
	 * @param userid
	 * @return ArrayList<User>
	 */
	public ArrayList<User> queryUserId(int userid) {
		ArrayList<User> userList = new ArrayList<User>();
		conn = DbConn.getconn();

		String sql = "SELECT * FROM MYUSER WHERE USERID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			pstmt.setInt(1, userid);
			System.out.println("prepareStatement�������óɹ�");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement����ִ�гɹ�");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);

				User user = new User(id, name, password);
				userList.add(user);
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����ArrayList<User> userList");
		return userList;
	}

	/**
	 * �����û�����������о�ȷ��ѯ
	 * ��ע������ֵArrayList<User>�ɸĽ�
	 * @param username
	 * @param userpassword
	 * @return ArrayList<User>
	 */
	public ArrayList<User> queryUser(String username, String userpassword) {
		ArrayList<User> userList = new ArrayList<User>();
		conn = DbConn.getconn();

		String sql = "SELECT * FROM MYUSER WHERE USERNAME=? AND USERPASSWORD=?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			pstmt.setString(1, username);
			pstmt.setString(2, userpassword);
			System.out.println("prepareStatement�������óɹ�");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement����ִ�гɹ�");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);

				User user = new User(id, name, password);
				userList.add(user);
				System.out.println(userList.get(0));
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����ArrayList<User> userList");
		return userList;
	}

	/**
	 * �����û����ƽ���ģ����ѯ
	 * 
	 * @param username
	 * @return ArrayList<User>
	 */
	public ArrayList<User> queryUserNameFuzzy(String username) {
		ArrayList<User> userList = new ArrayList<User>();
		conn = DbConn.getconn();

		String sql = "SELECT * FROM MYUSER WHERE USERNAME LIKE ?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			pstmt.setString(1, "%" + username + "%");
			System.out.println("prepareStatement�������óɹ�");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement����ִ�гɹ�");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);

				User User = new User(id, name, password);
				userList.add(User);
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����ArrayList<User> userList");
		return userList;
	}

	/**
	 * �����û����ƽ��о�ȷ��ѯ
	 * 
	 * @param username
	 * @return ArrayList<User>
	 */
	public ArrayList<User> queryUserNameExact(String username) {
		ArrayList<User> userList = new ArrayList<User>();
		conn = DbConn.getconn();

		String sql = "SELECT * FROM MYUSER WHERE USERNAME LIKE ?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			pstmt.setString(1, "%" + username + "%");
			System.out.println("prepareStatement�������óɹ�");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement����ִ�гɹ�");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);

				User User = new User(id, name, password);
				userList.add(User);
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����ArrayList<User> userList");
		return userList;
	}

}
