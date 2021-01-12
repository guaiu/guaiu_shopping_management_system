package entity;

/**
 * �û�ʵ����
 * 
 * @author guaiu
 *
 */
public final class User {

	// ���ݿ�user����
	private int userid;
	private String username;
	private String userpassword;

	/**
	 * �����û�����
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
	 * ����û���Ϣ
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
	 * ���ݱ�Ÿ����û���Ϣ
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
	 * ���ݱ�Ÿ����û���Ϣ
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
