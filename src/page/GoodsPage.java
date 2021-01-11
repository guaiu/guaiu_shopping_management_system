package page;

import java.awt.BorderLayout;

import javax.swing.JFrame;


/**
 * 商品管理窗口
 * @author guaiu
 *
 */
public class GoodsPage extends JFrame{

	private GoodsShowTablePanel showTablePanel;
	private GoodsAddPanel addPanel;
	private GoodsDeletePanel deletePanel;
	private GoodsChangePanel changePanel;
	private GoodsQueryPanel queryPanel;
	
	public GoodsPage() {
		// TODO Auto-generated constructor stub
		super();
		this.setTitle("商品管理窗口");
	
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(1000, 100, 800, 800);
		this.setLocationRelativeTo(null);
		
		this.initPanel();
		
		this.setVisible(true);
		
		
	}

	
	private void initPanel() {
		this.showTablePanel = new GoodsShowTablePanel();
		this.addPanel = new GoodsAddPanel();
		this.deletePanel = new GoodsDeletePanel();
		this.changePanel = new GoodsChangePanel();
		this.queryPanel = new GoodsQueryPanel();
		
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
