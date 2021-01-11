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
 * �����Ʒ��ѯ�����������Ӳ�ѯ���ͱ��չʾ���
 * 
 * @author guaiu
 *
 */
public class GoodsQueryListener {

	private GoodsQueryPanel queryPanel;
	private GoodsShowTablePanel showTablePanel;

	/**
	 * ��ʼ����ΪqueryPanel��������ѯ��ť���ActionListener������
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
	 * ���ü�����
	 */
	private void setListener() {
		this.set_button_query_listener();
		this.set_button_query_all_listener();
	}
	
	/**
	 * Ϊbutton_query���ActionListener������
	 */
	private void set_button_query_listener() {
		queryPanel.getButton_query().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���ڲ�ѯ");
				showTablePanel.getData().getDataVector().clear();//���TabelModel����һ�����֪ͨ����TabelModel�ļ���������״̬
				showTablePanel.getData().fireTableChanged(new TableModelEvent(showTablePanel.getData()));//֪ͨ����TableModel�ļ���������״̬�����룬����ᱨ��
				
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
				System.out.println("��ѯ����");
			}
		});
	}

	/**
	 * Ϊbutton_query_all���ActionListener������
	 */
	private void set_button_query_all_listener() {
		queryPanel.getButton_query_all().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���ڲ�ѯ");
				showTablePanel.getData().getDataVector().clear();//���TabelModel����һ�����֪ͨ����TabelModel�ļ���������״̬
				showTablePanel.getData().fireTableChanged(new TableModelEvent(showTablePanel.getData()));//֪ͨ����TableModel�ļ���������״̬�����룬����ᱨ��
				
				ArrayList<Goods> goodsList = new GoodsDao().displayGoods();
				if (goodsList.size() > 0) {
					for (Goods goods : goodsList) {
						Object[] rowData = { goods.getGid(), goods.getGname(), goods.getGprice(), goods.getGnum() };
						showTablePanel.getData().addRow(rowData);
					}
				}
				System.out.println("��ѯ����");
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
