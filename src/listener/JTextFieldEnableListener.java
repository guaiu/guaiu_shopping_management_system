package listener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * ʵ��JRadioButton����ѡ��ʱ��JTextFieldȡ��������JRadioButton����ȡ��ѡ��ʱ��JTextField��������
 * @author guaiu
 *
 */
public class JTextFieldEnableListener implements ChangeListener{

	private JRadioButton radioButton;
	private JTextField textField;
	
	public JTextFieldEnableListener(JRadioButton jRadioButton,JTextField jTextField) {
		// TODO Auto-generated constructor stub
		this.radioButton = jRadioButton;
		this.textField = jTextField;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		// ʹ�¼�ԴΪthis.radioButton
		if(this.radioButton.isSelected()) {
			this.textField.setEnabled(true);
		}
		else{
			this.textField.setEnabled(false);
		}
	}
	
}
