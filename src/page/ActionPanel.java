package page;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * @author guaiu
 *
 */
public class ActionPanel extends JPanel{

	
	/**
	 * 无参数方法，默认面板标题"功能面板"
	 */
	public ActionPanel() {
		// TODO Auto-generated constructor stub
		super();
		this.setBorder(BorderFactory.createTitledBorder("功能面板"));
	}
	
	/**
	 * 有参数方法，面板标题为参数text
	 * @param text
	 */
	public ActionPanel(String text) {
		super();
		this.setBorder(BorderFactory.createTitledBorder(text));
	}
}
