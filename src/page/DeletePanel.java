package page;

import java.awt.BorderLayout;

import javax.swing.JButton;

/**
 * ɾ�����
 * @author guaiu
 *
 */
public class DeletePanel extends ActionPanel{
	
	private JButton button_delete;

	/**
	 * �޲�������������ɾ�����
	 */
	public DeletePanel() {
		// TODO Auto-generated constructor stub
		super("ɾ�����");
		this.button_delete = new JButton("ɾ��");
		this.setLayout(new BorderLayout());
		this.add(button_delete,BorderLayout.NORTH);
	}

	public JButton getButton_delete() {
		return button_delete;
	}

//	public void setButton_delete(JButton button_delete) {
//		this.button_delete = button_delete;
//	}
	

}
