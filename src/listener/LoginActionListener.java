package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.UserDao;
import entity.User;
import page.GoodsPage;
import page.LoginActionPanel;
import page.LoginInputPanel;
import page.LoginPage;

public class LoginActionListener {

	private LoginPage page;

	private LoginInputPanel inputPanel;
	private LoginActionPanel actionPanel;

	public LoginActionListener(LoginPage page) {
		// TODO Auto-generated constructor stub
		this.page = page;
		this.inputPanel = page.getInputPanel();
		this.actionPanel = page.getActionPanel();

		this.set_button_login_listener();
	}

	private void set_button_login_listener() {
		actionPanel.getButton_login().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = inputPanel.getTextfield_username().getText();
				//String userpassword = inputPanel.getTextfield_password().getPassword();
				String userpassword = String.valueOf(inputPanel.getTextfield_password().getPassword());
				
				System.out.println(username);
				System.out.println(userpassword);

				if (username.equals("") || userpassword.equals("")) {
					System.out.println("�û����������п�ֵ");
					JOptionPane.showMessageDialog(null, "�����������û��������룡");
					return;
				}

				ArrayList<User> user = new UserDao().queryUser(username, userpassword);

				if (user.size() == 0) {
					System.out.println("���ݿ�û��ƥ����");
					JOptionPane.showMessageDialog(null, "�û������������");
					return;
				} else {
					System.out.println("���ݿ���ƥ����");
					JOptionPane.showMessageDialog(null, "��¼�ɹ�");
					page.setVisible(false);
					GoodsPage myPage = new GoodsPage();
				}
			}
		});
	}
}
