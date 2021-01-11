package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.TableModelEvent;

import dao.GoodsDao;
import entity.Goods;
import page.GoodsQueryPanel;
import page.GoodsShowTablePanel;

/**
 * 添加商品查询监听器，连接查询面板和表格展示面板
 * 
 * @author guaiu
 *
 */
public class GoodsQueryListener {

	private GoodsQueryPanel queryPanel;
	private GoodsShowTablePanel showTablePanel;

	/**
	 * 初始化，为queryPanel的两个查询按钮添加ActionListener监听器
	 * 
	 * @param queryPanel
	 * @param showTablePanel
	 */
	public GoodsQueryListener(GoodsQueryPanel queryPanel, GoodsShowTablePanel showTablePanel) {
		// TODO Auto-generated constructor stub

		this.queryPanel = queryPanel;
		this.showTablePanel = showTablePanel;

		this.setListener();
	}

	
	/**
	 * 设置监听器
	 */
	private void setListener() {
		this.set_button_query_listener();
		this.set_button_query_all_listener();
	}
	
	/**
	 * 为button_query添加ActionListener监听器
	 */
	private void set_button_query_listener() {
		queryPanel.getButton_query().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("正在查询");
				showTablePanel.getData().getDataVector().clear();//清空TabelModel，下一句必须通知所有TabelModel的监视器重置状态
				showTablePanel.getData().fireTableChanged(new TableModelEvent(showTablePanel.getData()));//通知所有TableModel的监视器重置状态，必须，否则会报错
				
				if (queryPanel.getRadioButton_id().isSelected()) {
					int id = Integer.parseInt(queryPanel.getTextField_id().getText());
					ArrayList<Goods> goodsList = new GoodsDao().queryGoodsId(id);
					if (goodsList.size() > 0) {
						for (Goods goods : goodsList) {
							Object[] rowData = { goods.getGid(), goods.getGname(), goods.getGprice(), goods.getGnum() };
							showTablePanel.getData().addRow(rowData);
						}
					}
				} else if (queryPanel.getRadioButton_name().isSelected()) {
					String name = queryPanel.getTextField_name().getText();
					ArrayList<Goods> goodsList = new GoodsDao().queryGoodsNameFuzzy(name);
					if (goodsList.size() > 0) {
						for (Goods goods : goodsList) {
							Object[] rowData = { goods.getGid(), goods.getGname(), goods.getGprice(), goods.getGnum() };
							showTablePanel.getData().addRow(rowData);
						}
					}
				}
				System.out.println("查询结束");
			}
		});
	}

	/**
	 * 为button_query_all添加ActionListener监听器
	 */
	private void set_button_query_all_listener() {
		queryPanel.getButton_query_all().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("正在查询");
				showTablePanel.getData().getDataVector().clear();//清空TabelModel，下一句必须通知所有TabelModel的监视器重置状态
				showTablePanel.getData().fireTableChanged(new TableModelEvent(showTablePanel.getData()));//通知所有TableModel的监视器重置状态，必须，否则会报错
				
				ArrayList<Goods> goodsList = new GoodsDao().displayGoods();
				if (goodsList.size() > 0) {
					for (Goods goods : goodsList) {
						Object[] rowData = { goods.getGid(), goods.getGname(), goods.getGprice(), goods.getGnum() };
						showTablePanel.getData().addRow(rowData);
					}
				}
				System.out.println("查询结束");
			}
		});
	}

//	public GoodsQueryPanel getQueryPanel() {
//		return queryPanel;
//	}
//
//	public GoodsShowTablePanel getShowTablePanel() {
//		return showTablePanel;
//	}
//
//	public void setQueryPanel(GoodsQueryPanel queryPanel) {
//		this.queryPanel = queryPanel;
//	}
//
//	public void setShowTablePanel(GoodsShowTablePanel showTablePanel) {
//		this.showTablePanel = showTablePanel;
//	}

}
