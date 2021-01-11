package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;

import dao.GoodsDao;
import page.GoodsDeletePanel;
import page.GoodsShowTablePanel;

/**
 * �����Ʒɾ��������������ɾ�����ͱ��չʾ��
 * 
 * @author guaiu
 *
 */
public class GoodsDeleteListener {

	private GoodsShowTablePanel showTablePanel;
	private GoodsDeletePanel deletePanel;

	/**
	 * ��ʼ����Ϊbutton_delete���ActionListener������
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
	 * Ϊbutton_delete���ActionListener������
	 * ��ע����showTablePanel��ȡselectedRows֮�󣬽��е���ɾ����ȷ����ѡɾ����˳�����У� �����߼���ο�����
	 */
	public void set_button_delete_listener() {
		this.deletePanel.getButton_delete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("���ڽ�����Ʒɾ������");
				int[] selectedRows = showTablePanel.getTable().getSelectedRows();

				// ����ɾ��
				if (selectedRows.length > 0) {
					for (int i = selectedRows.length - 1; i >= 0; i--) {
						int gid = (int) showTablePanel.getData().getValueAt(selectedRows[i], 0);
						boolean result = new GoodsDao().deleteGoods(gid);
						if (result == true) {
							System.out.println("id: " + gid + " ɾ���ɹ�");
							JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
							showTablePanel.getData().removeRow(selectedRows[i]);
						} else {
							System.out.println("id: " + gid + " ɾ��ʧ��");
							JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
						}
					}
				} else {
					System.out.println("��ѡȡ��Ʒ��");
					JOptionPane.showMessageDialog(null, "��ѡ����Ʒ��");
				}
				System.out.println("��Ʒɾ����������");
			}
		});
	}
}
