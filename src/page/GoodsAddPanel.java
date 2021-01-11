package page;

import java.awt.BorderLayout;

import javax.swing.JButton;

/**
 * 商品添加面板
 * @author guaiu
 *
 */
public class GoodsAddPanel extends ActionPanel{

	private GoodsInputPanel panel_input;
	private JButton button_add;
	
	/**
	 * 无参数方法，生成商品添加面板
	 */
	public GoodsAddPanel() {
		// TODO Auto-generated constructor stub
		super("添加面板(商品)");
		
		this.panel_input = new GoodsInputPanel();
		this.button_add = new JButton("添加");
		
		this.setLayout(new BorderLayout());;
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
