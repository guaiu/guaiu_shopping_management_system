package listener;

import page.*;
import entity.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.GoodsDao;

/**
 * �����Ʒ��Ӽ�����������������ͱ��չʾ���
 * 
 * @author guaiu
 *
 */
public class GoodsAddListener {

	private GoodsAddPanel addPanel;
	private GoodsShowTablePanel showTablePanel;

	/**
	 * ��ʼ����Ϊbutton_add���ActionListener������
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
	 * ���ü�����
	 */
	private void setListener() {
		this.set_button_add_listener();
	}

	/**
	 * Ϊbutton_add���ActionListener������
	 */
	private void set_button_add_listener() {
		addPanel.getButton_add().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�������");
				if (addPanel.getPanel_input().getTextField_name().getText().equals("")
						|| addPanel.getPanel_input().getTextField_price().getText().equals("")
						|| addPanel.getPanel_input().getTextField_num().getText().equals("")) {
					System.out.println("�����ֹ�����������п�ֵ");
					JOptionPane.showMessageDialog(null, "���ʧ�ܣ����������ֵ��");
					return;
				}

				Goods goods = new Goods(addPanel.getPanel_input().getTextField_name().getText(),
						Double.parseDouble(addPanel.getPanel_input().getTextField_price().getText()),
						Integer.parseInt(addPanel.getPanel_input().getTextField_num().getText()));
				boolean result = new GoodsDao().addGoods(goods);
				if (result == true) {
					System.out.println("��ӳɹ�");
					JOptionPane.showMessageDialog(null, "��ӳɹ���");
					clear_textField();
					update_showTable(goods);
				} else {
					System.out.println("���ʧ��");
					JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
				}

			}
		});
	}

	/**
	 * �ڱ��չʾ������ĩβ����������ӵ���Ʒ����Ϣ
	 * 
	 * @param goods
	 */
	private void update_showTable(Goods goods) {
		goods.setGid(new GoodsDao().queryGoodsNameExact(goods.getGname()).get(0).getGid());
		// �����ݿ��ȡ�·����Ψһid�ţ����ݿ�Goods����gName�о���Ψһ��Լ��������ʹ��gName���о�ȷ��ѯ

		Object[] rowData = { goods.getGid(), goods.getGname(), goods.getGprice(), goods.getGnum() };
		showTablePanel.getData().addRow(rowData);
		System.out.println("����Ѹ���");
	}

	/**
	 * ��������
	 */
	private void clear_textField() {
		addPanel.getPanel_input().getTextField_name().setText("");
		addPanel.getPanel_input().getTextField_price().setText("");
		addPanel.getPanel_input().getTextField_num().setText("");
	}
}