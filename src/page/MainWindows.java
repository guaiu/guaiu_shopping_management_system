package page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import listener.GoodsPanelListener;

/**
 * �����࣬��������ͼ�������ֱ�����˷�װ�����Ǳ���ȴ��̫�ã���ʱ����
 * 
 * @author guaiu
 * @deprecated
 *
 */
public class MainWindows extends JFrame {

	private GoodsPanel panel;
	private GoodsPanelListener panelListener;

	/**
	 * ��ʼ�����ڣ���������ͼ�������ֱ�����˷�װ
	 */
	public MainWindows() {
		// TODO Auto-generated constructor stub
		super();
		this.panel = new GoodsPanel();
		this.panelListener = new GoodsPanelListener(panel);

		this.setTitle("��Ʒ������");

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
