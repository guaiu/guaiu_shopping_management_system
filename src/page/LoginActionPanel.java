package page;

import java.awt.GridLayout;

import javax.swing.JButton;

/**
 * ��¼����Ķ������
 * 
 * @author guaiu
 *
 */
public class LoginActionPanel extends ActionPanel {

	private JButton button_login;

	/**
	 * �޲������������ɵ�¼����Ķ������
	 */
	public LoginActionPanel() {
		// TODO Auto-generated constructor stub
		super("��¼����");

		this.button_login = new JButton("��¼");

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
