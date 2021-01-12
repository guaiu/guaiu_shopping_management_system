package page;

import java.awt.GridLayout;

import javax.swing.JButton;

/**
 * 登录界面的动作面板
 * 
 * @author guaiu
 *
 */
public class LoginActionPanel extends ActionPanel {

	private JButton button_login;

	/**
	 * 无参数方法，生成登录界面的动作面板
	 */
	public LoginActionPanel() {
		// TODO Auto-generated constructor stub
		super("登录动作");

		this.button_login = new JButton("登录");

		this.setLayout(new GridLayout(1, 1));
		this.add(button_login);
	}

	public JButton getButton_login() {
		return button_login;
	}

//	public void setButton_login(JButton button_login) {
//		this.button_login = button_login;
//	}
}
