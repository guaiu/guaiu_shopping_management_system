package listener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 实现JRadioButton对象被选定时，JTextField取消锁定；JRadioButton对象被取消选定时，JTextField对象锁定
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
		// 使事件源为this.radioButton
		if(this.radioButton.isSelected()) {
			this.textField.setEnabled(true);
		}
		else{
			this.textField.setEnabled(false);
		}
	}
	
}
