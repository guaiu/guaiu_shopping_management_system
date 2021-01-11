package page;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * 表格展示面板
 * @author guaiu
 * 
 */
public class ShowTablePanel extends ActionPanel{
	
	private DefaultTableModel data;
	private JTable table;
	private JScrollPane scrollPane;
	
	
	/**
	 * 无参数方法，生成空表头空内容的表格展示面板
	 * 备注：表格条目不可编辑，可使用鼠标点击进行多选
	 * @param none
	 * @return void
	 */
	public ShowTablePanel() {
		// TODO Auto-generated constructor stub
		super("展示与选择");
		
		this.data = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
		this.table = new JTable();
		this.table.setModel(data);
		this.table.getTableHeader().setReorderingAllowed(false);
		this.table.setPreferredScrollableViewportSize(new Dimension(600,550));
		this.scrollPane = new JScrollPane(this.table);
		this.setLayout(new BorderLayout());
		this.add(scrollPane,BorderLayout.NORTH);
	}
	
	/**
	 * 有参数方法生成表格展示面板
	 * 指定表头和指定表目内容，并指定是否可以点击鼠标进行多选表格条目的
	 * @param rowData
	 * @param columnNames
	 * @param enableMultiple
	 */
	public ShowTablePanel(Object[][] rowData,Object[] columnNames,boolean enableMultiple) {
		
		super("展示与选择");
		
		this.data = new DefaultTableModel(rowData,columnNames){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        
		this.table = new JTable();
		this.table.setModel(data);
		this.table.getTableHeader().setReorderingAllowed(false);
		this.table.setPreferredScrollableViewportSize(new Dimension(600,300));
		this.scrollPane = new JScrollPane(this.table);
		this.setLayout(new BorderLayout());
		this.add(scrollPane,BorderLayout.NORTH);
		
		ListSelectionModel selectionModel = table.getSelectionModel();
		if(enableMultiple) {
			selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			}
			else {
				selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			}
	}

	public DefaultTableModel getData() {
		return data;
	}

	public JTable getTable() {
		return table;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

//	public void setData(DefaultTableModel data) {
//		this.data = data;
//	}
//
//	public void setTable(JTable table) {
//		this.table = table;
//	}
//
//	public void setScrollPane(JScrollPane scrollPane) {
//		this.scrollPane = scrollPane;
//	}
	
}
