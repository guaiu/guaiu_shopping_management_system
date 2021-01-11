package listener;

import page.*;
import entity.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.GoodsDao;

/**
 * 添加商品添加监听器，连接添加面板和表格展示面板
 * 
 * @author guaiu
 *
 */
public class GoodsAddListener {

	private GoodsAddPanel addPanel;
	private GoodsShowTablePanel showTablePanel;

	/**
	 * 初始化，为button_add添加ActionListener监听器
	 * 
	 * @param addPanel
	 * @param showTablePanel
	 */
	public GoodsAddListener(GoodsAddPanel addPanel, GoodsShowTablePanel showTablePanel) {
		// TODO Auto-generated constructor stub
		this.addPanel = addPanel;
		this.showTablePanel = showTablePanel;

		this.setListener();

	}

	/**
	 * 设置监听器
	 */
	private void setListener() {
		this.set_button_add_listener();
	}

	/**
	 * 为button_add添加ActionListener监听器
	 */
	private void set_button_add_listener() {
		addPanel.getButton_add().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("正在添加");
				if (addPanel.getPanel_input().getTextField_name().getText().equals("")
						|| addPanel.getPanel_input().getTextField_price().getText().equals("")
						|| addPanel.getPanel_input().getTextField_num().getText().equals("")) {
					System.out.println("添加终止，输入数据有空值");
					JOptionPane.showMessageDialog(null, "添加失败，请勿输入空值！");
					return;
				}

				Goods goods = new Goods(addPanel.getPanel_input().getTextField_name().getText(),
						Double.parseDouble(addPanel.getPanel_input().getTextField_price().getText()),
						Integer.parseInt(addPanel.getPanel_input().getTextField_num().getText()));
				boolean result = new GoodsDao().addGoods(goods);
				if (result == true) {
					System.out.println("添加成功");
					JOptionPane.showMessageDialog(null, "添加成功！");
					clear_textField();
					update_showTable(goods);
				} else {
					System.out.println("添加失败");
					JOptionPane.showMessageDialog(null, "添加失败！");
				}

			}
		});
	}

	/**
	 * 在表格展示面板表格的末尾行添加新增加的商品的信息
	 * 
	 * @param goods
	 */
	private void update_showTable(Goods goods) {
		goods.setGid(new GoodsDao().queryGoodsNameExact(goods.getGname()).get(0).getGid());
		// 从数据库获取新分配的唯一id号，数据库Goods表中gName列具有唯一性约束，可以使用gName进行精确查询

		Object[] rowData = { goods.getGid(), goods.getGname(), goods.getGprice(), goods.getGnum() };
		showTablePanel.getData().addRow(rowData);
		System.out.println("表格已更新");
	}

	/**
	 * 清空输入框
	 */
	private void clear_textField() {
		addPanel.getPanel_input().getTextField_name().setText("");
		addPanel.getPanel_input().getTextField_price().setText("");
		addPanel.getPanel_input().getTextField_num().setText("");
	}
}