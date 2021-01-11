package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;

import dao.GoodsDao;
import page.GoodsDeletePanel;
import page.GoodsShowTablePanel;

/**
 * 添加商品删除监听器，连接删除面板和表格展示板
 * 
 * @author guaiu
 *
 */
public class GoodsDeleteListener {

	private GoodsShowTablePanel showTablePanel;
	private GoodsDeletePanel deletePanel;

	/**
	 * 初始化，为button_delete添加ActionListener监听器
	 * 
	 * @param deletePanel
	 * @param showTablePanel
	 */
	public GoodsDeleteListener(GoodsDeletePanel deletePanel, GoodsShowTablePanel showTablePanel) {
		// TODO Auto-generated constructor stub
		this.deletePanel = deletePanel;
		this.showTablePanel = showTablePanel;
		set_button_delete_listener();

	}

	/**
	 * 为button_delete添加ActionListener监听器
	 * 备注：从showTablePanel获取selectedRows之后，进行倒序删除（确保多选删除的顺利进行） 具体逻辑请参考代码
	 */
	public void set_button_delete_listener() {
		this.deletePanel.getButton_delete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("正在进行商品删除操作");
				int[] selectedRows = showTablePanel.getTable().getSelectedRows();

				// 倒序删除
				if (selectedRows.length > 0) {
					for (int i = selectedRows.length - 1; i >= 0; i--) {
						int gid = (int) showTablePanel.getData().getValueAt(selectedRows[i], 0);
						boolean result = new GoodsDao().deleteGoods(gid);
						if (result == true) {
							System.out.println("id: " + gid + " 删除成功");
							JOptionPane.showMessageDialog(null, "删除成功！");
							showTablePanel.getData().removeRow(selectedRows[i]);
						} else {
							System.out.println("id: " + gid + " 删除失败");
							JOptionPane.showMessageDialog(null, "删除失败！");
						}
					}
				} else {
					System.out.println("请选取商品！");
					JOptionPane.showMessageDialog(null, "请选择商品！");
				}
				System.out.println("商品删除操作结束");
			}
		});
	}
}
