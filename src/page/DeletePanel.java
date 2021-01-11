package page;

import java.awt.BorderLayout;

import javax.swing.JButton;

/**
 * 删除面板
 * @author guaiu
 *
 */
public class DeletePanel extends ActionPanel{
	
	private JButton button_delete;

	/**
	 * 无参数方法，生成删除面板
	 */
	public DeletePanel() {
		// TODO Auto-generated constructor stub
		super("删除面板");
		this.button_delete = new JButton("删除");
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
