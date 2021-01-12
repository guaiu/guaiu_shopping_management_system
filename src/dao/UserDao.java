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
 * 数据库user表操作
 * 
 * @author guaiu
 *
 */
public class UserDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/**
	 * 添加新用户
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
			System.out.println("prepareStatement对象获取成功");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getUserpassword());
			System.out.println("prepareStatement对象设置成功");

			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
				System.out.println("prepareStatement对象执行成功");
			} else {
				System.out.println("prepareStatement对象执行失败");
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.addClose(pstmt, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回boolean值");
		return bool;
	}

	/**
	 * 更改用户信息
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
			System.out.println("prepareStatement对象获取成功");
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getUserpassword());
			pstmt.setInt(3, user.getUserid());
			System.out.println("prepareStatement对象设置成功");

			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
				System.out.println("prepareStatement对象执行成功");
			} else {
				System.out.println("prepareStatement对象执行失败");
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.addClose(pstmt, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回boolean值");
		return bool;
	}

	/**
	 * 删除指定userid的用户信息
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
			System.out.println("prepareStatement对象获取成功");
			pstmt.setInt(1, userid);
			System.out.println("prepareStatement对象设置成功");
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
				System.out.println("prepareStatement对象执行成功");
			} else {
				System.out.println("prepareStatement对象执行失败");
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.addClose(pstmt, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回boolean值");
		return bool;
	}

	/**
	 * 查询所有用户信息，默认排序
	 * 
	 * @return ArrayList<User>
	 */
	public ArrayList<User> displayUser() {
		ArrayList<User> userList = new ArrayList<User>();
		conn = DbConn.getconn();
		String sql = "SELECT * FROM MYUSER";

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement对象获取成功");
			System.out.println("prepareStatement对象设置成功"); // 已设置

			rs = pstmt.executeQuery();
			System.out.println("prepareStatement对象执行成功");

			while (rs.next()) {
				int id = rs.getInt(1);
//				int id = rs.getInt("id"); //双引号+主键名,也可用数字表示.
				String name = rs.getString(2);
				String password = rs.getString(3);

				User user = new User(id, name, password); // 创建User对象，并赋值.
				userList.add(user); // 添加信息到ArrayList<User>中.
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回ArrayList<User> userList");
		return userList;

	}

	/**
	 * 根据id精确查询 备注：返回值ArrayList<User> 不太恰当，因为id序列具有唯一性，实际上永远只返回0个或者1个User
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
			System.out.println("prepareStatement对象获取成功");
			pstmt.setInt(1, userid);
			System.out.println("prepareStatement对象设置成功");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement对象执行成功");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);

				User user = new User(id, name, password);
				userList.add(user);
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回ArrayList<User> userList");
		return userList;
	}

	/**
	 * 根据用户名和密码进行精确查询
	 * 备注：返回值ArrayList<User>可改进
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
			System.out.println("prepareStatement对象获取成功");
			pstmt.setString(1, username);
			pstmt.setString(2, userpassword);
			System.out.println("prepareStatement对象设置成功");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement对象执行成功");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);

				User user = new User(id, name, password);
				userList.add(user);
				System.out.println(userList.get(0));
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回ArrayList<User> userList");
		return userList;
	}

	/**
	 * 根据用户名称进行模糊查询
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
			System.out.println("prepareStatement对象获取成功");
			pstmt.setString(1, "%" + username + "%");
			System.out.println("prepareStatement对象设置成功");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement对象执行成功");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);

				User User = new User(id, name, password);
				userList.add(User);
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回ArrayList<User> userList");
		return userList;
	}

	/**
	 * 根据用户名称进行精确查询
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
			System.out.println("prepareStatement对象获取成功");
			pstmt.setString(1, "%" + username + "%");
			System.out.println("prepareStatement对象设置成功");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement对象执行成功");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);

				User User = new User(id, name, password);
				userList.add(User);
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回ArrayList<User> userList");
		return userList;
	}

}
