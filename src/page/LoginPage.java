package page;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import listener.JTextFieldHintListener;
import listener.LoginActionListener;

public class LoginPage extends JFrame {

	private LoginInputPanel inputPanel;
	private LoginActionPanel actionPanel;
	
	private LoginActionListener actionListener;

	public LoginPage() {
		// TODO Auto-generated constructor stub
		super();
		this.setTitle("µÇÂ¼´°¿Ú");

		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(1000, 100, 400, 180);
		this.setLocationRelativeTo(null);

		this.initPanel();
		this.initListener();

		this.setVisible(true);

	}

	private void initPanel() {
		this.inputPanel = new LoginInputPanel();
		this.actionPanel = new LoginActionPanel();

		this.setLayout(new BorderLayout());
		this.add(inputPanel, BorderLayout.CENTER);
		this.add(actionPanel, BorderLayout.SOUTH);

	}

	private void initListener() {
		this.actionListener = new LoginActionListener(this);
	}

	public LoginInputPanel getInputPanel() {
		return inputPanel;
	}

	public LoginActionPanel getActionPanel() {
		return actionPanel;
	}

//	public void setInputPanel(LoginInputPanel inputPanel) {
//		this.inputPanel = inputPanel;
//	}
//
//	public void setActionPanel(LoginActionPanel actionPanel) {
//		this.actionPanel = actionPanel;
//	}

}
