package page;

import javax.swing.ListSelectionModel;

/**
 * ��Ʒչʾ��
 * @author guaiu
 *
 */
public class GoodsShowTablePanel extends ShowTablePanel {

	/**
	 * ������Ʒչʾ�壬��ͷԪ��Ϊ�ֱ�Ϊ"ID"�� "����"�� "�۸�"�� "����"�������Ŀ���������ѡ 
	 */
	public GoodsShowTablePanel() {
		// TODO Auto-generated constructor stub
		super();
		Object[][] rowData = {};
		Object[] columnNames = { "ID", "����", "�۸�", "����" };
		this.getData().setDataVector(rowData, columnNames);
		
		ListSelectionModel selectionModel = this.getTable().getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}
}
