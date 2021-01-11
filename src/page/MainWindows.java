package page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import listener.GoodsPanelListener;

/**
 * 窗口类，将界面类和监听器类分别进行了封装，但是表现却不太好，暂时弃用
 * 
 * @author guaiu
 * @deprecated
 *
 */
public class MainWindows extends JFrame {

	private GoodsPanel panel;
	private GoodsPanelListener panelListener;

	/**
	 * 初始化窗口，将界面类和监听器类分别进行了封装
	 */
	public MainWindows() {
		// TODO Auto-generated constructor stub
		super();
		this.panel = new GoodsPanel();
		this.panelListener = new GoodsPanelListener(panel);

		this.setTitle("商品管理窗口");

		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.NORTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(1000, 100, 850, 850);
		this.setLocationRelativeTo(null);

		this.setVisible(true);
	}

	public GoodsPanel getPanel() {
		return panel;
	}

	public GoodsPanelListener getPanelListener() {
		return panelListener;
	}

	public void setPanel(GoodsPanel panel) {
		this.panel = panel;
	}

	public void setPanelListener(GoodsPanelListener panelListener) {
		this.panelListener = panelListener;
	}
}
