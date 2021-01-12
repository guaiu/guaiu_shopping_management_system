package entity;

/**
 * 用户实体类
 * 
 * @author guaiu
 *
 */
public final class User {

	// 数据库user主键
	private int userid;
	private String username;
	private String userpassword;

	/**
	 * 生成用户对象
	 * 
	 * @param userid
	 * @param username
	 * @param userpassword
	 */
	public User(int userid, String username, String userpassword) {
		// TODO Auto-generated constructor stub
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
	}

	/**
	 * 添加用户信息
	 * 
	 * @param username
	 * @param userpassword
	 */
	public User(String username, String userpassword) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.userpassword = userpassword;
	}

	/**
	 * 根据编号更改用户信息
	 * 
	 * @deprecated
	 * @param userid
	 * @param username
	 */
	public void User_username(int userid, String username) {
		// TODO Auto-generated constructor stub
		this.userid = userid;
		this.username = username;
	}

	/**
	 * 根据编号更改用户信息
	 * 
	 * @deprecated
	 * @param userid
	 * @param userpassword
	 */
	public void User_userpasser(int userid, String userpassword) {
		// TODO Auto-generated constructor stub
		this.userid = userid;
		this.userpassword = userpassword;
	}

	public int getUserid() {
		return userid;
	}

	public String getUsername() {
		return username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

}
