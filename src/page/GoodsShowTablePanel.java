package page;

import javax.swing.ListSelectionModel;

/**
 * 商品展示板
 * @author guaiu
 *
 */
public class GoodsShowTablePanel extends ShowTablePanel {

	/**
	 * 生成商品展示板，表头元素为分别为"ID"、 "名称"、 "价格"、 "数量"，表格条目可鼠标点击多选 
	 */
	public GoodsShowTablePanel() {
		// TODO Auto-generated constructor stub
		super();
		Object[][] rowData = {};
		Object[] columnNames = { "ID", "名称", "价格", "数量" };
		this.getData().setDataVector(rowData, columnNames);
		
		ListSelectionModel selectionModel = this.getTable().getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}
}
