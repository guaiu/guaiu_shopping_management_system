package page;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * @author guaiu
 *
 */
public class ActionPanel extends JPanel{

	
	/**
	 * �޲���������Ĭ��������"�������"
	 */
	public ActionPanel() {
		// TODO Auto-generated constructor stub
		super();
		this.setBorder(BorderFactory.createTitledBorder("�������"));
	}
	
	/**
	 * �в���������������Ϊ����text
	 * @param text
	 */
	public ActionPanel(String text) {
		super();
		this.setBorder(BorderFactory.createTitledBorder(text));
	}
}
