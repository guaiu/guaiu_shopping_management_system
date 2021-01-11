package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import dao.GoodsDao;
import entity.Goods;
import page.GoodsChangePanel;
import page.GoodsShowTablePanel;

/**
 * 添加商品更改监听器，连接更改面板和表格展示面板
 * 
 * @author guaiu
 *
 */
public class GoodsChangeListener {

	private GoodsChangePanel changePanel;
	private GoodsShowTablePanel showTablePanel;

	public GoodsChangeListener(GoodsChangePanel changePanel, GoodsShowTablePanel showTablePanel) {
		// TODO Auto-generated constructor stub

		this.changePanel = changePanel;
		this.showTablePanel = showTablePanel;

		this.set_table_listener();
		this.set_button_change_listener();
	}

	/**
	 * 为showTablePanel的table添加ListSelectionListener监听器，
	 * 使得用户点选的条目信息会显示在changePanel的textField
	 * 
	 */
	private void set_table_listener() {
		showTablePanel.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				// 选择动作已完成
				if (e.getValueIsAdjusting() == false) {
					ListSelectionModel selectionModel = showTablePanel.getTable().getSelectionModel();
					if (selectionModel.isSelectionEmpty() == true) {
						set_textField_empty();
					} else {
						set_textField_text();
					}
				}
			}
		});
	}

	/**
	 * 将changePanel的textField清空
	 */
	private void set_textField_empty() {
		changePanel.getPanel_idShow().getTextField_id().setText("");
		changePanel.getPanel_input().getTextField_name().setText("");
		changePanel.getPanel_input().getTextField_price().setText("");
		changePanel.getPanel_input().getTextField_num().setText("");
	}

	/**
	 * 读取鼠标点选table的条目，并将条目信息输入到changePanel的textField
	 */
	private void set_textField_text() {
		DefaultTableModel data = showTablePanel.getData();
		int selectedRow = showTablePanel.getTable().getSelectedRow();// 只获取选中的第一行

		Object gid = data.getValueAt(selectedRow, 0);
		Object gname = data.getValueAt(selectedRow, 1);
		Object gprice = data.getValueAt(selectedRow, 2);
		Object gnum = data.getValueAt(selectedRow, 3);

		changePanel.getPanel_idShow().getTextField_id().setText(gid.toString());
		changePanel.getPanel_input().getTextField_name().setText(gname.toString());
		changePanel.getPanel_input().getTextField_price().setText(gprice.toString());
		changePanel.getPanel_input().getTextField_num().setText(gnum.toString());
	}

	/**
	 * 为button_change添加ActionListener监听器
	 */
	private void set_button_change_listener() {
		changePanel.getButton_change().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextField textField_id = changePanel.getPanel_idShow().getTextField_id();
				JTextField textField_name = changePanel.getPanel_input().getTextField_name();
				JTextField textField_price = changePanel.getPanel_input().getTextField_price();
				JTextField textField_num = changePanel.getPanel_input().getTextField_num();

				if (textField_name.getText().equals("") || textField_price.getText().equals("")
						|| textField_num.getText().equals("")) {
					System.out.println("更新终止，输入数据有空值");
					JOptionPane.showMessageDialog(null, "更新失败，请勿输入空值！");
					return ;
				}

				int gid = Integer.parseInt(textField_id.getText());
				String gname = textField_name.getText();
				double gprice = Double.parseDouble(textField_price.getText());
				int gnum = Integer.parseInt(textField_num.getText());

				Goods goods = new Goods(gid, gname, gprice, gnum);

				boolean result = new GoodsDao().updateGoods(goods);
				if (result == true) {
					System.out.println("更改成功");
					set_showTable_data_update(gname,gprice,gnum);
					JOptionPane.showMessageDialog(null, "更改成功！");
				} else {
					System.out.println("更改失败");
					JOptionPane.showMessageDialog(null, "更改失败！");
				}
			}
		});
	}
	
	/**
	 * 根据参数更新当前鼠标点选的表格条目信息
	 * @param gname
	 * @param gprice
	 * @param gnum
	 */
	private void set_showTable_data_update(String gname,double gprice,int gnum) {
		
		DefaultTableModel data = showTablePanel.getData();
		int selectedRow = showTablePanel.getTable().getSelectedRow();// 只获取选中的第一行
		
		data.setValueAt(gname, selectedRow, 1);
		data.setValueAt(gprice, selectedRow, 2);
		data.setValueAt(gnum, selectedRow, 3);
	}
}
