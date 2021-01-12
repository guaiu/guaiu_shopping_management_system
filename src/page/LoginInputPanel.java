package page;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import listener.JTextFieldHintListener;

/**
 * 登录界面的输入面板
 * 
 * @author guaiu
 *
 */
public class LoginInputPanel extends InputPanel {

	private JLabel lable_username;
	private JLabel lable_password;
	private JTextField textfield_username;
	private JPasswordField textfield_password;

	/**
	 * 无参数方法，生成用户名和密码输入面板
	 */
	public LoginInputPanel() {
		// TODO Auto-generated constructor stub
		this.lable_username = new JLabel("用户名");
		this.lable_password = new JLabel("密码");
		this.textfield_username = new JTextField();
		this.textfield_password = new JPasswordField();
		

		//有bug
//		this.textfield_username.addFocusListener(new JTextFieldHintListener(textfield_username, "请输入用户名"));
//		this.textfield_password.addFocusListener(new JTextFieldHintListener(textfield_password, "请输入密码"));

		this.setLayout(new GridLayout(2, 2));
		this.add(lable_username);
		this.add(textfield_username);
		this.add(lable_password);
		this.add(textfield_password);
	}

	public JLabel getLable_username() {
		return lable_username;
	}

	public JLabel getLable_password() {
		return lable_password;
	}

	public JTextField getTextfield_username() {
		return textfield_username;
	}

	public JPasswordField getTextfield_password() {
		return textfield_password;
	}

//	public void setLable_username(JLabel lable_username) {
//		this.lable_username = lable_username;
//	}
//
//
//	public void setLable_password(JLabel lable_password) {
//		this.lable_password = lable_password;
//	}
//
//
//	public void setTextfield_username(JTextField textfield_username) {
//		this.textfield_username = textfield_username;
//	}
//
//
//	public void setTextfield_password(JPasswordField textfield_password) {
//		this.textfield_password = textfield_password;
//	}

}
