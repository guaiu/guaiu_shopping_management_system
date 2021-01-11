package page;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * ��Ʒ�������
 * @author guaiu
 *
 */
public class GoodsChangePanel extends ActionPanel{

	private GoodsIdShowPanel panel_idShow;
	private GoodsInputPanel panel_input;
	private JButton button_add;
	
	/**
	 * �޲���������������Ʒ�������
	 */
	public GoodsChangePanel() {
		// TODO Auto-generated constructor stub
		super("�������(��Ʒ)");
		
		this.panel_idShow = new GoodsIdShowPanel();
		this.panel_input = new GoodsInputPanel();
		this.button_add = new JButton("����");
		
		this.setLayout(new BorderLayout());
		this.add(panel_idShow, BorderLayout.NORTH);
		this.add(panel_input, BorderLayout.CENTER);
		this.add(button_add, BorderLayout.SOUTH);
	}

	public GoodsInputPanel getPanel_input() {
		return panel_input;
	}

	public JButton getButton_add() {
		return button_add;
	}

//	public void setPanel_input(GoodsInputPanel panel_input) {
//		this.panel_input = panel_input;
//	}
//
//	public void setButton_add(JButton button_add) {
//		this.button_add = button_add;
//	}
	
}
