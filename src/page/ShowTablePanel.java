package page;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * ���չʾ���
 * @author guaiu
 * 
 */
public class ShowTablePanel extends ActionPanel{
	
	private DefaultTableModel data;
	private JTable table;
	private JScrollPane scrollPane;
	
	
	/**
	 * �޲������������ɿձ�ͷ�����ݵı��չʾ���
	 * ��ע�������Ŀ���ɱ༭����ʹ����������ж�ѡ
	 * @param none
	 * @return void
	 */
	public ShowTablePanel() {
		// TODO Auto-generated constructor stub
		super("չʾ��ѡ��");
		
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
	 * �в����������ɱ��չʾ���
	 * ָ����ͷ��ָ����Ŀ���ݣ���ָ���Ƿ���Ե�������ж�ѡ�����Ŀ��
	 * @param rowData
	 * @param columnNames
	 * @param enableMultiple
	 */
	public ShowTablePanel(Object[][] rowData,Object[] columnNames,boolean enableMultiple) {
		
		super("չʾ��ѡ��");
		
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
