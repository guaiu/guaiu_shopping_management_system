package listener;

import page.GoodsAddPanel;
import page.GoodsChangePanel;
import page.GoodsDeletePanel;
import page.GoodsPanel;
import page.GoodsQueryPanel;
import page.GoodsShowTablePanel;

/**
 * 实现了监听器的封装，已弃用
 * 
 * @author guaiu
 * @deprecated
 * @see page.MainWindows
 */
public class GoodsPanelListener {

	private GoodsShowTablePanel showTablePanel;
	private GoodsAddPanel addPanel;
	private GoodsDeletePanel deletePanel;
	private GoodsChangePanel changePanel;
	private GoodsQueryPanel queryPanel;

	private GoodsQueryListener queryListener;
	private GoodsAddListener addListener;
	private GoodsDeleteListener deleteListener;
	private GoodsChangeListener changeListener;

	/**
	 * 初始化监听器，实现封装
	 * 
	 * @param panel
	 */
	public GoodsPanelListener(GoodsPanel panel) {
		// TODO Auto-generated constructor stub
		this.showTablePanel = panel.getShowTablePanel();
		this.addPanel = panel.getAddPanel();
		this.deletePanel = panel.getDeletePanel();
		this.changePanel = panel.getChangePanel();
		this.queryPanel = panel.getQueryPanel();

		this.queryListener = new GoodsQueryListener(queryPanel, showTablePanel);
		this.addListener = new GoodsAddListener(addPanel, showTablePanel);
		this.deleteListener = new GoodsDeleteListener(deletePanel, showTablePanel);
		this.changeListener = new GoodsChangeListener(changePanel, showTablePanel);
	}

}
