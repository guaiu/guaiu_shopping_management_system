package page;

import java.awt.BorderLayout;

/**
 * 界面类的封装，已弃用
 * 
 * @author guaiu
 * @deprecated
 * @see page.MainWindows
 */
public class GoodsPanel extends ActionPanel {

	private GoodsShowTablePanel showTablePanel;
	private GoodsAddPanel addPanel;
	private GoodsDeletePanel deletePanel;
	private GoodsChangePanel changePanel;
	private GoodsQueryPanel queryPanel;

	/**
	 * 初始化界面，封装几个面板类
	 */
	public GoodsPanel() {
		// TODO Auto-generated constructor stub
		super("商品管理");

		this.showTablePanel = new GoodsShowTablePanel();
		this.addPanel = new GoodsAddPanel();
		this.deletePanel = new GoodsDeletePanel();
		this.changePanel = new GoodsChangePanel();
		this.queryPanel = new GoodsQueryPanel();

		this.setLayout(new BorderLayout());
		this.add(addPanel, BorderLayout.WEST);
		this.add(queryPanel, BorderLayout.NORTH);
		this.add(showTablePanel, BorderLayout.CENTER);
		this.add(deletePanel, BorderLayout.SOUTH);
		this.add(changePanel, BorderLayout.EAST);
	}

	public GoodsShowTablePanel getShowTablePanel() {
		return showTablePanel;
	}

	public GoodsAddPanel getAddPanel() {
		return addPanel;
	}

	public GoodsDeletePanel getDeletePanel() {
		return deletePanel;
	}

	public GoodsChangePanel getChangePanel() {
		return changePanel;
	}

	public GoodsQueryPanel getQueryPanel() {
		return queryPanel;
	}

//	public void setShowTablePanel(GoodsShowTablePanel showTablePanel) {
//		this.showTablePanel = showTablePanel;
//	}
//
//	public void setAddPanel(GoodsAddPanel addPanel) {
//		this.addPanel = addPanel;
//	}
//
//	public void setDeletePanel(GoodsDeletePanel deletePanel) {
//		this.deletePanel = deletePanel;
//	}
//
//	public void setChangePanel(GoodsChangePanel changePanel) {
//		this.changePanel = changePanel;
//	}
//
//	public void setQueryPanel(GoodsQueryPanel queryPanel) {
//		this.queryPanel = queryPanel;
//	}

}
