package page;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * id��Ϣչʾ���
 * @author guaiu
 *
 */
public class IdShowPanel extends ActionPanel{
	
	private JLabel label_id;
	private JTextField textField_id;
	
	/**
	 * �޲�������������id��Ϣչʾ��
	 * ��ע��չʾ��Ϣ���ɱ༭
	 */
	public IdShowPanel() {
		// TODO Auto-generated constructor stub
		super("id��Ϣ");
		
		this.label_id = new JLabel("id");
		this.textField_id = new JTextField();
		
		textField_id.setEditable(false);
		
		this.setLayout(new GridLayout(2,1));
		this.add(label_id);
		this.add(textField_id);
	}

	public JLabel getLabel_id() {
		return label_id;
	}

	public JTextField getTextField_id() {
		return textField_id;
	}

//	public void setLabel_id(JLabel label_id) {
//		this.label_id = label_id;
//	}
//
//	public void setTextField_id(JTextField textField_id) {
//		this.textField_id = textField_id;
//	}

}
