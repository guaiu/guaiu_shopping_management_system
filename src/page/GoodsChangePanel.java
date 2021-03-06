package page;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * 商品更改面板
 * @author guaiu
 *
 */
public class GoodsChangePanel extends ActionPanel{

	private GoodsIdShowPanel panel_idShow;
	private GoodsInputPanel panel_input;
	private JButton button_change;
	
	/**
	 * 无参数方法，生成商品更改面板
	 */
	public GoodsChangePanel() {
		// TODO Auto-generated constructor stub
		super("更改面板(商品)");
		
		this.panel_idShow = new GoodsIdShowPanel();
		this.panel_input = new GoodsInputPanel();
		this.button_change = new JButton("更改");
		
		this.setLayout(new BorderLayout());
		this.add(panel_idShow, BorderLayout.NORTH);
		this.add(panel_input, BorderLayout.CENTER);
		this.add(button_change, BorderLayout.SOUTH);
	}

	public GoodsInputPanel getPanel_input() {
		return panel_input;
	}

	public JButton getButton_change() {
		return button_change;
	}

	public GoodsIdShowPanel getPanel_idShow() {
		return panel_idShow;
	}

//	public void setPanel_idShow(GoodsIdShowPanel panel_idShow) {
//		this.panel_idShow = panel_idShow;
//	}
//
//	public void setPanel_input(GoodsInputPanel panel_input) {
//		this.panel_input = panel_input;
//	}
//
//	public void setButton_change(JButton button_change) {
//		this.button_change = button_change;
//	}
	
}
